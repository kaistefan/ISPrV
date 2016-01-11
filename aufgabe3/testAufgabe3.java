package aufgabe3;

import java.util.List;

public class testAufgabe3 {
	
	public static void main(String[] args) {
	TxtFolderReader in = new TxtFolderReader ();
	List<String> test =in.readFolder(args[1]);
	TextClassification textcl =new TextClassification ();
	System.out.println(test.size());
	textcl.trainA(test);
	}
}
