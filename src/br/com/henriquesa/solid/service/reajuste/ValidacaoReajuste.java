package br.com.henriquesa.solid.service.reajuste;

import java.math.BigDecimal;

import br.com.henriquesa.solid.model.Funcionario;

public interface ValidacaoReajuste {

	void validar(Funcionario funcionario, BigDecimal aumento);
}
