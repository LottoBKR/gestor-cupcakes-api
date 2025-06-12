package com.alfajor.gestion_cupcakes.utils;

import com.alfajor.gestion_cupcakes.models.dto.IngredienteDTO;
import com.alfajor.gestion_cupcakes.models.dto.ProductoDTO;

import java.util.List;

public class CalculosUtil {

    public Double calcularPrecioTotal(List<IngredienteDTO> ingredientes){
        Double precioTotal = .0;
        ingredientes.forEach(i -> {
            //precioTotal += i.getPrecioPorUso();
        });
        return precioTotal;
    }

    private Double calculaPrecioPorGramosUsados(ProductoDTO producto, IngredienteDTO ingrediente){
        return ingrediente.getGramosUsados() * calculaPrecioPorGramo(producto);
    }

    private Double calculaPrecioPorGramo(ProductoDTO producto){
        return producto.getPrecio() / producto.getPesoEnGramos();
    }
}
