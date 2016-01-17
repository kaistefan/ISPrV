package aufgabe3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TxtFolderReader {
	
	/**
	 * Gibt alle Texte aus dem Ordner in einer Liste wieder.
	 * @param file File zum Ordner als Text.
	 * @return Liste mit den Texten
	 */
	List <String>  readFolder(String file){	
		return readFolder(new File(file));	
	}
	
	/**
	 * Gibt alle Texte aus dem Ordner in einer Liste wieder.
	 * @param file File zum Ordner.
	 * @return Liste mit den Texten
	 */
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
	
	/**
	 * liefert den Text vom File.
	 * @param a File zum Text
	 * @return Der Text.
	 */
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
