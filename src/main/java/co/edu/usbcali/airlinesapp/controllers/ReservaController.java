package co.edu.usbcali.airlinesapp.controllers;

import co.edu.usbcali.airlinesapp.services.interfaces.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.usbcali.airlinesapp.dtos.ReservaDTO;
import co.edu.usbcali.airlinesapp.dtos.MensajeDTO;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping(path = "/guardarReserva",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            return new ResponseEntity(reservaService.guardarReserva(reservaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerReservas")
    public ResponseEntity<List<ReservaDTO>> obtenerReservas() {
        return new ResponseEntity(reservaService.obtenerReservas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerReservasActivas")
    public ResponseEntity<List<ReservaDTO>> obtenerReservasActivas() {
        return new ResponseEntity(reservaService.obtenerReservasActivas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerReserva/{idReserva}")
    public ResponseEntity<ReservaDTO> obtenerReserva(@PathVariable("idReserva") Integer idReserva) {
        try {
            return new ResponseEntity(reservaService.obtenerReservaPorId(idReserva), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerReservasVuelo/{idVuelo}")
    public ResponseEntity<ReservaDTO> obtenerReservasVuelo(@PathVariable("idVuelo") Integer idVuelo) {
        try {
            return new ResponseEntity(reservaService.obtenerReservasPorIdVuelo(idVuelo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerReservasUsuario/{cedula}")
    public ResponseEntity<ReservaDTO> obtenerReservasUsuario(@PathVariable("cedula") String cedula) {
        try {
            return new ResponseEntity(reservaService.obtenerReservasPorCedula(cedula), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = "/actualizarReserva",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            return new ResponseEntity(reservaService.actualizarReserva(reservaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/eliminarReserva/{idReserva}")
    public ResponseEntity eliminarReserva(@PathVariable("idReserva") Integer idReserva) {
        try {
            return new ResponseEntity(reservaService.eliminarReserva(idReserva), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
