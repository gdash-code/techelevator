package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestions {

    public String question;
    public List<String> answers;
    public String correctAnswer;

    public QuizQuestions(){

    }

    public QuizQuestions(String[] question){
        String Question = question[0];
        answers.add(String.valueOf(1));
        correctAnswer = getCorrectAnswer(answers);
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        List<String> answers = new ArrayList<>();
        return answers;
    }

    public String getCorrectAnswer(List<String> answers) {
        for( int i=0; i < answers.size(); i++){
            if(answers.contains("*")){
                answers = Collections.singletonList(answers.remove(answers.size() - 1));
                return correctAnswer;
            }
        }
        return "";
    }
}
