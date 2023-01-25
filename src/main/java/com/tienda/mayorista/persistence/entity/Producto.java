package com.tienda.mayorista.persistence.entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    private String codigo;

    private String categoria;

    @Column(name = "fecha_vencimiento")
    private LocalDateTime fechaVencimiento;

    @OneToOne(mappedBy = "producto")
    private RegistroStock registroStocks;

    @OneToMany(mappedBy = "producto")
    private List<ProductoProveedor> productoProveedors;

    public List<ProductoProveedor> getProductoProveedors() {
        return productoProveedors;
    }

    public void setProductoProveedors(List<ProductoProveedor> productoProveedors) {
        this.productoProveedors = productoProveedors;
    }

    public RegistroStock getRegistroStocks() {
        return registroStocks;
    }

    public void setRegistroStocks(RegistroStock registroStocks) {
        this.registroStocks = registroStocks;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
