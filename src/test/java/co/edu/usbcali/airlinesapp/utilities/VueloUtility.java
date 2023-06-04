package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Vuelo;
import co.edu.usbcali.airlinesapp.dtos.VueloDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VueloUtility {
    public static Integer IDNUNO = 1;
    public static long PRECIONUNO = 100000;
    public static Date HORANSALIDANUNO = new Date();
    public static Date HORANLLEGADANUNO = new Date();
    public static long PRECIONASIENTONVIPNUNO = 50000;
    public static long PRECIONASIENTONNORMALNUNO = 30000;
    public static long PRECIONASIENTONBASICONUNO = 10000;
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static String FECHANFUTURO = "2023-11-27 08:00";
    public static String FECHANFUTURONDOS = "2023-12-27 10:00";
    public static String PATTERNNFECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHANFUTURONDATE;
    public static Date FECHANFUTURONDATENDOS;
    public static Integer VUELOSNSIZE = 2;
    public static Integer VUELOSNVACIONSIZE = 0;
    public static String HORASALIDANREQUIREDNMESSAGE = "La hora de salida del vuelo no puede ser nula";
    public static String IDNNOTNFOUNDNMESSAGE = "El vuelo con id %s no existe";


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

    public static Vuelo VUELONUNO = Vuelo.builder()
            .idVuelo(1)
            .aeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO)
            .aeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS)
            .precio(100000)
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .precioAsientoVip(50000)
            .precioAsientoNormal(30000)
            .precioAsientoBasico(10000)
            .estado("A")
            .build();

    public static Vuelo VUELONDOS = Vuelo.builder()
            .idVuelo(2)
            .aeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO)
            .aeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS)
            .precio(150000)
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .precioAsientoVip(80000)
            .precioAsientoNormal(50000)
            .precioAsientoBasico(30000)
            .estado("A")
            .build();

    public static VueloDTO VUELODTONUNO = VueloDTO.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS.getIdAeropuerto())
            .precio(100000)
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .precioAsientoVip(50000)
            .precioAsientoNormal(30000)
            .precioAsientoBasico(10000)
            .estado("A")
            .build();

    public static VueloDTO VUELODTONDOS = VueloDTO.builder()
            .idVuelo(2)
            .idAeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS.getIdAeropuerto())
            .precio(150000)
            .horaSalida(FECHANFUTURONDATE)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .precioAsientoVip(80000)
            .precioAsientoNormal(50000)
            .precioAsientoBasico(30000)
            .estado("A")
            .build();

    public static VueloDTO VUELODTONHORASALIDANNULL = VueloDTO.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtility.AEROPUERTONUNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtility.AEROPUERTONDOS.getIdAeropuerto())
            .precio(100000)
            .horaSalida(null)
            .horaLlegada(FECHANFUTURONDATENDOS)
            .precioAsientoVip(50000)
            .precioAsientoNormal(30000)
            .precioAsientoBasico(10000)
            .estado("A")
            .build();

    public static List<Vuelo> VUELOS = Arrays.asList(VUELONUNO, VUELONDOS);

    public static List<VueloDTO> VUELOSDTO = Arrays.asList(VUELODTONUNO, VUELODTONDOS);

    public static List<Vuelo> VUELOSNVACIO = Arrays.asList();

    public static List<VueloDTO> VUELOSDTONVACIO = Arrays.asList();
}
