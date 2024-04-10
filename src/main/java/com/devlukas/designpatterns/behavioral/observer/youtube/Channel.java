package com.devlukas.designpatterns.behavioral.observer.youtube;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private final String name;

    private final List<String> videos = new ArrayList<>();

    private final List<Subscriber> subscribers = new ArrayList<>();

    public Channel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void subscribe(Subscriber sub) {
        this.subscribers.add(sub);
    }

    public void unsubscribe(Subscriber sub) {
        this.subscribers.remove(sub);
    }

    public void uploadNewVideo(String title) {
        this.videos.add(title);
        this.notifySubscribers(title);
    }

    private void notifySubscribers(String title) {
        this.subscribers.forEach(sub -> sub.update(title));
    }
}
