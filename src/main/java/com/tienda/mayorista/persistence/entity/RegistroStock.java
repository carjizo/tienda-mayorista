package com.tienda.mayorista.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "registros_stock")
public class RegistroStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reg_stock")
    private Integer idRegStock;

    @Column(name = "id_producto")
    private Integer idProducto;

    private Integer cantidad;

    @OneToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getIdRegStock() {
        return idRegStock;
    }

    public void setIdRegStock(Integer idRegStock) {
        this.idRegStock = idRegStock;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
