package resear.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.zip.GZIPInputStream;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public class HexStringUtil_Incomplete {

	public static void main(String[] args) throws DecoderException, UnsupportedEncodingException {
		String hexString = "ED9AF973D346148047B113C25168E94D2F7A1F6E12C9D8B9FA1A90CCDA5175B25A1F710FD7D0509881C29070FCF97D4F5AAD130F1926D323C9E47918466F77B597F6FBF687176F1085D72B3D212BF6E2CAF58A885BB34F77EF2EACD62AE39D17B52BF776771FAF2F2D3D7FFE7C7167FC78F1CEA3874BE3DBE3C72F1E3E589FA9D4AAF40CD599DA9967DB4F76EE3FFAEBC6ACE5569C45BB36F76CFCE0E9F60ECCCDD4E6D4E8A6AB5C3863D5CE452DBB1E8D6C5F45306FD5E665D272E39608E1ACB5519BF504B68373963A57B79D9505BBB9E0D8549CB952C1794BCDC45E1EAAAD142E58CA6A53D4A5775EC3776CFC2DE4FFB05878228CE12216379A76F173A8";
		
		 
		
//		String hexString = "9B7D2C34A366BF890C730641E6CECF6F";    
//		byte[] bytes = Hex.decodeHex(hexString.toCharArray());
//		System.out.println(new String(bytes, "UTF-8"));
		
//		HexBinaryAdapter hexBinaryAdapter = new HexBinaryAdapter();
//		byte[] bytes = new BigInteger("00A0BF", 16).toByteArray();
//		System.out.println(new String(bytes, "UTF-8"));
		byte[] byteArr = DatatypeConverter.parseHexBinary(hexString);
//		System.out.println(new String(byteArr, "ISO-8859-1"));
		System.out.println(new String(new Base64().decode(byteArr), "ascii"));
		System.out.println(new String(new Base32().decode(byteArr), "ascii"));
//		System.out.println(new String(byteArr, "ascii"));
//		System.out.println(new String(DatatypeConverter.parseBase64Binary(hexToBinary(hexString)), "UTF-8"));
//		System.out.println(new String(DatatypeConverter.parseBase64Binary(hexToBinary1(hexString)), "UTF-8"));
//		System.out.println(hex_to_plaintext(hexString));
//		System.out.println(hexToBinary(hexString));
//		System.out.println(String.valueOf(hex_to_binary(hexString)));
//		System.out.println(meth(hex_to_binary(hexString)));
//		System.out.println(hex2decimal(hexString));
//		byte[] dem = decompress(DatatypeConverter.parseHexBinary(hexString));
//		System.out.println(new String(dem, "UTF-8"));
//		byte[] bytArr = fromHexString(hexString);
//		System.out.println(new String(bytArr, "UTF-8"));
//		byte[] decodedHex = new Hex().decodeHex(hexString.toCharArray());
//		System.out.println(new String(decodedHex, "ASCII"));
		
//		System.out.println(new String(hexStrToByteArray(hexString), "UTF-8"));
		
//		String password = "test";
//
//        MessageDigest digest = null;
//
//        try {
//            digest = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            digest.update(password.getBytes("UTF-8"));
//        } catch (UnsupportedEncodingException ex) {
//            ex.printStackTrace();
//        }
//
//        byte[] rawData = digest.digest();
//        StringBuffer printable = new StringBuffer();
//
//        for (int i = 0; i < rawData.length; i++) {
//            printable.append(carr[((rawData[i] & 0xF0) >> 4)]);
//            printable.append(carr[(rawData[i] & 0x0F)]);
//        }
//        String phpbbPassword = printable.toString();
//
//        System.out.println("PHPBB           : " + phpbbPassword);
//        System.out.println("MVNFORUM        : " + getMD5_Base64(password));
//        System.out.println("PHPBB->MVNFORUM : " + getBase64FromHEX(phpbbPassword));
//        
//        System.out.println(new String(fromHexString(hexString), "ASCII"));
	}
	
	static char[] carr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

   /* public static String getBase64FromHEX(String input) {

        byte barr[] = new byte[16];
        int bcnt = 0;
        for (int i = 0; i < 32; i += 2) {
            char c1 = input.charAt(i);
            char c2 = input.charAt(i + 1);
            int i1 = intFromChar(c1);
            int i2 = intFromChar(c2);

            barr[bcnt] = 0;
            barr[bcnt] |= (byte) ((i1 & 0x0F) << 4);
            barr[bcnt] |= (byte) (i2 & 0x0F);
            bcnt++;
        }*/

        /*BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(barr);
    }*/

    /*public static synchronized String getMD5_Base64(String input) {
        // please note that we dont use digest, because if we
        // cannot get digest, then the second time we have to call it
        // again, which will fail again
        MessageDigest digest = null;

        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (digest == null)
            return input;

        // now everything is ok, go ahead
        try {
            digest.update(input.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        byte[] rawData = digest.digest();
        BASE64Encoder bencoder = new BASE64Encoder();
        return bencoder.encode(rawData);
    }*/

    private static int intFromChar(char c) {
        char clower = Character.toLowerCase(c);
        for (int i = 0; i < carr.length; i++) {
            if (clower == carr[i]) {
                return i;
            }
        }

        return 0;
    }

	
	private static byte[] fromHexString(final String encoded) {
	    if ((encoded.length() % 2) != 0)
	        throw new IllegalArgumentException("Input string must contain an even number of characters");

	    final byte result[] = new byte[encoded.length()/2];
	    final char enc[] = encoded.toCharArray();
	    for (int i = 0; i < enc.length; i += 2) {
	        StringBuilder curr = new StringBuilder(2);
	        curr.append(enc[i]).append(enc[i + 1]);
	        result[i/2] = (byte) Integer.parseInt(curr.toString(), 16);
	    }
	    return result;
	}
	
	private static String doWork(String str) throws UnsupportedEncodingException{
		return new String(DatatypeConverter.parseHexBinary(str), "UTF-8");
	}
	
	private static String meth(String input){
		String output = "";
		for(int i = 0; i <= input.length() - 8; i+=8)
		{
		    int k = Integer.parseInt(input.substring(i, i+8), 2);
		    output += (char) k;
		}   
		return output;
	}
	
	private static String hexToBinary(String hex) {
		return new BigInteger(hex, 16).toString(2);
	}
	
	private static String hexToBinary1(String hex) {
	    int len = hex.length() * 4;
	    String bin = new BigInteger(hex, 16).toString(2);

	    //left pad the string result with 0s if converting to BigInteger removes them.
	    if(bin.length() < len){
	        int diff = len - bin.length();
	        String pad = "";
	        for(int i = 0; i < diff; ++i){
	            pad = pad.concat("0");
	        }
	        bin = pad.concat(bin);
	    }
	    return bin;
	}
	
	public static String zero_pad_bin_char(String bin_char){
	    int len = bin_char.length();
	    if(len == 8) return bin_char;
	    String zero_pad = "0";
	    for(int i=1;i<8-len;i++) zero_pad = zero_pad + "0"; 
	    return zero_pad + bin_char;
	}
	public static String plaintext_to_binary(String pt){
	    return hex_to_binary(plaintext_to_hex(pt));
	}
	public static String binary_to_plaintext(String bin){
	    return hex_to_plaintext(binary_to_hex(bin));
	}
	public static String plaintext_to_hex(String pt) {
	    String hex = "";
	    for(int i=0;i<pt.length();i++){
	        String hex_char = Integer.toHexString(pt.charAt(i));
	        if(i==0) hex = hex_char;
	        else hex = hex + hex_char;
	    }
	    return hex;  
	}
	public static String binary_to_hex(String binary) {
	    String hex = "";
	    String hex_char;
	    int len = binary.length()/8;
	    for(int i=0;i<len;i++){
	        String bin_char = binary.substring(8*i,8*i+8);
	        int conv_int = Integer.parseInt(bin_char,2);
	        hex_char = Integer.toHexString(conv_int);
	        if(i==0) hex = hex_char;
	        else hex = hex+hex_char;
	    }
	    return hex;
	}
	public static String hex_to_binary(String hex) {
	    String hex_char,bin_char,binary;
	    binary = "";
	    int len = hex.length()/2;
	    for(int i=0;i<len;i++){
	        hex_char = hex.substring(2*i,2*i+2);
	        int conv_int = Integer.parseInt(hex_char,16);
	        bin_char = Integer.toBinaryString(conv_int);
	        bin_char = zero_pad_bin_char(bin_char);
	        if(i==0) binary = bin_char; 
	        else binary = binary+bin_char;
	        //out.printf("%s %s\n", hex_char,bin_char);
	    }
	    return binary;
	}
	public static String hex_to_plaintext(String hex) {
	    String hex_char;
	    StringBuilder plaintext = new StringBuilder();
	    char pt_char;
	    int len = hex.length()/2;
	    for(int i=0;i<len;i++){
	        hex_char = hex.substring(2*i,2*i+2);
	        pt_char = (char)Integer.parseInt(hex_char,16);
	        plaintext.append(pt_char);
	        //out.printf("%s %s\n", hex_char,bin_char);
	    }
	    return plaintext.toString();
	}
	
	public static int hex2decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
	
	public static byte[] decompress(byte[] contentBytes){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            IOUtils.copy(new GZIPInputStream(new ByteArrayInputStream(contentBytes)), out);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
        return out.toByteArray();
    }
	
	public static byte[] hexStrToByteArray(String hex) {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream(hex.length() / 2);

	    for (int i = 0; i < hex.length(); i += 2) {
	        String output = hex.substring(i, i + 2);
	        int decimal = Integer.parseInt(output, 16);
	        baos.write(decimal);
	    }
	    return baos.toByteArray();
	}
	
}
