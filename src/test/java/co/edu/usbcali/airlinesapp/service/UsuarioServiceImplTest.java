package co.edu.usbcali.airlinesapp.service;


import co.edu.usbcali.airlinesapp.domain.RolUsuario;
import co.edu.usbcali.airlinesapp.domain.Usuario;
import co.edu.usbcali.airlinesapp.dtos.UsuarioDTO;
import co.edu.usbcali.airlinesapp.services.interfaces.UsuarioService;
import co.edu.usbcali.airlinesapp.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.AutoConfigureDataJdbc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

@SpringBootTest
public class UsuarioServiceImplTest {
    @Autowired
    private UsuarioService usuarioService;

    @MockBean
    private UsuarioRepository usuarioRepository;

    @Test
    public void obtenerUsuariosNegativo() throws Exception{
        List<Usuario> usuarios = Arrays.asList();
        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);
        List<UsuarioDTO> usuariosDTO = usuarioService.obtenerUsuarios();
        assertEquals(0, usuariosDTO.size());
    }

    @Test
    public void obtenerUsuariosActivosPositivo(){
        RolUsuario rolUsuario = RolUsuario.builder()
                .idRolUsuario(1)
                .descripcion("Administrador")
                .estado("A")
                .build();

        Usuario usuario = Usuario.builder()
                .idUsuario(1)
                .rolUsuario(rolUsuario)
                .cedula("123456789")
                .nombre("Mauricio")
                .apellido("Manuel")
                .correo("mBer@correo.com")
                .estado("A")
                .build();

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario);

        Mockito.when(usuarioRepository.getReferenceById(1)).thenReturn(usuario);
        Mockito.when(usuarioRepository.findAllByEstado("A")).thenReturn(usuarios);
        List<UsuarioDTO> usuariosDTO = usuarioService.obtenerUsuariosActivos();
        assertEquals(1, usuariosDTO.size());


    }

    @Test
    public void obtenerUsuariosActivosNegativo() throws Exception{

        List<Usuario> usuarios = new ArrayList<>();
        Mockito.when(usuarioRepository.findAllByEstado("I")).thenReturn(usuarios);
        List<UsuarioDTO> usuariosDTO = usuarioService.obtenerUsuariosActivos();
        assertEquals(0, usuariosDTO.size());

    }

    @Test
    public void obtenerUsuarioPorIdPositivo() throws Exception{

        RolUsuario rolUsuario = RolUsuario.builder()
                .idRolUsuario(1)
                .descripcion("Administrador")
                .estado("A")
                .build();

        Usuario usuario = Usuario.builder()
                .idUsuario(1)
                .rolUsuario(rolUsuario)
                .cedula("123456789")
                .nombre("Mauricio")
                .apellido("Manuel")
                .correo("mBer@correo.com")
                .estado("A")
                .build();

        Mockito.when(usuarioRepository.existsById(1)).thenReturn(true);
        Mockito.when(usuarioRepository.getReferenceById(1)).thenReturn(usuario);
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(1);
        assertEquals(1, usuarioDTO.getIdUsuario());

    }

    @Test
    public void obtenerUsuarioPorCedulaNegativo() throws Exception {

        Mockito.when(usuarioRepository.existsByCedula("1020345")).thenReturn(false);
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorCedula("1020345");
        assertEquals(null, usuarioDTO);
    }


    @Test
    public void eliminarUsuarioPositivo() throws Exception{

    }

    @Test
    public void eliminarUsuarioNegativo() throws Exception{

    }


}
