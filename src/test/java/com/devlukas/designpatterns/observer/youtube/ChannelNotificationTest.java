package com.devlukas.designpatterns.observer.youtube;

import com.devlukas.designpatterns.behavioral.observer.youtube.Channel;
import com.devlukas.designpatterns.behavioral.observer.youtube.Subscriber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ChannelNotificationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void channelNotificationTest() {

        var devlukas = new Channel("Dev Lukas");

        var s1 = new Subscriber("John");
        var s2 = new Subscriber("Eva");
        var s3 = new Subscriber("Ana");

        devlukas.subscribe(s1);
        devlukas.subscribe(s2);
        devlukas.subscribe(s3);
        s1.subscribeChannel(devlukas);
        s2.subscribeChannel(devlukas);
        s3.subscribeChannel(devlukas);

        s1.activeNotification();
        s2.activeNotification();

        devlukas.uploadNewVideo("Template Method Design Pattern explained with Java");

        Assertions.assertThat(outContent.toString()).isEqualTo("Dev Lukas upload a new vídeo: Template Method Design Pattern explained with Java\n".repeat(2));
    }
}
