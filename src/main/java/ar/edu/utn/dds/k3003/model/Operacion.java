package ar.edu.utn.dds.k3003.model;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operaciones")
public class Operacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer heladeraId;

    @Column(nullable = false)
    private String qrVianda;

    @Column(nullable = false)
    private LocalDateTime fecha;

    public Operacion() {}

    public Operacion(Integer heladeraId, String qrVianda) {
        this.heladeraId = heladeraId;
        this.qrVianda = qrVianda;
        this.fecha = LocalDateTime.now();
    }
}
