package com.tienda.mayorista.persistence.mapper;

import com.tienda.mayorista.domain.Vendor;
import com.tienda.mayorista.persistence.entity.Proveedor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    @Mappings({
            @Mapping(source = "idProveedor", target = "vendorId"),
            @Mapping(source = "razonSocial", target = "businessName"),
            @Mapping(source = "ruc", target = "ruc"),
            @Mapping(source = "direccion", target = "adress"),
    })
    Vendor toVendor(Proveedor proveedor);
    List<Vendor> toVendors(List<Proveedor> proveedors);

    @InheritInverseConfiguration
    @Mapping(target = "productoProveedors", ignore = true)
    @Mapping(target = "facturas", ignore = true)
    Proveedor toProveedor(Vendor vendor);
}
