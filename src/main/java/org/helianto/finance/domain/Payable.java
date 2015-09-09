package org.helianto.finance.domain;

import javax.persistence.DiscriminatorValue;

import org.helianto.core.domain.Entity;

/**
 * Payables.
 * 
 * @author mauriciofernandesdecastro
 */
@javax.persistence.Entity
@DiscriminatorValue("P")
public class Payable extends AbstractFinance {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor.
	 */
	public Payable() {
		super();
	}

	/**
	 * Key constructor.
	 * 
	 * @param entity
	 * @param internalNumber
	 */
    public Payable(Entity entity, long internalNumber) {
		this();
		setEntity(entity);
		setInternalNumber(internalNumber);
	}
    
    public int getStartNumber() {
    	return 1;
    }

	public String getInternalNumberKey() {
		return "PAYABLE";
	}

}
