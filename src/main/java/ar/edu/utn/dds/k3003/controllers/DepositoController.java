package ar.edu.utn.dds.k3003.controllers;

import java.util.NoSuchElementException;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.dtos.DepositoDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class DepositoController {
    private final Fachada fachada;

    public DepositoController(Fachada fachada) {
        this.fachada = fachada;
    }

    public void depositar(Context context) {
        var depositoDTO = context.bodyAsClass(DepositoDTO.class);

        try {
            this.fachada.depositar(depositoDTO.getHeladeraId(), depositoDTO.getQrVianda());

            //Si no tiro ex devuelvo OK
            context.status(HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            context.result(ex.getLocalizedMessage());
            context.status(HttpStatus.NOT_FOUND);
        }
    }
}
