package com.devlukas.designpatterns.behavioral.observer.sentenceCounter;

public class UpperCaseCounter implements WordsCounter {

    private Integer quantity = 0;

    @Override
    public void count(String word) {
        if(Character.isUpperCase(word.charAt(0))) {
            quantity++;
        }
    }

    @Override
    public Integer getCount() {
        return quantity;
    }
}
