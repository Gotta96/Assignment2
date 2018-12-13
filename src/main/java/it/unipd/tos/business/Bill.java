package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class Bill implements RestaurantBill {
	
	
	public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
		double tot=0.0;
		double minprice=Integer.MAX_VALUE;
		
		if(itemsOrdered.size() > 20)
			throw new RestaurantBillException("!!ERROR!! : Ordine superiore ai 20 elementi");
		else {
			for(MenuItem i : itemsOrdered) {
				tot+= i.getPrice();
			}
		}
		
		if(itemsOrdered.size() > 10) {
			for(MenuItem i : itemsOrdered) {
				if(i.getPrice() < minprice)
					minprice=i.getPrice();
			}
			
			tot -= minprice;
		}
		
		if(tot > 100)
			tot *= 0.95;
		
		return tot;
	}

}
