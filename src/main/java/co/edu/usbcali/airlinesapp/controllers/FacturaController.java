package co.edu.usbcali.airlinesapp.controllers;

import co.edu.usbcali.airlinesapp.services.interfaces.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.usbcali.airlinesapp.dtos.FacturaDTO;
import co.edu.usbcali.airlinesapp.dtos.MensajeDTO;

import java.util.List;

@RestController
@RequestMapping("/factura")
@Slf4j
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @PostMapping(path = "/guardarFactura",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarFactura(@RequestBody FacturaDTO facturaDTO) {
        try {
            return new ResponseEntity(facturaService.guardarFactura(facturaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerFacturas")
    public ResponseEntity<List<FacturaDTO>> obtenerFacturas() {
        return new ResponseEntity(facturaService.obtenerFacturas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerFacturasActivas")
    public ResponseEntity<List<FacturaDTO>> obtenerFacturasActivas() {
        return new ResponseEntity(facturaService.obtenerFacturasActivas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerFactura/{idFactura}")
    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable("idFactura") Integer idFactura) {
        try {
            return new ResponseEntity(facturaService.obtenerFacturaPorId(idFactura), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerFacturasReserva/{idReserva}")
    public ResponseEntity<List<FacturaDTO>> obtenerFacturasReserva(@PathVariable("idReserva") Integer idReserva) {
        try {
            return new ResponseEntity(facturaService.obtenerFacturasPorIdReserva(idReserva), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/actualizarFactura",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity actualizarFactura(@RequestBody FacturaDTO facturaDTO) {
        try {
            return new ResponseEntity(facturaService.actualizarFactura(facturaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/eliminarFactura/{idFactura}")
    public ResponseEntity eliminarFactura(@PathVariable("idFactura") Integer idFactura) {
        try {
            return new ResponseEntity(facturaService.eliminarFactura(idFactura), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
