package com.wipro.its.repository;

import com.wipro.its.entity.CandidateRating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRatingRepository extends CrudRepository<CandidateRating,Integer> {
}
