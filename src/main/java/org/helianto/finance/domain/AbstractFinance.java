package org.helianto.finance.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.helianto.core.domain.Entity;
import org.helianto.core.internal.AbstractEventControl;
import org.helianto.core.number.Sequenceable;
import org.helianto.partner.domain.PrivateEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Finance base class.
 * 
 * @author mauriciofernandesdecastro
 */
@javax.persistence.Entity
@Table(name="fin_finance",
    uniqueConstraints = {@UniqueConstraint(columnNames={"entityId", "internalNumber"})}
)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="type",
    discriminatorType=DiscriminatorType.CHAR
)
@DiscriminatorValue("F")
public abstract class AbstractFinance 
	extends AbstractEventControl 
	implements Sequenceable
{
	
	private static final long serialVersionUID = 1L;
	
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name="privateEntityId", nullable=true)
	private PrivateEntity privateEntity;
	
	@Column(length=128)
	private String summary;
	
	private BigDecimal faceValue;
	
	@Transient
	private Integer privateEntityId;
	
	/**
	 * Default constructor.
	 */
	public AbstractFinance() {
		super();
	}
	
	/**
	 * Key constructor.
	 * 
	 * @param entity
	 * @param internalNumber
	 */
	public AbstractFinance(Entity entity, long internalNumber) {
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
    public AbstractFinance(Entity entity, PrivateEntity privateEntity, long internalNumber) {
		this(entity,internalNumber);
		setPrivateEntity(privateEntity);
	}
	
	public String getEntityAlias() {
		if (getPrivateEntity()!=null) {
			return getEntityAlias();
		}
		return "";
	}
	
	/**
	 * Related private entity.
	 */
	public PrivateEntity getPrivateEntity() {
		return privateEntity;
	}
	public void setPrivateEntity(PrivateEntity privateEntity) {
		this.privateEntity = privateEntity;
	}
	
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	/**
	 * Face value.
	 */
	public BigDecimal getFaceValue() {
		return faceValue;
	}
	public void setFaceValue(BigDecimal faceValue) {
		this.faceValue = faceValue;
	}
	
	/**
	 * Transient privateEntityId.
	 */
	public Integer getPrivateEntityId() {
		return privateEntityId;
	}
	public void setPrivateEntityId(Integer privateEntityId) {
		this.privateEntityId = privateEntityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((getEntity() == null) ? 0 : getEntity().hashCode());
		result = prime * result + (int) (getInternalNumber() ^ (getInternalNumber() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractFinance other = (AbstractFinance) obj;
		if (getEntity() == null) {
			if (other.getEntity() != null)
				return false;
		} else if (!getEntity().equals(other.getEntity()))
			return false;
		if (getInternalNumber() != other.getInternalNumber())
			return false;
		return true;
	}

}
