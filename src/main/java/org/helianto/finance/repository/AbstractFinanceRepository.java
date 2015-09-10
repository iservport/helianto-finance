package org.helianto.finance.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.helianto.finance.domain.AbstractFinance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * AbstractFinance Repository.
 * 
 * @author Eldevan Nery Junior
 *
 */
public interface AbstractFinanceRepository extends JpaRepository<AbstractFinance, Serializable> {

	/**
	 * Find list by entity.
	 * 
	 * @param entityId
	 * 
	 */
	List<AbstractFinance> findByEntity_Id(Integer entityId);
	
	/**
	 * Find by privateEntity.
	 * 
	 * @param privateEntityId
	 */
	List<AbstractFinance> findByPrivateEntity_Id(Integer privateEntityId);
	
	/**
	 * Find list by entity and Resolution.
	 * 
	 * @param entityId
	 * 
	 */
	List<AbstractFinance> findByEntity_IdAndResolutionIn(Integer entityId, Set<Character> resolutions);
	
	/**
	 * Find by privateEntity and Resolution.
	 * 
	 * @param privateEntityId
	 */
	List<AbstractFinance> findByPrivateEntity_IdAndResolutionIn(Integer privateEntityId, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) FROM AbstractFinance fin WHERE fin.entity.id = ?1 ")
	BigDecimal sumFaceValueByEntityId(Integer entityId);
	
	/**
	 * Sum faceValue by privateEntityId.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) FROM AbstractFinance fin WHERE fin.privateEntity.id = ?1 ")
	BigDecimal sumFaceValueByPrivateEntityId(Integer privateEntityId);
	
	/**
	 * Sum faceValue by entityId and Resolution.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.resolution in (?2) ")
	BigDecimal sumFaceValueByEntityIdAndResolutionIn(Integer entityId, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId and Resolution.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin "
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.resolution in (?2) ")
	BigDecimal sumFaceValueByPrivateEntityIdAndResolutionIn(Integer privateEntityId, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId issueDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.issueDate > ?2 "
		+ " AND fin.resolution in (?3) ")
	BigDecimal sumFaceValueByEntityIdAndIssueDateAfter(Integer entityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId issueDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin"
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.issueDate > ?2"
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByPrivateEntityIdAndIssueDateAfter(Integer privateEntityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId nextCheckDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue)"
		+ " FROM AbstractFinance fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND fin.nextCheckDate > ?2 "
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByEntityIdAndNextCheckDateAfter(Integer entityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId nextCheckDate after startDate.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin"
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND fin.nextCheckDate > ?2 "
		+ " AND fin.resolution in (?3)")
	BigDecimal sumFaceValueByPrivateEntityIdAndNextCheckDateAfter(Integer privateEntityId, Date start, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId issueDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND (fin.issueDate BETWEEN ?2 AND ?3) "
		+ " AND fin.resolution in (?4)  ")
	BigDecimal sumFaceValueByEntityIdAndIssueDateBetween(Integer entityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId issueDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ "	FROM AbstractFinance fin "
		+ " WHERE fin.privateEntity.id = ?1 "
		+ " AND (fin.issueDate BETWEEN ?2 AND ?3) "
		+ " AND fin.resolution in (?4)")
	BigDecimal sumFaceValueByPrivateEntityIdAndIssueDateBetween(Integer privateEntityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by entityId nextCheckDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		+ " FROM AbstractFinance fin "
		+ " WHERE fin.entity.id = ?1 "
		+ " AND (fin.nextCheckDate BETWEEN ?2 AND ?3) "
		+ "	AND fin.resolution in (?4) ")
	BigDecimal sumFaceValueByEntityIdAndNextCheckDateBetween(Integer entityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Sum faceValue by privateEntityId nextCheckDate between dates.
	 * 
	 * @param entityId
	 * 
	 */
	@Query("SELECT SUM(fin.faceValue) "
		 + " FROM AbstractFinance fin "
		 + " WHERE fin.privateEntity.id = ?1 "
		 + " AND (fin.nextCheckDate BETWEEN ?2 AND ?3) "
		 + " AND fin.resolution in (?4) ")
	BigDecimal sumFaceValueByPrivateEntityIdAndNextCheckDateBetween(Integer privateEntityId, Date start, Date end, Set<Character> resolutions);
	
	/**
	 * Find by entity between issue date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<AbstractFinance> findByEntity_IdAndResolutionInAndIssueDateBetween(Integer entityId, Set<Character> resolutions , Date start, Date end);
	
	/**
	 * Find by entity between next check date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<AbstractFinance> findByEntity_IdAndResolutionInAndNextCheckDateBetween(Integer entityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by private entity between issue date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<AbstractFinance> findByPrivateEntity_IdAndResolutionInAndIssueDateBetween(Integer privateEntityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by private entity between next check date.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<AbstractFinance> findByPrivateEntity_IdAndResolutionInAndNextCheckDateBetween(Integer privateEntityId, Set<Character> resolutions, Date start, Date end);
	
	/**
	 * Find by entity issue date after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<AbstractFinance> findByEntity_IdAndResolutionInAndIssueDateAfter(Integer entityId, Set<Character> resolutions, Date start);
	
	
	/**
	 * Find by private entity issue date after startDate.
	 * 
	 * @param entityId
	 * @param start
	 * @param end
	 */
	List<AbstractFinance> findByPrivateEntity_IdAndResolutionInAndIssueDateAfter(Integer privateEntityId, Set<Character> resolutions, Date start);

}
