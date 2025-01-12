package Foro.Hub.API.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="topicos")
@Entity(name="topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_usuario")
    private String idUsuario;
    private String mensaje;
    @Column(name = "nombre_curso")
    private String nombreCurso;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private boolean activo;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.activo=true;
        this.idUsuario= datosRegistroTopico.idUsuario();
        this.mensaje= datosRegistroTopico.mensaje();
        this.nombreCurso= datosRegistroTopico.nombreCurso();
        this.titulo= datosRegistroTopico.titulo();
        this.estado=datosRegistroTopico.estado();
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.mensaje() !=null){
            this.mensaje= datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.nombreCurso()!=null){
            this.nombreCurso= datosActualizarTopico.nombreCurso();
        }
        if(datosActualizarTopico.titulo()!=null){
            this.titulo= datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.estado()!=null){
            this.estado= Estado.valueOf(datosActualizarTopico.estado());
        }
    }

    public void desactivarTopico() {
        this.activo=false;
    }
}
