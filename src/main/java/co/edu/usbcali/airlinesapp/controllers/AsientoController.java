package co.edu.usbcali.airlinesapp.controllers;


import co.edu.usbcali.airlinesapp.services.interfaces.AsientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.usbcali.airlinesapp.dtos.AsientoDTO;
import co.edu.usbcali.airlinesapp.dtos.MensajeDTO;


import java.util.List;

@RestController
@RequestMapping("/asiento")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class AsientoController {
    private final AsientoService asientoService;

    public AsientoController(AsientoService asientoService) {
        this.asientoService = asientoService;
    }

    @PostMapping(path = "/guardarAsiento",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarAsiento(@RequestBody AsientoDTO asientoDTO) {
        try {
            return new ResponseEntity(asientoService.guardarAsiento(asientoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerAsientos")
    public ResponseEntity<List<AsientoDTO>> obtenerAsientos() {
        return new ResponseEntity(asientoService.obtenerAsientos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAsientosActivos")
    public ResponseEntity<List<AsientoDTO>> obtenerAsientosActivos() {
        return new ResponseEntity(asientoService.obtenerAsientosActivos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAsiento/{idAsiento}")
    public ResponseEntity<AsientoDTO> obtenerAsiento(@PathVariable("idAsiento") Integer idAsiento) {
        try {
            return new ResponseEntity(asientoService.obtenerAsientoPorId(idAsiento), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping(path = "/actualizarAsiento",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarAsiento(@RequestBody AsientoDTO asientoDTO) {
        try {
            return new ResponseEntity(asientoService.actualizarAsiento(asientoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/eliminarAsiento/{idAsiento}")
    public ResponseEntity eliminarAsiento(@PathVariable("idAsiento") Integer idAsiento) {
        try {
            return new ResponseEntity(asientoService.eliminarAsiento(idAsiento), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
