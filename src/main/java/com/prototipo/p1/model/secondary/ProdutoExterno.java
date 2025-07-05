package com.prototipo.p1.model.secondary;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProdutoExterno {
    @Id
    private int numeroOp;
    
    private int codigoProduto;
    private String descricaoProduto; 
    private String lote;
    private double carga;
    private LocalDate data;
    
    public ProdutoExterno(int numeroOp, int codigoProduto, String descricaoProduto, String lote, double carga,
            LocalDate data) {
        this.numeroOp = numeroOp;
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.lote = lote;
        this.carga = carga;
        this.data = data;
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
