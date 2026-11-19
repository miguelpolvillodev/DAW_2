package com.unaempresa.segundoproyecto.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.unaempresa.segundoproyecto.controller.CategoriaController;
import com.unaempresa.segundoproyecto.controller.ClienteController;
import com.unaempresa.segundoproyecto.controller.PedidoController;
import com.unaempresa.segundoproyecto.controller.ProductoController;

@ControllerAdvice(assignableTypes = {
    ClienteController.class,
    PedidoController.class,
    ProductoController.class,
    CategoriaController.class
})
public class GlobalExceptionHandler {

    // Captura ClienteNoEncontradoException venga del controlador que venga.
    @ExceptionHandler(ClienteNoEncontradoException.class)
    public String handleClienteNoEncontrado(ClienteNoEncontradoException ex, Model model) {
        model.addAttribute("titulo", "Cliente no encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        return "error/cliente-no-encontrado";
    }

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public String handleProductoNoEncontrado(ProductoNoEncontradoException ex, Model model) {
        model.addAttribute("titulo", "Producto no encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        return "error/producto-no-encontrado";
    }

    @ExceptionHandler(PedidoNoEncontradoException.class)
    public String handlePedidoNoEncontrado(PedidoNoEncontradoException ex, Model model) {
        model.addAttribute("titulo", "Pedido no encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        return "error/pedido-no-encontrado";
    }

    @ExceptionHandler(CategoriaNoEncontradoException.class)
    public String handleCategoriaNoEncontrado(CategoriaNoEncontradoException ex, Model model) {
        model.addAttribute("titulo", "Categoría no encontrada");
        model.addAttribute("mensaje", ex.getMessage());
        return "error/categoria-no-encontrada";
    }

}