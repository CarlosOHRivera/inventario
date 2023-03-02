package com.oh.inventario;

import com.oh.inventario.categoria.Categoria;
import com.oh.inventario.categoria.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class CatergoriaRepositoryTest {
   // @Autowired
   // private CategoriaRepository categoriaRepository;

   // @Test
    //public void testCrearCategoria() {
    //    Categoria categoriaGuardada = categoriaRepository.save(new Categoria("Plasticos"));
        // assertThat(categoriaGuardada.getId().GreaterThan(0.0) ); // da error
       // assertThat(categoriaGuardada.getId() > 0); //esta es solución practica


   // }

}
