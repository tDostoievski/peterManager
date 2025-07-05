package com.prototipo.p1.controller;

import org.springframework.stereotype.Component;

import com.prototipo.p1.dto.PedidosDTO;
import com.prototipo.p1.model.primary.ProdutoLocal;
import com.prototipo.p1.model.secondary.ProdutoExterno;

@Component
public class PedidosHelper {
    
    
    public PedidosDTO geraPedido(ProdutoLocal produtoLocal, ProdutoExterno produtoExterno){
        PedidosDTO pedido = new PedidosDTO(
        produtoLocal.getMaquina(), 
        produtoLocal.getStatus(), 
        produtoLocal.getSetor(),
        produtoExterno.getNumeroOp(),
        produtoExterno.getCodigoProduto(),
        produtoExterno.getDescricaoProduto(),
        produtoExterno.getLote(),
        produtoExterno.getCarga(),
        produtoExterno.getData());
        return pedido;
    }

    public PedidosDTO geraPedidoSemLocal (ProdutoExterno produtoExterno){
        PedidosDTO pedido = new PedidosDTO(
        produtoExterno.getNumeroOp(),
        produtoExterno.getCodigoProduto(),
        produtoExterno.getDescricaoProduto(),
        produtoExterno.getLote(),
        produtoExterno.getCarga(),
        produtoExterno.getData());
        return pedido;
    }

    public ProdutoLocal geraPedidoLocal(PedidosDTO pedido){
        ProdutoLocal produto = new ProdutoLocal( 
        pedido.getNumeroOp(),
        pedido.getCodigoProduto(),
        pedido.getDescricaoProduto(),
        pedido.getLote(),
        pedido.getCarga(),
        pedido.getData());
        return produto;
    }

}
