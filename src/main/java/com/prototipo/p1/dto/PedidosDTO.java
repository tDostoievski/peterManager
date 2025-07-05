package com.prototipo.p1.dto;

import java.time.LocalDate;

import com.prototipo.p1.model.primary.Maquina;

public class PedidosDTO {
    private Maquina maquina;
    private String status;
    private String setor;
    private int numeroOp;
    private int codigoProduto;
    private String descricaoProduto; 
    private String lote;
    private double carga;
    private LocalDate data;

    
    public PedidosDTO(Maquina maquina, String status, String setor, int numeroOp, int codigoProduto,
            String descricaoProduto, String lote, double carga, LocalDate data) {
        this.maquina = maquina;
        this.status = status;
        this.setor = setor;
        this.numeroOp = numeroOp;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.lote = lote;
        this.carga = carga;
        this.data = data;
    }

    public PedidosDTO(int numeroOp, int codigoProduto, String descricaoProduto, String lote, double carga, LocalDate data) {
        this.maquina = null;
        this.status = "Não programado";
        this.setor = "Indefinido";
        this.numeroOp = numeroOp;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.lote = lote;
        this.carga = carga;
        this.data = data;
    }


    public Maquina getMaquina() {
        return maquina;
    }


    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public String getSetor() {
        return setor;
    }


    public void setSetor(String setor) {
        this.setor = setor;
    }


    public int getNumeroOp() {
        return numeroOp;
    }


    public void setNumeroOp(int numeroOp) {
        this.numeroOp = numeroOp;
    }


    public int getCodigoProduto() {
        return codigoProduto;
    }


    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }


    public String getDescricaoProduto() {
        return descricaoProduto;
    }


    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }


    public String getLote() {
        return lote;
    }


    public void setLote(String lote) {
        this.lote = lote;
    }


    public double getCarga() {
        return carga;
    }


    public void setCarga(double carga) {
        this.carga = carga;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }

    
}
