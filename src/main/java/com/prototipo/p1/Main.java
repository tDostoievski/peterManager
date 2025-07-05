package com.prototipo.p1;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prototipo.p1.javafx.JavaFxApplication;

import javafx.application.Application;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }
}