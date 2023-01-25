package com.tienda.mayorista.persistence.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "razon_social")
    private String razonSocial;

    private String ruc;

    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<Factura> facturas;

    @OneToMany(mappedBy = "proveedor")
    private List<ProductoProveedor> productoProveedors;

    public List<ProductoProveedor> getProductoProveedors() {
        return productoProveedors;
    }

    public void setProductoProveedors(List<ProductoProveedor> productoProveedors) {
        this.productoProveedors = productoProveedors;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
