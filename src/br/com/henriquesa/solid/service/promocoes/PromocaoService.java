package br.com.henriquesa.solid.service.promocoes;

import br.com.henriquesa.solid.ValidacaoException;
import br.com.henriquesa.solid.model.Cargo;
import br.com.henriquesa.solid.model.Funcionario;

public class PromocaoService {

	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();
		if(Cargo.GERENTE.equals(cargoAtual)) {
			throw new ValidacaoException("Gerentes nao podem ser promovidos");
		}
		
		if(metaBatida) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.promover(novoCargo);
		} else {
			throw new ValidacaoException("Funcionario não bateu a meta!");
		}
	}
}
