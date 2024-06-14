package ar.edu.utn.dds.k3003.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "heladeras")
public class Heladera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = true)
    private Double longitud;
    @Column(nullable = true)
    private Double latitud;
    @Column(nullable = true)
    private String direccion;
    @Column(nullable = true)
    private Integer ocupacion; // cantidad de viandas que hay en la heladera
    @Column(nullable = true)
    private Integer capacidad; // cantidad de viandas maxima de la heladera
    @Column(nullable = true)
    private Integer temperaturaMaxima;
    @Column(nullable = true)
    private Integer temperaturaMinima;
    @Column(nullable = true)
    private Integer temperaturaActual;
    @Column(nullable = true)
    private LocalDateTime fechaCreacion;
    @Column(nullable = true)
    private Boolean activa;

    public Heladera() {}

    public Heladera (String nombre) {
        this.nombre = nombre;
        this.ocupacion = 0;
        this.fechaCreacion = LocalDateTime.now();
        this.activa = true;
    }

    public Heladera(Integer id, String nombre){
        this.id = id;
        this.nombre = nombre;
        this.ocupacion = 0;
        this.fechaCreacion = LocalDateTime.now();
        this.activa = true;
    }
}
