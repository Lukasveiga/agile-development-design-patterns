package com.devlukas.designpatterns.observer.sentenceCounter;

import com.devlukas.designpatterns.behavioral.observer.sentenceCounter.OddCounter;
import com.devlukas.designpatterns.behavioral.observer.sentenceCounter.SentenceBreaker;
import com.devlukas.designpatterns.behavioral.observer.sentenceCounter.SimpleCounter;
import com.devlukas.designpatterns.behavioral.observer.sentenceCounter.UpperCaseCounter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SentenceBreakerTest {

    private SentenceBreaker breaker;
    private static final String sentence = "The best part of beauty is that which no picture can express";


    @BeforeEach
    void setUp() {
        breaker = new SentenceBreaker();
    }

    @Test
    void testSentenceBreakerSuccess() {
        var words = breaker.breakeSentence(sentence);
        Assertions.assertThat(words.size()).isEqualTo(12);
    }

    @Test
    void testSentenceBreakerSuccessWithSimpleCounter() {
        breaker.addCounter("SIMPLE", new SimpleCounter());
        breaker.breakeSentence(sentence);
        Assertions.assertThat(breaker.getCount("SIMPLE")).isEqualTo(12);
    }

    @Test
    void testSentenceBreakerSuccessWithUpperCaseCounter() {
        breaker.addCounter("UPPERCASE", new UpperCaseCounter());
        breaker.breakeSentence(sentence);
        Assertions.assertThat(breaker.getCount("UPPERCASE")).isEqualTo(1);
    }

    @Test
    void testSentenceBreakerSuccessWithOddCounter() {
        breaker.addCounter("ODD", new OddCounter());
        breaker.breakeSentence(sentence);
        Assertions.assertThat(breaker.getCount("ODD")).isEqualTo(5);
    }

    @Test
    void testSentenceBreakerSuccessWithMultipleCounters() {
        breaker.addCounter("SIMPLE", new SimpleCounter());
        breaker.addCounter("UPPERCASE", new UpperCaseCounter());
        breaker.addCounter("ODD", new OddCounter());
        breaker.breakeSentence(sentence);
        Assertions.assertThat(breaker.getCount("SIMPLE")).isEqualTo(12);
        Assertions.assertThat(breaker.getCount("UPPERCASE")).isEqualTo(1);
        Assertions.assertThat(breaker.getCount("ODD")).isEqualTo(5);
    }
}
