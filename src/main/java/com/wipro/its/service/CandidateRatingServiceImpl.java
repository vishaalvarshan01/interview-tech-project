package com.wipro.its.service;

import com.wipro.its.entity.CandidateRating;
import com.wipro.its.repository.CandidateRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateRatingServiceImpl implements CandidateRatingService{

    @Autowired
    CandidateRatingRepository candidateRatingRepository;
    @Override
    public CandidateRating saveCandidateRating(CandidateRating rating) {
        return candidateRatingRepository.save(rating);
    }
}
