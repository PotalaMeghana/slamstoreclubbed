package eStoreProduct.BLL;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Component
public class OrderIdCreationBLL {
		private static final Logger logger = LoggerFactory.getLogger(OrderIdCreationBLL.class);
//create the orderId  
	public String createRazorpayOrder(double amt) {
				logger.info("eStoreProduct:OrderIdCreationBLL::creating the orderId");
		System.out.println("amount in razorpay  " + amt);
		long amountInPaise = (long) (amt * 100);
		String orderId = null;
		try {
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_Eu94k5nuplVQzA", "iC6DFpPEkTIq0UGGQalJir6s");
			JSONObject obj = new JSONObject();
			obj.put("amount", amountInPaise);
			obj.put("currency", "INR");
			obj.put("receipt", "hello123");
			obj.put("payment_capture", true);
			Order order = razorpayClient.orders.create(obj);
			orderId = order.get("id");
			System.out.println(order.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}
}
