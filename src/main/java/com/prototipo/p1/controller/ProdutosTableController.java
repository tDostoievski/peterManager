package com.prototipo.p1.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prototipo.p1.dto.PedidosDTO;
import com.prototipo.p1.model.primary.ProdutoLocal;
import com.prototipo.p1.model.secondary.ProdutoExterno;
import com.prototipo.p1.service.ProdutoLocalService;
import com.prototipo.p1.view.CardFactory;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

@Controller
public class ProdutosTableController {

    @FXML private VBox segundaBox;

    @Autowired
    private PedidosHelper pedidosHelper;

    @Autowired
    private CardFactory cardFactory;

    @Autowired
    private ProdutoLocalService produtoLocalService; 

    //@Autowired
    //private ProdutoLocalRepository produtoLocalRepository;

    //@Autowired
    //private ProdutoExternoRepository produtoExternoRepository;

    public void initialize(){
        ProdutoExterno p1 = new ProdutoExterno(
            1001, 5012, "Pigmento Azul FTX", "L1234A", 150.0, LocalDate.now()
            );
    
            ProdutoExterno p2 = new ProdutoExterno(
            1002, 5013, "Pigmento Vermelho RVX", "L1235B", 200.0, LocalDate.now().plusDays(1)
            );
    
            List<ProdutoExterno> produtosExternos = List.of(p1, p2);
    
            for (ProdutoExterno externo : produtosExternos){
                PedidosDTO pedido = pedidosHelper.geraPedidoSemLocal(externo);
                ProdutoLocal produto = produtoLocalService.salvarPedido(pedido);
                
                Node card = cardFactory.geraCard(produto);
    
                segundaBox.getChildren().add(card);
    
    }

}
}