package parte2.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Anuncio {
	
	private int id;
	private String nome;
	private String cliente;
	private Date dataInicio;
	private Date dataTermino;
	private Double investDia;

	public Anuncio() {
	}

	public Anuncio(String nome, String cliente, Date dataInicio, Date dataTermino, double investDia, int id) {
		this.id = id;
		this.nome = nome;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.investDia = investDia;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDataInicio() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		String di = formato.format(dataInicio);
		return di;
	}

	public void setDataInicio(String dataInicio) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date d = formato.parse(dataInicio);
		this.dataInicio = d;
	}

	public String getDataTermino() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		String dt = formato.format(dataTermino);
		return dt;
	}

	public void setDataTermino(String dataTermino) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date d = formato.parse(dataTermino);
		this.dataTermino = d;
	}

	public Double getInvestDia() {
		return investDia;
	}

	public void setInvestDia(Double investDia) {
		this.investDia = investDia;
	}

	public Double valorTotal() {
		
		DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient(false);
        long dt = (this.dataTermino.getTime() - this.dataInicio.getTime());
        Double total = (((dt / 86400000L) * this.investDia));
        return total;
	}
	
	public void qtdMax() {
		
		double alcanceSoma;
		double alcanceInicial;
		Double alcanceTotal = 0.0;
		Double cliques = 0.0;
		Double compart = 0.0;
		int max = 0;

		if (this.investDia >= 1) {

			alcanceInicial = this.investDia * 30;
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

			System.out.println("Quantidade m�xima de visualiza��es: " + alcanceTotal.intValue());
			System.out.println("Quantidade m�xima de cliques: " + cliques.intValue());
			System.out.println("Quantidade m�xima de compartilhamentos: " + compart.intValue());

		} else {
			System.out.println("Saldo insuficiente.");
		}

	}

}
