package model.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Parcelas;
import model.services.ProcessaContato;
import model.services.ServicoPayPal;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Dados do contrato:");
		System.out.print("Número do contrato:");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.print("Dada do contrato (DD/MM/YYYY):");
		Date data = sdf.parse(sc.nextLine());
		System.out.print("Valor do contrato R$:");
		Double valor = sc.nextDouble();
		System.out.print("Quantidade de parcelas:");
		int quantidadeParcelas = sc.nextInt();
		ProcessaContato processaContrato = new ProcessaContato(quantidadeParcelas, new Contrato(numero, data, valor),new ServicoPayPal());
		processaContrato.calculaParcelas();
		int cont=1;
		for(Parcelas parcela:processaContrato.getContrato().getParcelas()) {
			System.out.println("Parcela <"+cont+"> "+sdf.format(parcela.getDataVencimento())+" - R$ "+String.format("%.2f",parcela.getValorParcela()));
			cont++;
		}
		sc.close();
	}

}
