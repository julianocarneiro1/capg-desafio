package calcview;

import java.util.Scanner;

public class calculadora {

	public static void main(String[] args) {

		double invest;
		double alcanceSoma;
		double alcanceInicial;
		Double alcanceTotal;
		double cliques;
		double compart;
		int max = 0;

		Scanner sc = new Scanner(System.in);

		System.out.printf("Digite o valor investido (R$): ");
		invest = sc.nextInt();
		sc.close();

		if (invest >= 1) {

			alcanceInicial = invest * 30;
			alcanceTotal = alcanceInicial;
			alcanceSoma = alcanceInicial;

			do {

				cliques = (alcanceSoma / 100) * 12;

				compart = (cliques / 20) * 3;

				alcanceSoma = (compart * 40);

				if (compart >= 1){
					alcanceTotal += alcanceSoma;	
				} else {
					max = 3;
				}

				max++;

			} while (max < 3);

			System.out.println("O anúncio pode alcançar até " + alcanceTotal.intValue() + " pessoas.");

		} else {
			System.out.println("Saldo insuficiente.");
		}

	}

}
