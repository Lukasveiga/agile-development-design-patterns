package com.devlukas.designpatterns.behavioral.observer.sentenceCounter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceBreaker {

    private final Map<String, WordsCounter> counters = new HashMap<>();

    public List<String> breakeSentence(String sentence) {
        List<String> list = Arrays.stream(sentence.split(" ")).toList();
        list.forEach((word) -> {
            for (WordsCounter counter : counters.values()) {
                counter.count(word);
            }
        });
        return list;
    };

    public void addCounter(String counterName, WordsCounter counter) {
        counters.put(counterName, counter);
    }

    public  Integer getCount(String counter) {
        return counters.get(counter).getCount();
    }
}
