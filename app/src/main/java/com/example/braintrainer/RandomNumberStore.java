package com.example.braintrainer;

import java.util.ArrayList;

public class RandomNumberStore {
    private ArrayList<Integer> genarated = new ArrayList<>();
    private ArrayList<Integer> givenInputs = new ArrayList<>();
    private static RandomNumberStore instance;

    public static RandomNumberStore getInstance() {
        return instance;
    }

    public static RandomNumberStore getNewInstance() {
        instance = new RandomNumberStore();
        return instance;
    }

    public void addGenaratedRandomNumber(Integer number) {
        genarated.add(number);
    }

    public void addInputNumber(Integer number) {
        givenInputs.add(number);
    }

    public ArrayList<Integer> getGenarated() {
        return genarated;
    }

    public ArrayList<Integer> getGivenInputs() {
        return givenInputs;
    }

    public int getCountOfCorectGuesses(){
        int score=0;
        for (int i = 0; i <getGivenInputs().size() ; i++) {
            if(getGivenInputs().get(i)==getGenarated().get(i)){
                score++;
            }

        }
        return score;
    }
}
