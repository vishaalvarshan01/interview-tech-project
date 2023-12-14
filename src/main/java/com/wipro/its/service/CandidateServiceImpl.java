package com.wipro.its.service;

import com.wipro.its.entity.Candidate;
import com.wipro.its.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates(int id) {
        return candidateRepository.findByAdminIdAndInterviewByHr(id);
    }

    @Override
    public List<Candidate> getAllTechCandidates(int id) {
        return candidateRepository.findByAdminIdAndInterviewByTech(id);
    }

    @Override
    public Optional<Candidate> findById(int id){
        return candidateRepository.findById(id);
    }
}
