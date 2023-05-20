package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import core.app.emp.Emp;

public interface IOUtils {

	public static void storeEmp(String fileName,Map<String,Emp> empMap) throws FileNotFoundException, IOException{
		File file=new File(fileName);
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file,file.exists()))){
			out.writeObject(empMap);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String , Emp> restoreEmp(String fileName){
		
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(fileName))){
			
			return (HashMap<String, Emp>) in.readObject();
		} catch (Exception e) {
			
			return new HashMap<>();
		} 
		
		
	}
	
	
	
}
