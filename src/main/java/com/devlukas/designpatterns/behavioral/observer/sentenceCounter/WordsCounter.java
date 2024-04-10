package com.devlukas.designpatterns.behavioral.observer.sentenceCounter;

public interface WordsCounter {

    void count(String word);

    Integer getCount();
}
