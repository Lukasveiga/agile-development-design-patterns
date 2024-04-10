package com.devlukas.designpatterns.behavioral.observer.sentenceCounter;

public class OddCounter implements WordsCounter {

    private Integer quantity = 0;
    @Override
    public void count(String word) {
        if (word.length() % 2 != 0) {
            quantity++;
        }
    }

    @Override
    public Integer getCount() {
        return quantity;
    }
}
