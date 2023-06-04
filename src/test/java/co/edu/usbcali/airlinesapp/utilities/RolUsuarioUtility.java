package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.RolUsuario;
import co.edu.usbcali.airlinesapp.dtos.RolUsuarioDTO;

import java.util.Arrays;
import java.util.List;

public class RolUsuarioUtility {
    public static Integer IDNUNO = 1;
    public static String DESCRIPCIONNUNO = "Cliente";
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static Integer ROLUSUARIOSNSIZE = 2;
    public static Integer ROLUSUARIOSNVACIONSIZE = 0;
    public static String DESCRIPTIONNREQUIREDNMESSAGE = "La descripción no puede ser nula o vacía";
    public static String IDNNOTNFOUNDNMESSAGE = "El rol de usuario con id %s no existe";

    public static RolUsuario ROLUSUARIONUNO = RolUsuario.builder()
            .idRolUsuario(1)
            .descripcion("Cliente")
            .estado("A")
            .build();

    public static RolUsuario ROLUSUARIONDOS = RolUsuario.builder()
            .idRolUsuario(2)
            .descripcion("Administrador")
            .estado("A")
            .build();

    public static RolUsuarioDTO ROLUSUARIODTONUNO = RolUsuarioDTO.builder()
            .idRolUsuario(1)
            .descripcion("Cliente")
            .estado("A")
            .build();

    public static RolUsuarioDTO ROLUSUARIODTONDOS = RolUsuarioDTO.builder()
            .idRolUsuario(2)
            .descripcion("Administrador")
            .estado("A")
            .build();

    public static RolUsuarioDTO ROLUSUARIODTONDESCRIPCIONNNULL = RolUsuarioDTO.builder()
            .idRolUsuario(1)
            .descripcion(null)
            .estado("A")
            .build();

    public static List<RolUsuario> ROLUSUARIOS = Arrays.asList(ROLUSUARIONUNO, ROLUSUARIONDOS);

    public static List<RolUsuarioDTO> ROLUSUARIOSDTO = Arrays.asList(ROLUSUARIODTONUNO, ROLUSUARIODTONDOS);

    public static List<RolUsuario> ROLUSUARIOSNVACIO = Arrays.asList();

    public static List<RolUsuarioDTO> ROLUSUARIOSDTONVACIO = Arrays.asList();
}
