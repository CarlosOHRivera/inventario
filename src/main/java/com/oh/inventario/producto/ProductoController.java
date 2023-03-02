package com.oh.inventario.producto;

import com.oh.inventario.categoria.Categoria;
import com.oh.inventario.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/productos")

public class ProductoController {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;

    // Se deja en blanco.. pero en realidad asume el url del @Requestmapping ... y asi mismo los metodos hijos
    @GetMapping("")// en el navegador : /productos
    public String listarProductos(Model model) {
        List<Producto> listaProductos = productoRepository.findAll();
        model.addAttribute("listaproductos", listaProductos);
        return "productos";
    }

    @GetMapping("/nuevo")// en el navegador : /productos/nuevo
    public String mostrarFormularioDeNuevoProducto(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("producto", new Producto());
        model.addAttribute("listaCategorias", listaCategorias);
        return "productos_formulario";
    }

    //https://youtu.be/yZXjA4wLR78?t=9938
    @PostMapping("/guardar")// en el navegador : /productos/guardar
    public String guardarProducto(@ModelAttribute("producto") Producto producto,
                                  HttpServletRequest request) {
        // hace falta la opcion de buscar si ya existe... para actualizarlo
        // Se ha resuelto poniendo un input hidden que capture el id actual..
        String[] detallesIDs = request.getParameterValues("detallesID");
        String[] detallesNombres = request.getParameterValues("detallesNombre");
        String[] detallesValores = request.getParameterValues("detallesValor");

/*
        productoRepository.save(producto);
        List<ProductoDetalles> productoDetalles = new ArrayList<>();
        for (int i = 0; i < detallesNombres.length; i++) {
            productoDetalles.add(new ProductoDetalles( detallesNombres[i], detallesValores[i]) );
        }
*/
        int x =0;

        for (Object o : detallesNombres){
            if (detallesIDs != null && detallesIDs.length > 0) {
                producto.setDetalle(Long.valueOf(detallesIDs[x]), detallesNombres[x], detallesValores[x]);
            } else {
                producto.aniadirDetalles(detallesNombres[x], detallesValores[x]);
            }
            x++;
        }
/* Por alguna razon.. no ingresa a este loop..
        for (int i = 0; i < detallesNombres.length; i++) {
            if (detallesIDs != null && detallesIDs.length > 0) {
                producto.setDetalle(Long.valueOf(detallesIDs[i]), detallesNombres[i], detallesValores[i]);
            } else {
                producto.aniadirDetalles(detallesNombres[i], detallesValores[i]);
            }
        }
*/
        productoRepository.save(producto);
        return "redirect:/productos";
    }

    // https://youtu.be/yZXjA4wLR78?t=8554 --- de alli me da error
    @GetMapping("/editar/{id}") // en el navegador : /productos/editar/{id}"
    public String mostrarFormularioDeEditarProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoRepository.findById(id).get();
        model.addAttribute("producto", producto);
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "productos_formulario";
    }

    @GetMapping("/productos/eliminar/{id}")
    // en el navegador : /productos/eliminar/{id}" -- No se para que sirve el model aca
    public String eliminarProducto(@PathVariable("id") Long id, Model model) {
        productoRepository.deleteById(id);
        return "redirect:/productos";
    }
}
