package com.wipro.its.repository;

import com.wipro.its.entity.Candidate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate,Integer> {

    @Query("SELECT c FROM Candidate c WHERE c.admin.id = :adminId AND c.interviewBy = 'hr'")
    List<Candidate> findByAdminIdAndInterviewByHr(@Param("adminId") int adminId);

    @Query("SELECT c FROM Candidate c WHERE c.admin.id = :adminId AND c.interviewBy = 'tech'")
    List<Candidate> findByAdminIdAndInterviewByTech(@Param("adminId") int adminId);
}
