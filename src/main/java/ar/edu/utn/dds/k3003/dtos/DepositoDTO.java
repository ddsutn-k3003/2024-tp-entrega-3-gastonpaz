package ar.edu.utn.dds.k3003.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepositoDTO {
    private Integer heladeraId;
    private String qrVianda;

    public DepositoDTO(Integer heladeraId, String qrVianda) {
        this.heladeraId = heladeraId;
        this.qrVianda = qrVianda;
    }
}
