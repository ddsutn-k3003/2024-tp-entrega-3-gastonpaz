package ar.edu.utn.dds.k3003.controllers;

import ar.edu.utn.dds.k3003.repositories.HeladeraRepository;
import ar.edu.utn.dds.k3003.repositories.OperacionRepository;
import ar.edu.utn.dds.k3003.repositories.TemperaturaRepository;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class CleanupController {

    private final HeladeraRepository heladeraRepository;
    private final OperacionRepository operacionRepository;
    private final TemperaturaRepository temperaturaRepository;

    public CleanupController() {
        this.heladeraRepository = new HeladeraRepository();
        this.operacionRepository = new OperacionRepository();
        this.temperaturaRepository = new TemperaturaRepository();
    }

    public void cleanup(Context context) {
        heladeraRepository.deleteAll();
        operacionRepository.deleteAll();
        temperaturaRepository.deleteAll();
        context.status(HttpStatus.OK);
    }
}
