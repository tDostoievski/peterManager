package com.prototipo.p1.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.prototipo.p1.model.primary.ProdutoLocal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

@Controller
@Scope("prototype")
public class CardController {
    // Definir elementos FXML, label por ora
@FXML private Label labelOp;
@FXML private Label labelCodigo;
@FXML private Label labelDescricao;
@FXML private Label labelLote;
@FXML private Label labelCarga;
@FXML private Label labelMaquina;
@FXML private Label labelStatus;
@FXML private Label labelData;

@FXML private TextField textFieldData; 

public void initialize(){
    labelData.setOnMouseClicked(event -> {
        if(event.getClickCount() == 2){
            labelData.setVisible(false);
            textFieldData.setVisible(true);
            textFieldData.setOnKeyPressed(event2 -> {
                if(event2.getCode() == KeyCode.ENTER){
                    labelData.setText(textFieldData.getText());
                    textFieldData.setVisible(false);
                    labelData.setVisible(true);
                    textFieldData.requestFocus();
                }
            });
        }
    });

}

    public void setDados(ProdutoLocal pedido){
        labelOp.setText(String.valueOf(pedido.getNumeroOp()));
        labelCodigo.setText(String.valueOf(pedido.getCodigoProduto()));
        labelDescricao.setText(pedido.getDescricaoProduto());
        labelLote.setText(pedido.getLote());
        labelCarga.setText(String.valueOf(pedido.getCarga()));
        labelMaquina.setText(pedido.getMaquina() != null ? pedido.getMaquina().getEquipamento() : "");
        labelStatus.setText(pedido.getStatus());
        labelData.setText(pedido.getData() != null ? pedido.getData().toString() : "");
}

// Mediante um duplo clique numa label, isso torne ela um editable textField. Ao clicar enter, o valor da label se torna igual o do editable textField

}