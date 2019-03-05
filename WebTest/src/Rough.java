import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Key;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//just to test from another pc for git
public class Rough{
	
	private static Rough roughObj;
		
	private int i;
	private String name;
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static String regis(){
		return "Class name: "+Rough.class.getName();
	}
	
	public String getClassName(){
		return Rough.regis();
	}
	
	public synchronized static Rough getRoughObj(){
		if(roughObj==null)
			roughObj=new Rough();
		return roughObj;
	}
	
	public static void main(String[] args) {
		
		//&&
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		//&
		System.out.println(true & true);
		System.out.println(true & false);
		System.out.println(false & true);
		System.out.println(false & false);
		
		//||
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		//|
		System.out.println(true | true);
		System.out.println(true | false);
		System.out.println(false | true);
		System.out.println(false | false);
		
		/*null pointer exception check*/
		Object o = null;		//NullPointerException
//		Object o = null;
//		Object o = System.getenv("path");
//		Object o = System.getenv("path1");
		String path = (String) o;
		System.out.println("path: "+path);
		/*null pointer exception check*/
		
		checkLoggingGranuality();
		
		
		System.out.println(fibonacci(7));
		//create an environment variable before this named "amigo_eclipse"
		System.out.println("amigo_eclipse: "+System.getenv("amigo_eclipse"));
		String eol = System.lineSeparator();
		doMethodThing();
		System.out.println("is 1024*1024*1024 larger than Integer's MAX_VALUE: "+((1024*1024*1024)>Integer.MAX_VALUE)+eol
				+ "bcoz 1024*1024*1024= "+(1024*1024*1024)+" and Integer's MAX_VALUE= "+Integer.MAX_VALUE+eol
				+ "so Integer's MAX_VALUE don't give a DAMN about the 1024*1024*1024..."+eol
				+ "FUCK YEAH!!! 1024*1024*1024 ;) :D :P");
		
		System.out.println("is 2000*1024*1024= "+(2000*1024*1024)+" larger than Integer's MAX_VALUE: "+Integer.MAX_VALUE+" "+((2000*1024*1024)>Integer.MAX_VALUE));
		System.out.println("Integer.MAX_VALUE can go to max of the "+(double)(Integer.MAX_VALUE/(1024*1024*1024))+"gb");
		
		System.out.println(Math.round(Float.parseFloat("-1")));
		String decimalPattern = "[+-]?\\d*\\.?\\d*";  
		String either0OR1 = "[01]?";
		String number="-2000";  
		String num = "0";
		boolean match = Pattern.matches(decimalPattern, number);
		System.out.println(match); //if true then decimal else not
		System.out.println("either 0 or 1: "+Pattern.matches(either0OR1, num)); //if true then either0 or 1 else not
		
		StringBuilder sb = new StringBuilder();
		sb.append("Feeling like shit.Get on your feet. Make some peel.Pinch of the Feat. Need some chill.Shake it Feel.Yo!! Just shake to Peel.-Shake"+eol);
		sb.append("Kill You Shake-.Mojito"+eol);
		String nonSense = sb.toString();
		
		String[] nonSenseSpit = nonSense.split("\\.");
		for(String nonSenseSpitStr:nonSenseSpit){
			System.out.println(nonSenseSpitStr);
		}
		
		try {
			File fileScannerRead = new File(System.getProperty("user.dir")+File.separator+"resource"+File.separator+"AUTO START Linux DB2.txt");
			if(fileScannerRead.exists())
				System.out.println(new Scanner(fileScannerRead).useDelimiter("\\A").next());
			
//			System.out.println("fucking equal or not: "+new Scanner(new File("C:\\Users\\nitish.kholiya\\Desktop\\NF\\README_Windows_Original.txt")).useDelimiter("\\A").next().equalsIgnoreCase(new Scanner(new File("C:\\Users\\nitish.kholiya\\Desktop\\NF\\README_Windows_Updated.txt")).useDelimiter("\\A").next()));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("file.separator '\\' (true/false)?: "+(System.getProperty("file.separator").equals("\\")));
		System.out.println("temp path exist: "+(System.getenv("comspec"))+": "+new File(System.getenv("comspec")).exists());
		//encrypt/decrypt
		try 
        {
            String text = "Each destination is associated with a connection factory and, if the pooling feature is used, with a connection pool. Initially the destination pool is empty. JCo runtime does not preallocate connections. The first connection will be created if the first call is sent. The property peak_limit describes how many connections can be created simultaneously, if applications allocate connections (either executes a remote call or for a stateful call sequence) in different sessions at the same time. After peak_limit connections are allocated (in peak_limit sessions), the next session will wait for maximum max_get_client_time ms until a different session releases a connection (either finishes the remote call or ends the stateful call sequence). In case the waiting session does not get any connection during the max_get_client_time ms, the function request will be aborted with a JCoException with the key JCO_ERROR_RESOURCE.";
            String key = "012encrydecry345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(new String("encrypted: "+encrypted));
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println("decrypted: "+decrypted);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
		String st = null;
//		System.out.println(st.isEmpty());
		System.out.println("1".equals(null));
		System.out.println("[12345]? : "+Pattern.matches("[12345]?", "1"));
		if(Boolean.parseBoolean("true"))
			System.out.println(true&&true&&false);
		
		System.out.println("---------");		
		System.out.println("numDecodings:  "+numDecodings("101"));
		//alter path accordingly
		System.out.println("endsWith: "+"C:\\SNC\\dsadm\\ER0\\IBMDDADM.cRt".trim().toLowerCase().endsWith(" ".trim().toLowerCase()));
		
		
		/*Properties properties = new Properties();
		properties.put("Name", null);
		properties.put("Age", null);
		System.out.println(properties);*/
		
		System.out.println("true&&!false&&!false: " +(true&&!false&&!false));
		InnerClass01 innerClass01 = new Rough().new InnerClass01();
		InnerClass02 innerClass02 = new Rough().new InnerClass02();
		
		System.out.println("new Object[]{1,2}: "+new Object[]{1,2});
		
		String[] strA = "boo:and:foo".split("o",2);
		System.out.println("strA.length: "+strA.length);
		for(String a: strA){
			System.out.print(a+",");
		}
		
		String[] strARR = {"DOM", "Bo Ha ha HA", "IN7", "ER0", new Object().toString(), "1", new Rough().toString(), "mangoshake"};
		for(String str: strARR){
			System.out.println("\n\nReading "+str);
			readSncConfigAndprovideRespectiveMap(str);
		}
		

		String o1 = "Nitish";
		String o2 = new String("Kholiya");
		System.out.println(new Rough().hi1(o1, o2));
		
		//FileWriter performance
		
		//alter path accordingly
		File fileWriterFile = new File("C:\\Users\\nitish.kholiya\\Desktop\\PerformanceCheck\\FileWriter");

		try {
			if(!fileWriterFile.exists()){
				fileWriterFile.mkdirs();
			}
			//alter path accordingly
			fileWriterFile = new File("C:\\Users\\nitish.kholiya\\Desktop\\PerformanceCheck\\FileWriter\\FileWriterPerformanceWithoutThread.txt");
			if(!fileWriterFile.exists()){
				fileWriterFile.createNewFile();
			}
			FileWriter fileWriterObj = new FileWriter(fileWriterFile);
			fileWriterObj.write("Performace check for FileWriter without Thread:    "+eol);
			Long startTime = System.currentTimeMillis();
			for(int i=0; i<9999999; i++){
				fileWriterObj.write("i: "+i+eol);
			}
			Long endTime = System.currentTimeMillis();
			fileWriterObj.write("Time taken to write into this file : "+(endTime-startTime)+"millis"+eol);
			fileWriterObj.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		
		//BufferedWriter performance
		//alter path accordingly
		File bufferedWriterFile = new File("C:\\Users\\nitish.kholiya\\Desktop\\PerformanceCheck\\BufferedWriter");
		try {
			if(!bufferedWriterFile.exists()){
				bufferedWriterFile.mkdirs();
			}
			//alter path accordingly
			bufferedWriterFile = new File("C:\\Users\\nitish.kholiya\\Desktop\\PerformanceCheck\\BufferedWriter\\BufferefdfWriterPerformanceWithoutThread.txt");
			if(!bufferedWriterFile.exists()){
				bufferedWriterFile.createNewFile();
			}
			Writer writer = new FileWriter(bufferedWriterFile);
			BufferedWriter bufferedWriterObj = new BufferedWriter(writer);
			bufferedWriterObj.write("Performace check for BufferedWriter without Thread:    "+eol);
			Long startTime = System.currentTimeMillis();
			for(int i=0; i<9999999; i++){
				bufferedWriterObj.write("i: "+i+eol);
			}
			Long endTime = System.currentTimeMillis();
			bufferedWriterObj.write("Time taken to write into this file : "+(endTime-startTime)+"millis"+eol);
			bufferedWriterObj.close();

		} catch (IOException e) {
			e.printStackTrace();
		} 

		
		
		try {
			Desktop.getDesktop().open(fileWriterFile);
			Desktop.getDesktop().open(bufferedWriterFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//FileWriter performance with Thread
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {

					String eol = System.getProperty("line.separator");
					//alter path accordingly
					File fileWriterFile = new File("C:\\Users\\nitish.kholiya\\Desktop\\PerformanceCheck\\FileWriter\\FileWriterPerformanceWithThread.txt");
					if(!fileWriterFile.exists()){
						fileWriterFile.createNewFile();
					}
					FileWriter fileWriterObj = new FileWriter(fileWriterFile);
					fileWriterObj.write("Performace check for FileWriter with Thread:    "+eol);
					Long startTime = System.currentTimeMillis();
					for(int i=0; i<9999999; i++){
						fileWriterObj.write("i: "+i+eol);
					}
					Long endTime = System.currentTimeMillis();
					fileWriterObj.write("Time taken to write into this file : "+(endTime-startTime)+"millis"+eol);
					fileWriterObj.close();
					Desktop.getDesktop().open(fileWriterFile);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}).start();;
		
		
		//BufferedWriter performance with Thread
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {

					String eol = System.getProperty("line.separator");
					//alter path accordingly
					File bufferedWriterFile = new File("C:\\Users\\nitish.kholiya\\Desktop\\PerformanceCheck\\BufferedWriter\\BufferefdfWriterPerformanceWithThread.txt");
					if(!bufferedWriterFile.exists()){
						bufferedWriterFile.createNewFile();
					}
					Writer writer = new FileWriter(bufferedWriterFile);
					BufferedWriter bufferedWriterObj = new BufferedWriter(writer);
					bufferedWriterObj.write("Performace check for BufferedWriter with Thread:    "+eol);
					Long startTime = System.currentTimeMillis();
					for(int i=0; i<9999999; i++){
						bufferedWriterObj.write("i: "+i+eol);
					}
					Long endTime = System.currentTimeMillis();
					bufferedWriterObj.write("Time taken to write into this file : "+(endTime-startTime)+"millis"+eol);
					bufferedWriterObj.close();
					
					Desktop.getDesktop().open(bufferedWriterFile);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}).start();
		
		System.out.print("press a key: ");
		try {
			System.out.print(System.in.read());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("formattedMessage: "+ new MessageFormat("Hello Mr.{0}, How are you Today?").format(new Object[]{}));
		
		Path p = Paths.get("C:\\");
		System.out.println(p.toString()+" exists: "+Files.exists(p));
		p = Paths.get(p.toString(), "HI.txt");
		try{
			Files.createFile(p);	
		} catch (IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
		/*System.out.println("\n\nComplete SNC.config: ");
		readSncConfigComplete();
		System.out.println("Full SNC.config reading done!!!\n\n");
		readSncConfig();*/
		int toleranceCounter=0;
		for(int i=0; i<i+1; i++){		
			String strin = Rough.getRoughObj().getPathToSomeotherLocation(i);
			if(strin.contains("doesn't exist")){
				toleranceCounter++;
			}
			if(toleranceCounter>7){
				strin = "told u asshole many times already, that directory doesn't exits still...";
			}
			System.out.println("Directory up by "+i+" : "+strin);
			if(toleranceCounter>7){
				System.err.println("Keeda hai kya?????");
				return;
			}
		}
		
		
	}

	public static void checkLoggingGranuality() {
		Level[] logValue = {Level.ALL, Level.CONFIG, Level.FINE, Level.FINER, Level.FINEST, Level.INFO, Level.OFF, Level.SEVERE, Level.WARNING};
		
		for(int current=0; current<logValue.length; current++){
			for(int next=current; next<logValue.length; next++){
				if(logValue[current].intValue()>logValue[next].intValue()){
					Level Swap = logValue[current];
					logValue[current] = logValue[next];
					logValue[next] = Swap;
				}
			}
		}
		
		for (Level level : logValue) {
			System.out.println(level + ": " + level.intValue());
		}
	}
	
	private String getPathToSomeotherLocation(int directoryUp){
		File currentPath= new File(this.getClass().getResource("").getPath().toString());
		for(int i=0; i<directoryUp; i++){
			if(currentPath.getParent()!=null)
				currentPath=new File(currentPath.getParent());
			else
				return "directory above "+directoryUp+" doesn't exist..";
		}
		return currentPath.getAbsolutePath();
	}

	
	private static void readSncConfigAndprovideRespectiveMap(String str) {
		try{
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\nitish.kholiya\\Desktop\\SNC.config"));
			List<Map<String,String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			String strLine;
			while ((strLine = br.readLine()) != null){
				if(strLine.contains("<BEGIN>")){
					map = new HashMap<String, String>();
				}
				if(!strLine.contains("<BEGIN>") && !strLine.contains("<END>") && strLine.contains("=")){
					String[] strLineArr = strLine.split("=",2);
					if(strLineArr.length==1)
						map.put(strLineArr[0].trim(), null);
					else if(strLineArr.length==2)
						map.put(strLineArr[0].trim(), strLineArr[1].trim());
				}
				if(strLine.contains("<END>")){
					list.add(map);
				}
			}
			
			
			Iterator<Map<String, String>> iter = list.iterator();
			while(iter.hasNext()){
				Map<String, String> selectedMap = iter.next();
				if(selectedMap.containsKey("NAME") && selectedMap.get("NAME").equals(str)){
					for(Map.Entry<String, String> entry: selectedMap.entrySet()){
						System.out.println(entry.getKey()+"->"+entry.getValue());
					}
				}
			}
			
		} catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	private static void readSncConfig() {
		try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"resource"+File.separator+"SNC.config"));){
			List<Map<String,String>> list = new ArrayList<Map<String, String>>();
			Map<String, String> map = null;
			String strLine;
			while ((strLine = br.readLine()) != null){
				System.out.println("reading: "+strLine);
				if(strLine.contains("<BEGIN>")){
					map = new HashMap<String, String>();
				}
				if(!strLine.contains("<BEGIN>") && !strLine.contains("<END>") && strLine.contains("=")){
					String[] strLineArr = strLine.split("=",2);
					if(strLineArr.length==1)
						map.put(strLineArr[0], null);
					else if(strLineArr.length==2)
						map.put(strLineArr[0], strLineArr[1]);
					else
						throw new WrongConfigFile("Please check if right config file is provided. Config file should have proper formatting");
				}
				if(strLine.contains("<END>")){
					list.add(map);
				}
			}
			
			
			Iterator<Map<String, String>> iter = list.iterator();
			while(iter.hasNext()){
				map = iter.next();
				for(Map.Entry<String, String> entry: map.entrySet()){
					System.out.println(entry.getKey()+"->"+entry.getValue());
				}
			}
			
		} catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	private static void readSncConfigComplete() {
		try{
			BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"resource"+File.separator+"SNC.config"));
			String strLine;
			while ((strLine = br.readLine()) != null){
				System.out.println (strLine);
			}
			br.close();
		}catch (Exception e){
				 System.err.println("Error: " + e.getMessage());
			}
	}


	class InnerClass01{
		public InnerClass01(){
			System.out.println("InnerClass01");
		}
	}
	
	class InnerClass02{
		public InnerClass02(){
			System.out.println("InnerClass02");
		}
	}
	
	private static void doMethodThing() {
		for(Method meth: Rough.class.getDeclaredMethods()){
			System.out.println(Modifier.toString(meth.getModifiers())+" "+meth.getReturnType()+" "+meth.getName());
		}
		String uselessString="     ";
		System.out.println("uselessString.length(): "+uselessString.length());
		System.out.println("uselessString.trim().equalsIgnoreCase(): "+(uselessString.trim().isEmpty()));
	}	
	
	/*
	 * 	 A message containing letters from A-Z is being encoded to numbers using the following mapping:
		‘A’ – 1
		‘B’ – 2
		‘Z’ – 26
		Given an encoded message containing digits, determine the total number of ways to decode it.
		For example,
		Given encoded message “12″, it could be decoded as “AB” (1 2) or “L” (12).
		The number of ways decoding “12″ is 2.
	 * */
		
	public static int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;
        int ways[] = new int[n+1];
         
        ways[0] = 1;
        ways[1] = s.charAt(0) !='0' ? 1:0;
        for(int i=2; i<=n; i++){
            if(s.charAt(i-1) !='0'){
                ways[i] = ways[i-1];
            }
            int val = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
            if(val<=26 && val>=10){
                ways[i] += ways[i-2];
            }
        }
        return ways[n];
    }
	
	
	//1st preference
	private String hi1(String o1, String o2){
		return "Calling ... private String hi1(String o1, String o2)";
	}
	
	//2nd preference
	private String hi1(String o1, Object o2){
		return "Calling ... private String hi1(String o1, Object o2)";
	}
	
	//3rd preference
	private String hi1(Object o1, String o2){
		return "Calling ... private String hi1(Object o1, String o2)";
	}
	
	//4th preference
	private String hi1(Object o1, Object o2){
		return "Calling ... private String hi1(Object o1, Object o2)";
	}
	
	
	private static int fibonacci(int n){
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	
	
}

class GrandParent{
	void meth(){
		System.out.println("GrandParent");
	}
}

class Parent extends GrandParent{
	protected void meth(){
		System.out.println("Parent");
	}
}

class Child extends Parent{
	protected void meth(){
		System.out.println("Child");
	}
}

class Child1 extends Child{
	public void meth(){
		System.out.println("Child1");
	}
}

class WrongConfigFile extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongConfigFile(String arg0) {
		super(arg0);
	}
	public WrongConfigFile(Throwable th) {
		super(th);
	}
}

