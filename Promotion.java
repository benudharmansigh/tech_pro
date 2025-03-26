package promotionengine;

import java.util.Map;

public class Promotion {
	String type;
	Map<String, Integer> items; //SKU and required quantity
	int discoutPrice;
	
	
	public Promotion(String type, Map<String, Integer> items, int discoutPrice) {
		this.type = type;
		this.items = items;
		this.discoutPrice = discoutPrice;
	}
	
	public boolean isApplicable(Map<String,Integer> cartItems) {
		
		for(Map.Entry<String, Integer> entry:items.entrySet()) {
			if(cartItems.getOrDefault(entry.getKey(), 0)< entry.getValue()) {
				
			return false;
		}
	}
	return true;
		
	}
	
 
}
