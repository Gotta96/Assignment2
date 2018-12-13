////////////////////////////////////////////////////////////////////
// [Mattia] [Gottardello] [1142520]
////////////////////////////////////////////////////////////////////


package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable{
    private String message;

    public String getMessage() {
        return message;
    }
    public RestaurantBillException(String a) {
        this.message = a;
    }
}
