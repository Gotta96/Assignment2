package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class Bill implements RestaurantBill {
	
	
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
		double tot=0.0;
		
		if(itemsOrdered.size() > 20)
			throw new RestaurantBillException("!!ERROR!! : Ordine superiore ai 20 elementi");
		else {
			for(MenuItem i : itemsOrdered) {
				tot+= i.getPrice();
			}
		}
		
		return tot;
	}

}
