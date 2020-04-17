package model.entities;

import java.util.Date;

public class Parcelas {
	private Date dataVencimento;
	private Double valorParcela;
	
	public Parcelas() {
		
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
}
