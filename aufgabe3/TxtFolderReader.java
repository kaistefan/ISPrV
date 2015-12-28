package aufgabe3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TxtFolderReader {
	
	List <String>  readFolder(String file){
		
		return readFolder(new File(file));	
	}
	List <String>  readFolder(File file){
		List<String> out = new LinkedList<String> ();
		
			for(File a : file.listFiles()){
				if(a.isFile()){
					String typ = a.getName();
					typ = typ.substring(typ.indexOf('.'));
					if(typ.equalsIgnoreCase(".txt")){
						out.add(readFile(a));
					}
				}
			
		}
		return out;	
	}
	String readFile(File a) {
		// TODO Auto-generated method stub
		String out = "";
		 try {
	            FileReader f0 = new FileReader(a);
	            BufferedReader f = new BufferedReader(f0);
	            String line="";
	            while ((line = f.readLine()) != null) {
	            	out+=line;        
	            }
	            f.close();
	            f0.close();
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
		 
		return out;
	}
}
