package com.curso.ecommerce.springecommerce.controller;

import com.curso.ecommerce.springecommerce.model.Producto;
import com.curso.ecommerce.springecommerce.model.Usuario;
import com.curso.ecommerce.springecommerce.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;


    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create(){

        return "productos/create";
    }
    @PostMapping("/save")
    public String save(Producto producto){

        logger.info("Este es el producto: {}", producto);

        Usuario user = new Usuario(2,"","","","","","","");
        producto.setUsuario(user);
        productoService.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){

        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();

        model.addAttribute("producto", producto);

        logger.info("Producto buscado: {}", producto);


        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto){

        productoService.update(producto);
        return "redirect:/productos";
    }




}
