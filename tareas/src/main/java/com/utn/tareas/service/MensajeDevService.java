package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService {
    @Override
    public void mostrarBienvenida() {
        System.out.println("DEV activo: Bienvenido, puedes empezar a probar.");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("DEV finalizado: Hasta luego, sigue desarrollando.");

    }
}