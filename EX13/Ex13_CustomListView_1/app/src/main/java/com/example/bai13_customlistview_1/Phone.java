package com.example.bai13_customlistview_1;

public class Phone {
    private final String name;
    private final int imageResource;

    public Phone(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}
