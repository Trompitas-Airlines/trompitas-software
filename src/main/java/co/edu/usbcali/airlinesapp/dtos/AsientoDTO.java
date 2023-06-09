package co.edu.usbcali.airlinesapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class AsientoDTO {
        private Integer idAsiento;
        private Integer idTipoAsiento;
        private String ubicacion;
        private long precio;
        private String estado;
}
