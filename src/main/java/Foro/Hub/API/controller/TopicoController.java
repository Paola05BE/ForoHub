package Foro.Hub.API.controller;

import Foro.Hub.API.domain.topico.*;
import Foro.Hub.API.infra.errores.TratadorDeErrores;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name="bearer-key")
public class TopicoController {
    @Autowired
    TratadorDeErrores tratadorDeErrores;
    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Topico topico= topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico= new DatosRespuestaTopico
                (topico.getId(),topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo()
                        ,topico.getEstado().toString());
        URI url=uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoMedicos
            (@PageableDefault(size =10, sort = {"nombreCurso"}) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if (!topicoExistente.isPresent()) {

            ErrorResponse errorResponse = new ErrorResponse("error", "El tópico con ID " + id + " no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
        Topico topico = topicoExistente.get();
        topico.actualizarTopico(datosActualizarTopico);

        return ResponseEntity.ok(new DatosRespuestaTopico(
                topico.getId(),
                topico.getIdUsuario(),
                topico.getMensaje(),
                topico.getNombreCurso(),
                topico.getTitulo(),
                topico.getEstado().toString()
        ));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {

        Optional<Topico> topicoExistente = topicoRepository.findById(id);

        if (!topicoExistente.isPresent()) {

            ErrorResponse errorResponse = new ErrorResponse("error", "El tópico con ID " + id + " no existe.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        Topico topico = topicoExistente.get();
        topico.desactivarTopico();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaTopicoCreado(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        var datosTopico=(new DatosRespuestaTopico
                (topico.getId(),topico.getIdUsuario(),topico.getMensaje(),topico.getNombreCurso(),
                        topico.getTitulo(),topico.getEstado().toString()));
        return ResponseEntity.ok(datosTopico);
    }
    public record ErrorResponse(String clave, String valor) {
    }
}