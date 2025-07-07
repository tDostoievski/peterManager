package com.prototipo.p1.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;

import com.prototipo.p1.model.primary.ProdutoLocal;
import com.prototipo.p1.model.secondary.ProdutoExterno;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

@Controller
public class ColumnController {
    
    @FXML private Label numberDay;
    @FXML private Label weekDay;
    //Metodo que carrega um arquivo fxml onde ele tem data e o correspondente dia da semana 
    
    public void setDados(LocalDate date){
        numberDay.setText(String.valueOf(date));
        weekDay.setText(String.valueOf(date.getDayOfWeek()));
    }
    }
