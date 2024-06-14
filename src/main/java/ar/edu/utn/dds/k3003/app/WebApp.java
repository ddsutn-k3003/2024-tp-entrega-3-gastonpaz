package ar.edu.utn.dds.k3003.app;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;

import ar.edu.utn.dds.k3003.clients.ViandasProxy;
import ar.edu.utn.dds.k3003.controllers.CleanupController;
import ar.edu.utn.dds.k3003.controllers.DepositoController;
import ar.edu.utn.dds.k3003.controllers.HeladeraController;
import ar.edu.utn.dds.k3003.controllers.RetiroController;
import ar.edu.utn.dds.k3003.controllers.TemperaturaController;
import ar.edu.utn.dds.k3003.facades.dtos.Constants;
import ar.edu.utn.dds.k3003.model.CustomLocalDateTimeDeserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.module.SimpleModule;

import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;

import java.util.TimeZone;

public class WebApp {
    public static void main(String[] args) {

        var env = System.getenv();
        var objectMapper = createObjectMapper();
        var fachada = new Fachada();
        fachada.setViandasProxy(new ViandasProxy(objectMapper));

        var port = Integer.parseInt(env.getOrDefault("PORT", "8080"));

        //var app = Javalin.create().start(port);
        var app = Javalin.create(config -> {
            config.jsonMapper(new JavalinJackson(objectMapper));
        }).start(port);

        var heladerasController = new HeladeraController(fachada);
        var depositosController = new DepositoController(fachada);
        var retirosController = new RetiroController(fachada);
        var temperaturasController = new TemperaturaController(fachada);
        var cleanupController = new CleanupController();

        app.post("/heladeras", heladerasController::agregar);
        app.get("/heladeras/{id}", heladerasController::obtener);
        app.post("/depositos", depositosController::depositar);
        app.post("/retiros", retirosController::retirar);
        app.post("/temperaturas", temperaturasController::registrar);
        app.get("/heladeras/{id}/temperaturas", heladerasController::obtenerTemperaturas);
        app.get("/heladeras/{id}/viandas", heladerasController::obtenerCantidadViandas);
        app.delete("/cleanup", cleanupController::cleanup);
    }

    public static ObjectMapper createObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDateTime.class, new CustomLocalDateTimeDeserializer());
        objectMapper.registerModule(module);

        var sdf = new SimpleDateFormat(Constants.DEFAULT_SERIALIZATION_FORMAT, Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        objectMapper.setDateFormat(sdf);

        return objectMapper;
    }
}
