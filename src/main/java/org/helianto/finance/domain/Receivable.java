package org.helianto.finance.domain;

import javax.persistence.DiscriminatorValue;

import org.helianto.core.domain.Entity;

/**
 * Receivables.
 * 
 * @author mauriciofernandesdecastro
 */
@javax.persistence.Entity
@DiscriminatorValue("R")
public class Receivable extends AbstractFinance {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor.
	 */
	public Receivable() {
		super();
	}

	/**
	 * Key constructor.
	 * 
	 * @param entity
	 * @param internalNumber
	 */
    public Receivable(Entity entity, long internalNumber) {
		this();
		setEntity(entity);
		setInternalNumber(internalNumber);
	}

    public String getInternalNumberKey() {
    	return "RECEIVABLE";
    }

    public int getStartNumber() {
    	return 1;
    }

}
