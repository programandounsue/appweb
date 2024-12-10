package com.sena.autenticacion.model;

public class Main {
    public static void main(String[] args) {
        // Usuario con nombre 'MASTER' y contraseña '123456789'
        Usuario usuario = new Usuario("MASTER", "123456789");

        
        System.out.println("Antes de modificar la contraseña: " + usuario);

        // Modificar la contraseña
        usuario.setPassword("nuevaContraseña123");

        // Mostrar el usuario después de modificar la contraseña
        System.out.println("Después de modificar la contraseña: " + usuario);
    }
}
