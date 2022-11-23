package org.ada.gestorgastronomico.entity;

import javax.persistence.*;

@Entity
@Table(name = "ingrediente")
public class Ingrediente {

    @Id
    private int id;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private String unidadMedida;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_materia_prima", nullable = false)
    private MateriaPrima materiaPrima;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_producto" )
    private Producto producto;

}
