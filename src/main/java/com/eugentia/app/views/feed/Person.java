package com.eugentia.app.views.feed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private String image;
    private String name;
    private String date;
    private String post;
    private String likes;
    private String comments;
    private String shares;

    public Person() {
    }

}
