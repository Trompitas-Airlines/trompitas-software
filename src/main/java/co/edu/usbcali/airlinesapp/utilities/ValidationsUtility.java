package co.edu.usbcali.airlinesapp.utilities;

public class ValidationsUtility {
    public static String PATTERN_MAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static String PATTERN_NAME_REGEX = "^[\\p{L} ]+$";
    public static String PATTERN_IATA_REGEX = "^[A-Z]{3}$";
    public static String PATTERN_SEAT_REGEX = "^[A-C]\\d{1,2}$";
    public static String PATTERN_CURRENCY_REGEX = "^[0-9]{1,10}$";
}
