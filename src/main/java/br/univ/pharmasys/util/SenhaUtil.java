package br.univ.pharmasys.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class SenhaUtil {

	private static final int ITERATIONS = 310_000;
	private static final int KEY_LENGTH = 256;
	private static final int SALT_LENGTH = 16;
	private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
	
	private static final SecureRandom random = new SecureRandom();
	
	public static String hashPassword(String password) {
		return hashPassword(password.toCharArray());
	}	
	
	public static String hashPassword(char[] password) {
		byte[] salt = new byte[SALT_LENGTH];
		random.nextBytes(salt);
		byte[] hash = pbkdf2(password, salt);
		
		return Base64.getEncoder().encodeToString(salt) + ":" +
		Base64.getEncoder().encodeToString(hash);
	}
	
	public static boolean verifyPassword(String password, String stored) {
		return verifyPassword(password.toCharArray(), stored);
	}

	public static boolean verifyPassword(char[] password, String stored) {
		
		String[] parts = stored.split(":");
		if (parts.length != 2) {
			return false;
		}
		
		byte[] salt = Base64.getDecoder().decode(parts[0]);	
		byte[] expectedHash = Base64.getDecoder().decode(parts[1]);
		byte[] testHash = pbkdf2(password, salt);	
		
		return MessageDigest.isEqual(expectedHash, testHash);
	}
	
	private static byte[] pbkdf2(char[] password, byte[] salt) {
	
		try {
			PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
			SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
		
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException("Falha crítica na criptografia da senha", e);
		}
	}
}