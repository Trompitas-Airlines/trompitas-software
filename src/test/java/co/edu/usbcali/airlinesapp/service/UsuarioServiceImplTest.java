package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.UsuarioDTO;
import co.edu.usbcali.airlinesapp.repository.RolUsuarioRepository;
import co.edu.usbcali.airlinesapp.repository.UsuarioRepository;
import co.edu.usbcali.airlinesapp.services.implementation.UsuarioServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.RolUsuarioUtilityTest;
import co.edu.usbcali.airlinesapp.utilities.UsuarioUtilityTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class UsuarioServiceImplTest {
    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private RolUsuarioRepository rolUsuarioRepository;

    @Test
    public void guardarUsuarioPositivo() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(true);
        given(rolUsuarioRepository.getReferenceById(RolUsuarioUtilityTest.ID_UNO)).willReturn(RolUsuarioUtilityTest.ROLUSUARIO_UNO);
        given(usuarioRepository.existsById(UsuarioUtilityTest.ID_UNO)).willReturn(false);
        given(usuarioRepository.save(UsuarioUtilityTest.USUARIO_UNO)).willReturn(UsuarioUtilityTest.USUARIO_UNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.guardarUsuario(UsuarioUtilityTest.USUARIODTO_UNO);

        assertEquals(UsuarioUtilityTest.ID_UNO, usuarioSavedDTO.getIdUsuario());
    }

    @Test
    public void guardarUsuarioNegativo() {
        given(usuarioRepository.existsById(UsuarioUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> usuarioServiceImpl.guardarUsuario(UsuarioUtilityTest.USUARIODTO_UNO));
    }

    @Test
    public void obtenerUsuariosPositivo() {
        given(usuarioRepository.findAll()).willReturn(UsuarioUtilityTest.USUARIOS);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuarios();

        assertEquals(UsuarioUtilityTest.USUARIOS_SIZE, usuariosSavedDTO.size());
        assertEquals(UsuarioUtilityTest.CEDULA_UNO, usuariosSavedDTO.get(0).getCedula());
    }

    @Test
    public void obtenerUsuariosNegativo() {
        given(usuarioRepository.findAll()).willReturn(UsuarioUtilityTest.USUARIOS_VACIO);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuarios();

        assertEquals(UsuarioUtilityTest.USUARIOS_VACIO_SIZE, usuariosSavedDTO.size());
    }

    @Test
    public void obtenerUsuariosActivosPositivo() {
        given(usuarioRepository.findAllByEstado("A")).willReturn(UsuarioUtilityTest.USUARIOS);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuariosActivos();

        assertEquals(UsuarioUtilityTest.USUARIOS_SIZE, usuariosSavedDTO.size());
        assertEquals(UsuarioUtilityTest.CEDULA_UNO, usuariosSavedDTO.get(0).getCedula());
    }

    @Test
    public void obtenerUsuariosActivosNegativo() {
        given(usuarioRepository.findAllByEstado("A")).willReturn(UsuarioUtilityTest.USUARIOS_VACIO);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuariosActivos();

        assertEquals(UsuarioUtilityTest.USUARIOS_VACIO_SIZE, usuariosSavedDTO.size());
    }

    @Test
    public void obtenerUsuarioPorIdPositivo() throws Exception {
        rolUsuarioRepository.save(RolUsuarioUtilityTest.ROLUSUARIO_UNO);
        usuarioRepository.save(UsuarioUtilityTest.USUARIO_UNO);

        given(usuarioRepository.existsById(UsuarioUtilityTest.ID_UNO)).willReturn(true);
        given(usuarioRepository.getReferenceById(UsuarioUtilityTest.ID_UNO)).willReturn(UsuarioUtilityTest.USUARIO_UNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.obtenerUsuarioPorId(UsuarioUtilityTest.ID_UNO);

        assertEquals(UsuarioUtilityTest.ID_UNO, usuarioSavedDTO.getIdUsuario());
    }

    @Test
    public void obtenerUsuarioPorIdNegativo() {
        given(usuarioRepository.existsById(UsuarioUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> usuarioServiceImpl.obtenerUsuarioPorId(UsuarioUtilityTest.ID_UNO));
    }

    @Test
    public void obtenerUsuarioPorCedulaPositivo() throws Exception {
        rolUsuarioRepository.save(RolUsuarioUtilityTest.ROLUSUARIO_UNO);
        usuarioRepository.save(UsuarioUtilityTest.USUARIO_UNO);

        given(usuarioRepository.existsByCedula(UsuarioUtilityTest.CEDULA_UNO)).willReturn(true);
        given(usuarioRepository.getReferenceByCedula(UsuarioUtilityTest.CEDULA_UNO)).willReturn(UsuarioUtilityTest.USUARIO_UNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.obtenerUsuarioPorCedula(UsuarioUtilityTest.CEDULA_UNO);

        assertEquals(UsuarioUtilityTest.CEDULA_UNO, usuarioSavedDTO.getCedula());
    }

    @Test
    public void obtenerUsuarioPorCedulaNegativo() throws Exception {
        given(usuarioRepository.existsByCedula(UsuarioUtilityTest.CEDULA_UNO)).willReturn(false);

        assertNull(usuarioServiceImpl.obtenerUsuarioPorCedula(UsuarioUtilityTest.CEDULA_UNO));
    }

    @Test
    public void actualizarUsuarioPositivo() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(true);
        given(rolUsuarioRepository.getReferenceById(RolUsuarioUtilityTest.ID_UNO)).willReturn(RolUsuarioUtilityTest.ROLUSUARIO_UNO);
        given(usuarioRepository.existsById(UsuarioUtilityTest.ID_UNO)).willReturn(true);
        given(usuarioRepository.save(UsuarioUtilityTest.USUARIO_UNO)).willReturn(UsuarioUtilityTest.USUARIO_UNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.actualizarUsuario(UsuarioUtilityTest.USUARIODTO_UNO);

        assertEquals(UsuarioUtilityTest.ID_UNO, usuarioSavedDTO.getIdUsuario());
    }

    @Test
    public void actualizarUsuarioNegativo() {
        given(usuarioRepository.existsById(UsuarioUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> usuarioServiceImpl.actualizarUsuario(UsuarioUtilityTest.USUARIODTO_UNO));
    }
}
