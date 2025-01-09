package Foro.Hub.API.topico;

import jakarta.validation.constraints.NotBlank;


public record DatosRegistroTopico(
        @NotBlank
        String idUsuario,
        @NotBlank
        String mensaje,
        @NotBlank
        String nombreCurso,
        @NotBlank
        String titulo) {
}
