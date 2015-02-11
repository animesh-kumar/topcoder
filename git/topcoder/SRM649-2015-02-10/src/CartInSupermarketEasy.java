import java.util.ArrayList;

/**
 * This code is not complete and doesn't work. Please don't use it.
 * 
 * @author animesh-kumar
 *
 */
public class CartInSupermarketEasy {

	public int calc(int n, int k) {
		// First check if k > 0
		int time = 0;
		ArrayList<Integer> carts = new ArrayList<Integer>();
		ArrayList<Integer> cartsDup = new ArrayList<Integer>();
		cartsDup.add(n);
		if (k > 0) {
			// Split the cart
			for (int i = 0; i < k; i++) {
				// Check each element in the arraylist and divide it
				boolean divided = false;
				for (Integer cart : cartsDup) {
					if (cart > 1) {
						divided = true;
						int half = cart / 2;
						if (cart % 2 == 0) {
							carts.add(half);
							carts.add(half);
						} else {
							carts.add(half);
							carts.add(half + 1);
						}
					} else {
						break;
					}
				}
				if (divided) {
					time++;
					cartsDup.removeAll(cartsDup);
					cartsDup.addAll(carts);
					carts.removeAll(carts);
				}
			}
			int i = 0;
			carts.addAll(cartsDup);
			int size = carts.size();

			// Once you have finished division reduce
			while (size > 0) {
				for (int j = 0; j < size; j++) {
					int cart = carts.remove(i);
					cart--;
					if (cart > 0) {
						carts.add(cart);
					}
				}
				size = carts.size();
				time++;
			}
			System.out.println(time);
			return time;
		}
		System.out.println(time);
		return n;
	}

	public static void main(String[] args) {
		CartInSupermarketEasy c = new CartInSupermarketEasy();
		int n = 15;
		int k = 4;
		c.calc(n, k);
	}

}
