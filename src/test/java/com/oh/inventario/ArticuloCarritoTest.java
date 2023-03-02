package com.oh.inventario;

import com.oh.inventario.carrito.compras.ArticuloCarrito;
import com.oh.inventario.carrito.compras.ArticuloCarritoRepository;
import com.oh.inventario.producto.Producto;
import com.oh.inventario.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ArticuloCarritoTest {
    // Se desactivado por que el EntityManager nos da un error;

    @Autowired
    private ArticuloCarritoRepository articuloCarritoRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testAniadirArticulo() {
        Producto producto = entityManager.find(Producto.class, 1L);
        Usuario usuario = entityManager.find(Usuario.class, 2L);
        ArticuloCarrito articuloCarrito = new ArticuloCarrito(5, producto, usuario);
        articuloCarritoRepository.save(articuloCarrito);
    }

    @Test
    public void testAniadirMultiplesArticulos() {
        Usuario usuario = new Usuario(1l);
        Producto producto1 = new Producto(3L);
        Producto producto2 = new Producto(4L);

        ArticuloCarrito articuloCarrito1 =
                new ArticuloCarrito(10, producto1, usuario);
        ArticuloCarrito articuloCarrito2 =
                new ArticuloCarrito(25, producto2, usuario);
// Para la version 9+
        // articuloCarritoRepository.saveAll(List.of(articuloCarrito1, articuloCarrito2));

// Para la version 8 de java
        List<ArticuloCarrito> articulos = new ArrayList<>();
        articulos.add(articuloCarrito1);
        articulos.add(articuloCarrito2);
        articuloCarritoRepository.saveAll(Collections.unmodifiableList(articulos));
//--------------------------
    }

    @Test
    public void testListarArticulos() {
        //https://youtu.be/yZXjA4wLR78?t=16465
        List<ArticuloCarrito> articuloCarritos = articuloCarritoRepository.findAll();
        articuloCarritos.forEach(System.out::println);
    }

    @Test
    public void testActualizarArticulo() {
        ArticuloCarrito articuloCarrito =
                articuloCarritoRepository.findById(1l).get();
        articuloCarrito.setCantidad(10);
        articuloCarrito.setProducto(new Producto(3l));

    }

    @Test
    public void testEliminarArticulo() {
        articuloCarritoRepository.deleteById(1l);
    }

}
