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
	private Double numberCountA,numberCountB;
	
	TextClassification(){
		totalTextA=0.0;
		totalSentencesA=0.0;
		totalWordsA=0.0;
		wordsA=new HashMap<String,Double>();
	}
	
	
	void trainA(List<String> list){
		
		for(String text : list){
			totalTextA++;
			String [] sentences=text.split(".");
			totalSentencesA+=sentences.length;
			for(String sentenc :sentences){
				String [] words=sentenc.split(" ");
				totalWordsA+=words.length;
				for(String word :words){
					if(word.matches("[0-9]")){
						
					}
					else{
						if(wordsA.get(word)==null)wordsA.put(word, 0.0);		
						wordsA.put(word, wordsA.get(word)+1);
					}		
				}
			}
			
		}
		
	}
}
