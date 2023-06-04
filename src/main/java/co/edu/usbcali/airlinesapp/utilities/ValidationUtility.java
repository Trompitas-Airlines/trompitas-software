package co.edu.usbcali.airlinesapp.utilities;

public class ValidationUtility {
    public static String PATTER_MAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static String PATTER_NAME = "^[\\p{L} ]+$";
    public static String PATTER_IATA = "^[A-Z]{3}$";
    public static String PATTER_SEAT = "^[a-hj-z]\\d{1,2}$";
    public static String PATTER_CURRENCY = "^[0-9]{1,10}$";
}
