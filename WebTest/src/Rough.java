import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.regex.Pattern;


public class Rough{
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
	public static void main(String[] args) {
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
		String number="-2000";  
		boolean match = Pattern.matches(decimalPattern, number);
		System.out.println(match); //if true then decimal else not  
		
		StringBuilder sb = new StringBuilder();
		sb.append("Feeling like shit.Get on your feet. Make some peel.Pinch of the Feat. Need some chill.Shake it Feel.Yo!! Just shake to Peel.-Shake"+eol);
		sb.append("Kill You Shake-.Mojito"+eol);
		String nonSense = sb.toString();
		
		String[] nonSenseSpit = nonSense.split("\\.");
		for(String nonSenseSpitStr:nonSenseSpit){
			System.out.println(nonSenseSpitStr);
		}
	}

	private static void doMethodThing() {
		for(Method meth: Rough.class.getDeclaredMethods()){
			System.out.println(Modifier.toString(meth.getModifiers())+" "+meth.getReturnType()+" "+meth.getName());
		}
	}
	
}
