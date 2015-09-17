package org.helianto.finance.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.helianto.finance.domain.Receivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Receivable Repository.
 * 
 * @author Eldevan Nery Junior
 *
 */
public interface ReceivableRepository extends JpaRepository<Receivable, Serializable> {

	/**
	 * Entities queries.
	 */
	
	/*
	 * SUM'S
	 */
	
	/**
	 * Sum faceValue by entityId and Resolution.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.resolution in (?2) ")
	BigDecimal sumFaceValueByEntityIdAndResolutionIn(Integer entityId, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId issueDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.issueDate > ?2 "
		+ " AND fin.resolution in (?3) ")
	BigDecimal sumFaceValueByEntityIdAndIssueDateAfter(Integer entityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId nextCheckDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue)"
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.nextCheckDate > ?2 "
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByEntityIdAndNextCheckDateAfter(Integer entityId, Date start, Set<Character> resolutions);

	/**
	 * Sum faceValue by entityId PaymentDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.paymentDate > ?2 "
		+ " AND fin.resolution in (?3) ")
	BigDecimal sumFaceValueByEntityIdAndPaymentDateAfter(Integer entityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId issueDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND (fin.issueDate BETWEEN ?2 AND ?3) "
		+ " AND fin.resolution in (?4)  ")
	BigDecimal sumFaceValueByEntityIdAndIssueDateBetween(Integer entityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId nextCheckDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND (fin.nextCheckDate BETWEEN ?2 AND ?3) "
		+ "	AND fin.resolution in (?4) ")
	BigDecimal sumFaceValueByEntityIdAndNextCheckDateBetween(Integer entityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId PaymentDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND (fin.paymentDate BETWEEN ?2 AND ?3) "
		+ " AND fin.resolution in (?4)  ")
	BigDecimal sumFaceValueByEntityIdAndPaymentDateBetween(Integer entityId, Date start, Date end, Set<Character> resolutions);
	
	/*
	 * FIND'S
	 */
	
	/**
	 * Find list by entity.
	 * 
	 * @param entityId
	 * 
	 */
	List<Receivable> findByEntity_Id(Integer entityId);
	
	/**
	 * Find list by entity and Resolution.
	 * 
	 * @param entityId
	 * 
	 */
	List<Receivable> findByEntity_IdAndResolutionIn(Integer entityId, Set<Character> resolutions);

	
	/**
	 * Find by entity between issue date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByEntity_IdAndResolutionInAndIssueDateBetween(Integer entityId, Set<Character> resolutions , Date start, Date end);
	
	/**
	 * Find by entity between next check date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByEntity_IdAndResolutionInAndNextCheckDateBetween(Integer entityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by private entity between PaymentDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByEntity_IdAndResolutionInAndPaymentDateBetween(Integer privateEntityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by entity issue date after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByEntity_IdAndResolutionInAndIssueDateAfter(Integer entityId, Set<Character> resolutions, Date start);
	
	/**
	 * Find by entity issue date after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByEntity_IdAndResolutionInAndNextCheckDateAfter(Integer entityId, Set<Character> resolutions, Date start);
	
	/**
	 * Find by entity PaymentDate after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByEntity_IdAndResolutionInAndPaymentDateAfter(Integer entityId, Set<Character> resolutions, Date start);
	
	/**
	 * Private Entities queries.
	 */
	
	/*
	 * SUM'S
	 */
	
	/**
	 * Sum faceValue by entityId.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) FROM Receivable fin WHERE fin.entity.id = ?1 ")
	BigDecimal sumFaceValueByEntityId(Integer entityId);
	
	/**
	 * Sum faceValue by privateEntityId.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) FROM Receivable fin WHERE fin.privateEntity.id = ?1 ")
	BigDecimal sumFaceValueByPrivateEntityId(Integer privateEntityId);
	
	/**
	 * Sum faceValue by privateEntityId and Resolution.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin "
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.resolution in (?2) ")
	BigDecimal sumFaceValueByPrivateEntityIdAndResolutionIn(Integer privateEntityId, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId issueDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin"
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.issueDate > ?2"
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByPrivateEntityIdAndIssueDateAfter(Integer privateEntityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId nextCheckDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin"
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.nextCheckDate > ?2 "
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByPrivateEntityIdAndNextCheckDateAfter(Integer privateEntityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId PaymentDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM Receivable fin"
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.paymentDate > ?2"
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByPrivateEntityIdAndPaymentDateAfter(Integer privateEntityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId issueDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ "	FROM Receivable fin "
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND (fin.issueDate BETWEEN ?2 AND ?3) "
		+ " AND fin.resolution in (?4)")
	BigDecimal sumFaceValueByPrivateEntityIdAndIssueDateBetween(Integer privateEntityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId nextCheckDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		 + " FROM Receivable fin "
		 + " WHERE fin.privateEntity.id = ?1 "
		 + " AND (fin.nextCheckDate BETWEEN ?2 AND ?3) "
		 + " AND fin.resolution in (?4) ")
	BigDecimal sumFaceValueByPrivateEntityIdAndNextCheckDateBetween(Integer privateEntityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId PaymentDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ "	FROM Receivable fin "
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND (fin.paymentDate BETWEEN ?2 AND ?3) "
		+ " AND fin.resolution in (?4)")
	BigDecimal sumFaceValueByPrivateEntityIdAndPaymentDateBetween(Integer privateEntityId, Date start, Date end, Set<Character> resolutions);
	
	/*
	 * FIND'S
	 */
	
	/**
	 * Find by privateEntity.
	 * 
	 * @param privateEntityId
	 */
	List<Receivable> findByPrivateEntity_Id(Integer privateEntityId);
	
	/**
	 * Find by privateEntity and Resolution.
	 * 
	 * @param privateEntityId
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionIn(Integer privateEntityId, Set<Character> resolutions);
	
	/**
	 * Find by private entity between issue date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionInAndIssueDateBetween(Integer privateEntityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by private entity between next check date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionInAndNextCheckDateBetween(Integer privateEntityId, Set<Character> resolutions, Date start, Date end);
	
	
	/**
	 * Find by private entity between PaymentDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionInAndPaymentDateBetween(Integer privateEntityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by private entity issue date after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionInAndIssueDateAfter(Integer privateEntityId, Set<Character> resolutions, Date start);
	
	/**
	 * Find by private entity nextcheckDate after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionInAndNextCheckDateAfter(Integer privateEntityId, Set<Character> resolutions, Date start);
	
	/**
	 * Find by private entity PaymentDate after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<Receivable> findByPrivateEntity_IdAndResolutionInAndPaymentDateAfter(Integer privateEntityId, Set<Character> resolutions, Date start);

	Receivable findByTransactionCode(String transactionCode);
	
	/**
	 * Last internalNumber.
	 * 
	 * @param entityId
	 */
	@Query("select max(fin.internalNumber) "
			+ "from Receivable fin "
			+ "where fin.entity.id = ?1 ")
	Long findLastInternalNumber(int entityId);
	
	List<Receivable> findByReference(String reference);
	
}
