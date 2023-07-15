package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        var productos = productoService.getProductos(false);
        model.addAttribute("productos", productos);
        
        return "/producto/listado";
    }
    
    @GetMapping("/agregar")
    public String agregar(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto/agregar";
    }
    
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto, MultipartFile imagenFile) {
        
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable("id") Long idProducto, Model model) {
        Producto producto = productoService.findById(idProducto);
        model.addAttribute("producto", producto);
        return "producto/modificar";
    }
    
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long idProducto) {
        productoService.deleteById(idProducto);
        return "redirect:/producto/listado";
    }
}

