package Sternimperienberater;

import java.util.LinkedList;

public class Parser {

	public boolean interessanterTeil = false;
	public boolean ende = false;

	public void parse(String s) {

		String[] tokenized = s.split(" ");

		for (int i = 0; i < tokenized.length; i++) {
			if (tokenized[i] != null) {
				checkSpiobericht(tokenized[i]);
			}
			
			if(ende){
				tokenized[i] = "#";
			}

			if (!interessanterTeil) {

				tokenized = deleteArrayElement(tokenized, i);
				i--;

			}

		}

		for (int i = 0; i < tokenized.length; i++) {

			if (tokenized[i] != null) {
				
				tokenized[i] = NuetzlicheMethoden.leerzeichenUndTabsVernichter(tokenized[i]);

			}

			if (tokenized[i] == null || tokenized[i].equals("")
					|| tokenized[i].equals(" ") || tokenized.equals("\t")) {
				tokenized = deleteArrayElement(tokenized, i);
				i--;
			}

		}

		for (int i = 0; i < tokenized.length; i++) {
			System.out.println(tokenized[i]);
		}

	}

	public void parse() {

	}

	public String[] deleteArrayElement(String[] array, int i) {

		String[] newArray = new String[array.length - 1];

		for (int j = 0; j < newArray.length; j++) {

			if (j >= i) {
				array[j] = array[j + 1];

			}

			newArray[j] = array[j];
		}

		return newArray;

	}

	// public String[] deleteArrayElements(String[] array, LinkedList<Integer>
	// i) {
	// String[] tempArray = array;
	// LinkedList<LinkedList<Integer>> pairedInteger = new
	// LinkedList<LinkedList<Integer>>();
	// int tempInt = i.get(0);
	// LinkedList<Integer> tempLinked = new LinkedList<Integer>();
	// tempLinked.add(tempInt);
	// String[] tempStrings = new String[0];
	// int inter;
	//
	// for (int j = 1; j < i.size(); j++) {
	//
	// if (++tempInt == i.get(j)) {
	// tempLinked.add(i.get(j));
	//
	// } else {
	// pairedInteger.add(tempLinked);
	// tempLinked = new LinkedList<Integer>();
	// tempInt = i.get(j);
	//
	// }
	//
	// }
	//
	// for (int j = 0; j < pairedInteger.size(); j++) {
	//
	// tempLinked = pairedInteger.get(j);
	// tempInt = tempLinked.get(tempLinked.size() - 1);
	// inter = tempInt;
	// tempStrings = new String[array.length - tempInt];
	// tempInt++;
	// int counter = 0;
	//
	// for (int j2 = 0; j2 < tempLinked.size(); j2++) {
	// if(j2 + tempInt < tempLinked.size()){
	// array[j2] = array[j2 + tempInt];
	// counter++;
	// } else{
	//
	// break;
	// }
	// }
	// //TODO Ab hier folgendes Problem: Wenn k+ inter out of bounds muss das
	// normale nachrücken passieren
	// for (int k = tempInt; k < tempArray.length; k++) {
	// array[k] = array[k + inter];
	//
	// }
	//
	// for (int j2 = 0; j2 < tempArray.length - 1; j2++) {
	//
	// if (inter + tempInt <= j2) {
	// tempArray[j2 + 1] = tempArray[j2 + 1];
	// }
	// tempStrings[j2] = tempArray[j2];
	// }
	//
	// }
	// return tempStrings;
	// }

	public void checkSpiobericht(String s) {

		String[] tokenized = s.split(" ");
		if (tokenized[0].equals("Zielplanet:")) {

			interessanterTeil = true;
			ende = false;

		}

		if (tokenized[0].equals("[Nachricht")) {
			
			ende = true;
			
		}
		
		if(tokenized[0].equals("löschen]")){
			interessanterTeil = false;

		}

	}
	
	public void /*LinkedList<LinkedList<String>>*/ weitereAufbereitung(String[] input){
		LinkedList<LinkedList<String>> ausgabeListe = new LinkedList<LinkedList<String>>();
		LinkedList<String> tempString = new LinkedList<String>();
		
		for (int i = 0; i < input.length; i++) {
			String s = input[i];
			
		
			if(s.equals("Zielplanet:")){
				tempString.add("PLANETNAME");
				tempString.add(input[i+1]);
				tempString.add("KOORDINATEN");
				tempString.add(input[i+2]);
			}else if(s.equals("Spieler")){
				tempString.add("SPIELERNAME");
				tempString.add(input[i+1]);
				
			}else if(s.equals("Ressourcen")){
				tempString.add("METALL");
				tempString.add(input[i+2]);
				tempString.add("KRISTALL");
				tempString.add(input[i+4]);
				tempString.add("TREIBSTOFF");
				tempString.add(input[i+6]);
				tempString.add("ANTIMATERIE");
				tempString.add(input[i+8]);
	
				
			}
			
			
		}
		
		
	}

}
