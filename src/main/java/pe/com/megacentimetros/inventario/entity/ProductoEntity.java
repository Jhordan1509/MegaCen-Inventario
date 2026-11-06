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
@Entity(name = "ProductoEntity")
@Table(name = "producto")
public class ProductoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codprod")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "codbarra", length = 40, nullable = false, unique = true)
    private String codigoBarras;

    @Column(name = "nomprod", length = 150, nullable = false)
    private String nombre;

    @Column(name = "descrip", length = 300)
    private String descripcion;

    @Column(name = "precom", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioCompra;

    @Column(name = "preven", nullable = false, precision = 12, scale = 2)
    private BigDecimal precioVenta;

    @Column(name = "stomin", nullable = false)
    private Integer stockMinimo;

    @Column(name = "stomax")
    private Integer stockMaximo;

    @Column(name = "codcat", nullable = false)
    private Long codcat;

    @Column(name = "codmar", nullable = false)
    private Long codmar;

    @Column(name = "codtipemp", nullable = false)
    private Long codtipemp;

    @Column(name = "estprod", nullable = false)
    private Boolean estado;

    @Transient
    private Object categoriaproducto;

    @Transient
    private Object marcaproducto;

    @Transient
    private Object tipoempaque;
}
