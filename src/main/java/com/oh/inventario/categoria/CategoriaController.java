package com.oh.inventario.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Se deja en blanco y toma por default el mapeo del requestmapping -- se asume como el metodo de entrada
    @GetMapping("")
    public String listarCategorias(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        return "categorias";
    }

    @GetMapping("/nuevo") // en el navegador : /categorias/nuevo
    public String mostrarFormularioDeNuevaCategoria(Model model) {
        // Categoria cat = new Categoria();
        // model.addAttribute("categoria", cat);
        model.addAttribute("categoria", new Categoria());
        return "categoria_formulario";
    }

    @PostMapping("/guardar") ///categorias/guardar
    public String guardarCategoria(@ModelAttribute("categoria") Categoria categoria) {
        categoriaRepository.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormualarioEditarCategoria(@PathVariable("id") Long id, Model model) {
        Categoria categoria = categoriaRepository.findById(id).get();
        model.addAttribute("categoria", categoria);
        return "categoria_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaRepository.deleteById(id);
        return "redirect:/categorias";
    }

/* //Tambien asi fuciona
@PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute("Categoria") Categoria categ){
        categoriaRepository.save(categ);
        return "redirect:/categorias";
    }*/

}
