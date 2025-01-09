package Foro.Hub.API.topico;

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

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.idUsuario= datosRegistroTopico.idUsuario();
        this.mensaje= datosRegistroTopico.mensaje();
        this.nombreCurso= datosRegistroTopico.nombreCurso();
        this.titulo= datosRegistroTopico.titulo();
    }
}
