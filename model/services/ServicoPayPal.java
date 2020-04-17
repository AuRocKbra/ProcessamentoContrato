package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.entities.Contrato;
import model.entities.Parcelas;

public class ServicoPayPal implements ServicoDePagamento{

	@Override
	public void calculaValorParcelas(Contrato contrato, int quantidadeDeParcelas){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Parcelas> parcelas = new ArrayList<>();
		for (int i =0; i<quantidadeDeParcelas;i++) {
			Parcelas parcela = new Parcelas();
			Calendar cal = Calendar.getInstance();
			cal.setTime(contrato.getDataDoContrato());
			cal.add(Calendar.MONTH,+(i+1));
			try {
				parcela.setDataVencimento(sdf.parse(sdf.format(cal.getTime())));
				parcela.setValorParcela((contrato.getValorDoContrato()/quantidadeDeParcelas)+((contrato.getValorDoContrato()/quantidadeDeParcelas)*0.01*(i+1)));
				parcela.setValorParcela(parcela.getValorParcela()+(parcela.getValorParcela()*0.02));
				parcelas.add(parcela);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		contrato.setParcelas(parcelas);
	}

}
