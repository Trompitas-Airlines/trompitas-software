package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.TipoAsiento;
import co.edu.usbcali.airlinesapp.dtos.TipoAsientoDTO;

import java.util.Arrays;
import java.util.List;

public class TipoAsientoUtility {
    public static Integer IDNUNO = 1;
    public static String DESCRIPCIONNUNO = "Ejecutivo";
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static Integer TIPOASIENTOSNSIZE = 2;
    public static Integer TIPOASIENTOSNVACIONSIZE = 0;
    public static String DESCRIPCIONNREQUIREDNMESSAGE = "La descripción no puede ser nula o vacía";
    public static String IDNNOTNFOUNDNMESSAGE = "El tipo de asiento con id %s no existe";

    public static TipoAsiento TIPOASIENTONUNO = TipoAsiento.builder()
            .idTipoAsiento(1)
            .descripcion("Ejecutivo")
            .estado("A")
            .build();

    public static TipoAsiento TIPOASIENTONDOS = TipoAsiento.builder()
            .idTipoAsiento(2)
            .descripcion("Económico")
            .estado("A")
            .build();

    public static TipoAsientoDTO TIPOASIENTODTONUNO = TipoAsientoDTO.builder()
            .idTipoAsiento(1)
            .descripcion("Ejecutivo")
            .estado("A")
            .build();

    public static TipoAsientoDTO TIPOASIENTODTONDOS = TipoAsientoDTO.builder()
            .idTipoAsiento(2)
            .descripcion("Económico")
            .estado("A")
            .build();

    public static TipoAsientoDTO TIPOASIENTODTONDESCRIPCIONNNULL = TipoAsientoDTO.builder()
            .idTipoAsiento(1)
            .descripcion(null)
            .estado("A")
            .build();

    public static List<TipoAsiento> TIPOASIENTOS = Arrays.asList(TIPOASIENTONUNO, TIPOASIENTONDOS);

    public static List<TipoAsientoDTO> TIPOASIENTOSDTO = Arrays.asList(TIPOASIENTODTONUNO, TIPOASIENTODTONDOS);

    public static List<TipoAsiento> TIPOASIENTOSNVACIO = Arrays.asList();

    public static List<TipoAsientoDTO> TIPOASIENTOSDTONVACIO = Arrays.asList();
}
