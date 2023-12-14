package com.wipro.its.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int candidateId;

    @NotNull(message = "name cannot be null")
    private String candidateName;
    @NotNull(message = "location cannot be null")
    private String candidateLocation;
    @Min(value = 0, message = "Candidate experience cannot be negative.")
    private int candidateExp;
    @NotNull(message = "eligibility cannot be null")
    private String candidateEligibility;
    @NotNull(message = "interviewer cannot be null")
    private String interviewBy;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private CandidateRating candidateRating;
}
