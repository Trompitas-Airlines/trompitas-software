package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Reserva;
import co.edu.usbcali.airlinesapp.dtos.ReservaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReservaUtility {
    public static Integer IDNUNO = 1;
    public static long PRECIONTOTALNUNO = 100000;
    public static String ESTADONPAGONUNO = "A";
    public static Date FECHANUNO = new Date();
    public static String ESTADONUNO = "A";
    public static Integer IDNDOS = 2;
    public static String FECHANFUTURO = "2023-11-27 08:00";
    public static String PATTERNNFECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHANFUTURONDATE;
    public static Integer RESERVASNSIZE = 2;
    public static Integer RESERVASNVACIONSIZE = 0;
    public static String FECHANREQUIREDNMESSAGE = "La fecha de la reserva no puede ser nula";
    public static String IDNNOTNFOUNDNMESSAGE = "La reserva con id %s no existe";

    static {
        try {
            FECHANFUTURONDATE = new SimpleDateFormat(PATTERNNFECHA).parse(FECHANFUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static Reserva RESERVANUNO = Reserva.builder()
            .idReserva(1)
            .vuelo(VueloUtility.VUELONUNO)
            .asiento(AsientoUtility.ASIENTONUNO)
            .usuario(UsuarioUtility.USUARIONUNO)
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static Reserva RESERVANDOS = Reserva.builder()
            .idReserva(2)
            .vuelo(VueloUtility.VUELONUNO)
            .asiento(AsientoUtility.ASIENTONUNO)
            .usuario(UsuarioUtility.USUARIONUNO)
            .precioTotal(150000)
            .estadoPago("A")
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static ReservaDTO RESERVADTONUNO = ReservaDTO.builder()
            .idReserva(1)
            .idVuelo(VueloUtility.VUELONUNO.getIdVuelo())
            .idAsiento(AsientoUtility.ASIENTONUNO.getIdAsiento())
            .idUsuario(UsuarioUtility.USUARIONUNO.getIdUsuario())
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static ReservaDTO RESERVADTONDOS = ReservaDTO.builder()
            .idReserva(2)
            .idVuelo(VueloUtility.VUELONUNO.getIdVuelo())
            .idAsiento(AsientoUtility.ASIENTONUNO.getIdAsiento())
            .idUsuario(UsuarioUtility.USUARIONUNO.getIdUsuario())
            .precioTotal(150000)
            .estadoPago("A")
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static ReservaDTO RESERVADTONFECHANNULL = ReservaDTO.builder()
            .idReserva(1)
            .idVuelo(VueloUtility.VUELONUNO.getIdVuelo())
            .idAsiento(AsientoUtility.ASIENTONUNO.getIdAsiento())
            .idUsuario(UsuarioUtility.USUARIONUNO.getIdUsuario())
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(null)
            .estado("A")
            .build();

    public static List<Reserva> RESERVAS = Arrays.asList(RESERVANUNO, RESERVANDOS);

    public static List<ReservaDTO> RESERVASDTO = Arrays.asList(RESERVADTONUNO, RESERVADTONDOS);

    public static List<Reserva> RESERVASNVACIO = Arrays.asList();

    public static List<ReservaDTO> RESERVASDTONVACIO = Arrays.asList();
}
