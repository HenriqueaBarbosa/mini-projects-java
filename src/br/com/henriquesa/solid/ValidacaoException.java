package br.com.henriquesa.solid;

public class ValidacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValidacaoException(String mensagem) {
		super(mensagem);
	}
}
