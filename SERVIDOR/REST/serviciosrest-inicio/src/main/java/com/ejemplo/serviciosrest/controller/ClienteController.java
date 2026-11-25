package com.ejemplo.serviciosrest.controller;

import com.ejemplo.serviciosrest.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String lista(Model model) {
        model.addAttribute("clientes", clienteService.listaClientes());
        return "clientes/lista";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.buscaPorId(id));
        return "clientes/detalle";
    }

    @PostMapping("/{id}/borrar")
    public String borra(@PathVariable Long id) {
        clienteService.borra(id);
        return "redirect:/clientes";
    }
}
