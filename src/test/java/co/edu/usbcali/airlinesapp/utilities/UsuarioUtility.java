package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Usuario;
import co.edu.usbcali.airlinesapp.dtos.UsuarioDTO;

import java.util.Arrays;
import java.util.List;

public class UsuarioUtility {
    public static Integer IDNUNO = 1;
    public static String CEDULANUNO = "123456789";
    public static String NOMBRENUNO = "Santiago";
    public static String APELLIDONUNO = "García";
    public static String CORREONUNO = "santiagogarcia@gmail.com";
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static Integer USUARIOSNSIZE = 2;
    public static Integer USUARIOSNVACIONSIZE = 0;
    public static String CEDULANREQUIREDNMESSAGE = "La cédula del usuario no puede ser nula o vacía";
    public static String IDNNOTNFOUNDNMESSAGE = "El usuario con id %s no existe";

    public static Usuario USUARIONUNO = Usuario.builder()
            .idUsuario(1)
            .rolUsuario(RolUsuarioUtility.ROLUSUARIONUNO)
            .cedula("123456789")
            .nombre("Santiago")
            .apellido("García")
            .correo("santiagogarcia@gmail.com")
            .estado("A")
            .build();

    public static Usuario USUARIONDOS = Usuario.builder()
            .idUsuario(2)
            .rolUsuario(RolUsuarioUtility.ROLUSUARIONUNO)
            .cedula("987654321")
            .nombre("Juan")
            .apellido("Pérez")
            .correo("juanperez@gmail.com")
            .estado("A")
            .build();

    public static UsuarioDTO USUARIODTONUNO = UsuarioDTO.builder()
            .idUsuario(1)
            .idRolUsuario(RolUsuarioUtility.ROLUSUARIONUNO.getIdRolUsuario())
            .cedula("123456789")
            .nombre("Santiago")
            .apellido("García")
            .correo("santiagogarcia@gmail.com")
            .estado("A")
            .build();

    public static UsuarioDTO USUARIODTONDOS = UsuarioDTO.builder()
            .idUsuario(2)
            .idRolUsuario(RolUsuarioUtility.ROLUSUARIONUNO.getIdRolUsuario())
            .cedula("987654321")
            .nombre("Juan")
            .apellido("Pérez")
            .correo("juanperez@gmail.com")
            .estado("A")
            .build();

    public static UsuarioDTO USUARIODTONCEDULANNULL = UsuarioDTO.builder()
            .idUsuario(1)
            .idRolUsuario(RolUsuarioUtility.ROLUSUARIONUNO.getIdRolUsuario())
            .cedula(null)
            .nombre("Santiago")
            .apellido("García")
            .correo("juanperez@gmail.com")
            .estado("A")
            .build();

    public static List<Usuario> USUARIOS = Arrays.asList(USUARIONUNO, USUARIONDOS);

    public static List<UsuarioDTO> USUARIOSDTO = Arrays.asList(USUARIODTONUNO, USUARIODTONDOS);

    public static List<Usuario> USUARIOSNVACIO = Arrays.asList();

    public static List<UsuarioDTO> USUARIOSDTONVACIO = Arrays.asList();
}
