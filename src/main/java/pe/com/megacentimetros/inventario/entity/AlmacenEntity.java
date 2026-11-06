package pe.com.megacentimetros.inventario.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "AlmacenEntity")
@Table(name = "almacen")
public class AlmacenEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codalm")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomalm", length = 120, nullable = false)
    private String nombre;

    @Column(name = "tipalm", length = 80, nullable = false)
    private String tipo;

    @Column(name = "ubicacion", length = 250, nullable = false)
    private String ubicacion;

    @Column(name = "capac", precision = 12, scale = 2)
    private BigDecimal capacidad;

    @Column(name = "sitalm", length = 30, nullable = false)
    private String situacion;

    @Column(name = "codsuc", nullable = false)
    private Long codsuc;

    @Column(name = "estalm", nullable = false)
    private Boolean estado;

    @Transient
    private Object sucursal;
}
