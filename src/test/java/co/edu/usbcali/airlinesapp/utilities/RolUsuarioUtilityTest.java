package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.RolUsuario;
import co.edu.usbcali.airlinesapp.dtos.RolUsuarioDTO;

import java.util.Arrays;
import java.util.List;

public class RolUsuarioUtilityTest {
    public static Integer ID_UNO = 1;
    public static String DESCRIPCION_UNO = "Cliente";
    public static String ESTADO_UNO = "A";
    public static Integer ID_DOS = 2;
    public static Integer ROLUSUARIOS_SIZE = 2;
    public static Integer ROLUSUARIOS_VACIO_SIZE = 0;
    public static String DESCRIPTION_REQUIRED_MESSAGE = "La descripción no puede ser nula o vacía";
    public static String ID_NOT_FOUND_MESSAGE = "El rol de usuario con id %s no existe";

    public static RolUsuario ROLUSUARIO_UNO = RolUsuario.builder()
            .idRolUsuario(1)
            .descripcion("Cliente")
            .estado("A")
            .build();

    public static RolUsuario ROLUSUARIO_DOS = RolUsuario.builder()
            .idRolUsuario(2)
            .descripcion("Administrador")
            .estado("A")
            .build();

    public static RolUsuarioDTO ROLUSUARIODTO_UNO = RolUsuarioDTO.builder()
            .idRolUsuario(1)
            .descripcion("Cliente")
            .estado("A")
            .build();

    public static RolUsuarioDTO ROLUSUARIODTO_DOS = RolUsuarioDTO.builder()
            .idRolUsuario(2)
            .descripcion("Administrador")
            .estado("A")
            .build();

    public static RolUsuarioDTO ROLUSUARIODTO_DESCRIPCION_NULL = RolUsuarioDTO.builder()
            .idRolUsuario(1)
            .descripcion(null)
            .estado("A")
            .build();

    public static List<RolUsuario> ROLUSUARIOS = Arrays.asList(ROLUSUARIO_UNO, ROLUSUARIO_DOS);

    public static List<RolUsuarioDTO> ROLUSUARIOSDTO = Arrays.asList(ROLUSUARIODTO_UNO, ROLUSUARIODTO_DOS);

    public static List<RolUsuario> ROLUSUARIOS_VACIO = Arrays.asList();

    public static List<RolUsuarioDTO> ROLUSUARIOSDTO_VACIO = Arrays.asList();
}
