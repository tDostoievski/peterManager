package com.prototipo.p1.javafx;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.prototipo.p1.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {
    private ConfigurableApplicationContext springContext;

    @Override
    public void init() throws Exception{
        springContext = new SpringApplicationBuilder(Main.class).run();
    }

    @Override
    public void start(Stage PrimaryStage) throws Exception { 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/templates/boardPage.fxml"));
        loader.setControllerFactory(springContext::getBean);

        Parent root = loader.load();
        Scene scene = new Scene(root);
        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Menu principal");
        PrimaryStage.show();

    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }
}
