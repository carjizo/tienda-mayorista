package com.tienda.mayorista.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "productos_proveedores")
public class ProductoProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_proveedor")
    private Integer idProductoProveedor;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", insertable = false, updatable = false)
    private Proveedor proveedor;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getIdProductoProveedor() {
        return idProductoProveedor;
    }

    public void setIdProductoProveedor(Integer idProductoProveedor) {
        this.idProductoProveedor = idProductoProveedor;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }
}
