package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "StockAlmacenEntity")
@Table(name = "stockalmacen")
public class StockAlmacenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codstock")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codalm", nullable = false)
    private Long codalm;

    @Column(name = "codprod", nullable = false)
    private Long codprod;

    @Column(name = "cantdisp", nullable = false)
    private Integer cantidadDisponible;

    @Column(name = "fecact", nullable = false)
    private LocalDateTime fechaActualizacion;

    @Column(name = "eststock", nullable = false)
    private Boolean estado;
}
