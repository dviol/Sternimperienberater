package Sternimperienberater;

import javax.swing.JOptionPane;


public class NuetzlicheMethoden {
	
	public static void fehlerMeldungAusgeben(String fehlermeldung){
		
		if(fehlermeldung.length() == 0){
			fehlerMeldungAusgeben("Du hast keinen konkreten Fehler angegeben.");
		}else{
			String fehler = "Error: " + fehlermeldung;
			System.out.println(fehler);
			JOptionPane.showMessageDialog(null, fehler);
		}
		
		
	}

	
	
	
	public static String leerzeichenUndTabsVernichter(String s){
		String tempS = s;
		boolean watchOut = false;
		boolean firstTimeIn = false;
		int counter = 0;
		
		for (int i = 0; i < tempS.length(); i++) {
		//Vernichtet die Leerzeichen / Tabs vor dem String	
			if(!(String.valueOf(s.charAt(i)).equals(" ") || String.valueOf(s.charAt(i)).equals("\t"))){
				tempS = s.substring(i);
				break;
						
			}
			// Wenn nur aus leerzeichen/ tabs besteht...
			else if(i == s.length() - 1){
				tempS = "";
			}
			
			
		}
		
		//Vernichtet die Leerzeiche/ Tabs NACH dem String
		for (int i = 0; i < tempS.length(); i++) {
			
			if(String.valueOf(tempS.charAt(i)).equals(" ") || String.valueOf(s.charAt(i)).equals("\t")){
				watchOut = true;
				if(firstTimeIn){
					firstTimeIn = false;
					counter = i;
				}
				
			}else{
				watchOut = false;
				firstTimeIn = true;
			}
			
			if(watchOut && i == tempS.length()-1){
				
				tempS = tempS.substring(0,counter);
				
			}
			
		}
		return tempS;
	}
}
