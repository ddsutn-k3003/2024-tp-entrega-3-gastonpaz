package ar.edi.itn.dds.k3003.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.edu.utn.dds.k3003.app.Fachada;
import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.HeladeraDTO;
import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;

@ExtendWith(MockitoExtension.class)
public class FachadaTest {
    // @Mock
    // private FachadaViandas fachadaViandas;

    // @InjectMocks
    // private Fachada fachada;
    
    // @Test
    // void testAgregar() {
    //     Integer heladeraId = 3;
    //     String heladeraNombre = "Heladera Test";

    //     //HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraId, heladeraNombre);
    //     HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraNombre);
    //     heladeraDTO.setId(heladeraId);

    //     HeladeraDTO heladeraAgregada = this.fachada.agregar(heladeraDTO);

    //     assertEquals(heladeraDTO, heladeraAgregada);
    // }

    // @Test
    // void testCantidadViandas() {
    //     //Integer heladeraId = 1;
    //     String qrViaString1 = "QR123";
    //     String qrViaString2 = "QR456";
    //     Integer heladeraIdTest = 1;
    //     String heladeraNombreTest = "Heladera Test 1";

    //     //HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraIdTest, heladeraNombreTest);
    //     HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraNombreTest);
    //     heladeraDTO.setId(heladeraIdTest);
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR123")).thenReturn(new ViandaDTO("QR123", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR456")).thenReturn(new ViandaDTO("QR456", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));

    //     HeladeraDTO heladeraAgregada = this.fachada.agregar(heladeraDTO);

    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString1);
    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString2);

    //     Integer cantidadViandasFachada = this.fachada.cantidadViandas(heladeraIdTest);

    //     Integer cantidadViandasTest = 2;
    //     assertEquals(cantidadViandasFachada, cantidadViandasTest);
    // }

    // @Test
    // void testDepositar() {
    //     //Integer heladeraId = 1;
    //     String qrViaString1 = "QR123";
    //     String qrViaString2 = "QR456";
    //     String qrViaString3 = "QR789";

    //     Integer heladeraIdTest = 1;
    //     String heladeraNombreTest = "Heladera Test 1";

    //     //HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraIdTest, heladeraNombreTest);
    //     HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraNombreTest);
    //     heladeraDTO.setId(heladeraIdTest);
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR123")).thenReturn(new ViandaDTO("QR123", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR456")).thenReturn(new ViandaDTO("QR456", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR789")).thenReturn(new ViandaDTO("QR789", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));

    //     HeladeraDTO heladeraAgregada = this.fachada.agregar(heladeraDTO);

    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString1);
    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString2);
    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString3);

    //     Integer cantidadViandasDepositadas = 3;
    //     Integer cantidadViandasFachada = this.fachada.cantidadViandas(heladeraIdTest);
    //     assertEquals(cantidadViandasDepositadas, cantidadViandasFachada);
    // }

    // @Test
    // void testRetirar() {
    //     String qrViaString1 = "QR123";
    //     String qrViaString2 = "QR456";
    //     String qrViaString3 = "QR789";
    //     String heladeraTarjeta = "Tarjeta Heladera test";

    //     Integer heladeraIdTest = 1;
    //     String heladeraNombreTest = "Heladera Test 1";

    //     //HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraIdTest, heladeraNombreTest);
    //     HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraNombreTest);
    //     heladeraDTO.setId(heladeraIdTest);

    //     HeladeraDTO heladeraAgregada = this.fachada.agregar(heladeraDTO);
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR123")).thenReturn(new ViandaDTO("QR123", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR456")).thenReturn(new ViandaDTO("QR456", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));
    //     Mockito.when(this.fachadaViandas.buscarXQR("QR789")).thenReturn(new ViandaDTO("QR789", LocalDateTime.now(), EstadoViandaEnum.PREPARADA, (long) 1, 1));

    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString1);
    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString2);
    //     this.fachada.depositar(heladeraAgregada.getId(), qrViaString3);

    //     Integer cantidadViandasDepositadas = 3;
    //     Integer cantidadViandasFachada = this.fachada.cantidadViandas(heladeraIdTest);
    //     assertEquals(cantidadViandasDepositadas, cantidadViandasFachada);

    //     RetiroDTO retiroDTO = new RetiroDTO(qrViaString3, heladeraTarjeta, heladeraIdTest);
    //     this.fachada.retirar(retiroDTO);
    //     cantidadViandasDepositadas --;
    //     cantidadViandasFachada = this.fachada.cantidadViandas(heladeraIdTest);
    //     assertEquals(cantidadViandasDepositadas, cantidadViandasFachada);
    // }

    // @Test
    // void testTemperaturas() {
    //     Integer heladeraIdTest = 1;
    //     String heladeraNombreTest = "Heladera Test 1";
    //     //HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraIdTest, heladeraNombreTest);
    //     HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraNombreTest);
    //     heladeraDTO.setId(heladeraIdTest);
    //     HeladeraDTO heladeraAgregada = this.fachada.agregar(heladeraDTO);

    //     TemperaturaDTO temperatura = new TemperaturaDTO(10, heladeraIdTest, LocalDateTime.now());

    //     this.fachada.temperatura(temperatura);

    //     List<TemperaturaDTO> temperaturasObtenidas = this.fachada.obtenerTemperaturas(heladeraAgregada.getId());
    //     Integer temperaturasAgregadas = 1;
    //     Integer temperaturasObtenidasCantidad = temperaturasObtenidas.size();
    //     assertEquals(temperaturasAgregadas, temperaturasObtenidasCantidad);
    //     assertEquals(temperatura, temperaturasObtenidas.get(0));
    // }

    // @Test
    // void testObtenerTemperaturas() {
    //     Integer heladeraIdTest = 1;
    //     String heladeraNombreTest = "Heladera Test 1";
    //     //HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraIdTest, heladeraNombreTest);
    //     HeladeraDTO heladeraDTO = new HeladeraDTO(heladeraNombreTest);
    //     heladeraDTO.setId(heladeraIdTest);
    //     HeladeraDTO heladeraAgregada = this.fachada.agregar(heladeraDTO);

    //     TemperaturaDTO temperatura1 = new TemperaturaDTO(10, heladeraIdTest, LocalDateTime.now());
    //     TemperaturaDTO temperatura2 = new TemperaturaDTO(12, heladeraIdTest, LocalDateTime.now());

    //     this.fachada.temperatura(temperatura1);
    //     this.fachada.temperatura(temperatura2);

    //     List<TemperaturaDTO> temperaturasObtenidas = this.fachada.obtenerTemperaturas(heladeraAgregada.getId());
    //     Integer temperaturasAgregadas = 2;
    //     Integer temperaturasObtenidasCantidad = temperaturasObtenidas.size();
    //     assertEquals(temperaturasAgregadas, temperaturasObtenidasCantidad);
    // }
}
