import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptUtils {

		//단방향 암호화 - MD5 -> SHA256 or SHA512
		public static String getSHA512(String input){

			String toReturn = null;
			try {
				MessageDigest digest = MessageDigest.getInstance("SHA-512");
				digest.reset();
				digest.update(input.getBytes("utf8"));
				toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));
			} catch (Exception e) {
				e.printStackTrace();
			}

			return toReturn;
		}
		
		public static void main(String[] args) {
			
		String result = getSHA512("512");
		System.out.println(result);
		System.out.println(result.length());

		//양방향 암호화
	}
}
