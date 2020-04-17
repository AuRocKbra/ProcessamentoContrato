package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	private int numero;
	private Date dataDoContrato;
	private Double valorDoContrato;
	private List <Parcelas> parcelas;
	
	public Contrato() {
		
	}

	public Contrato(int numero, Date dataDoContrato, Double valorDoContrato) {
		this.numero = numero;
		this.dataDoContrato = dataDoContrato;
		this.valorDoContrato = valorDoContrato;
		this.parcelas = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public Date getDataDoContrato() {
		return dataDoContrato;
	}

	public Double getValorDoContrato() {
		return valorDoContrato;
	}
	
	public List <Parcelas> getParcelas() {
		return parcelas;
	}
	
	public void setParcelas(List<Parcelas>parcelas) {
		this.parcelas = parcelas;
	} 
}
