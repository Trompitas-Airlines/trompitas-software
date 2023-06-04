package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Avion;
import co.edu.usbcali.airlinesapp.dtos.AvionDTO;

import java.util.Arrays;
import java.util.List;

public class AvionUtility {
    public static Integer IDNUNO = 1;
    public static String MODELONUNO = "Boeing 737";
    public static String AEROLINEANUNO = "Avianca";
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static Integer AVIONESNSIZE = 2;
    public static Integer AVIONESNVACIONSIZE = 0;
    public static String MODELONREQUIREDNMESSAGE = "El modelo del avión no puede ser nulo o vacío";
    public static String IDNNOTNFOUNDNMESSAGE = "El avión con id %s no existe";

    public static Avion AVIONNUNO = Avion.builder()
            .idAvion(1)
            .modelo("Boeing 737")
            .estado("A")
            .build();

    public static Avion AVIONNDOS = Avion.builder()
            .idAvion(2)
            .modelo("Boeing 747")
            .estado("A")
            .build();

    public static AvionDTO AVIONDTONUNO = AvionDTO.builder()
            .idAvion(1)
            .modelo("Boeing 737")
            .estado("A")
            .build();

    public static AvionDTO AVIONDTONDOS = AvionDTO.builder()
            .idAvion(2)
            .modelo("Boeing 747")
            .estado("A")
            .build();

    public static AvionDTO AVIONDTONMODELONNULL = AvionDTO.builder()
            .idAvion(1)
            .modelo(null)
            .estado("A")
            .build();

    public static List<Avion> AVIONES = Arrays.asList(AVIONNUNO, AVIONNDOS);

    public static List<AvionDTO> AVIONESDTO = Arrays.asList(AVIONDTONUNO, AVIONDTONDOS);

    public static List<Avion> AVIONESNVACIO = Arrays.asList();

    public static List<AvionDTO> AVIONESDTONVACIO = Arrays.asList();
}
