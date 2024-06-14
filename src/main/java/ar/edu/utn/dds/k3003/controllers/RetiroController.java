package ar.edu.utn.dds.k3003.controllers;

import java.util.NoSuchElementException;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class RetiroController {
    private final Fachada fachada;

    public RetiroController(Fachada fachada) {
        this.fachada = fachada;
    }

    public void retirar(Context context) {
        var retiroDTO = context.bodyAsClass(RetiroDTO.class);
        
        try {
            this.fachada.retirar(retiroDTO);
            //Si no tiro ex devuelvo OK
            context.status(HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            context.result(ex.getLocalizedMessage());
            context.status(HttpStatus.NOT_FOUND);
        }
    }
}
