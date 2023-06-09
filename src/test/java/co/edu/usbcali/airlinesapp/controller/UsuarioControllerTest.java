package co.edu.usbcali.airlinesapp.controller;

import co.edu.usbcali.airlinesapp.controllers.UsuarioController;
import co.edu.usbcali.airlinesapp.dtos.UsuarioDTO;
import co.edu.usbcali.airlinesapp.services.interfaces.UsuarioService;
import co.edu.usbcali.airlinesapp.utilities.UsuarioUtilityTest;
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
public class UsuarioControllerTest {
    @Autowired
    private UsuarioController usuarioController;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    public void guardarUsuarioPositivo() throws Exception {
        when(usuarioService.guardarUsuario(any())).thenReturn(UsuarioUtilityTest.USUARIODTO_UNO);

        ResponseEntity<UsuarioDTO> response = usuarioController.guardarUsuario(UsuarioUtilityTest.USUARIODTO_UNO);

        verify(usuarioService).guardarUsuario(eq(UsuarioUtilityTest.USUARIODTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void guardarUsuarioNegativo() {
        try {
            usuarioController.guardarUsuario(UsuarioUtilityTest.USUARIODTO_CEDULA_NULL);
        } catch (Exception e) {
            assertEquals(UsuarioUtilityTest.CEDULA_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    public void obtenerUsuariosPositivo() {
        when(usuarioService.obtenerUsuarios()).thenReturn(UsuarioUtilityTest.USUARIOSDTO);

        ResponseEntity<List<UsuarioDTO>> response = usuarioController.obtenerUsuarios();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(UsuarioUtilityTest.USUARIOS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerUsuariosNegativo() {
        when(usuarioService.obtenerUsuarios()).thenReturn(UsuarioUtilityTest.USUARIOSDTO_VACIO);

        ResponseEntity<List<UsuarioDTO>> response = usuarioController.obtenerUsuarios();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(UsuarioUtilityTest.USUARIOS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerUsuariosActivosPositivo() {
        when(usuarioService.obtenerUsuariosActivos()).thenReturn(UsuarioUtilityTest.USUARIOSDTO);

        ResponseEntity<List<UsuarioDTO>> response = usuarioController.obtenerUsuariosActivos();

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(UsuarioUtilityTest.USUARIOS_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerUsuariosActivosNegativo() {
        when(usuarioService.obtenerUsuariosActivos()).thenReturn(UsuarioUtilityTest.USUARIOSDTO_VACIO);

        ResponseEntity<List<UsuarioDTO>> response = usuarioController.obtenerUsuariosActivos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(UsuarioUtilityTest.USUARIOS_VACIO_SIZE, response.getBody().size());
    }

    @Test
    public void obtenerUsuarioPositivo() throws Exception {
        when(usuarioService.obtenerUsuarioPorId(any())).thenReturn(UsuarioUtilityTest.USUARIODTO_UNO);

        ResponseEntity<UsuarioDTO> response = usuarioController.obtenerUsuarioPorId(UsuarioUtilityTest.ID_UNO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void obtenerUsuarioNegativo() {
        try {
            usuarioController.obtenerUsuarioPorId(UsuarioUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(String.format(UsuarioUtilityTest.ID_NOT_FOUND_MESSAGE, UsuarioUtilityTest.ID_DOS), e.getMessage());
        }
    }

    @Test
    public void actualizarUsuarioPositivo() throws Exception {
        when(usuarioService.actualizarUsuario(any())).thenReturn(UsuarioUtilityTest.USUARIODTO_UNO);

        ResponseEntity<UsuarioDTO> response = usuarioController.actualizarUsuario(UsuarioUtilityTest.USUARIODTO_UNO);

        verify(usuarioService).actualizarUsuario(eq(UsuarioUtilityTest.USUARIODTO_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    public void actualizarUsuarioNegativo() {
        try {
            usuarioController.actualizarUsuario(UsuarioUtilityTest.USUARIODTO_CEDULA_NULL);
        } catch (Exception e) {
            assertEquals(UsuarioUtilityTest.CEDULA_REQUIRED_MESSAGE, e.getMessage());
        }
    }

    @Test
    void eliminarUsuarioPositivo() throws Exception {
        when(usuarioService.eliminarUsuario(any())).thenReturn(UsuarioUtilityTest.USUARIODTO_UNO);

        ResponseEntity<UsuarioDTO> response = usuarioController.eliminarUsuario(UsuarioUtilityTest.ID_UNO);

        verify(usuarioService).eliminarUsuario(eq(UsuarioUtilityTest.ID_UNO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }

    @Test
    void eliminarUsuarioNegativo() throws Exception {
        try {
            usuarioController.eliminarUsuario(UsuarioUtilityTest.ID_DOS);
        } catch (Exception e) {
            assertEquals(UsuarioUtilityTest.ID_NOT_FOUND_MESSAGE, e.getMessage());
        }
    }
}
