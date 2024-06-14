package ar.edi.itn.dds.k3003.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.repositories.HeladeraRepository;

public class HeladeraRepositoryTest {
    private HeladeraRepository heladeraRepository;

    // @BeforeEach
    // void setUp() {
    //     this.heladeraRepository = new HeladeraRepository();
    // }

    // @Test
    // void testSave() {
    //     //Datos a guardar
    //     Integer idHeladera = 1;
    //     String nombreHeladera = "Heladera Test 1";

    //     //Creo la clase que voy a guardar
    //     Heladera heladera = new Heladera(idHeladera, nombreHeladera);

    //     //Guardo y recibo lo que guarde
    //     Heladera heladeraGuardada = this.heladeraRepository.save(heladera);

    //     //Pruebo que recibo algo
    //     assertNotNull(heladeraGuardada);
    //     //Pruebo que coincida lo que guarde con lo que efectivamente se guardo.
    //     assertEquals(heladera, heladeraGuardada);
    // }

    // @Test
    // void testSeqId() {
    //     //Datos para 2 heladeras
    //     Integer idHeladera1 = 1;
    //     String nombreHeladera1 = "Heladera Test 1";
    //     Integer idHeladera2 = 2;
    //     String nombreHeladera2 = "Heladera Test 2";

    //     //Creo las 2 heladeras sin id
    //     Heladera heladera1 = new Heladera(nombreHeladera1);
    //     Heladera heladera2 = new Heladera(nombreHeladera2);

    //     //Guardo las 2 heladeras
    //     Heladera heladeraGuardada1 = this.heladeraRepository.save(heladera1);
    //     Heladera heladeraGuardada2 = this.heladeraRepository.save(heladera2);

    //     //Pruebo que haya funcionado bien el id secuencial
    //     assertEquals(heladeraGuardada1.getId(), idHeladera1);
    //     assertEquals(heladeraGuardada2.getId(), idHeladera2);
    // }

    // @Test
    // void testFindById() {
    //     //Datos para 2 heladeras
    //     Integer idHeladera1 = 1;
    //     String nombreHeladera1 = "Heladera Test 1";
    //     Integer idHeladera2 = 2;
    //     String nombreHeladera2 = "Heladera Test 2";

    //     //Creo las 2 heladeras 
    //     Heladera heladera1 = new Heladera(idHeladera1, nombreHeladera1);
    //     Heladera heladera2 = new Heladera(idHeladera2, nombreHeladera2);

    //     //Guardo las 2 heladeras
    //     Heladera heladeraGuardada1 = this.heladeraRepository.save(heladera1);
    //     Heladera heladeraGuardada2 = this.heladeraRepository.save(heladera2);

    //     //Busco las heladeras por id correspondiente
    //     Heladera heladeraEncontrada1 = this.heladeraRepository.findById(idHeladera1);
    //     Heladera heladeraEncontrada2 = this.heladeraRepository.findById(idHeladera2);

    //     //Pruebo que haya encontrado lo que corresponda
    //     assertEquals(heladeraGuardada1, heladeraEncontrada1);
    //     assertEquals(heladeraGuardada2, heladeraEncontrada2);
    // }
}
