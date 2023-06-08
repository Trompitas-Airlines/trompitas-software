package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Reserva;
import co.edu.usbcali.airlinesapp.dtos.ReservaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReservaUtilityTest {
    public static Integer ID_UNO = 1;
    public static long PRECIO_TOTAL_UNO = 100000;
    public static String ESTADO_PAGO_UNO = "A";
    public static Date FECHA_UNO = new Date();
    public static String ESTADO_UNO = "A";
    public static Integer ID_DOS = 2;
    public static String FECHA_FUTURO = "2023-11-27 08:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE;
    public static Integer RESERVAS_SIZE = 2;
    public static Integer RESERVAS_VACIO_SIZE = 0;
    public static String FECHA_REQUIRED_MESSAGE = "La fecha de la reserva no puede ser nula";
    public static String ID_NOT_FOUND_MESSAGE = "La reserva con id %s no existe";

    static {
        try {
            FECHA_FUTURO_DATE = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static Reserva RESERVA_UNO = Reserva.builder()
            .idReserva(1)
            .vuelo(VueloUtilityTest.VUELO_UNO)
            .asiento(AsientoUtilityTest.ASIENTO_UNO)
            .usuario(UsuarioUtilityTest.USUARIO_UNO)
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static Reserva RESERVA_DOS = Reserva.builder()
            .idReserva(2)
            .vuelo(VueloUtilityTest.VUELO_UNO)
            .asiento(AsientoUtilityTest.ASIENTO_UNO)
            .usuario(UsuarioUtilityTest.USUARIO_UNO)
            .precioTotal(150000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static ReservaDTO RESERVADTO_UNO = ReservaDTO.builder()
            .idReserva(1)
            .idVuelo(VueloUtilityTest.VUELO_UNO.getIdVuelo())
            .idAsiento(AsientoUtilityTest.ASIENTO_UNO.getIdAsiento())
            .idUsuario(UsuarioUtilityTest.USUARIO_UNO.getIdUsuario())
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static ReservaDTO RESERVADTO_DOS = ReservaDTO.builder()
            .idReserva(2)
            .idVuelo(VueloUtilityTest.VUELO_UNO.getIdVuelo())
            .idAsiento(AsientoUtilityTest.ASIENTO_UNO.getIdAsiento())
            .idUsuario(UsuarioUtilityTest.USUARIO_UNO.getIdUsuario())
            .precioTotal(150000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static ReservaDTO RESERVADTO_FECHA_NULL = ReservaDTO.builder()
            .idReserva(1)
            .idVuelo(VueloUtilityTest.VUELO_UNO.getIdVuelo())
            .idAsiento(AsientoUtilityTest.ASIENTO_UNO.getIdAsiento())
            .idUsuario(UsuarioUtilityTest.USUARIO_UNO.getIdUsuario())
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(null)
            .estado("A")
            .build();

    public static List<Reserva> RESERVAS = Arrays.asList(RESERVA_UNO, RESERVA_DOS);

    public static List<ReservaDTO> RESERVASDTO = Arrays.asList(RESERVADTO_UNO, RESERVADTO_DOS);

    public static List<Reserva> RESERVAS_VACIO = Arrays.asList();

    public static List<ReservaDTO> RESERVASDTO_VACIO = Arrays.asList();
}
