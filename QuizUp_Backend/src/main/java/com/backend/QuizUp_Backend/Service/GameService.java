package com.backend.QuizUp_Backend.Service;

import com.backend.QuizUp_Backend.Dto.*;
import com.backend.QuizUp_Backend.Entities.enums.Complexity;
import com.backend.QuizUp_Backend.Entities.enums.HelpOptions;
import com.backend.QuizUp_Backend.Mappers.IGameMapper;
import com.backend.QuizUp_Backend.Service.Interfaces.IGameService;
import com.backend.QuizUp_Backend.Service.Interfaces.IQuizService;
import com.backend.QuizUp_Backend.Service.Interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameService implements IGameService {

    private final IQuizService quizService;
    private final IUserService userService;
    private final IGameMapper gameMapper;

    @Autowired
    public GameService(IQuizService quizService, IUserService userService,IGameMapper gameMapper) {
        this.quizService = quizService;
        this.userService = userService;
        this.gameMapper = gameMapper;
    }


    public GameDto getNewQuiz(String userId) {
        UserDto userDto = userService.getUserById(userId);
        Random randomizer = new Random();
        List<QuizDto> quizzes;
        QuizDto randomQuiz;
        Integer userBonus = userDto.getBonus();
        if(userBonus == 0){
            userBonus = 100;
        }
        if(userDto.getBonus() <= 1000){
            quizzes = quizService.getQuizzesByComplexityAndBonus(Complexity.Easy.name(), userBonus);
            randomQuiz = quizzes.get(randomizer.nextInt(quizzes.size()));
            return gameMapper.convertToDto(randomQuiz, userDto);
        } else if (userDto.getBonus() > 1000 && userDto.getBonus() <= 32000) {
            quizzes = quizService.getQuizzesByComplexityAndBonus(Complexity.Intermediate.name(), userBonus);
            randomQuiz = quizzes.get(randomizer.nextInt(quizzes.size()));
            return gameMapper.convertToDto(randomQuiz, userDto);
        } else if (userDto.getBonus() > 32000 && userDto.getBonus() <= 1000000) {
            quizzes = quizService.getQuizzesByComplexityAndBonus(Complexity.Hard.name(), userBonus);
            randomQuiz = quizzes.get(randomizer.nextInt(quizzes.size()));
            return gameMapper.convertToDto(randomQuiz, userDto);
        }
        return null;
    }


    public void updateUserBonus(UserDto userDto, QuizDto quizDto) {
        userDto.setBonus(quizDto.getBonus());
        userService.updateUser(userDto);
    }


    public GameDto deleteTwoAnswers(String userId, String quizId) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);
        Random randomizer = new Random();
        List<AnswerDto> answers = quizDto.getAnswers();
        List<AnswerDto> answersToSend = new ArrayList<>();


        answers.stream().filter(x -> Objects.equals(x.getAnswerNumber(), quizDto.getCorrectAnswer())).
                forEach(answersToSend::add);


        List<AnswerDto> notCorrectAnswers = answers.stream()
                .filter(x -> !Objects.equals(x.getAnswerNumber(), quizDto.getCorrectAnswer())).toList();

        AnswerDto randomAnswer = notCorrectAnswers.get(randomizer.nextInt(notCorrectAnswers.size()));
        answersToSend.add(randomAnswer);
        quizDto.setAnswers(answersToSend);
        if(answersToSend.size() == 2){
            return gameMapper.convertToDto(quizDto, userDto);
        }
        return null;
    }


    public FriendDto callFriend(String userId, String quizId) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);
        List<AnswerDto> answersToSend = new ArrayList<>();

        List<AnswerDto> answers = quizDto.getAnswers();

        answers.stream().filter(x -> Objects.equals(x.getAnswerNumber(), quizDto.getCorrectAnswer()))
                .forEach(answersToSend::add);


        if(answersToSend.size() > 1){
            throw new RuntimeException("Friend gives one answer!");
        }

        return gameMapper.convertFriendAnswersToDto(quizDto, userDto, answersToSend.get(0));
    }


    public PublicDto askPublic(String userId, String quizId) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);
        List<AnswerDto> publicAnswers = new ArrayList<>();
        Integer correctAnswer = quizDto.getCorrectAnswer();
        List<AnswerDto> notCorrectAnswers = quizDto.getAnswers().stream().
                filter(x -> !Objects.equals(x.getAnswerNumber(), correctAnswer)).toList();


        Random randomizer = new Random();
        int correctAnswersPercentage = randomizer.nextInt(66,76);
        publicAnswers.add(new AnswerDto(correctAnswer, Integer.toString(correctAnswersPercentage)));
        Integer restPercentage = 100 - correctAnswersPercentage;
        List<Integer> restPublicPercentage = getRandomPercentage(3, restPercentage);

        for(int i = 0 ; i < 3; i++){
            AnswerDto answerDto = new AnswerDto(notCorrectAnswers.get(i).getAnswerNumber(), restPublicPercentage.get(i).toString());
            publicAnswers.add(answerDto);
        }

        return gameMapper.convertPublicAnswersToDto(quizDto, userDto, publicAnswers);
    }

    @Override
    public GameDto getQuizByHelpOptions(String userId, String quizId, String helpOption) {
        UserDto userDto = userService.getUserById(userId);
        List<String> helpOptions = userDto.getHelpOptions();
        if(helpOptions.contains(helpOption)){
            if(helpOption.equals(HelpOptions.askPublic.name())){
                List<String> temp = helpOptions.stream().filter(x -> !x.equals("askPublic")).toList();
                updateHelpOptionList(userDto, temp);
                return askPublic(userId, quizId);
            } else if (helpOption.equals(HelpOptions.deleteTwoQuestions.name())) {
                List<String> temp = helpOptions.stream().filter(x -> !x.equals("deleteTwoQuestions")).toList();
                updateHelpOptionList(userDto, temp);
                return deleteTwoAnswers(userId, quizId);
            } else if (helpOption.equals(HelpOptions.callFriend.name())) {
                List<String> temp = helpOptions.stream().filter(x -> !x.equals("callFriend")).toList();
                updateHelpOptionList(userDto, temp);
                return callFriend(userId, quizId);
            }
        }
        return null;
    }

    @Override
    public GameDto gameCheck(String userId, String quizId,Integer answer, String helpOption) {
        UserDto userDto = userService.getUserById(userId);
        QuizDto quizDto = quizService.getQuizById(quizId);

        //checks if help options are used
        if(!helpOption.isEmpty()){
            return getQuizByHelpOptions(userDto.getId(), quizDto.getId(), helpOption);
        } else if (Objects.equals(quizDto.getCorrectAnswer(), answer)) {
            updateUserBonus(userDto, quizDto);
            return getNewQuiz(userDto.getId());
        }else {
            throw new RuntimeException("Game Over!"); //gameOver
        }
    }

    @Override
    public GameDto startGame(String userId) {
        UserDto userDto = userService.getUserById(userId);
        return getNewQuiz(userDto.getId());
    }

    private void updateHelpOptionList(UserDto userDto, List<String> helpOptions){
        userDto.setHelpOptions(helpOptions);
        userService.updateUser(userDto);
    }

    // Function to generate a list of, m random non-negative integers, whose sum is n
    private List<Integer> getRandomPercentage(Integer m, Integer n){
        // Create an array of size m where every element is initialized to 0
        int[] arr = new int[m];
        List<Integer> integers = new ArrayList<>();

        // To make the sum of the final list as n
        for (int i = 0; i < n; i++) {
            // Increment any random element from the array by 1
            arr[(int)(Math.random() * m)]++;
        }
        Arrays.stream(arr).forEach(integers::add);
        return integers;
    }
}
