import java.util.Arrays;


public class DecryPass {
	
	private static final char[] mask = new char[]{'#','P','X','*','1'};
	private static final String SaltList[] = {"g$44=", "F8h6B", "C2^sf", "KMD7*", "dh!f9,", "1O32", "7sGp~", "KDQ5h","km#zBn", "L1xJ4EQ"};
	private static final char unMask = 31;
	private static final char maskBit = 7;
	private static final char[] identifier = {'8','.','1','_','P','A','S','S'};

	public static void main(String[] args) {
			
		System.out.println(convertConfigFilePW("; .;!INLTGN54%,:0t@wy?)6XWFTT"));
	}
	
	public static String convertConfigFilePW(String pw) {
		/* code written to handle the quotes referred from \Classic_Stages\dssapsupBOOL::CSerializedString::Quote(CString &sString) 
		 Logic: If hash password contains " then before writing that password in config file, above GUI code appends " before each " and whole password is then 
		 enclosed under "". Therefore to get the actual hash password from config file, we first remove extra " and then convert hash password to clear format
		 Hashing is done is using salt mechanism and below implementation is same as done in Classic_Stages\commonlib\password.c\DecryptPassword. 
		 * */
		if(pw!=null && pw!=""){
			if(pw.contains("\"")){
				pw = pw.substring(1, pw.length()-1);
			}
			char pwca[] = pw.toCharArray();
			
			StringBuilder sb = new StringBuilder(pw);
			for(int i = 0; i<pwca.length;i++){
				if(pwca[i]=='"'){
					if(pwca[i+1]=='"'){
						sb.deleteCharAt(i+1);
						i++;
					}
				}
			}
			pw = sb.toString();
			
			char[] value = pw.toCharArray();
			if(pw.length()<8){
				return convertConfigFilePWOld(pw, value);
			}
			else{
				char[] pwdIdentifier = pw.substring(pw.length()-8, pw.length()).toCharArray();

				for(int strindex = 0;strindex<pwdIdentifier.length;strindex++){
					pwdIdentifier[strindex]= (char)(pwdIdentifier[strindex]^maskBit);
				}

				if(Arrays.equals(identifier, pwdIdentifier)){
					int index1 =Integer.parseInt(""+((char) (value[0]^(mask[0] & unMask))));
					int index2 =Integer.parseInt(""+((char) (value[1]^(mask[1] & unMask))));
					int index3 =Integer.parseInt(""+((char) (value[2]^(mask[2] & unMask))));
					int index4 =Integer.parseInt(""+((char) (value[3]^(mask[3] & unMask)))); 
					int index5 =Integer.parseInt(""+((char) (value[4]^(mask[4] & unMask))));
					int sizeOfOrgPwd = (index4*10)+index5;

					char[] preSalt = (SaltList[index1]+SaltList[index2]+SaltList[index3]).toCharArray();
					char[] finalSalt=new  char[preSalt.length];
					char[] finalPwd=new  char[sizeOfOrgPwd];

					for (int strindex = 0; strindex < preSalt.length; strindex++) {
						finalSalt[strindex] = (char) (preSalt[strindex] & unMask); 		
					}
					for (int strindex = 0; strindex < sizeOfOrgPwd; strindex++) {
						if(strindex<finalSalt.length){
							finalPwd[strindex] = (char) (value[strindex+5]^finalSalt[strindex]);	
						}			
						else
							finalPwd[strindex]=value[strindex+5];
					}

					String decryptedPW = new String(finalPwd);
					decryptedPW = decryptedPW.substring(0, sizeOfOrgPwd);
					return decryptedPW;
				}
				else{
					return convertConfigFilePWOld(pw, value);
				}
			}
		}
		return pw;
	}
	
	private static String convertConfigFilePWOld(String pw, char[] value) {
		final int mask = 0x1F;
		for (int strindex = 0; strindex < value.length; strindex++) {
			value[strindex] ^= mask;
		}

		String decryptedPW = new String(value);
		return decryptedPW;
	}

}
