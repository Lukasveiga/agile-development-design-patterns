package com.devlukas.designpatterns.behavioral.observer.sentenceCounter;

public class SimpleCounter implements WordsCounter {

    private Integer quantity = 0;
    @Override
    public void count(String word) {
        quantity++;
    }

    @Override
    public Integer getCount() {
        return this.quantity;
    }
}
