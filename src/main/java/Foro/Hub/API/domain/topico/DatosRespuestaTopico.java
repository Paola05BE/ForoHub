package Foro.Hub.API.domain.topico;

public record DatosRespuestaTopico(
        Long id, String idUsuario,String mensaje,  String nombreCurso,String titulo,String estado ) {
}
