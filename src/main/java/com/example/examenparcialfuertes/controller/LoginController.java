
package com.example.examenparcialfuertes.controller;


import com.example.examenparcialfuertes.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
/**
 *
 * @author BETZABET
 */
@Controller
public class LoginController {
  @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute Usuario usuario, Model model) {
        if ("admin".equals(usuario.getUsername()) && "admin".equals(usuario.getPassword())) {
            return "success";  // Redirige a la vista de éxito
        } else {
            model.addAttribute("error", "Credenciales incorrectas. Inténtalo de nuevo.");
            return "login";  // Muestra el formulario con un mensaje de error
        }
    }
}
