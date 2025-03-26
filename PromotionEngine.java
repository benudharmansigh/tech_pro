package promotionengine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionEngine {
	List<Promotion> promotions;

	public PromotionEngine(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	public int applyPromotion(List<CartItem> cart) {
		Map<String, Integer> cartItems = new HashMap<String, Integer>();
		int totalPrice = 0;

		for (CartItem item : cart) {
			cartItems.put(item.product.sku, item.quantity);
			totalPrice = totalPrice+item.product.price * item.quantity;
		}
		for (Promotion promo : promotions) {
			while (promo.isApplicable(cartItems)) {
				for (String sku : promo.items.keySet()) {
					cartItems.put(sku, cartItems.get(sku) - promo.items.get(sku));
				}
				totalPrice -= calculateDiscout(cart, promo);
			}
		}
		return totalPrice;

	}

	private int calculateDiscout(List<CartItem> cart, Promotion promo) {
		// TODO Auto-generated method stub
		int originalPrice = 0;

		for (CartItem item : cart) {
			if (promo.items.containsKey(item.product.sku)) {
				originalPrice += item.product.price * promo.items.get(item.product.sku);
			}
		}
		return originalPrice - promo.discoutPrice;
	}

}
