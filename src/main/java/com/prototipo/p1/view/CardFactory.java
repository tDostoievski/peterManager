package com.prototipo.p1.view;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.prototipo.p1.controller.CardController;
import com.prototipo.p1.model.primary.ProdutoLocal;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

@Component
public class CardFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public Node geraCard(ProdutoLocal produto){
        try{
        FXMLLoader loader = new FXMLLoader(CardFactory.class.getResource("/templates/cardTemplate.fxml"));
        loader.setControllerFactory(applicationContext::getBean); // Carrega o FXML

        VBox cardNode = loader.load(); // Gera a vbox do card;
        CardController controller = loader.getController();
        controller.setDados(produto);

        return cardNode;
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}




// View - Template V
// Service - validações e persistências.
// Controller - Vai ter as funcionalidades e interação com a view. 