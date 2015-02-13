package Sternimperienberater;

public class Planetenrechner {

	private double metallfaktor;
	private int metallBasis = 30;

	private double kristallfaktor;
	private int kristallBasis = 15;
	private double treibstofffaktor;
	private int treibstoffBasis = 10;
	private double antimateriefaktor;
	private double antimatBasis = 1.5;

	private void faktorAnpassen(byte planettyp) {

		switch (planettyp) {

		case 0: // Gesteinwelt

			metallfaktor = 1.2;
			kristallfaktor = 1;
			treibstofffaktor = 1;
			antimateriefaktor = 1;

			break;
		case 1: // Gasplanet
			
			metallfaktor = 0.6;
			kristallfaktor = 1;
			treibstofffaktor = 2;
			antimateriefaktor = 1.25;
			
			break;
		case 2: // Eiswelt
			
			metallfaktor = 0.8;
			kristallfaktor = 2;
			treibstofffaktor = 0.75;
			antimateriefaktor = 1.6;
			
			break;
		case 3: // Metallwelt
			
			metallfaktor = 3;
			kristallfaktor = 2.5;
			treibstofffaktor = 0.1;
			antimateriefaktor = 0.4;
			
			break;
		default:
			System.out.println("Something went wrong");
			break;

		}}

//Wenn rafinationszentrum stufe Null BITTE Trotzdem als 0 uebergeben
		public double[] prodStunde(int[] stufenRaffs){
			
			if(stufenRaffs.length != 6){
				
			}
			/*
			 * Verdopplung von 1 auf 2
			 * 2 auf 4
			 * 4 bis 6
			 * ab hier alle 4 Stufen verdopplung
			 * IMMER 0,99^stufe
			 * alle 50 stufen *0,98^i++ 
			 * 
			 */
			int stufeMetall = stufenRaffs[0];
			int stufeKristall = stufenRaffs[1];
			int stufeTreibstoff = stufenRaffs[2];
			int stufeTeilchen = stufenRaffs[3];
			int forschungAnti = stufenRaffs[4];
			int stufeRaffi = stufenRaffs[5];
			
			
			double prodMet =  produktionsrechner(metallBasis, stufeMetall,stufeRaffi) * metallfaktor;
			double prodKris =  produktionsrechner(kristallBasis, stufeKristall,stufeRaffi) * kristallfaktor;
			double prodTreib = produktionsrechner(treibstoffBasis, stufeTreibstoff,stufeRaffi) * treibstofffaktor;
			double prodAnti = produktionsrechner(antimatBasis, stufeTeilchen,stufeRaffi,forschungAnti) * antimateriefaktor;
			
			
			return new double[] {prodMet, prodKris, prodTreib, prodAnti};
		}
		
		
		
		
	
	
	private int produktionsrechner(double basis, int ausbaustufe, int stufeRaf){
		return produktionsrechner(basis, ausbaustufe, stufeRaf,0);
	}
	
	
	
	private int produktionsrechner(double basis, int ausbaustufe, int stufeRaf, int antiMatF){
		int tempAusbau = ausbaustufe;
		int j = 0;
		double rafD = 1+stufeRaf/100;
		double anti = Math.pow(1.2, antiMatF);
		
		if(ausbaustufe >= 50 ){
			
			while(tempAusbau % 50 != 0){
				tempAusbau--;
				
				
			}
			j = tempAusbau/50;
			
		}
		
		return (int) (verdopplungsAlgo(basis, ausbaustufe)*anti*(1+rafD)*Math.pow(0.99, ausbaustufe) * Math.pow(0.98, j));
				
				
	}

	private double verdopplungsAlgo(double basis, int ausbaustufe) {

		switch (ausbaustufe) {
		case 0:
			return 0;
			
		case 1:
			return basis;
			
		case 2:

			return verdopplungsAlgo(2*basis, ausbaustufe-1);
		case 3:
			
			return 90;
			
		case 4:

			return verdopplungsAlgo(2*basis, ausbaustufe-2);
		case 5:
			
			return 180;
			
		case 6:
			return verdopplungsAlgo(2*basis, ausbaustufe-2);
			

		default:
			if(checkBasis(ausbaustufe)){
			return verdopplungsAlgo(2*basis, ausbaustufe-4);}else{
				int groundAusbaustufe = ausbaustufe;
				int counter = 0;
				while(!checkBasis(groundAusbaustufe)){
					groundAusbaustufe--;
					counter++;
					
				}
				double tempWert = verdopplungsAlgo(basis, groundAusbaustufe);
			    tempWert = tempWert + tempWert/4 *counter;
				return tempWert;
				
			}
			
		}

	}
	
	private boolean checkBasis(long ausbaustufe){
		
		if(ausbaustufe <= 0){
			return false;
		}else if(ausbaustufe == 6){
			return true;
		}else{
			return checkBasis(ausbaustufe-4);
		}
		
	}

}
