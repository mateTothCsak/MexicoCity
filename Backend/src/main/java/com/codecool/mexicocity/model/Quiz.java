package com.codecool.mexicocity.model;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Quiz {
    private int id;
    private String context;
    private int solution;


    public Quiz(int round) {
        switch (round){
            case 1:
                levelOneQuiz();
                break;
            case 2:
                levelTwoQuiz();
                break;
            case 3:
                levelThreeQuiz();
                break;
            default: throw new IllegalStateException("There is no quiz for this round :" + round);

        }
    }


    private String levelOneQuiz() {
        int num1 = Util.randomNum(1,50);
        int num2 = Util.randomNum(1,50);
        int bigger = Math.max(num1,num2);
        int smaller = Math.min(num1,num2);

        String randOperator = Util.randomOperator(1);

        context = Integer.toString(bigger) + randOperator + Integer.toString(smaller);
        solution = eval(context);
        return context;
    }


    private String levelTwoQuiz(){
        int num1 = Util.randomNum(1,99);
        int num2 = Util.randomNum(1,99);
        String randOperator = Util.randomOperator(1);

        context = Integer.toString(num1) + randOperator + Integer.toString(num2);
        solution = eval(context);
        return context;
    }


    private String levelThreeQuiz(){
        int num1 = Util.randomNum(1,99);
        int num2 = Util.randomNum(1,99);
        String randOperator = Util.randomOperator(3);

        context = Integer.toString(num1) + randOperator + Integer.toString(num2);

        if(randOperator.equals("/")){
            int sum = num1 * num2;

            context = Integer.toString(sum) + randOperator + Integer.toString(num2);
            solution = num1;
            return context;
        }
        solution = eval(context);
        return context;
    }


    private int eval(String quiz) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByExtension("js");
        int result = 0;
        try {
            result = (Integer) engine.eval(quiz);

            System.out.println(quiz + " = " + result);
            return result;
        }
        catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }


    public int getSolution() {
        return solution;
    }

    public String getContext() {
        return context;
    }
}
