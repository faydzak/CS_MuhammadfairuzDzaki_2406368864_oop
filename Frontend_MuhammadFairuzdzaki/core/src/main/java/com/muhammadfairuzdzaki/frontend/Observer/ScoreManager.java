package com.muhammadfairuzdzaki.frontend.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class ScoreManager implements Subject {
    public List<Observer>arrayList = new ArrayList<Observer>();
    private int score = 0;

    ScoreManager(){
        this.arrayList = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer observer){

    }
    @Override
    public void removeObserver(Observer observer){

    }
    @Override
    public void notifyObserver(int score){

    }
    public void setScore{
        this.score = score;
    }
    public void getscore{
        return score;
    }
}
