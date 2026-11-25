package com.ejemplo.vehiculos.controller;

import com.ejemplo.vehiculos.service.VehiculoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("vehiculos", vehiculoService.listaVehiculos());
        return "vehiculos/lista";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("vehiculo", vehiculoService.buscaPorId(id));
        return "vehiculos/detalle";
    }

    @PostMapping("/{id}/borrar")
    public String borra(@PathVariable Long id) {
        vehiculoService.borra(id);
        return "redirect:/vehiculos";
    }
}
