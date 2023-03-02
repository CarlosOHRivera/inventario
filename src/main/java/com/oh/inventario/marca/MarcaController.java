package com.oh.inventario.marca;

import com.oh.inventario.categoria.Categoria;
import com.oh.inventario.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/marcas")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Se deja en blanco y toma por default el mapeo del requestmapping -- se asume como el metodo de entrada
    @GetMapping("")
    public String listarMarcas(Model model){
        List<Marca> listaMarcas = marcaRepository.findAll();
        model.addAttribute("listaMarcas",listaMarcas);
        return "marcas";
    }

    @GetMapping("/nuevo")
    public String mostrarFomularioNuevaMarca(Model model) {
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        model.addAttribute("listaCategorias", listaCategorias);
        model.addAttribute("marca", new Marca());
        return "marca_formulario";
    }

    @PostMapping("/guardar")
    public String guardarMarca(Marca marca) {
        marcaRepository.save(marca);
        return ("redirect:/marcas");
    }

    //Algo le falta a este metodo porque no presenta las opciones elegidas
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarMarca(@PathVariable("id") Long id, Model model){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        Marca marcaobj =  marcaRepository.findById(id).get();
        // enviemos los objetos al modelo
        model.addAttribute("marca",marcaobj);
        model.addAttribute("listaCategorias", listaCategorias);
        return "marca_formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMarca(@PathVariable("id") Long id){
        marcaRepository.deleteById(id);
        return "redirect:/marcas";
    }


}
