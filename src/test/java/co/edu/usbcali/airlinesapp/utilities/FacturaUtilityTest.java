package co.edu.usbcali.airlinesapp.utilities;

import co.edu.usbcali.airlinesapp.domain.Factura;
import co.edu.usbcali.airlinesapp.dtos.FacturaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FacturaUtilityTest {
    public static Integer ID_UNO = 1;
    public static Date FECHA_UNO = new Date();
    public static String ESTADO_UNO = "A";
    public static String FECHA_FUTURO = "2023-11-27 08:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE;
    public static Integer ID_DOS = 2;
    public static Integer FACTURAS_SIZE = 2;
    public static Integer FACTURAS_VACIO_SIZE = 0;
    public static String FECHA_REQUIRED_MESSAGE = "La fecha de la factura no puede ser nula o vacía";
    public static String ID_NOT_FOUND_MESSAGE = "La factura con id %s no existe";

    static {
        try {
            FECHA_FUTURO_DATE = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Factura FACTURA_UNO = Factura.builder()
            .idFactura(1)
            .reserva(ReservaUtilityTest.RESERVA_UNO)
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static Factura FACTURA_DOS = Factura.builder()
            .idFactura(2)
            .reserva(ReservaUtilityTest.RESERVA_UNO)
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static FacturaDTO FACTURADTO_UNO = FacturaDTO.builder()
            .idFactura(1)
            .idReserva(ReservaUtilityTest.ID_UNO)
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static FacturaDTO FACTURADTO_DOS = FacturaDTO.builder()
            .idFactura(2)
            .idReserva(ReservaUtilityTest.ID_UNO)
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static FacturaDTO FACTURADTO_FECHA_NULL = FacturaDTO.builder()
            .idFactura(1)
            .idReserva(ReservaUtilityTest.ID_UNO)
            .fecha(null)
            .estado("A")
            .build();

    public static List<Factura> FACTURAS = Arrays.asList(FACTURA_UNO, FACTURA_DOS);

    public static List<FacturaDTO> FACTURASDTO = Arrays.asList(FACTURADTO_UNO, FACTURADTO_DOS);

    public static List<Factura> FACTURAS_VACIO = Arrays.asList();

    public static List<FacturaDTO> FACTURASDTO_VACIO = Arrays.asList();
}
