package com.devlukas.designpatterns.behavioral.observer.youtube;

public class Subscriber {

    private final String name;

    private boolean activeNotifications;

    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    public void subscribeChannel(Channel ch) {
        this.channel = ch;
    }

    public void activeNotification() {
        this.activeNotifications = true;
    }

    public void update(String videoTitle) {
        if(activeNotifications) {
            System.out.println(this.channel.getName() + " upload a new vídeo: " + videoTitle);
        }
    }
}
