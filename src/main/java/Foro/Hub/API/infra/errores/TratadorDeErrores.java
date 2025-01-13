package Foro.Hub.API.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratadorDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private record DatosErrorValidacion(String campo, String error) {
        DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> tratarErrorConstraintViolation
            (SQLIntegrityConstraintViolationException e) {
        String mensaje = e.getMessage().contains("Duplicate entry")
                ? "La información: " + extraerValorDuplicado(e.getMessage()) + "' ya se encuentra registrada."
                : "Hubo un problema al registrar el tópico. Verifique los datos.";

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse("Error de registro", mensaje));
    }

    private String extraerValorDuplicado(String mensajeTecnico) {
        String[] partes = mensajeTecnico.split("'");
        return (partes.length >= 2) ? partes[1] : "desconocido";
    }

    private record ErrorResponse(String error, String message) {}
}
