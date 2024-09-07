package Entidades;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fecha")
    private String fecha;
    @Column(name = "numero")
    private int numero;
    @Column(name = "total")
    private int total;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;
    //para unidireccional
    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();

    @OneToMany(mappedBy = "factura",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();


}
