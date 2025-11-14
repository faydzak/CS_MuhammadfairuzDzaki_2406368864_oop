package com.muhammadfairuzdzaki.frontend.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(int score);
}
