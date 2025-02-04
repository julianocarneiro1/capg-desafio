package parte2;

import java.text.ParseException;
import java.util.Scanner;
import parte2.entities.Anuncio;

public class Principal {

	public static void main(String[] args) throws ParseException {

		int i = 1;
		Integer o;
		int op;
		Anuncio[] a = new Anuncio[10];

		//menu do programa
		do {

			op = 0;

			System.out.println("-------------- MENU --------------");
			System.out.println("Digite o n�mero da op��o desejada:");
			System.out.println("1 - Cadastrar an�ncio");
			System.out.println("2 - Obter relat�rio");
			System.out.println("3 - Encerrar programa");
			System.out.println("----------------------------------");

			Scanner sc = new Scanner(System.in);
			op = sc.nextInt();

			if (op < 1 || op > 3) {
				System.out.println("Op��o inv�lida. Por favor, digite o n�mero correspondente � opera��o desejada.");
			}

			switch (op) {
			
			//cadastro de an�ncios
			case 1:

				do {

					sc.nextLine();

					a[i] = new Anuncio();
					a[i].setId(i);

					System.out.println("Digite as informa��es para cadastrar um novo an�ncio.");
					System.out.printf("Nome do an�ncio: ");
					a[i].setNome(sc.nextLine());
					System.out.printf("Nome do cliente: ");
					a[i].setCliente(sc.nextLine());
					System.out.printf("Data de in�cio (dd/MM/yyyy): ");
					a[i].setDataInicio(sc.next());
					System.out.printf("Data de t�rmino (dd/MM/yyyy): ");
					a[i].setDataTermino(sc.next());
					System.out.printf("Investimento di�rio (R$): ");
					a[i].setInvestDia(sc.nextDouble());

					System.out.println("----------------------------------");
					System.out.println("An�ncio cadastrado com sucesso!");
					i++;

					do {

						System.out.println("----------------------------------");
						System.out.println("1 - Cadastrar novo an�ncio");
						System.out.println("2 - Retornar");
						op = sc.nextInt();

						if (op == 1) {
							break;
						}

						if (op != 1 && op != 2) {
							System.out.println(
									"Op��o inv�lida. Por favor, digite o n�mero correspondente � opera��o desejada.");
						}

					} while (op == 1);

				} while (op == 1);

				break;

			//consulta de an�ncios
			case 2:

				if (a[1] == null) {

					System.out.println("N�o h� an�ncios cadastrados.");

				} else {

					System.out.println("An�ncios cadastrados:");

					for (int p = 1; p <= (i - 1); p++) {
						System.out.println("Id: " + a[p].getId() + " | Nome: " + a[p].getNome());
					}

					System.out.println("----------------------------------");
					System.out.printf("Digite o id do an�ncio para obter o relat�rio: ");
					o = sc.nextInt();

					if (o != 0 && o < i) {

						System.out.println("----------------------------------");
						System.out.println("Consultando an�ncio " + a[o].getNome());
						System.out.println("----------------------------------");
						System.out.println("Nome do an�ncio: " + a[o].getNome());
						System.out.println("Nome do cliente: " + a[o].getCliente());
						System.out.println("Data de in�cio (dd/MM/yyyy): " + a[o].getDataInicio());
						System.out.println("Data de t�rmino (dd/MM/yyyy): " + a[o].getDataTermino());
						System.out.println("Investimento di�rio: R$" + Math.round(a[o].getInvestDia()));
						System.out.printf("Valor total investido: R$" + Math.round(a[o].valorTotal()) + "\n");
						a[o].qtdMax();

						op = 1;						

						do {							
							if (op != 0) {
								System.out.println("----------------------------------");
								System.out.println("Para retornar, digite 0: ");
								op = sc.nextInt();
							}							
						} while (op != 0);

						break;

					} else {

						System.out.println("Por favor, digite um id v�lido. ");

					}

				}

				break;

			//encerramento do programa
			case 3:

				sc.close();
				break;

			}

		} while (op != 3);

		System.out.println("Encerrado.");

	}

}
