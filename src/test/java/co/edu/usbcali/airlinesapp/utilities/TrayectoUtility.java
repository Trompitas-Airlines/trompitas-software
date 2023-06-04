package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Trayecto;
import co.edu.usbcali.airlinesapp.dtos.TrayectoDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TrayectoUtility {
    public static Integer IDNUNO = 1;
    public static Date HORANSALIDANUNO = new Date();
    public static Date HORANLLEGADANUNO = new Date();
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static String FECHANFUTURO = "2023-11-27 08:00";
    public static String FECHANFUTURONDOS = "2023-12-27 10:00";
    public static String PATTERNNFECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHANFUTURONDATE;
    public static Date FECHANFUTURONDATENDOS;
    public static Integer TRAYECTOSNSIZE = 2;
    public static Integer TRAYECTOSNVACIONSIZE = 0;
    public static String HORASALIDANREQUIREDNMESSAGE = "La hora de salida no puede ser nula";
    public static String IDNNOTNFOUNDNMESSAGE = "El trayecto con id %s no existe";

    static {
        try {
            FECHANFUTURONDATE = new SimpleDateFormat(PATTERNNFECHA).parse(FECHANFUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            FECHANFUTURONDATENDOS = new SimpleDateFormat(PATTERNNFECHA).parse(FECHANFUTURONDOS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Trayecto TRAYECTONUNO = Trayecto.builder()
            .idTrayecto(1)
            .avion(AvionUtility.AVIONNUNO)
            .aeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO)
            .aeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS)
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .vuelo(VueloUtility.VUELONUNO)
            .estado("A")
            .build();

    public static Trayecto TRAYECTONDOS = Trayecto.builder()
            .idTrayecto(2)
            .avion(AvionUtility.AVIONNUNO)
            .aeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO)
            .aeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS)
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .vuelo(VueloUtility.VUELONUNO)
            .estado("A")
            .build();

    public static TrayectoDTO TRAYECTODTONUNO = TrayectoDTO.builder()
            .idTrayecto(1)
            .idAvion(AvionUtility.AVIONNUNO.getIdAvion())
            .idAeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS.getIdAeropuerto())
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .idVuelo(VueloUtility.VUELONUNO.getIdVuelo())
            .estado("A")
            .build();

    public static TrayectoDTO TRAYECTODTONDOS = TrayectoDTO.builder()
            .idTrayecto(2)
            .idAvion(AvionUtility.AVIONNUNO.getIdAvion())
            .idAeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS.getIdAeropuerto())
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .idVuelo(VueloUtility.VUELONUNO.getIdVuelo())
            .estado("A")
            .build();

    public static TrayectoDTO TRAYECTODTONHORASALIDANNULL = TrayectoDTO.builder()
            .idTrayecto(1)
            .idAvion(AvionUtility.AVIONNUNO.getIdAvion())
            .idAeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS.getIdAeropuerto())
            .horaSalida(null)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .idVuelo(VueloUtility.VUELONUNO.getIdVuelo())
            .estado("A")
            .build();

    public static List<Trayecto> TRAYECTOS = Arrays.asList(TRAYECTONUNO, TRAYECTONDOS);

    public static List<TrayectoDTO> TRAYECTOSDTO = Arrays.asList(TRAYECTODTONUNO, TRAYECTODTONDOS);

    public static List<Trayecto> TRAYECTOSNVACIO = Arrays.asList();

    public static List<TrayectoDTO> TRAYECTOSDTONVACIO = Arrays.asList();
}
