package resear.utils;

import java.io.ByteArrayOutputStream;

public class CryptHelper_Incomplete {

	/*public byte[] encryptBytesToBytes(byte[] plainData, byte[] key, byte[] iv) {
	    try {
	        initCipher(Cipher.ENCRYPT_MODE, key, iv);
	        return aesCipher.doFinal(plainData);

	    } catch (IllegalBlockSizeException | BadPaddingException e) {
	        log.severe(e.getMessage());
	    }

	    return null;
	}    

	public byte[] decryptBytesToBytes(byte[] encryptedBytes, int length,
	        byte[] key, byte[] iv) {
	    try {
	        initCipher(Cipher.DECRYPT_MODE, key, iv);
	        return aesCipher.doFinal(encryptedBytes, 0, length);
	    } catch (IllegalBlockSizeException | BadPaddingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	private void initCipher(int mode, byte[] keyBytes, byte[] ivBytes) {
	    try {

	        // create shared secret and init cipher mode
	        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
	        aesCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        aesCipher.init(mode == Cipher.ENCRYPT_MODE ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(ivBytes));
	    } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
	        e.printStackTrace();
	    }
	}*/

	public String byteArrayToHexStr(byte[] encrypted) {
	    StringBuilder hex = new StringBuilder();
	    for (byte b : encrypted) {
	        hex.append(String.format("%02X", b));
	    }
	    return new String(hex.toString());
	}

	public byte[] hexStrToByteArray(String hex) {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream(hex.length() / 2);

	    for (int i = 0; i < hex.length(); i += 2) {
	        String output = hex.substring(i, i + 2);
	        int decimal = Integer.parseInt(output, 16);
	        baos.write(decimal);
	    }
	    return baos.toByteArray();
	}
}
