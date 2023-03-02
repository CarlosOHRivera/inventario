package com.oh.inventario;

import com.oh.inventario.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    /* No se ha probado esta clase por que no funciona El TestEntityManager */
    /*
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void tesCrearRoles() {
        Rol rolAdmin = new Rol("Administrador");
        Rol rolEditor = new Rol("Editor");
        Rol rolVisitante = new Rol("Visitante");
        entityManager.persist(rolAdmin);
        entityManager.persist(rolEditor);
        entityManager.persist(rolVisitante);
    }


    @Test
    public void tesCrearNuevoUsarioConUnRol() {
        Rol rolEditor = entityManager.find(Rol.class, 2);
        Rol rolVisitante = entityManager.find(Rol.class, 3);

        Usuario usuario = new Usuario("COHR@gmail.com", "12345");
        usuario.aniadirRol(rolEditor);
        usuario.aniadirRol(rolEditor);
        usuarioRepository.save(usuario);
    }

    @Test
    public void tesCrearNuevoUsarioConDosRoles() {
        Rol rolAdmin = entityManager.find(Rol.class, 1);
        Usuario usuario = new Usuario("CarlosOH@gmail.com", "123");
        usuario.aniadirRol(rolAdmin);
        usuarioRepository.save(usuario);
    }

    @Test
    public void tesAsignarRolAUsuarioExistente() {
        Usuario usuario = usuarioRepository.findById(1L).get();
        Rol rolEditor = entityManager.find(Rol.class, 2);
        usuario.aniadirRol(rolEditor); // Lo graba automaticamente;
    }
    @Test
    public void testEliminarRolExistenteDeUsuario(){
        Usuario usuario = usuarioRepository.findById(1L).get();
        Rol rol = new Rol(2L);//LE PASAMOS ID DEL ROL A ELIMINAR
        usuario.eliminarRol(rol);
    }

    @Test
    public void tesCrearNuevoUsarioConNuevoRol() {

        Rol rolAdmin = new Rol("OtroRol");
        Rol rolAdmin = entityManager.find(Rol.class, 1);
        Usuario usuario = new Usuario("CarlosOH@gmail.com", "123");
        usuario.aniadirRol(rolAdmin);
        usuarioRepository.save(usuario);

    @Test
    public void testObtenerUsuario() {
        Usuario usuario = usuarioRepository.findById(1l).get();
        entityManager.detach(usuario);
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getRoles());
    }

    @Test
    public void testEliminarUsuario() {
        usuarioRepository.deleteById(2L);
    }*/


}
