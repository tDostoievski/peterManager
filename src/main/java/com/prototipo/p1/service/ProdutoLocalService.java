package com.prototipo.p1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototipo.p1.dto.PedidosDTO;
import com.prototipo.p1.model.primary.ProdutoLocal;
import com.prototipo.p1.repository.primaryDataSource.ProdutoLocalRepository;



@Service
public class ProdutoLocalService {

    @Autowired
    private ProdutoLocalRepository produtoLocalRepository;
    
    public ProdutoLocal salvarPedido (PedidosDTO pedido){
        ProdutoLocal novoProduto = new ProdutoLocal(
        pedido.getMaquina(),
        pedido.getStatus(),
        pedido.getSetor(),
        pedido.getNumeroOp(),
        pedido.getCodigoProduto(),
        pedido.getDescricaoProduto(),
        pedido.getLote(),
        pedido.getCarga(),
        pedido.getData()
        );

        return produtoLocalRepository.save(novoProduto);
    }
}
