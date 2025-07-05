package com.prototipo.p1.model.primary;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Maquina {

    @Id
    private String equipamento;
    private Double capacidadeDiariaMax;

    @OneToMany
    private final List<ProdutoLocal> produtos = new ArrayList<>();

    public Maquina(String equipamento, Double capacidadeDiariaMax) {
        this.equipamento = equipamento;
        this.capacidadeDiariaMax = capacidadeDiariaMax;
    }
    public Maquina() {
    }
    public String getEquipamento() {
        return equipamento;
    }
    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }
    public Double getCapacidadeDiariaMax() {
        return capacidadeDiariaMax;
    }
    public void setCapacidadeDiariaMax(Double capacidadeDiariaMax) {
        this.capacidadeDiariaMax = capacidadeDiariaMax;
    }
    public List<ProdutoLocal> getProdutos() {
        return produtos;
    } 
}
