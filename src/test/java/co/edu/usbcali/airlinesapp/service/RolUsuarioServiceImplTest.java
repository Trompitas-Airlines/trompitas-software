package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.RolUsuarioDTO;
import co.edu.usbcali.airlinesapp.repository.RolUsuarioRepository;
import co.edu.usbcali.airlinesapp.services.implementation.RolUsuarioServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.RolUsuarioUtility;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class RolUsuarioServiceImplTest {
    @InjectMocks
    private RolUsuarioServiceImpl rolUsuarioServiceImpl;

    @Mock
    private RolUsuarioRepository rolUsuarioRepository;

    @Test
    public void guardarRolUsuarioOk() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(false);
        given(rolUsuarioRepository.save(RolUsuarioUtility.ROLUSUARIONUNO)).willReturn(RolUsuarioUtility.ROLUSUARIONUNO);

        RolUsuarioDTO rolUsuarioSavedDTO = rolUsuarioServiceImpl.guardarRolUsuario(RolUsuarioUtility.ROLUSUARIODTONUNO);

        assertEquals(RolUsuarioUtility.IDNUNO, rolUsuarioSavedDTO.getIdRolUsuario());
    }

    @Test
    public void guardarRolUsuarioNotOk() {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(true);

        assertThrows(Exception.class, () -> rolUsuarioServiceImpl.guardarRolUsuario(RolUsuarioUtility.ROLUSUARIODTONUNO));
    }

    @Test
    public void obtenerRolUsuariosOk() {
        given(rolUsuarioRepository.findAll()).willReturn(RolUsuarioUtility.ROLUSUARIOS);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuarios();

        assertEquals(RolUsuarioUtility.ROLUSUARIOSNSIZE, rolUsuariosSavedDTO.size());
        assertEquals(RolUsuarioUtility.DESCRIPCIONNUNO, rolUsuariosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerRolUsuariosNotOk() {
        given(rolUsuarioRepository.findAll()).willReturn(RolUsuarioUtility.ROLUSUARIOSNVACIO);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuarios();

        assertEquals(RolUsuarioUtility.ROLUSUARIOSNVACIONSIZE, rolUsuariosSavedDTO.size());
    }

    @Test
    public void obtenerRolUsuariosActivosOk() {
        given(rolUsuarioRepository.findAllByEstado("A")).willReturn(RolUsuarioUtility.ROLUSUARIOS);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuariosActivos();

        assertEquals(RolUsuarioUtility.ROLUSUARIOSNSIZE, rolUsuariosSavedDTO.size());
        assertEquals(RolUsuarioUtility.DESCRIPCIONNUNO, rolUsuariosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerRolUsuariosActivosNotOk() {
        given(rolUsuarioRepository.findAllByEstado("A")).willReturn(RolUsuarioUtility.ROLUSUARIOSNVACIO);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuariosActivos();

        assertEquals(RolUsuarioUtility.ROLUSUARIOSNVACIONSIZE, rolUsuariosSavedDTO.size());
    }

    @Test
    public void obtenerRolUsuarioPorIdOk() throws Exception {
        rolUsuarioRepository.save(RolUsuarioUtility.ROLUSUARIONUNO);

        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(true);
        given(rolUsuarioRepository.getReferenceById(RolUsuarioUtility.IDNUNO)).willReturn(RolUsuarioUtility.ROLUSUARIONUNO);

        RolUsuarioDTO rolUsuarioSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuarioPorId(RolUsuarioUtility.IDNUNO);

        assertEquals(RolUsuarioUtility.IDNUNO, rolUsuarioSavedDTO.getIdRolUsuario());
    }

    @Test
    public void obtenerRolUsuarioPorIdNotOk() {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> rolUsuarioServiceImpl.obtenerRolUsuarioPorId(RolUsuarioUtility.IDNUNO));
    }

    @Test
    public void actualizarRolUsuarioOk() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(true);
        given(rolUsuarioRepository.save(RolUsuarioUtility.ROLUSUARIONUNO)).willReturn(RolUsuarioUtility.ROLUSUARIONUNO);

        RolUsuarioDTO rolUsuarioSavedDTO = rolUsuarioServiceImpl.actualizarRolUsuario(RolUsuarioUtility.ROLUSUARIODTONUNO);

        assertEquals(RolUsuarioUtility.IDNUNO, rolUsuarioSavedDTO.getIdRolUsuario());
    }

    @Test
    public void actualizarRolUsuarioNotOk() {
        given(rolUsuarioRepository.existsById(RolUsuarioUtility.IDNUNO)).willReturn(false);

        assertThrows(Exception.class, () -> rolUsuarioServiceImpl.actualizarRolUsuario(RolUsuarioUtility.ROLUSUARIODTONUNO));
    }
}
