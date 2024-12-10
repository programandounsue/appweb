package com.sena.autenticacion;

import com.sena.autenticacion.model.Usuario;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AutoSevioService {

    // Mapa de usuarios (simulando una base de datos en memoria)
    private Map<String, Usuario> usuariosRegistrados = new HashMap<>();

    // Registro de usuario
    @PostMapping("/registro")
    public String registrar(@RequestParam String username, @RequestParam String password) {
        if (usuariosRegistrados.containsKey(username)) {
            return "Usuario ya registrado";
        }
        usuariosRegistrados.put(username, new Usuario(username, password));
        return "Usuario registrado correctamente";
    }

    // Login de usuario
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        Usuario usuario = usuariosRegistrados.get(username);
        if (usuario == null) {
            return "Usuario no encontrado";
        }
        if (usuario.getPassword().equals(password)) {
            return "Bienvenido, " + username;
        } else {
            return "Credenciales incorrectas";
        }
    }
}
