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
    public void obtenerUsuariosPositivo() {
        RolUsuario rolUsuario = RolUsuario.builder()
                .idRolUsuario(1)
                .descripcion("Administrador")
                .estado("A")
                .build();

        Usuario.builder()
                .idUsuario(1)
                .rolUsuario(rolUsuario)
                .cedula("123456789")
                .nombre("Mauricio")
                .apellido("Manuel")
                .correo("mBer@correo.com")
                .estado("A")
                .build();
        List<Usuario> usuarios = Arrays.asList(Usuario.builder()
                .idUsuario(1)
                .rolUsuario(rolUsuario)
                .cedula("123456789")
                .nombre("Mauricio")
                .apellido("Manuel")
                .correo("Manul@.com")
                .estado("A")
                .build(),
                Usuario.builder()
                        .idUsuario(2)
                        .rolUsuario(rolUsuario)
                        .cedula("987654321")
                        .nombre("Manuel")
                        .apellido("Mauricio")
                        .correo("Manul@.com")
                        .estado("A")
                        .build());

        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);
        List<UsuarioDTO> usuariosDTO = usuarioService.obtenerUsuarios();
        assertEquals(2, usuariosDTO.size());
        assertEquals("89213721", usuariosDTO.get(0).getCedula());

    }


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
    public void obtenerUsuarioPorIdNegativo() throws Exception{

        Mockito.when(usuarioRepository.existsById(1)).thenReturn(false);
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorId(1);
        assertEquals(null, usuarioDTO);

    }

    @Test
    public void obtenerUsuarioPorCedulaPositivo() throws Exception {

        RolUsuario rolUsuario = RolUsuario.builder()
                .idRolUsuario(1)
                .descripcion("Administrador")
                .estado("A")
                .build();

        Usuario usuario = Usuario.builder()
                .idUsuario(1)
                .rolUsuario(rolUsuario)
                .cedula("1020345")
                .nombre("Nicolás")
                .apellido("Manuel")
                .correo("mer@correo.com")
                .estado("A")
                .build();

        Mockito.when(usuarioRepository.existsByCedula("1020345")).thenReturn(true);
        Mockito.when(usuarioRepository.getReferenceByCedula("1020345")).thenReturn(usuario);
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorCedula("1020345");
        assertEquals("1020345", usuarioDTO.getCedula());
    }

    @Test
    public void obtenerUsuarioPorCedulaNegativo() throws Exception {

        Mockito.when(usuarioRepository.existsByCedula("1020345")).thenReturn(false);
        UsuarioDTO usuarioDTO = usuarioService.obtenerUsuarioPorCedula("1020345");
        assertEquals(null, usuarioDTO);
    }

    @Test
    public void actualizarUsuarioPositivo() throws Exception{

        RolUsuario rolUsuario = RolUsuario.builder()
                .idRolUsuario(1)
                .descripcion("Administrador")
                .estado("A")
                .build();

        Usuario usuario = Usuario.builder()
                .idUsuario(1)
                .rolUsuario(rolUsuario)
                .cedula("1020345")
                .nombre("Nicolás")
                .apellido("Manuel")
                .correo("mer@correo.com")
                .estado("A")
                .build();

        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .idUsuario(1)
                .idRolUsuario(1)
                .correo("mer@correo.com")
                .cedula("1020345")
                .nombre("Nicolás")
                .apellido("Manuel")
                .estado("A")
                .build();

        Mockito.when(usuarioRepository.existsById(1)).thenReturn(true);
        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        UsuarioDTO usuarioDTOGuardado = usuarioService.actualizarUsuario(usuarioDTO);
        assertEquals(1,usuarioDTOGuardado.getIdUsuario());
    }

    @Test
    public void actualizarUsuarioNegativo() throws Exception{

        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .idUsuario(1)
                .idRolUsuario(1)
                .correo("mer@correo.com")
                .cedula("1020345")
                .nombre("Nicolás")
                .apellido("Manuel")
                .estado("A")
                .build();

        Mockito.when(usuarioRepository.existsById(1)).thenReturn(false);
        Mockito.when(usuarioRepository.save(null)).thenReturn(null);
        UsuarioDTO usuarioDTOGuardado = usuarioService.actualizarUsuario(usuarioDTO);
        assertEquals(null,usuarioDTOGuardado);

    }

    @Test
    public void eliminarUsuarioPositivo() throws Exception{

    }

    @Test
    public void eliminarUsuarioNegativo() throws Exception{

    }


}
