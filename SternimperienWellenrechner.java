package Sternimperienberater;

import java.util.Scanner;

public class SternimperienWellenrechner {

	static double factor = 0.45;
	static int initialRes;
	static boolean another = false;
	

	public static void main(String[] args) {
		
		String[] negativeAnswers = {"no","n","nein","nope","negative","nada","ne"} ;
		String[] optionalAnswers = {"o","optionen","menü","menue","möglichkeiten"};
		String[] positiveAnswers = {"yes","j","y","ja","positiv","jawohl","yeah","jep"};

		if (args.length != 0) {
			factor = Double.parseDouble(args[0]);
			System.out.println("New Factor Taken!");
		}

		Scanner s = new Scanner(System.in);

		System.out.println("With antimatter? [y/n]");

		String answer = s.next().toLowerCase();

		if (checkAnswer(answer,positiveAnswers)) {

			initialRes = 3;
		} else {
			initialRes = 4;

		}

		long sum = 0;

		do {
			System.out
					.println("Please insert everything below Ressourcen entdeckt");

			another = false;
			for (int i = 0; i < initialRes; i++) {
				sum += s.nextInt();
			if(i < initialRes-1){	
				s.next();}

			}
			System.out.println("Complete Sum: " + sum);
			for (int i = 0; i < 3; i++) {
				double forTransport = sum * factor;
				long grabbin = Math.round(forTransport);
				double gTrans = forTransport / 30000;
				double klTrans = forTransport / 6000;

				System.out.println(grabbin + "  You need: " + gTrans
						+ " GTrans or " + klTrans + " klTrans");
				sum -= grabbin;

			}
//TODO Wenn Antimatter auf "n" wird Antimaterie als antwort auf diese Frage genommen, muss gefixed werden
			System.out
					.println("Another Spybericht? [y/n] or o for Antimatteroptions: ");
			answer = s.next().toLowerCase();
			
			if(answer.equals("antimaterie")){
				answer = s.next().toLowerCase();
			}

			if (checkAnswer(answer, positiveAnswers)) {
				another = true;
			} else if (checkAnswer(answer, optionalAnswers)){
				System.out.println("With antimatter? [y/n]");
				answer = s.next().toLowerCase();

				if (checkAnswer(answer, positiveAnswers)) {

					initialRes = 3;
				} else {
					initialRes = 4;

				}
				another = true;

			}

		} while (another);

		s.close();

	}
	
	
	public static boolean checkAnswer(String input, String[] reference){
		
		for (String string : reference) {
			
			if(input.equals(string)){
				return true;
			}
			
			
		}
		return false;
		
	}

}
