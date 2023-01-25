package com.tienda.mayorista.persistence.mapper;

import com.tienda.mayorista.domain.Bill;
import com.tienda.mayorista.persistence.entity.Factura;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VendorMapper.class,ClientMapper.class})
public interface BillMapper {

    @Mappings({
            @Mapping(source = "idFactura", target = "billId"),
            @Mapping(source = "horaPedido", target = "timeRequested"),
            @Mapping(source = "numeroFactura", target = "billNumber"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "idProveedor", target = "vendorId"),
            @Mapping(source = "detallePedido", target = "orderDetail"),
            @Mapping(source = "cliente", target = "client"),
            @Mapping(source = "proveedor", target = "vendor")
    })

    Bill toBill(Factura factura);
    List<Bill> toBills(List<Factura> facturas);

    @InheritInverseConfiguration
    @Mapping(target = "numeroSerie", ignore = true)
    Factura toFactura(Bill bill);
}
