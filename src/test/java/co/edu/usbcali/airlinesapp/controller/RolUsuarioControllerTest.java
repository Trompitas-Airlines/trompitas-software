package co.edu.usbcali.airlinesapp.controller;

import co.edu.usbcali.airlinesapp.controllers.RolUsuarioController;
import co.edu.usbcali.airlinesapp.dtos.RolUsuarioDTO;
import co.edu.usbcali.airlinesapp.services.interfaces.RolUsuarioService;
import co.edu.usbcali.airlinesapp.utilities.RolUsuarioUtilityTest;
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
public class RolUsuarioControllerTest {
    @Autowired
    private RolUsuarioController rolUsuarioController;

    @MockBean
    private RolUsuarioService rolUsuarioService;

    @Test
    public void guardarRolUsuarioPositivo() throws Exception {
        when(rolUsuarioService.guardarRolUsuario(any())).thenReturn(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        ResponseEntity<RolUsuarioDTO> response = rolUsuarioController.guardarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        verify(rolUsuarioService).guardarRolUsuario(eq(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void guardarRolUsuarioNegativo() {
        try {
            rolUsuarioController.guardarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_DESCRIPCION_NULL);
        } catch (Exception e) {
            assertEquals(RolUsuarioUtilityTest.DESCRIPTION_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void obtenerRolUsuariosPositivo() {
        when(rolUsuarioService.obtenerRolUsuarios()).thenReturn(RolUsuarioUtilityTest.ROLUSUARIOSDTO);

        ResponseEntity<List<RolUsuarioDTO>> response = rolUsuarioController.obtenerRolUsuarios();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerRolUsuariosNegativo() {
        when(rolUsuarioService.obtenerRolUsuarios()).thenReturn(RolUsuarioUtilityTest.ROLUSUARIOSDTO_VACIO);

        ResponseEntity<List<RolUsuarioDTO>> response = rolUsuarioController.obtenerRolUsuarios();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerRolUsuariosActivosPositivo() {
        when(rolUsuarioService.obtenerRolUsuariosActivos()).thenReturn(RolUsuarioUtilityTest.ROLUSUARIOSDTO);

        ResponseEntity<List<RolUsuarioDTO>> response = rolUsuarioController.obtenerRolUsuariosActivos();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerRolUsuariosActivosNegativo() {
        when(rolUsuarioService.obtenerRolUsuariosActivos()).thenReturn(RolUsuarioUtilityTest.ROLUSUARIOSDTO_VACIO);

        ResponseEntity<List<RolUsuarioDTO>> response = rolUsuarioController.obtenerRolUsuariosActivos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerRolUsuarioPositivo() throws Exception {
        when(rolUsuarioService.obtenerRolUsuarioPorId(any())).thenReturn(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        ResponseEntity<RolUsuarioDTO> response = rolUsuarioController.obtenerRolUsuario(RolUsuarioUtilityTest.ID_UNO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void obtenerRolUsuarioNegativo() {
        try {
            rolUsuarioController.obtenerRolUsuario(RolUsuarioUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(String.format(RolUsuarioUtilityTest.ID_NOT_FOUND_MESSAGE, RolUsuarioUtilityTest.ID_DOS), e.getMessage());
        }
    }

    @Test
    public void actualizarRolUsuarioPositivo() throws Exception {
        when(rolUsuarioService.actualizarRolUsuario(any())).thenReturn(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        ResponseEntity<RolUsuarioDTO> response = rolUsuarioController.actualizarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        verify(rolUsuarioService).actualizarRolUsuario(eq(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void actualizarRolUsuarioNegativo() {
        try {
            rolUsuarioController.actualizarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_DESCRIPCION_NULL);
        } catch (Exception e) {
            assertEquals(RolUsuarioUtilityTest.DESCRIPTION_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    void eliminarRolUsuarioPositivo() throws Exception {
        when(rolUsuarioService.eliminarRolUsuario(any())).thenReturn(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        ResponseEntity<RolUsuarioDTO> response = rolUsuarioController.eliminarRolUsuario(RolUsuarioUtilityTest.ID_UNO);

        verify(rolUsuarioService).eliminarRolUsuario(eq(RolUsuarioUtilityTest.ID_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    void eliminarRolUsuarioNegativo() throws Exception {
        try {
            rolUsuarioController.eliminarRolUsuario(RolUsuarioUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(RolUsuarioUtilityTest.ID_NOT_FOUND_MESSAGE, e.getMessage());
        }
    }
}
