package co.edu.usbcali.airlinesapp.controllers;

import co.edu.usbcali.airlinesapp.dtos.MensajeDTO;
import co.edu.usbcali.airlinesapp.dtos.TipoAsientoDTO;
import co.edu.usbcali.airlinesapp.dtos.TrayectoDTO;
import co.edu.usbcali.airlinesapp.services.interfaces.TrayectoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trayecto")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class TrayectoController {
    private final TrayectoService trayectoService;

    public TrayectoController(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }

    @PostMapping(path = "/guardarTrayecto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarTrayecto(@RequestBody TrayectoDTO trayectoDTO) {
        try {
            return new ResponseEntity(trayectoService.guardarTrayecto(trayectoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerTrayectos")
    public ResponseEntity<List<TrayectoDTO>> obtenerTrayectos() {
        return new ResponseEntity(trayectoService.obtenerTrayectos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTrayectosActivos")
    public ResponseEntity<List<TrayectoDTO>> obtenerTrayectosActivos() {
        return new ResponseEntity(trayectoService.obtenerTrayectosActivos(), HttpStatus.OK);
    }

    @GetMapping("/obtenerTrayecto/{idTrayecto}")
    public ResponseEntity<TrayectoDTO> obtenerTrayecto(@PathVariable("idTrayecto") Integer idTrayecto) {
        try {
            return new ResponseEntity(trayectoService.obtenerTrayectoPorId(idTrayecto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value = "/actualizarTrayecto/{idTrayecto}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarTrayecto(@RequestBody TrayectoDTO trayectoDTO) {
        try {
            return new ResponseEntity(trayectoService.actualizarTrayecto(trayectoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
