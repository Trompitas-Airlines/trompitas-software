package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Asiento;
import co.edu.usbcali.airlinesapp.dtos.AsientoDTO;

import java.util.Arrays;
import java.util.List;

public class AsientoUtility {
    public static Integer IDNUNO = 1;
    public static String UBICACIONNUNO = "a1";
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static Integer ASIENTOSNSIZE = 2;
    public static Integer ASIENTOSNVACIONSIZE = 0;
    public static String UBICACIONNREQUIREDNMESSAGE = "La ubicación del asiento no puede ser nula o vacía";
    public static String IDNNOTNFOUNDNMESSAGE = "El asiento con id %s no existe";

    public static Asiento ASIENTONUNO = Asiento.builder()
            .idAsiento(1)
            .tipoAsiento(TipoAsientoUtility.TIPOASIENTONUNO)
            .ubicacion("a1")
            .estado("A")
            .build();

    public static Asiento ASIENTONDOS = Asiento.builder()
            .idAsiento(2)
            .tipoAsiento(TipoAsientoUtility.TIPOASIENTONUNO)
            .ubicacion("a2")
            .estado("A")
            .build();

    public static AsientoDTO ASIENTODTONUNO = AsientoDTO.builder()
            .idAsiento(1)
            .idTipoAsiento(ASIENTONUNO.getTipoAsiento().getIdTipoAsiento())
            .ubicacion("a1")
            .estado("A")
            .build();

    public static AsientoDTO ASIENTODTONDOS = AsientoDTO.builder()
            .idAsiento(2)
            .idTipoAsiento(ASIENTONDOS.getTipoAsiento().getIdTipoAsiento())
            .ubicacion("a2")
            .estado("A")
            .build();

    public static AsientoDTO ASIENTODTONUBICACIONNNULL = AsientoDTO.builder()
            .idAsiento(1)
            .idTipoAsiento(ASIENTONUNO.getTipoAsiento().getIdTipoAsiento())
            .ubicacion(null)
            .estado("A")
            .build();

    public static List<Asiento> ASIENTOS = Arrays.asList(ASIENTONUNO, ASIENTONDOS);

    public static List<AsientoDTO> ASIENTOSDTO = Arrays.asList(ASIENTODTONUNO, ASIENTODTONDOS);

    public static List<Asiento> ASIENTOSNVACIO = Arrays.asList();

    public static List<AsientoDTO> ASIENTOSDTONVACIO = Arrays.asList();
}
