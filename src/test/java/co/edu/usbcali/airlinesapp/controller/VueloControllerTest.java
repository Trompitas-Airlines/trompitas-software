package co.edu.usbcali.airlinesapp.controller;

import co.edu.usbcali.airlinesapp.controllers.VueloController;
import co.edu.usbcali.airlinesapp.dtos.VueloDTO;
import co.edu.usbcali.airlinesapp.services.interfaces.VueloService;
import co.edu.usbcali.airlinesapp.utilities.VueloUtilityTest;
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
public class VueloControllerTest {
    @Autowired
    private VueloController vueloController;

    @MockBean
    private VueloService vueloService;

    @Test
    public void guardarVueloPositivo() throws Exception {
        when(vueloService.guardarVuelo(any())).thenReturn(VueloUtilityTest.VUELODTO_UNO);

        ResponseEntity<VueloDTO> response = vueloController.guardarVuelo(VueloUtilityTest.VUELODTO_UNO);

        verify(vueloService).guardarVuelo(eq(VueloUtilityTest.VUELODTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void guardarVueloNegativo() {
        try {
            vueloController.guardarVuelo(VueloUtilityTest.VUELODTO_HORASALIDA_NULL);
        } catch (Exception e) {
            assertEquals(VueloUtilityTest.HORASALIDA_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void obtenerVuelosPositivo() {
        when(vueloService.obtenerVuelos()).thenReturn(VueloUtilityTest.VUELOSDTO);

        ResponseEntity<List<VueloDTO>> response = vueloController.obtenerVuelos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(VueloUtilityTest.VUELOS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerVuelosNegativo() {
        when(vueloService.obtenerVuelos()).thenReturn(VueloUtilityTest.VUELOSDTO_VACIO);

        ResponseEntity<List<VueloDTO>> response = vueloController.obtenerVuelos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(VueloUtilityTest.VUELOS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerVuelosActivosPositivo() {
        when(vueloService.obtenerVuelosActivos()).thenReturn(VueloUtilityTest.VUELOSDTO);

        ResponseEntity<List<VueloDTO>> response = vueloController.obtenerVuelosActivos();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(VueloUtilityTest.VUELOS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerVuelosActivosNegativo() {
        when(vueloService.obtenerVuelosActivos()).thenReturn(VueloUtilityTest.VUELOSDTO_VACIO);

        ResponseEntity<List<VueloDTO>> response = vueloController.obtenerVuelosActivos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(VueloUtilityTest.VUELOS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerVueloPositivo() throws Exception {
        when(vueloService.obtenerVueloPorId(any())).thenReturn(VueloUtilityTest.VUELODTO_UNO);

        ResponseEntity<VueloDTO> response = vueloController.obtenerVuelo(VueloUtilityTest.ID_UNO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void obtenerVueloNegativo() {
        try {
            vueloController.obtenerVuelo(VueloUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(String.format(VueloUtilityTest.ID_NOT_FOUND_MESSAGE, VueloUtilityTest.ID_DOS), e.getMessage());
        }
    }

    @Test
    public void actualizarVueloPositivo() throws Exception {
        when(vueloService.actualizarVuelo(any())).thenReturn(VueloUtilityTest.VUELODTO_UNO);

        ResponseEntity<VueloDTO> response = vueloController.actualizarVuelo(VueloUtilityTest.VUELODTO_UNO);

        verify(vueloService).actualizarVuelo(eq(VueloUtilityTest.VUELODTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void actualizarVueloNegativo() {
        try {
            vueloController.actualizarVuelo(VueloUtilityTest.VUELODTO_HORASALIDA_NULL);
        } catch (Exception e) {
            assertEquals(VueloUtilityTest.HORASALIDA_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    void eliminarVueloPositivo() throws Exception {
        when(vueloService.eliminarVuelo(any())).thenReturn(VueloUtilityTest.VUELODTO_UNO);

        ResponseEntity<VueloDTO> response = vueloController.eliminarVuelo(VueloUtilityTest.ID_UNO);

        verify(vueloService).eliminarVuelo(eq(VueloUtilityTest.ID_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    void eliminarVueloNegativo() throws Exception {
        try {
            vueloController.eliminarVuelo(VueloUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(VueloUtilityTest.ID_NOT_FOUND_MESSAGE, e.getMessage());
        }
    }
}
