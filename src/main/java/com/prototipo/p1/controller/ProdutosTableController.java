package com.prototipo.p1.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

@Controller
public class ProdutosTableController {

    @FXML private HBox boardBox;

    @Autowired
    private PedidosHelper pedidosHelper;

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

        Optional<LocalDate> minDatOpt = produtosExternos.stream()
        .map(ProdutoExterno::getData)
        .min(LocalDate::compareTo); 

        Optional<LocalDate> maxDatOpt = produtosExternos.stream()
        .map(ProdutoExterno::getData)
        .max(LocalDate::compareTo);

        if (minDatOpt.isEmpty() || maxDatOpt.isEmpty()){
                 System.err.println("Sem pedidos");
        }
            
        LocalDate minDate = minDatOpt.get();
        LocalDate maxDate = maxDatOpt.get();

        ArrayList<LocalDate> todasAsDatas = new ArrayList<>();
        LocalDate current = minDate; 
        while (!current.isAfter(maxDate)){
        todasAsDatas.add(current);
        current = current.plusDays(1); 
        }

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