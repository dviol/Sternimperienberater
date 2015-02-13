package Sternimperienberater;

import javax.swing.JOptionPane;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Parser s = new Parser();
		
	s.parse(JOptionPane.showInputDialog("Do it")); 
 
		
//		Planetenrechner p = new Planetenrechner();
//		for (int i = 0; i <= 14; i++) {
//			System.out.println("Level: "+ i + "Prod/Stunde: " +p.verdopplungsAlgo(30, i));
//
//		}
//		System.out.println(p.verdopplungsAlgo(30, 0));

}
}