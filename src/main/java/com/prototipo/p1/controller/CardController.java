package com.prototipo.p1.controller;

import org.springframework.stereotype.Controller;

import com.prototipo.p1.model.primary.ProdutoLocal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Controller
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
}