package com.shop.bill;

import com.shop.pm.PriceMatrix;

/*
 *  design & performance issues
 *  -----------------------------
 *  
 *    -> tight-coupling b/w dependent & dependency obj's impln
 *        ==> can't extend Extend/Maintenance
 *    -> too many duplicate dependecy instances created & destroyed..
 *        ==> slow,memory/resources use high
 *    -> Unit-Testing Not Possible
 *        ==> dev/bug-fix slow
 *     
 *        ------------------------------------------
 *        
 *        why these issues are occuring ?
 *        
 *        ==> dependent-obj itself creating its own dependency-obj
 *        
 *        soln:
 *        
 *        ==> don't create dependency in dependent's class, do Lookup
 *        
 *        Limitation on Lookup:
 *        
 *        ==> Location tight-coupling
 *        
 *        best-soln:
 *        
 *        ==> don't create/lookup , inject thru 'some-one' ( IOC )
 *        
 *            how to implement IOC ?
 *            
 *            --> thru 'Dependency Injection" ( DI )
 *            
 *                  how to inject dependency ?
 *                  
 *                   ==> constructor DI
 *                   ==> setter DI
 *                   
 *          ------------------------------------------------
 *          
 *                   
 *           S — Single responsibility principle
 *           O — Open for extension & closed for modification principle
 *           L — Liskov substitution principle
 *           I — Interface segregation principle
 *           D — Dependency Inversion principle
 *                   
 *        
 *        
 * 
 */

public class BillingImpl implements Billing {
	
	private PriceMatrix priceMatrix;
	
	public BillingImpl(PriceMatrix priceMatrix) {
		this.priceMatrix=priceMatrix;
	}
	

	/* (non-Javadoc)
	 * @see com.shop.bill.Billing#getTotalPrice(java.lang.String[])
	 */
	@Override
	public double getTotalPrice(String[] cart) {
		double total = 0.0;
		for (String item : cart) {
			total += priceMatrix.getPrice(item);
		}
		return total;
	}

}
