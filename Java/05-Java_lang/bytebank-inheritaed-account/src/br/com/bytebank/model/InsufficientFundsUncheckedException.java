package br.com.bytebank.model;

@SuppressWarnings("serial")
public class InsufficientFundsUncheckedException extends RuntimeException{

	public InsufficientFundsUncheckedException(String message) {
		super(message);
	}
}
