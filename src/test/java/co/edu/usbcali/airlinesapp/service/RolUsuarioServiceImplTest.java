package co.edu.usbcali.airlinesapp.service;

import co.edu.usbcali.airlinesapp.dtos.RolUsuarioDTO;
import co.edu.usbcali.airlinesapp.repository.RolUsuarioRepository;
import co.edu.usbcali.airlinesapp.services.implementation.RolUsuarioServiceImpl;
import co.edu.usbcali.airlinesapp.utilities.RolUsuarioUtilityTest;
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
    public void guardarRolUsuarioPositivo() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(false);
        given(rolUsuarioRepository.save(RolUsuarioUtilityTest.ROLUSUARIO_UNO)).willReturn(RolUsuarioUtilityTest.ROLUSUARIO_UNO);

        RolUsuarioDTO rolUsuarioSavedDTO = rolUsuarioServiceImpl.guardarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        assertEquals(RolUsuarioUtilityTest.ID_UNO, rolUsuarioSavedDTO.getIdRolUsuario());
    }

    @Test
    public void guardarRolUsuarioNegativo() {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(true);

        assertThrows(Exception.class, () -> rolUsuarioServiceImpl.guardarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO));
    }

    @Test
    public void obtenerRolUsuariosPositivo() {
        given(rolUsuarioRepository.findAll()).willReturn(RolUsuarioUtilityTest.ROLUSUARIOS);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuarios();

        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_SIZE, rolUsuariosSavedDTO.size());
        assertEquals(RolUsuarioUtilityTest.DESCRIPCION_UNO, rolUsuariosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerRolUsuariosNegativo() {
        given(rolUsuarioRepository.findAll()).willReturn(RolUsuarioUtilityTest.ROLUSUARIOS_VACIO);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuarios();

        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_VACIO_SIZE, rolUsuariosSavedDTO.size());
    }

    @Test
    public void obtenerRolUsuariosActivosPositivo() {
        given(rolUsuarioRepository.findAllByEstado("A")).willReturn(RolUsuarioUtilityTest.ROLUSUARIOS);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuariosActivos();

        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_SIZE, rolUsuariosSavedDTO.size());
        assertEquals(RolUsuarioUtilityTest.DESCRIPCION_UNO, rolUsuariosSavedDTO.get(0).getDescripcion());
    }

    @Test
    public void obtenerRolUsuariosActivosNegativo() {
        given(rolUsuarioRepository.findAllByEstado("A")).willReturn(RolUsuarioUtilityTest.ROLUSUARIOS_VACIO);

        List<RolUsuarioDTO> rolUsuariosSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuariosActivos();

        assertEquals(RolUsuarioUtilityTest.ROLUSUARIOS_VACIO_SIZE, rolUsuariosSavedDTO.size());
    }

    @Test
    public void obtenerRolUsuarioPorIdPositivo() throws Exception {
        rolUsuarioRepository.save(RolUsuarioUtilityTest.ROLUSUARIO_UNO);

        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(true);
        given(rolUsuarioRepository.getReferenceById(RolUsuarioUtilityTest.ID_UNO)).willReturn(RolUsuarioUtilityTest.ROLUSUARIO_UNO);

        RolUsuarioDTO rolUsuarioSavedDTO = rolUsuarioServiceImpl.obtenerRolUsuarioPorId(RolUsuarioUtilityTest.ID_UNO);

        assertEquals(RolUsuarioUtilityTest.ID_UNO, rolUsuarioSavedDTO.getIdRolUsuario());
    }

    @Test
    public void obtenerRolUsuarioPorIdNegativo() {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> rolUsuarioServiceImpl.obtenerRolUsuarioPorId(RolUsuarioUtilityTest.ID_UNO));
    }

    @Test
    public void actualizarRolUsuarioPositivo() throws Exception {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(true);
        given(rolUsuarioRepository.save(RolUsuarioUtilityTest.ROLUSUARIO_UNO)).willReturn(RolUsuarioUtilityTest.ROLUSUARIO_UNO);

        RolUsuarioDTO rolUsuarioSavedDTO = rolUsuarioServiceImpl.actualizarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO);

        assertEquals(RolUsuarioUtilityTest.ID_UNO, rolUsuarioSavedDTO.getIdRolUsuario());
    }

    @Test
    public void actualizarRolUsuarioNegativo() {
        given(rolUsuarioRepository.existsById(RolUsuarioUtilityTest.ID_UNO)).willReturn(false);

        assertThrows(Exception.class, () -> rolUsuarioServiceImpl.actualizarRolUsuario(RolUsuarioUtilityTest.ROLUSUARIODTO_UNO));
    }
}
