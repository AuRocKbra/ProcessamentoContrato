package model.services;

public class ServicoPayPal implements ServicoDePagamento{
	
	private final static Double TAXADEJUROS=0.01;
	private final static Double TAXADESERVICO= 0.02;

	@Override
	public Double calculaValorParcelas(Double quotaBasica,int parcela){
		Double quotaDoMes = quotaBasica + (quotaBasica * TAXADEJUROS * parcela);
		quotaDoMes += quotaDoMes * TAXADESERVICO;
		return quotaDoMes;
	}
}
