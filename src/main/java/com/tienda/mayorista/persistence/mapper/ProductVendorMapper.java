package com.tienda.mayorista.persistence.mapper;

import com.tienda.mayorista.domain.ProductVendor;
import com.tienda.mayorista.persistence.entity.ProductoProveedor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VendorMapper.class,ProductMapper.class})
public interface ProductVendorMapper {

    @Mappings({
            @Mapping(source = "idProductoProveedor", target = "productVendorId"),
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "idProveedor", target = "vendorId"),
            @Mapping(source = "producto", target = "product"),
            @Mapping(source = "proveedor", target = "vendor"),
    })

    ProductVendor toProductVendor(ProductoProveedor productoProveedor);
    List<ProductVendor> toProductVendors(List<ProductoProveedor> productoProveedors);

    @InheritInverseConfiguration
    ProductoProveedor toProductoProveedor(ProductVendor productVendor);
}
