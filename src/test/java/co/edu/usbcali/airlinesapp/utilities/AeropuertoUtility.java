package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Aeropuerto;
import co.edu.usbcali.airlinesapp.dtos.AeropuertoDTO;

import java.util.Arrays;
import java.util.List;

public class AeropuertoUtility {
    public static Integer IDNUNO = 1;
    public static String NOMBRENUNO = "Aeropuerto Internacional El Dorado";
    public static String IATANUNO = "BOG";
    public static String UBICACIONNUNO = "Bogotá";
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static String NOMBRENDOS = "Aeropuerto Internacional Alfonso Bonilla Aragón";
    public static String IATANDOS = "COL";
    public static String UBICACIONNDOS = "Santiago de Cali";
    public static String ESTADONDOS = "A";
    public static Integer AEROPUERTOSNSIZE = 2;
    public static Integer AEROPUERTOSNVACIONSIZE = 0;
    public static String NOMBRENREQUIREDNMESSAGE = "El nombre del aeropuerto no puede ser nulo  o vacío";
    public static String IDNNOTNFOUNDNMESSAGE = "El aeropuerto con id %s no existe";

    public static Aeropuerto AEROPUERTONUNO = Aeropuerto.builder()
            .idAeropuerto(1)
            .nombre("Aeropuerto Internacional El Dorado")
            .iata("BOG")
            .ubicacion("Bogotá")
            .estado("A")
            .build();

    public static Aeropuerto AEROPUERTONDOS = Aeropuerto.builder()
            .idAeropuerto(2)
            .nombre("Aeropuerto Internacional Alfonso Bonilla Aragón")
            .iata("COL")
            .ubicacion("Santiago de Cali")
            .estado("A")
            .build();

    public static AeropuertoDTO AEROPUERTODTONUNO = AeropuertoDTO.builder()
            .idAeropuerto(1)
            .nombre("Aeropuerto Internacional El Dorado")
            .iata("BOG")
            .ubicacion("Bogotá")
            .estado("A")
            .build();

    public static AeropuertoDTO AEROPUERTODTONDOS = AeropuertoDTO.builder()
            .idAeropuerto(2)
            .nombre("Aeropuerto Internacional Alfonso Bonilla Aragón")
            .iata("COL")
            .ubicacion("Santiago de Cali")
            .estado("A")
            .build();

    public static AeropuertoDTO AEROPUERTODTONNOMBRENNULL = AeropuertoDTO.builder()
            .idAeropuerto(1)
            .nombre(null)
            .iata("BOG")
            .ubicacion("Bogotá")
            .estado("A")
            .build();

    public static List<Aeropuerto> AEROPUERTOS = Arrays.asList(AEROPUERTONUNO, AEROPUERTONDOS);

    public static List<AeropuertoDTO> AEROPUERTOSDTO = Arrays.asList(AEROPUERTODTONUNO, AEROPUERTODTONDOS);

    public static List<Aeropuerto> AEROPUERTOSNVACIO = Arrays.asList();

    public static List<AeropuertoDTO> AEROPUERTOSDTONVACIO = Arrays.asList();
}
