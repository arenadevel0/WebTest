package resear.bytecodeCheck.javaassist;

import java.io.DataInputStream;
import java.io.InputStream;

import javassist.bytecode.ClassFile;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.MethodInfo;

public class ByteCodeChecker {
	public static void main(String[] args) {
		int classByteLength = 0;
		try(InputStream is=java.lang.System.class.getResourceAsStream("System.class")) {
		    ClassFile cf = new ClassFile(new DataInputStream(is));
		    for(MethodInfo mi: cf.getMethods()) {
		        CodeAttribute ca = mi.getCodeAttribute();
		        if(ca == null) continue; // abstract or native
		        int bLen = ca.getCode().length;
		        classByteLength+=bLen;
		        System.out.println("byte length for "+mi.getDescriptor()+": "+bLen+" bytes");
		        /*if(bLen > 300)
		            System.out.println(mi.getName()+" "+mi.getDescriptor()+", "+bLen+" bytes");*/
		    }
		    System.out.println("byte length of class: "+classByteLength+" bytes");
		} catch (Exception e) {
			System.err.println("error occured");
		}
	}
}
