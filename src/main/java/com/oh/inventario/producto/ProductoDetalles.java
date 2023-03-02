package com.oh.inventario.producto;


import javax.persistence.*;

@Entity
@Table(name ="ProductoDetalles" )
public class ProductoDetalles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45,nullable = false) // No puede ser Unico porque los detalles se pueden repetir
    private String nombre;

    @Column(length = 45,nullable = false) // No puede ser Unico
    private String  valor;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;

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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Constructores

    public ProductoDetalles() {
        super();
    }

    public ProductoDetalles(String nombre, String valor, Producto producto) {
        super();
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }

    public ProductoDetalles(Long id, String nombre, String valor, Producto producto) {
        this.id = id;
        this.nombre = nombre;
        this.valor = valor;
        this.producto = producto;
    }
    // toString

    @Override
    public String toString() {
        return  nombre + '-' + valor ;
    }
}
