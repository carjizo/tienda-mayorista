package com.tienda.mayorista.persistence.mapper;

import com.tienda.mayorista.domain.Product;
import com.tienda.mayorista.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "categoria", target = "category"),
            @Mapping(source = "fechaVencimiento", target = "dateExpiry")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "productoProveedors", ignore = true),
            @Mapping(target = "registroStocks", ignore = true),
            @Mapping(target = "codigo", ignore = true)
    })
    Producto toProducto(Product product);
}
