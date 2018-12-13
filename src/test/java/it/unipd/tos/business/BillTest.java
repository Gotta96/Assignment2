package it.unipd.tos.business;

import it.unipd.tos.business.Bill;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BillTest {

	 //Tot somma (issue #1)
	
    @Test
    public void TotalSimpleBillSomeItemsTest() {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        itemsOrdered.add(new MenuItem("Bigoli al torcio in salsa",MenuItem.alimenti.PRIMO_PIATTO, 10.5));
        itemsOrdered.add(new MenuItem("Lasagne alla bolognese rivisitate", MenuItem.alimenti.PRIMO_PIATTO, 12.0));
        Bill bill = new Bill();
        try {
            double tot = bill.getOrderPrice(itemsOrdered);
            assertEquals(22.5, tot, 0.0);
        } catch (RestaurantBillException e) {
            e.getMessage();
        }
    }
    
    //N elementi maggiore di 20 (issue #2)
    
    @org.junit.Rule
    public ExpectedException error= ExpectedException.none();
    
    @Test
    public void ExcededTwoentyItems() throws RestaurantBillException{
    	error.expect(RestaurantBillException.class);
        error.expectMessage("!!ERROR!! : Ordine superiore ai 20 elementi");
    	
    	List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
    	for(int i=0; i<25 ; i++) {
    		itemsOrdered.add(new MenuItem("Gorgonzola e speck" + i, MenuItem.alimenti.PIZZA, 6.5));
    	}
    	Bill bill= new Bill();
    	bill.getOrderPrice(itemsOrdered);
    }
    
    //Controllo e rimozione della pizza meno cara (issue #2)
    
    @Test
    
    public void presentMinItemWhenCountGreaterTen() throws RestaurantBillException{
    	List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
    	for(int i=0; i<15 ; i++) {
    		itemsOrdered.add(new MenuItem("Margherita" + i, MenuItem.alimenti.PIZZA, 4.0));
    	}
    	
    	Bill bill = new Bill();
        
        try 
        {
            assertEquals(56.0, bill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (RestaurantBillException e) 
        {
            e.getMessage();
        }
    }
}
