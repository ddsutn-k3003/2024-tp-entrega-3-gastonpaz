package ar.edu.utn.dds.k3003.app;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.utn.dds.k3003.facades.FachadaViandas;
import ar.edu.utn.dds.k3003.facades.dtos.EstadoViandaEnum;
import ar.edu.utn.dds.k3003.facades.dtos.HeladeraDTO;
import ar.edu.utn.dds.k3003.facades.dtos.RetiroDTO;
import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import ar.edu.utn.dds.k3003.facades.dtos.ViandaDTO;
import ar.edu.utn.dds.k3003.model.Heladera;
import ar.edu.utn.dds.k3003.model.Operacion;
import ar.edu.utn.dds.k3003.model.Temperatura;
import ar.edu.utn.dds.k3003.repositories.HeladeraMapper;
import ar.edu.utn.dds.k3003.repositories.HeladeraRepository;
import ar.edu.utn.dds.k3003.repositories.OperacionRepository;
import ar.edu.utn.dds.k3003.repositories.TemperaturaMapper;
import ar.edu.utn.dds.k3003.repositories.TemperaturaRepository;

public class Fachada implements ar.edu.utn.dds.k3003.facades.FachadaHeladeras{
    private final HeladeraRepository heladeraRepository;
    private final HeladeraMapper heladeraMapper;
    private final TemperaturaRepository temperaturaRepository;
    private final TemperaturaMapper temperaturaMapper;
    private final OperacionRepository operacionRepository;

    private FachadaViandas fachadaViandas;

    public Fachada() {
        this.heladeraRepository = new HeladeraRepository();
        this.heladeraMapper = new HeladeraMapper();
        this.temperaturaRepository = new TemperaturaRepository();
        this.temperaturaMapper = new TemperaturaMapper();
        this.operacionRepository = new OperacionRepository();
    }

    @Override
    public HeladeraDTO agregar(HeladeraDTO heladeraDTO) {
        // Heladera heladera = new Heladera(heladeraDTO.getId(), heladeraDTO.getNombre());
        Heladera heladera = new Heladera(heladeraDTO.getNombre());
        heladera = this.heladeraRepository.save(heladera);
        return heladeraMapper.map(heladera);
    }

    @Override 
    public void depositar(Integer heladeraId, String qrViaString) throws NoSuchElementException {
        //Buso la heladera por id en mi heladeraRepository
        Heladera heladera = heladeraRepository.findById(heladeraId);

        //valido que la vianda exista
        ViandaDTO viandaDTO = this.fachadaViandas.buscarXQR(qrViaString);
        
        //Agrego que tengo una vianda mas
        heladeraRepository.agregarVianda(heladera);
        
        //Guardo la operacion de depositar para saber cuantas veces se abrio la heladera
        Operacion operacion = new Operacion(heladera.getId(), viandaDTO.getCodigoQR());
        operacion = this.operacionRepository.save(operacion);
        
        //Modifico estado vianda a depositada
        this.fachadaViandas.modificarEstado(viandaDTO.getCodigoQR(), EstadoViandaEnum.DEPOSITADA);
    }

    @Override
    public void retirar(RetiroDTO retiro) throws NoSuchElementException {
        //Buso la heladera por id en mi heladeraRepository
        Heladera heladera = heladeraRepository.findById(retiro.getHeladeraId());

        //valido que la vianda exista
        ViandaDTO viandaDTO = this.fachadaViandas.buscarXQR(retiro.getQrVianda());

        //Resto una vianda a ocupacion ya que me la retiran
        heladeraRepository.retirarVianda(heladera);
        
        //Guardo la operacion de retiro para saber cuantas veces se abrio la heladera
        Operacion operacion = new Operacion(heladera.getId(), viandaDTO.getCodigoQR());
        operacion = this.operacionRepository.save(operacion);

        //Modifico estado vianda a retirada
        this.fachadaViandas.modificarEstado(viandaDTO.getCodigoQR(), EstadoViandaEnum.RETIRADA);
    }

    @Override
    public List<TemperaturaDTO> obtenerTemperaturas(Integer heladeraId) {
        //Obtengo las temperaturas segun la heladera
        Collection<Temperatura> temperaturas = this.temperaturaRepository.findByheladeraId(heladeraId);

        //Devuelvo la lista de temperaturas en DTO
        return this.temperaturaMapper.map(temperaturas);
    }

    @Override
    public void temperatura(TemperaturaDTO temperaturaDTO) {
        //Esto comentado abajo lo saco porque no lo pide la consigna y fallan los test de HeladeraTest para entrega 1
        //Buso la heladera por id en mi heladeraRepository
        // Heladera heladera = heladeraRepository.findById(temperaturaDTO.getHeladeraId());

        // //Actualizo la temperatura actual = temperatura utlima medicion
        // heladera.setTemperaturaActual(temperaturaDTO.getTemperatura());

        //Guardo en el repositorio la medicion
        Temperatura temperatura = new Temperatura(temperaturaDTO.getHeladeraId(), temperaturaDTO.getTemperatura(), temperaturaDTO.getFechaMedicion());
        this.temperaturaRepository.save(temperatura);
    }

    @Override
    public Integer cantidadViandas(Integer heladeraId) throws NoSuchElementException {
        //Buso la heladera por id en mi heladeraRepository
        Heladera heladera = heladeraRepository.findById(heladeraId);

        //Devuelvo la cantidad de viandas que tiene la heladera = ocupacion heladera
        return heladera.getOcupacion();
    }

    @Override
    public void setViandasProxy(FachadaViandas viandas) {
        this.fachadaViandas = viandas;
    }

    public HeladeraDTO buscarHeladeraXId(Integer heladeraId) throws NoSuchElementException{
        //Busco la heladera por id en mi heladeraRepository
        Heladera heladera = heladeraRepository.findById(heladeraId);

        //Devuelvo la heladera encontrada como HeladeraDTO
        return heladeraMapper.map(heladera);
    }
}
