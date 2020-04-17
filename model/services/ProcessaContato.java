package model.services;

import model.entities.Contrato;

public class ProcessaContato {
	private int quantidadeParcelas;
	private Contrato contrato;
	private ServicoDePagamento servicoDePagamento;
	
	public ProcessaContato() {
		
	}

	public ProcessaContato(int quantidadeParcelas, Contrato contrato, ServicoDePagamento servicoDePagamento) {
		super();
		this.quantidadeParcelas = quantidadeParcelas;
		this.contrato = contrato;
		this.servicoDePagamento = servicoDePagamento;
	}

	public int getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(int quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}
	
	public void calculaParcelas() {
		servicoDePagamento.calculaValorParcelas(contrato, quantidadeParcelas);
	}
	
	public Contrato getContrato() {
		return contrato;
	}
}
