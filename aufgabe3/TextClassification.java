package aufgabe3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class TextClassification {
	private int totalTextA,totalTextB;
	private int [] totalSentencesA,totalSentencesB;
	private Double [] sentenceLengtsA,sentenceLengtsB;
	private int []totalWordsA,totalWordsB;
	private HashMap<String, List<Double>> wordsA;
	private HashMap<String,List<Double>> wordsB;
	private HashMap<Character, List<Double>> charsA;
	private HashMap<Character,List<Double>> charsB;
	private int numberCountA,numberCountB;
	private List<Criterion> krits;
	
	/**
	 * Analyse der Texte auf Wort/Zeichen Häufigkeiten und durchschnitt Statzlängen. Fuer die Kategorie A.
	 * @param list Liste mit den zu trainieren Texten.
	 */
	void trainA(List<String> list){
		totalTextA=0;
		totalSentencesA=new int[list.size()];
		totalWordsA=new int[list.size()];
		sentenceLengtsA=new Double[list.size()];
		charsA=new HashMap<Character,List<Double>>();
		wordsA=new HashMap<String,List<Double>>();
		for(int i=0;i<list.size();i++){
			sentenceLengtsA[i]=0.0;
			totalSentencesA[i]=0;
			totalWordsA[i]=0;
		}
		numberCountA=0;
		for(String text : list){
			String [] sentences=text.split("[.?!]");
			totalSentencesA[totalTextA]+=sentences.length;
			for(String sentenc :sentences){
				sentenceLengtsA[totalTextA]+=sentenc.length();
				String [] words=sentenc.split("\\s");
				totalWordsA[totalTextA]+=words.length;
				for(String word :words){
					String temp =word.replaceAll("[^A-Za-z0-9]", "");
					if(!temp.equals("")){
						if(temp.matches("[0-9]+")){
							numberCountA++;
						}
						else{
							temp=temp.toLowerCase();
							if(wordsA.get(temp)==null){
								List<Double> listTemp = new LinkedList<Double>();	
								for(int i=0;i<list.size();i++) listTemp.add(0.0);
								wordsA.put(temp, listTemp);
							}
							wordsA.get(temp).add(totalTextA, wordsA.get(temp).get(totalTextA)+1.0/words.length);
							wordsA.get(temp).remove(totalTextA+1);
						}		
					}
				}
			}
			sentenceLengtsA[totalTextA]=sentenceLengtsA[totalTextA]/sentences.length;
			String satzZeichen=text.replaceAll("[A-Za-z0-9\u00C0-\u00FF  ]", "");
			for(char c:satzZeichen.toCharArray()){
				if(charsA.get(c)==null){
					List<Double> listTemp = new LinkedList<Double>();	
					for(int i=0;i<list.size();i++) listTemp.add(0.0);
					charsA.put(c, listTemp);
				}
				charsA.get(c).add(totalTextA, charsA.get(c).get(totalTextA)+1.0/satzZeichen.length());
				charsA.get(c).remove(totalTextA+1);
			}
			totalTextA++;
		}
	}
	
	/**
	 * Analyse der Texte auf Wort/Zeichen Häufigkeiten und durchschnitt Statzlängen. Fuer die Kategorie B.
	 * @param list Liste mit den zu trainieren Texten.
	 */
	void trainB(List<String> list){
		totalTextB=0;
		totalSentencesB=new int[list.size()];
		totalWordsB=new int[list.size()];
		sentenceLengtsB=new Double[list.size()];
		charsB=new HashMap<Character,List<Double>>();
		wordsB=new HashMap<String,List<Double>>();
		for(int i=0;i<list.size();i++){
			sentenceLengtsB[i]=0.0;
			totalSentencesB[i]=0;
			totalWordsB[i]=0;
		}
		numberCountB=0;
		for(String text : list){
			String [] sentences=text.split("[.?!]");
			totalSentencesB[totalTextB]+=sentences.length;
			for(String sentenc :sentences){
				sentenceLengtsB[totalTextB]+=sentenc.length();
				String [] words=sentenc.split("\\s");
				totalWordsB[totalTextB]+=words.length;
				for(String word :words){
					String temp =word.replaceAll("[^A-Za-z0-9]", "");
					if(!temp.equals("")){
						if(temp.matches("[0-9]+")){
							numberCountB++;
						}
						else{
							temp=temp.toLowerCase();
							if(wordsB.get(temp)==null){
								List<Double> listTemp = new LinkedList<Double>();	
								for(int i=0;i<list.size();i++) listTemp.add(0.0);
								wordsB.put(temp, listTemp);
							}
							wordsB.get(temp).add(totalTextB, wordsB.get(temp).get(totalTextB)+1);
							wordsB.get(temp).remove(totalTextB+1);
						}		
					}
				}
			}
			sentenceLengtsB[totalTextB]=sentenceLengtsB[totalTextB]/sentences.length;
			String satzZeichen=text.replaceAll("[A-Za-z0-9\u00C0-\u00FF  ]", "");
			for(char c:satzZeichen.toCharArray()){
				if(charsB.get(c)==null){
					List<Double> listTemp = new LinkedList<Double>();	
					for(int i=0;i<list.size();i++) listTemp.add(0.0);
					charsB.put(c, listTemp);
				}
				charsB.get(c).add(totalTextB, charsB.get(c).get(totalTextB)+1.0/satzZeichen.length());
				charsB.get(c).remove(totalTextB+1);
			}			
			totalTextB++;
		}
	}

	/**
	 *  Erstellt die Kriterien. Zu vor muss aber trainA() und trainB() aufgerufen werden.
	 * @param arg 
	 * 	Text der zur ueberpruefenden Merkmale: 
	 *  fuer durchschnitts Satzlänge \\s.length, 
	 *  fuer ein Wort \\word <?>,
	 *  fuer ein Zeichen \\char <?>.
	 * 	Mehere Merkmale werden mit , getrent.
	 *  Beispiel:"\\s.length  ,\\char ?,\\char ,,\\char :"
	 */
	void creatCriteria(String arg){
		krits=new ArrayList<Criterion>();
		for(String temp:arg.split(",")){	
			switch ( temp.split(" ")[0] ){
			case "\\s.length": krits.add(new Criterion("\\s.length","",sentenceLengtsA,sentenceLengtsB));continue;
			case "\\word" :krits.add(new Criterion("\\word",temp.split(" ")[1],listToDoubleArray(charsA.get(temp.split(" ")[1])),listToDoubleArray(charsB.get(temp.split(" ")[1]))));continue;	
			case "\\char" :krits.add(new Criterion("\\char",temp.split(" ")[1],listToDoubleArray(charsA.get(temp.split(" ")[1].charAt(0))),listToDoubleArray(charsB.get(temp.split(" ")[1].charAt(0)))));continue;
			}
			
		}
		
	}
	
	/**
	 * Wandelt eine Liste Mit Double werten in ein Double Array um.
	 * @param list Mit Double werten
	 * @return Double Array
	 */
	private  Double[] listToDoubleArray(List<Double> list){
		 Double[] out =new Double[list.size()];
		 for(int i =0;i<list.size();i++){
			 out[i]=list.get(i);
			
		 }
		
		
		 return out;
		
	}
	
	/**
	 * Ueberprueft den Text anhand der geweahlten Kriterien. 
	 * @param test Zu testender Text.
	 * @return 0 wenn der Text zu Kategorie A gehört und 1 wenn er zu B gehört.
	 */
	int test(String test){
		Double sentenceLengts=0.0;
		int numberCount=0;
		Map <Character,Double>charsM =new HashMap<Character,Double>();
		Map <String,Double>wordsM=new HashMap<String,Double>();
		String [] sentences=test.split("[.?!]");
		for(String sentenc :sentences){
			sentenceLengts+=sentenc.length();
			String [] words=sentenc.split("\\s");
			for(String word :words){
				String temp =word.replaceAll("[^A-Za-z0-9]", "");
				if(!temp.equals("")){
					if(temp.matches("[0-9]+")){
						numberCount++;
					}
					else{
						temp=temp.toLowerCase();
						if(wordsM.get(temp)==null)wordsM.put(temp, 0.0);		
						wordsM.put(temp, wordsM.get(temp)+1.0/words.length);
					}		
				}
			}
		}
		sentenceLengts=sentenceLengts/sentences.length;
		String satzZeichen=test.replaceAll("[A-Za-z0-9\u00C0-\u00FF  ]", "");
		for(char c:satzZeichen.toCharArray()){
			if(charsM.get(c)==null)charsM.put(c,0.0);		
			charsM.put(c, charsM.get(c)+1.0/satzZeichen.length());
		}
		double a=-1.0;
		double b=-1.0;
		for(Criterion krit:krits){
			Double[] temp;
			switch ( krit.typ ) {
				case "\\s.length"  : {
					temp=krit.test((double) sentenceLengts);
					if(a==-1.0)a=temp[0];
					else a*=temp[0];
					if(b==-1.0)b=temp[1];
					else b*=temp[1];
					continue;
				}
				case "\\word" :{
					temp=krit.test(wordsM.get(krit.item));
					if(a==-1.0)a=temp[0];
					else a*=temp[0];
					if(b==-1.0)b=temp[1];
					else b*=temp[1];continue;
				}
				case "\\char" :{
					temp=krit.test(charsM.get(krit.item.charAt(0)));
					if(a==-1.0)a=temp[0];
					else a*=temp[0];
					if(b==-1.0)b=temp[1];
					else b*=temp[1];
					continue;
				}
			}
		}
		double isA=a/(a+b);
		double isB=b/(a+b);	
		if(isA>=isB){
			return 0;
		}
		else{
			return 1;
		}	
	}	
}
