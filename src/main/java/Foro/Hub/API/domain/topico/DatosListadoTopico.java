package Foro.Hub.API.domain.topico;

public record DatosListadoTopico(
        Long id, String idUsuario,String mensaje,  String nombreCurso,String titulo,String estado ) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(),topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),
                topico.getTitulo(), topico.getEstado().toString());
    }
}


