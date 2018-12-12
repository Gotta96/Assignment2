package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable{
	private String avviso;

    public String getAvviso() {
        return avviso;
    }
    public RestaurantBillException(String a) {
        this.avviso = a;
    }
}
