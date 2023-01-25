package com.tienda.mayorista.persistence.mapper;

import com.tienda.mayorista.domain.RegisterStock;
import com.tienda.mayorista.persistence.entity.RegistroStock;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface RegisterStockMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productoId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "idRegStock", target = "registerStockId"),
            @Mapping(source = "producto", target = "product"),
    })
    RegisterStock toRegisterStock(RegistroStock registroStock);
    List<RegisterStock> toRegisterStocks(List<RegistroStock> registroStocks);

    @InheritInverseConfiguration
    RegistroStock toRegistroStock(RegisterStock registerStock);
}
