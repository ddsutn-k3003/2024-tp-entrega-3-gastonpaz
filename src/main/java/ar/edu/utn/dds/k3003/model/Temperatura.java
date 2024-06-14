package ar.edu.utn.dds.k3003.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "temperaturas")
public class Temperatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer heladeraId;

    @Column(nullable = false)
    private Integer temperatura;

    @Column(nullable = false)
    private LocalDateTime fecha;
    
    public Temperatura() {}

    public Temperatura(Integer heladeraId, Integer temperaturaMedida, LocalDateTime fechaMedicion) {
        this.heladeraId = heladeraId;
        this.temperatura = temperaturaMedida;
        this.fecha = fechaMedicion;
    }
}
