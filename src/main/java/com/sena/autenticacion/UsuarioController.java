package com.sena.autenticacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {

    private Map<String, String> usuarios = new HashMap<>();

    // Constructor
    public UsuarioController() {
        usuarios.put("MASTER", "123456789");
    }  // Aquí falta la llave de cierre del constructor

    @PostMapping("/registro")
    public String registrar(@RequestParam String username, @RequestParam String password) {
        if (usuarios.containsKey(username)) {
            return "El usuario ya existe.";
        }

        // Registrar el usuario en el mapa
        usuarios.put(username, password);
        return "Usuario registrado con éxito: " + username;
    }

    @PostMapping("/login.html")
    public String login(@RequestParam String username, @RequestParam String password) {
        String storedPassword = usuarios.get(username);

        if (storedPassword == null) {
            return "Usuario no encontrado.";
        }

        if (storedPassword.equals(password)) {
            return "redirect:/home";
        } else {
            return "Contraseña incorrecta.";
        }
    }

    // Página de inicio
    @GetMapping("/")
    public String inicio() {
        return "login.html";
    }

    @GetMapping("/home.html")
    public String home() {
        return "home.html";
    }
}
