package Foro.Hub.API.domain.topico;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DatosActualizarTopico(

        @Pattern(regexp = "^\\S.*$", message = "Este campo no puede ser vacio")
        @Size(min = 1, max = 200, message = "Mínimo 1 caracter, máximo 200 caracteres")
        String mensaje,
        @Pattern(regexp = "^\\S.*$", message = "Este campo no ser vacio")
        @Size(min = 1, max = 200, message = "mínimo 1 caracter, máximo 200 caracteres")
        String nombreCurso,
        @Pattern(regexp = "^\\S.*$", message = "Este campo no ser vacio")
        @Size(min = 1, max = 200, message = "mínimo 1 caracter, máximo 200 caracteres")
        String titulo,
        String estado) {
}
