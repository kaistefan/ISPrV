package aufgabe3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextClassification {
	private Double totalTextA,totalTextB;
	private Double totalSentencesA,totalSentencesB;
	private Double totalWordsA,totalWordsB;
	private Double totalCharsA,totalCharsB;
	private Map<String,Double> wordsA,wordsB;
	private Map<Character,Double> charsA,charsB;
	private int numberCountA,numberCountB;
	
	
	TextClassification(){
		totalTextA=0.0;
		totalSentencesA=0.0;
		totalWordsA=0.0;
		charsA=new HashMap<Character,Double>();
		wordsA=new HashMap<String,Double>();
		numberCountA=0;
	}
	
	
	void trainA(List<String> list){
		
		for(String text : list){
			totalTextA++;
			String [] sentences=text.split("[.?!]");
			totalSentencesA+=sentences.length;
			for(String sentenc :sentences){
				String [] words=sentenc.split("[ \t ]");
				totalWordsA+=words.length;
				for(String word :words){
					String temp =word.replaceAll("[^A-Za-z0-9]", "");
					if(!temp.equals("")){
						if(temp.matches("[0-9]+")){
							numberCountA++;
						}
						else{
							if(wordsA.get(temp)==null)wordsA.put(temp, 0.0);		
							wordsA.put(temp, wordsA.get(temp)+1);
						}		
					}
				}
			}
			String satzZeichen=text.replaceAll("[A-Za-z0-9\u00C0-\u00FF  ]", "");
			for(char c:satzZeichen.toCharArray()){
				if(charsA.get(c)==null)charsA.put(c, 0.0);		
				charsA.put(c, charsA.get(c)+1);
			}
			
		}
		System.out.println(wordsA.size());
		System.out.println(numberCountA);
		System.out.println(charsA);
	}
}
