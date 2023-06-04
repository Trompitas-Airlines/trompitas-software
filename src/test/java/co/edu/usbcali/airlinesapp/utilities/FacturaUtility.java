package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Factura;
import co.edu.usbcali.airlinesapp.dtos.FacturaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FacturaUtility {
    public static Integer IDNUNO = 1;
    public static Date FECHANUNO = new Date();
    public static String ESTADONUNO = "A";
    public static String FECHANFUTURO = "2023-11-27 08:00";
    public static String PATTERNNFECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHANFUTURONDATE;
    public static Integer IDNDOS = 2;
    public static Integer FACTURASNSIZE = 2;
    public static Integer FACTURASNVACIONSIZE = 0;
    public static String FECHANREQUIREDNMESSAGE = "La fecha de la factura no puede ser nula o vacía";
    public static String IDNNOTNFOUNDNMESSAGE = "La factura con id %s no existe";

    static {
        try {
            FECHANFUTURONDATE = new SimpleDateFormat(PATTERNNFECHA).parse(FECHANFUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Factura FACTURANUNO = Factura.builder()
            .idFactura(1)
            .reserva(ReservaUtility.RESERVANUNO)
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static Factura FACTURANDOS = Factura.builder()
            .idFactura(2)
            .reserva(ReservaUtility.RESERVANUNO)
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static FacturaDTO FACTURADTONUNO = FacturaDTO.builder()
            .idFactura(1)
            .idReserva(ReservaUtility.IDNUNO)
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static FacturaDTO FACTURADTONDOS = FacturaDTO.builder()
            .idFactura(2)
            .idReserva(ReservaUtility.IDNUNO)
            .fecha(FECHANFUTURONDATE)
            .estado("A")
            .build();

    public static FacturaDTO FACTURADTONFECHANNULL = FacturaDTO.builder()
            .idFactura(1)
            .idReserva(ReservaUtility.IDNUNO)
            .fecha(null)
            .estado("A")
            .build();

    public static List<Factura> FACTURAS = Arrays.asList(FACTURANUNO, FACTURANDOS);

    public static List<FacturaDTO> FACTURASDTO = Arrays.asList(FACTURADTONUNO, FACTURADTONDOS);

    public static List<Factura> FACTURASNVACIO = Arrays.asList();

    public static List<FacturaDTO> FACTURASDTONVACIO = Arrays.asList();
}
