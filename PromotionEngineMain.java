package promotionengine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PromotionEngineMain {
	public static void main(String[] args) {
		
		Product A =new Product("A", 50);
		Product B =new Product("B", 30);
		Product C =new Product("C", 20);
		Product D =new Product("D", 15);
		
		
		List<CartItem> cart=Arrays.asList(
				new CartItem(A,3),
				new CartItem(B,5),
				new CartItem(C,1),
				new CartItem(D,1)
);
		
		List<Promotion> promotions=Arrays.asList(
				new Promotion("Active Promotions", Map.of("A",3), 130),
				new Promotion("Active Promotions", Map.of("B",2), 45),
				new Promotion("Active Promotions", Map.of("C",1,"D",1), 30)
);
		
		PromotionEngine engine=new PromotionEngine(promotions);
		int finalPrice=engine.applyPromotion(cart);
		
		System.out.println("Final Price After Promotions: "+finalPrice);
	}
	

}
