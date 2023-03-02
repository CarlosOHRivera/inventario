package com.oh.inventario.carrito.compras;

import com.oh.inventario.producto.Producto;
import com.oh.inventario.usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "articulo_carrito")
public class ArticuloCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    // Relaciones
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne

    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructores

    public ArticuloCarrito() {
        super();
    }

    public ArticuloCarrito(Long id) {
        this.id = id;
    }

    public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }

    public ArticuloCarrito(Long id, int cantidad, Producto producto, Usuario usuario) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }

    // Getters - Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
