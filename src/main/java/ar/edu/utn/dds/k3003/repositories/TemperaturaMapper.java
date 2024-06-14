package ar.edu.utn.dds.k3003.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.edu.utn.dds.k3003.facades.dtos.TemperaturaDTO;
import ar.edu.utn.dds.k3003.model.Temperatura;

public class TemperaturaMapper {
    
    public List<TemperaturaDTO> map(Collection<Temperatura> temperaturas) {
        List<TemperaturaDTO> temperaturaDTOs = new ArrayList<>();
        
        for (Temperatura temperatura : temperaturas) {
            TemperaturaDTO temperaturaDTO = new TemperaturaDTO(temperatura.getTemperatura(), temperatura.getHeladeraId(), temperatura.getFecha());
            temperaturaDTOs.add(temperaturaDTO);
        }

        return temperaturaDTOs;
    }

}
