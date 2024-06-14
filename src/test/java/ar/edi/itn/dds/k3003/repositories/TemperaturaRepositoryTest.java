package ar.edi.itn.dds.k3003.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.utn.dds.k3003.model.Temperatura;
import ar.edu.utn.dds.k3003.repositories.TemperaturaRepository;

public class TemperaturaRepositoryTest {
    // private TemperaturaRepository temperaturaRepository;

    // @BeforeEach
    // void setUp() {
    //     this.temperaturaRepository = new TemperaturaRepository();
    // }

    // @Test
    // void testSave() {
    //     Integer heladeraId = 1;
    //     Integer temperaturaMedida = 10;
    //     LocalDateTime fecha = LocalDateTime.now();

    //     //Creo la clase que voy a guardar
    //     Temperatura temperatura = new Temperatura(heladeraId, temperaturaMedida, fecha);

    //     //Guardo y recibo lo que guarde
    //     Temperatura temperaturaGuardada = this.temperaturaRepository.save(temperatura);

    //     //Pruebo que recibo algo
    //     assertNotNull(temperaturaGuardada);
    //     //Pruebo que coincida lo que guarde con lo que efectivamente se guardo.
    //     assertEquals(temperatura, temperaturaGuardada);
    // }

    // @Test
    // void testFindByHeladeraId() {
    //     Integer heladeraId = 1;
    //     Integer temperaturaMedida1 = 12;
    //     LocalDateTime fecha1 = LocalDateTime.now();

    //     Integer temperaturaMedida2 = 10;
    //     LocalDateTime fecha2 = LocalDateTime.now();
    //     Integer heladeraId3 = 2;
    //     Integer temperaturaMedida3 = 8;
    //     LocalDateTime fecha3 = LocalDateTime.now();

    //     //Creo la clase que voy a guardar
    //     Temperatura temperatura1 = new Temperatura(heladeraId, temperaturaMedida1, fecha1);
    //     Temperatura temperatura2 = new Temperatura(heladeraId, temperaturaMedida2, fecha2);
    //     Temperatura temperatura3 = new Temperatura(heladeraId3, temperaturaMedida3, fecha3);

    //     this.temperaturaRepository.save(temperatura1);
    //     this.temperaturaRepository.save(temperatura2);
    //     this.temperaturaRepository.save(temperatura3);

    //     Collection<Temperatura> temperaturas = this.temperaturaRepository.findByheladeraId(1);
        
    //     for (Temperatura temperatura : temperaturas) {
    //         assertEquals(temperatura.getHeladeraId(), heladeraId);
    //     }
    // }
}
