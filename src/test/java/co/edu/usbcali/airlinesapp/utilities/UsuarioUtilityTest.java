package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Usuario;
import co.edu.usbcali.airlinesapp.dtos.UsuarioDTO;

import java.util.Arrays;
import java.util.List;

public class UsuarioUtilityTest {
    public static Integer ID_UNO = 1;
    public static String CEDULA_UNO = "123456789";
    public static String NOMBRE_UNO = "Santiago";
    public static String APELLIDO_UNO = "García";
    public static String CORREO_UNO = "santiagogarcia@gmail.com";
    public static String ESTADO_UNO = "A";
    public static Integer ID_DOS = 2;
    public static Integer USUARIOS_SIZE = 2;
    public static Integer USUARIOS_VACIO_SIZE = 0;
    public static String CEDULA_REQUIRED_MESSAGE = "La cédula del usuario no puede ser nula o vacía";
    public static String ID_NOT_FOUND_MESSAGE = "El usuario con id %s no existe";

    public static Usuario USUARIO_UNO = Usuario.builder()
            .idUsuario(1)
            .rolUsuario(RolUsuarioUtilityTest.ROLUSUARIO_UNO)
            .cedula("123456789")
            .nombre("Santiago")
            .apellido("García")
            .correo("santiagogarcia@gmail.com")
            .estado("A")
            .build();

    public static Usuario USUARIO_DOS = Usuario.builder()
            .idUsuario(2)
            .rolUsuario(RolUsuarioUtilityTest.ROLUSUARIO_UNO)
            .cedula("987654321")
            .nombre("Juan")
            .apellido("Pérez")
            .correo("juanperez@gmail.com")
            .estado("A")
            .build();

    public static UsuarioDTO USUARIODTO_UNO = UsuarioDTO.builder()
            .idUsuario(1)
            .idRolUsuario(RolUsuarioUtilityTest.ROLUSUARIO_UNO.getIdRolUsuario())
            .cedula("123456789")
            .nombre("Santiago")
            .apellido("García")
            .correo("santiagogarcia@gmail.com")
            .estado("A")
            .build();

    public static UsuarioDTO USUARIODTO_DOS = UsuarioDTO.builder()
            .idUsuario(2)
            .idRolUsuario(RolUsuarioUtilityTest.ROLUSUARIO_UNO.getIdRolUsuario())
            .cedula("987654321")
            .nombre("Juan")
            .apellido("Pérez")
            .correo("juanperez@gmail.com")
            .estado("A")
            .build();

    public static UsuarioDTO USUARIODTO_CEDULA_NULL = UsuarioDTO.builder()
            .idUsuario(1)
            .idRolUsuario(RolUsuarioUtilityTest.ROLUSUARIO_UNO.getIdRolUsuario())
            .cedula(null)
            .nombre("Santiago")
            .apellido("García")
            .correo("juanperez@gmail.com")
            .estado("A")
            .build();

    public static List<Usuario> USUARIOS = Arrays.asList(USUARIO_UNO, USUARIO_DOS);

    public static List<UsuarioDTO> USUARIOSDTO = Arrays.asList(USUARIODTO_UNO, USUARIODTO_DOS);

    public static List<Usuario> USUARIOS_VACIO = Arrays.asList();

    public static List<UsuarioDTO> USUARIOSDTO_VACIO = Arrays.asList();
}
