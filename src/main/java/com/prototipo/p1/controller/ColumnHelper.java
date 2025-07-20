package com.prototipo.p1.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.prototipo.p1.model.secondary.ProdutoExterno;

public class ColumnHelper {


    public ArrayList<LocalDate> geraDatas(List<ProdutoExterno> listaDeProdutos){
        //Optional recebe uma lista, transforma numa stream, mapeia por data,depois seleciona maximo com max. 
        Optional<LocalDate> maxOptDate = listaDeProdutos.stream()
        .map(ProdutoExterno::getData)
        .max(LocalDate::compareTo);

        Optional<LocalDate> minOptDate = listaDeProdutos.stream()
        .map(ProdutoExterno::getData)
        .min(LocalDate::compareTo);

        LocalDate minDate = minOptDate.get();
        LocalDate maxDate = maxOptDate.get();

        ArrayList<LocalDate> todasAsDatas = new ArrayList<>(); 
        LocalDate current = minDate;
        while(!current.isAfter(maxDate)){
            todasAsDatas.add(current);
            current.plusDays(1);
        }

        return todasAsDatas;
        
    }
}
