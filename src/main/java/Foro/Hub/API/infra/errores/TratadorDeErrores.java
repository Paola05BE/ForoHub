package Foro.Hub.API.infra.errores;

import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.sql.SQLIntegrityConstraintViolationException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.dao.DataIntegrityViolationException;


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
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> manejarExcepcionDeIntegridadDeDatos(DataIntegrityViolationException ex) {
        // Extraer el mensaje específico de error
        String mensaje = extraerDetalleDeDuplicado(ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.CONFLICT) // 409 Conflict
                .body(new ErrorResponse("Error de clave duplicada", mensaje));
    }

    private String extraerDetalleDeDuplicado(String mensajeTecnico) {
        if (mensajeTecnico.contains("Duplicate entry")) {
            String[] partes = mensajeTecnico.split("'");
            if (partes.length >= 2) {
                return "El valor '" + partes[1] + "' ya existe en el sistema.";
            }
        }
        return "Violación de restricción en la base de datos.";
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEnum(HttpMessageNotReadableException ex) {
        // Construye una respuesta de error con clave-valor
        ErrorResponse errorResponse = new ErrorResponse("error", "Valor no válido para el campo 'estado'. Los valores válidos son 'abierto' y 'cerrado'.");
        return ResponseEntity.badRequest().body(errorResponse);
    }
    private record ErrorResponse(String error, String message) {}
}
