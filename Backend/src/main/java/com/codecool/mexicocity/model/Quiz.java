package com.codecool.mexicocity.model;

public class Quiz {
    private int id;
    private String context;
    private int solution;

    public Quiz(int round) {
        switch (round){
            case 1:
                context = levelOneQuiz();
//                solution =
                break;
            case 2:
                context = levelTwoQuiz();
                break;
            case 3:
                context =levelThreeQuiz();
                break;
        }
    }

    public int getSolution() {
        return solution;
    }

    public String getContext() {
        return context;
    }

    private String levelOneQuiz(){
        return "Quiz1";
    }


    private String levelTwoQuiz(){
        return "Quiz2";
    }

    private String levelThreeQuiz(){
        return "Quiz3";
    }
}
