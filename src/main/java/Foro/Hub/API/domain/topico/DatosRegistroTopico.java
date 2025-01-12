package Foro.Hub.API.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record DatosRegistroTopico(
        @NotBlank(message = "El campo idUsuario es obligatorio")
        @Size(min = 1, max = 20, message = "Mínimo 1 caracter, máximo 20 caracteres")
        @Pattern(regexp = "^\\S.*$", message = "Este campo no puede ser vacio")
        String idUsuario,
        @NotBlank(message = "El campo mensaje es obligatorio")
        @Size(min = 1, max = 200, message = "Mínimo 1 caracter, máximo 200 caracteres")
        @Pattern(regexp = "^\\S.*$", message = "Este campo no puede ser vacio")
        String mensaje,
        @NotBlank(message = "El campo nombreCurso es obligatorio")
        @Size(min = 1, max = 200, message = "Mínimo 1 caracter, máximo 200 caracteres")
        @Pattern(regexp = "^\\S.*$", message = "Este campo no puede ser vacio")
        String nombreCurso,
        @NotBlank(message = "El campo titulo es obligatorio")
        @Size(min = 1, max = 200, message = "Mínimo 1 caracter, máximo 200 caracteres")
        @Pattern(regexp = "^\\S.*$", message = "Este campo no puede ser vacio")
        String titulo,
        @NotNull(message = "El campo estado es obligatorio")
        Estado estado) {
}
