package com.oh.inventario.producto;

import com.oh.inventario.categoria.Categoria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, unique = true, nullable = false)
    private String nombre;

    @Column(precision = 7, scale = 2)
    private float precio;

    public Producto() {
        super();
    }

    public Producto(Long id) {
        this.id = id;
    }

    public Producto(String nombre) {
        this.nombre = nombre;
    }

    public Producto(String nombre, float precio, Categoria categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(Long id, String nombre, float precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
// Relaciones
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    public Categoria getCategoria() {
        return categoria;
    }

    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL)
    private List<ProductoDetalles> detalles= new ArrayList<>();
// Getters and Setters



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

//https://youtu.be/yZXjA4wLR78?t=9114
    public void aniadirDetalles(String nombre, String valor){
        this.detalles.add(new ProductoDetalles(nombre,valor,this));
        for (ProductoDetalles detallae : detalles){
            System.out.println(detallae.getNombre());
            System.out.println(detallae.getValor());

        }
    }

    public List<ProductoDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ProductoDetalles> detalles) {
        this.detalles = detalles;
    }


    public void setDetalle(Long id, String nombre, String valor) {
        this.detalles.add(new ProductoDetalles(id,nombre,valor,this));
    }

    @Override
    public String toString() {
        return  nombre ;
    }
}
