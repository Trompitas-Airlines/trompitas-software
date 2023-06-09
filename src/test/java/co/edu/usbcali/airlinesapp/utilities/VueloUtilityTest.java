package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Vuelo;
import co.edu.usbcali.airlinesapp.dtos.VueloDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VueloUtilityTest {
    public static Integer ID_UNO = 1;
    public static long PRECIO_UNO = 100000;
    public static Date HORA_SALIDA_UNO = new Date();
    public static Date HORA_LLEGADA_UNO = new Date();
    public static long PRECIO_ASIENTO_VIP_UNO = 50000;
    public static long PRECIO_ASIENTO_NORMAL_UNO = 30000;
    public static long PRECIO_ASIENTO_BASICO_UNO = 10000;
    public static String ESTADO_UNO = "A";
    public static Integer ID_DOS = 2;
    public static String FECHA_FUTURO = "2023-11-27 08:00";
    public static String FECHA_FUTURO_DOS = "2023-12-27 10:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE;
    public static Date FECHA_FUTURO_DATE_DOS;
    public static Integer VUELOS_SIZE = 2;
    public static Integer VUELOS_VACIO_SIZE = 0;
    public static String HORASALIDA_REQUIRED_MESSAGE = "La hora de salida del vuelo no puede ser nula";
    public static String ID_NOT_FOUND_MESSAGE = "El vuelo con id %s no existe";


    static {
        try {
            FECHA_FUTURO_DATE = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            FECHA_FUTURO_DATE_DOS = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO_DOS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vuelo VUELO_UNO = Vuelo.builder()
            .idVuelo(1)
            .aeropuertoOrigen(AeropuertoUtilityTest.AEROPUERTO_UNO)
            .aeropuertoDestino(AeropuertoUtilityTest.AEROPUERTO_DOS)
            .precio(100000)
            .horaSalida(FECHA_FUTURO_DATE)
            .horaLlegada(FECHA_FUTURO_DATE_DOS)
            .precioAsientoVip(50000)
            .precioAsientoNormal(30000)
            .precioAsientoBasico(10000)
            .estado("A")
            .build();

    public static Vuelo VUELO_DOS = Vuelo.builder()
            .idVuelo(2)
            .aeropuertoOrigen(AeropuertoUtilityTest.AEROPUERTO_UNO)
            .aeropuertoDestino(AeropuertoUtilityTest.AEROPUERTO_DOS)
            .precio(150000)
            .horaSalida(FECHA_FUTURO_DATE)
            .horaLlegada(FECHA_FUTURO_DATE_DOS)
            .precioAsientoVip(80000)
            .precioAsientoNormal(50000)
            .precioAsientoBasico(30000)
            .estado("A")
            .build();

    public static VueloDTO VUELODTO_UNO = VueloDTO.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtilityTest.AEROPUERTO_UNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtilityTest.AEROPUERTO_DOS.getIdAeropuerto())
            .precio(100000)
            .horaSalida(FECHA_FUTURO_DATE)
            .horaLlegada(FECHA_FUTURO_DATE_DOS)
            .precioAsientoVip(50000)
            .precioAsientoNormal(30000)
            .precioAsientoBasico(10000)
            .estado("A")
            .build();

    public static VueloDTO VUELODTO_DOS = VueloDTO.builder()
            .idVuelo(2)
            .idAeropuertoOrigen(AeropuertoUtilityTest.AEROPUERTO_UNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtilityTest.AEROPUERTO_DOS.getIdAeropuerto())
            .precio(150000)
            .horaSalida(FECHA_FUTURO_DATE)
            .horaLlegada(FECHA_FUTURO_DATE_DOS)
            .precioAsientoVip(80000)
            .precioAsientoNormal(50000)
            .precioAsientoBasico(30000)
            .estado("A")
            .build();

    public static VueloDTO VUELODTO_HORASALIDA_NULL = VueloDTO.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtilityTest.AEROPUERTO_UNO.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtilityTest.AEROPUERTO_DOS.getIdAeropuerto())
            .precio(100000)
            .horaSalida(null)
            .horaLlegada(FECHA_FUTURO_DATE_DOS)
            .precioAsientoVip(50000)
            .precioAsientoNormal(30000)
            .precioAsientoBasico(10000)
            .estado("A")
            .build();

    public static List<Vuelo> VUELOS = Arrays.asList(VUELO_UNO, VUELO_DOS);

    public static List<VueloDTO> VUELOSDTO = Arrays.asList(VUELODTO_UNO, VUELODTO_DOS);

    public static List<Vuelo> VUELOS_VACIO = Arrays.asList();

    public static List<VueloDTO> VUELOSDTO_VACIO = Arrays.asList();
}
