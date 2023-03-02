package com.oh.inventario;

import com.oh.inventario.categoria.CategoriaRepository;
import com.oh.inventario.usuario.Rol;
import com.oh.inventario.usuario.RolRepository;
import com.oh.inventario.usuario.Usuario;
import com.oh.inventario.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;


@SpringBootApplication
public class InventarioApplication implements CommandLineRunner {

    @Autowired
    CategoriaRepository categoriaRepository;

    // Estas son para las pruebas de muchos a muchos de Rol y Usuario
    @Autowired
    RolRepository rolRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Las pruebas se hicieron manualmente por error de TestEntityManager nen las clases de pruebas
        /*	categoriaRepository.save(new Categoria("Electronicos"));*/
        /*List<Categoria> categorias = categoriaRepository.findAll();*/

        /*
        Categoria currentcat = null;
        for (int i = 0; i < categorias.size(); i++){
            currentcat = categorias.get(i);
        System.out.println(currentcat.toString());}
*/
              /*
        for (Categoria cat : categorias) {
            System.out.print(cat.getId()); //campos individuales
            System.out.println("-" + cat.getNombre()); //campos individuales
            System.out.println(cat.toString());
        }*/

        //En el siguiente apartado se haran las pruebas de la relacion MUCHOS A MUCHOS de las tablas Usuario y Rol
        //========================================================================================================
        // Efectuar un paso a la vez
        //Paso 1
    /*    Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");
        rolRepository.save(rolAdmin);
        rolRepository.save(rolEditor);
        rolRepository.save(rolVisitante);

        //Paso 2  tesCrearNuevoUsarioConUnRol() -- no me funciona hasta ahora..
        Usuario usuario = new Usuario("COHR@gmail.com", "12345");
        usuario.aniadirRol(new Rol("Admin") );
        usuarioRepository.save(usuario);
*/

    }
}
