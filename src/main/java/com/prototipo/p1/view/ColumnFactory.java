package com.prototipo.p1.view;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.prototipo.p1.controller.ColumnController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

@Component
public class ColumnFactory {

    @Autowired 
    ApplicationContext applicationContext;
    
    public VBox geraColuna(LocalDate date){
        try {
        FXMLLoader loader = new FXMLLoader(ColumnFactory.class.getResource("/templates/columnTemplate.fxml"));
        loader.setControllerFactory(applicationContext::getBean); 
        
        VBox columnNode = loader.load();
        ColumnController controller = loader.getController();
        controller.setDados(date);
        
        return columnNode;
        }
        catch (IOException e) {
             e.printStackTrace();
            return null;
        }
    }
}
