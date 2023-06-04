package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.UsuarioDTO;
import co.edu.usbcali.airlinesapp.repository.RolUsuarioRepository;
import co.edu.usbcali.airlinesapp.repository.UsuarioRepository;
import co.edu.usbcali.airlinesapp.services.implementation.UsuarioServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.RolUsuarioUtility;
import co.edu.usbcali.airlinesapp.utilities.UsuarioUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
    public void guardarUsuarioOk() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(true);
        given(rolUsuarioRepository.getReferenceById(RolUsuarioUtility.IDNUNO)).willReturn(RolUsuarioUtility.ROLUSUARIONUNO);
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(false);
        given(usuarioRepository.save(UsuarioUtility.USUARIONUNO)).willReturn(UsuarioUtility.USUARIONUNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.guardarUsuario(UsuarioUtility.USUARIODTONUNO);

        assertEquals(UsuarioUtility.IDNUNO, usuarioSavedDTO.getIdUsuario());
    }

    @Test
    public void guardarUsuarioNotOk() {
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> usuarioServiceImpl.guardarUsuario(UsuarioUtility.USUARIODTONUNO));
    }

    @Test
    public void obtenerUsuariosOk() {
        given(usuarioRepository.findAll()).willReturn(UsuarioUtility.USUARIOS);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuarios();

        assertEquals(UsuarioUtility.USUARIOSNSIZE, usuariosSavedDTO.size());
        assertEquals(UsuarioUtility.CEDULANUNO, usuariosSavedDTO.get(0).getCedula());
    }

    @Test
    public void obtenerUsuariosNotOk() {
        given(usuarioRepository.findAll()).willReturn(UsuarioUtility.USUARIOSNVACIO);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuarios();

        assertEquals(UsuarioUtility.USUARIOSNVACIONSIZE, usuariosSavedDTO.size());
    }

    @Test
    public void obtenerUsuariosActivosOk() {
        given(usuarioRepository.findAllByEstado("A")).willReturn(UsuarioUtility.USUARIOS);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuariosActivos();

        assertEquals(UsuarioUtility.USUARIOSNSIZE, usuariosSavedDTO.size());
        assertEquals(UsuarioUtility.CEDULANUNO, usuariosSavedDTO.get(0).getCedula());
    }

    @Test
    public void obtenerUsuariosActivosNotOk() {
        given(usuarioRepository.findAllByEstado("A")).willReturn(UsuarioUtility.USUARIOSNVACIO);

        List<UsuarioDTO> usuariosSavedDTO = usuarioServiceImpl.obtenerUsuariosActivos();

        assertEquals(UsuarioUtility.USUARIOSNVACIONSIZE, usuariosSavedDTO.size());
    }

    @Test
    public void obtenerUsuarioPorIdOk() throws Exception {
        rolUsuarioRepository.save(RolUsuarioUtility.ROLUSUARIONUNO);
        usuarioRepository.save(UsuarioUtility.USUARIONUNO);

        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(true);
        given(usuarioRepository.getReferenceById(UsuarioUtility.IDNUNO)).willReturn(UsuarioUtility.USUARIONUNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.obtenerUsuarioPorId(UsuarioUtility.IDNUNO);

        assertEquals(UsuarioUtility.IDNUNO, usuarioSavedDTO.getIdUsuario());
    }

    @Test
    public void obtenerUsuarioPorIdNotOk() {
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> usuarioServiceImpl.obtenerUsuarioPorId(UsuarioUtility.IDNUNO));
    }

    @Test
    public void obtenerUsuarioPorCedulaOk() throws Exception {
        rolUsuarioRepository.save(RolUsuarioUtility.ROLUSUARIONUNO);
        usuarioRepository.save(UsuarioUtility.USUARIONUNO);

        given(usuarioRepository.existsByCedula(UsuarioUtility.CEDULANUNO)).willReturn(true);
        given(usuarioRepository.getReferenceByCedula(UsuarioUtility.CEDULANUNO)).willReturn(UsuarioUtility.USUARIONUNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.obtenerUsuarioPorCedula(UsuarioUtility.CEDULANUNO);

        assertEquals(UsuarioUtility.CEDULANUNO, usuarioSavedDTO.getCedula());
    }

    @Test
    public void obtenerUsuarioPorCedulaNotOk() throws Exception {
        given(usuarioRepository.existsByCedula(UsuarioUtility.CEDULANUNO)).willReturn(false);

        assertNull(usuarioServiceImpl.obtenerUsuarioPorCedula(UsuarioUtility.CEDULANUNO));
    }

    @Test
    public void actualizarUsuarioOk() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(true);
        given(rolUsuarioRepository.getReferenceById(RolUsuarioUtility.IDNUNO)).willReturn(RolUsuarioUtility.ROLUSUARIONUNO);
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(true);
        given(usuarioRepository.save(UsuarioUtility.USUARIONUNO)).willReturn(UsuarioUtility.USUARIONUNO);

        UsuarioDTO usuarioSavedDTO = usuarioServiceImpl.actualizarUsuario(UsuarioUtility.USUARIODTONUNO);

        assertEquals(UsuarioUtility.IDNUNO, usuarioSavedDTO.getIdUsuario());
    }

    @Test
    public void actualizarUsuarioNotOk() {
        given(usuarioRepository.existsById(UsuarioUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> usuarioServiceImpl.actualizarUsuario(UsuarioUtility.USUARIODTONUNO));
    }
}
