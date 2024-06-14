package ar.edu.utn.dds.k3003.controllers;

import ar.edu.utn.dds.k3003.app.Fachada;

import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class TemperaturaController {
    private final Fachada fachada;

    public TemperaturaController(Fachada fachada) {
        this.fachada = fachada;
    }

    public void registrar(Context context) {
        var temperaturaDTO = context.bodyAsClass(TemperaturaDTO.class);
        this.fachada.temperatura(temperaturaDTO);
        context.status(HttpStatus.CREATED);
    }
}
