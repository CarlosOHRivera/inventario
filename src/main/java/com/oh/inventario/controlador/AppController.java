package com.oh.inventario.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping()
    public String verIndex(){
        return "index";
    }

}
