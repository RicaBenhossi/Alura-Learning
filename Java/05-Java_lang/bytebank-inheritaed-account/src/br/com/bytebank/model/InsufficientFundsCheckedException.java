package br.com.bytebank.model;

@SuppressWarnings("serial")
public class InsufficientFundsCheckedException extends Exception{

	public InsufficientFundsCheckedException(String message) {
		super(message);
	}
}
