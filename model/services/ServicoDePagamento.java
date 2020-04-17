package model.services;

import model.entities.Contrato;

public interface ServicoDePagamento {

	void calculaValorParcelas(Contrato contrato, int quantidadeDeParcelas);
}
