package com.wipro.its.service;

import com.wipro.its.entity.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {

    List<Candidate> getAllCandidates(int id);

    List<Candidate> getAllTechCandidates(int id);

    Optional<Candidate> findById(int id);
}
