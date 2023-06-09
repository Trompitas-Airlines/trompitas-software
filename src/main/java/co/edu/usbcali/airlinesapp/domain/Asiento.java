package co.edu.usbcali.airlinesapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "asiento")
public class Asiento {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asie_id", nullable = false, unique = true)
    private Integer idAsiento;

    @ManyToOne
    @JoinColumn(name = "tias_id", referencedColumnName = "tias_id")
    private TipoAsiento tipoAsiento;

    @Column(name = "ubicacion", nullable = false, length = 12)
    private String ubicacion;

    @Column(name = "precio", nullable = false)
    private long precio;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
}
