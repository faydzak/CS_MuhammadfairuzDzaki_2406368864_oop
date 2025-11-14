package com.muhammadfairuzdzaki.frontend.Observer;

import java.util.ArrayList;
import java.util.List;

public class ScoreManager implements Subject {
    public List<Observer> observers;
    private int score = 0;

    public ScoreManager(){
        this.observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer){
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }
    @Override
    public void notifyObserver(int score){
        for (Observer observer : observers){
            observer.update(score);
        }

    }
    public void setScore(int newScore){
        if (this.score != newScore){
            this.score = newScore;
            notifyObserver(score);
        }
    }
    public int getScore(){
        return score;
    }
}
