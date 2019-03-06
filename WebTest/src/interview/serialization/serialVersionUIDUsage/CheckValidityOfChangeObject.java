package interview.serialization.serialVersionUIDUsage;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CheckValidityOfChangeObject {

	public static void main(String[] args) {
		
		Address address = new Address();
		   address.setStreet("wall street");
		   address.setCountry("united states");

		   
		serializeObject(address);
		try {
			Desktop.getDesktop().open(new File("d:\\IBM\\address.txt"));
			Thread.sleep(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Address newAddress = deserializeObject();
		
		System.out.println("are both object same = "+(address.equals(newAddress)));
	}

	private static Address deserializeObject() {
		 
		 Address address = null;;
		try {
			FileInputStream fin = new FileInputStream("d:\\IBM\\address.txt");
			ObjectInputStream ois = new ObjectInputStream(fin);
			address = (Address) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return address;
		
	}

	private static void serializeObject(Address address) {
		try{

			FileOutputStream fout = new FileOutputStream("d:\\IBM\\address.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(address);
			oos.close();
			System.out.println("Done");

		   }catch(Exception ex){
			   ex.printStackTrace();
		   }
	}
	
}
