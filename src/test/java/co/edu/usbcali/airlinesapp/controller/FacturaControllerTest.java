package co.edu.usbcali.airlinesapp.controller;

import co.edu.usbcali.airlinesapp.controllers.FacturaController;
import co.edu.usbcali.airlinesapp.dtos.FacturaDTO;
import co.edu.usbcali.airlinesapp.services.interfaces.FacturaService;
import co.edu.usbcali.airlinesapp.utilities.FacturaUtilityTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FacturaControllerTest {
    @Autowired
    private FacturaController facturaController;

    @MockBean
    private FacturaService facturaService;

    @Test
    public void guardarFacturaPositivo() throws Exception {
        when(facturaService.guardarFactura(any())).thenReturn(FacturaUtilityTest.FACTURADTO_UNO);

        ResponseEntity<FacturaDTO> response = facturaController.guardarFactura(FacturaUtilityTest.FACTURADTO_UNO);

        verify(facturaService).guardarFactura(eq(FacturaUtilityTest.FACTURADTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void guardarFacturaNegativo() {
        try {
            facturaController.guardarFactura(FacturaUtilityTest.FACTURADTO_FECHA_NULL);
        } catch (Exception e) {
            assertEquals(FacturaUtilityTest.FECHA_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void obtenerFacturasPositivo() {
        when(facturaService.obtenerFacturas()).thenReturn(FacturaUtilityTest.FACTURASDTO);

        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturas();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(FacturaUtilityTest.FACTURAS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerFacturasNegativo() {
        when(facturaService.obtenerFacturas()).thenReturn(FacturaUtilityTest.FACTURASDTO_VACIO);

        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturas();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(FacturaUtilityTest.FACTURAS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerFacturasActivasPositivo() {
        when(facturaService.obtenerFacturasActivas()).thenReturn(FacturaUtilityTest.FACTURASDTO);

        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturasActivas();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(FacturaUtilityTest.FACTURAS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerFacturasActivasNegativo() {
        when(facturaService.obtenerFacturasActivas()).thenReturn(FacturaUtilityTest.FACTURASDTO_VACIO);

        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturasActivas();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(FacturaUtilityTest.FACTURAS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerFacturaPositivo() throws Exception {
        when(facturaService.obtenerFacturaPorId(any())).thenReturn(FacturaUtilityTest.FACTURADTO_UNO);

        ResponseEntity<FacturaDTO> response = facturaController.obtenerFactura(FacturaUtilityTest.ID_UNO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void obtenerFacturaNegativo() {
        try {
            facturaController.obtenerFactura(FacturaUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(String.format(FacturaUtilityTest.ID_NOT_FOUND_MESSAGE, FacturaUtilityTest.ID_DOS), e.getMessage());
        }
    }

    @Test
    public void actualizarFacturaPositivo() throws Exception {
        when(facturaService.actualizarFactura(any())).thenReturn(FacturaUtilityTest.FACTURADTO_UNO);

        ResponseEntity<FacturaDTO> response = facturaController.actualizarFactura(FacturaUtilityTest.FACTURADTO_UNO);

        verify(facturaService).actualizarFactura(eq(FacturaUtilityTest.FACTURADTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void actualizarFacturaNegativo() {
        try {
            facturaController.actualizarFactura(FacturaUtilityTest.FACTURADTO_FECHA_NULL);
        } catch (Exception e) {
            assertEquals(FacturaUtilityTest.FECHA_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    void eliminarFacturaPositivo() throws Exception {
        when(facturaService.eliminarFactura(any())).thenReturn(FacturaUtilityTest.FACTURADTO_UNO);

        ResponseEntity<FacturaDTO> response = facturaController.eliminarFactura(FacturaUtilityTest.ID_UNO);

        verify(facturaService).eliminarFactura(eq(FacturaUtilityTest.ID_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    void eliminarFacturaNegativo() throws Exception {
        try {
            facturaController.eliminarFactura(FacturaUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(FacturaUtilityTest.ID_NOT_FOUND_MESSAGE, e.getMessage());
        }
    }
}
