package co.edu.usbcali.airlinesapp.utilities;

public class MethodsUtility {
    public static boolean isActualOrFutureDate(java.util.Date date) {
        java.util.Date actualDate = new java.util.Date();

        return date.after(actualDate);
    }
}
