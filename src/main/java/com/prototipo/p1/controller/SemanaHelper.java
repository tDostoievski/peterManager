package com.prototipo.p1.controller;

import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class SemanaHelper {
    public boolean semana (LocalDate diaProduto) {
        LocalDate diaAtual = LocalDate.now();
        int semanaAtual = diaAtual.get(WeekFields.ISO.weekOfYear());
        int semanaProduto = diaProduto.get(WeekFields.ISO.weekOfYear());
        
        return semanaProduto == semanaAtual;

    }
}