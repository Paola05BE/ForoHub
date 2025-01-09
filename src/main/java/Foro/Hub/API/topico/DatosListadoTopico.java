package Foro.Hub.API.topico;

public record DatosListadoTopico(String idUsuario,String mensaje,  String nombreCurso,String titulo ) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo());
    }
}


