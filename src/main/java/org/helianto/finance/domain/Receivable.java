package org.helianto.finance.domain;

import javax.persistence.DiscriminatorValue;

import org.helianto.core.domain.Entity;
import org.helianto.partner.domain.PrivateEntity;

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
    
    /**
     * Constructor.
     * 
     * @param entity
     * @param privateEntity
     * @param internalNumber
     */
    public Receivable(Entity entity, PrivateEntity privateEntity, long internalNumber) {
		this(entity,internalNumber);
		setPrivateEntity(privateEntity);
	}

    public String getInternalNumberKey() {
    	return "RECEIVABLE";
    }

    public int getStartNumber() {
    	return 1;
    }

}
