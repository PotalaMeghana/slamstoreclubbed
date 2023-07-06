package eStoreProduct.externalServices;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class passwordHashing {
	public static String hashString(String input) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = messageDigest.digest(input.getBytes());

			StringBuilder stringBuilder = new StringBuilder();
			for (byte b : hashBytes) {
				stringBuilder.append(String.format("%02x", b));
			}

			return stringBuilder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}