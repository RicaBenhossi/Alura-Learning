package br.com.bytebank.model;

// model.TaxCalculator => FQN
public class TaxCalculator {
	
	private double taxTotal;
	
	public void register(Taxable tax) {
		double value = tax.getTaxValue();
		this.taxTotal += value;
		
	}
	
	public double getTaxTotal() {
		return taxTotal;
	}

}
