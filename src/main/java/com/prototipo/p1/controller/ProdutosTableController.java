package com.prototipo.p1.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.prototipo.p1.dto.PedidosDTO;
import com.prototipo.p1.model.primary.ProdutoLocal;
import com.prototipo.p1.model.secondary.ProdutoExterno;
import com.prototipo.p1.service.ProdutoLocalService;
import com.prototipo.p1.view.CardFactory;
import com.prototipo.p1.view.ColumnFactory;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

@Controller
public class ProdutosTableController {

    @FXML private HBox boardBox;

    @Autowired
    private PedidosHelper pedidosHelper;

    @Autowired 
    private ColumnHelper columnHelper;

    @Autowired
    private CardFactory cardFactory;

    @Autowired
    private ProdutoLocalService produtoLocalService; 
    
    @Autowired
    private ColumnFactory columnFactory;

    //@Autowired
    //private ProdutoLocalRepository produtoLocalRepository;

    //@Autowired
    //private ProdutoExternoRepository produtoExternoRepository;

    public void initialize(){


        ProdutoExterno p1 = new ProdutoExterno(
        1001, 5012, "Pigmento Azul FTX", "L1234A", 150.0, LocalDate.now()
            );
    
        ProdutoExterno p3 = new ProdutoExterno(
        1001, 5012, "Pigmento Azul FTX", "L1234A", 150.0, LocalDate.now().plusDays(2)
            );

        ProdutoExterno p2 = new ProdutoExterno(
        1002, 5013, "Pigmento Vermelho RVX", "L1235B", 200.0, LocalDate.now().plusDays(5)
            );
    
        List<ProdutoExterno> produtosExternos = List.of(p1, p2, p3);

        ArrayList<LocalDate> todasAsDatas = columnHelper.geraDatas(produtosExternos);


        for (LocalDate date : todasAsDatas){
            VBox column = columnFactory.geraColuna(date);  

            for (ProdutoExterno externo : produtosExternos){
                if (externo.getData().equals(date)){
                PedidosDTO pedido = pedidosHelper.geraPedidoSemLocal(externo);
                ProdutoLocal produto = produtoLocalService.salvarPedido(pedido);
                
                Node card = cardFactory.geraCard(produto);

                column.getChildren().add(card);
                }

            }

            boardBox.getChildren().add(column);
        }
            
    
     
    

}
}