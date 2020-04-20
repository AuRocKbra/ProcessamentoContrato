package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.entities.Contrato;
import model.entities.Parcelas;

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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Parcelas> parcelas = new ArrayList<>();
		Double quotaBasica = contrato.getValorDoContrato()/quantidadeParcelas;
		for (int i =0; i<quantidadeParcelas;i++) {
			Parcelas parcela = new Parcelas();
			Calendar cal = Calendar.getInstance();
			cal.setTime(contrato.getDataDoContrato());
			cal.add(Calendar.MONTH,+(i+1));
			try {
				parcela.setDataVencimento(sdf.parse(sdf.format(cal.getTime())));
				parcela.setValorParcela(servicoDePagamento.calculaValorParcelas(quotaBasica, i+1));
				parcelas.add(parcela);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		contrato.setParcelas(parcelas);		
	}
	
	public Contrato getContrato() {
		return contrato;
	}
}
