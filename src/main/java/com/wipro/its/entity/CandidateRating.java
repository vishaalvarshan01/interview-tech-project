package com.wipro.its.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate_ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ratingId;

    @NotNull(message = "Rating is required.")
    @Min(value = 1, message = "Rating should be at least 1.")
    @Max(value = 5, message = "Rating should be at most 5.")
    private int rating;

    @NotNull(message = "Feedback is required.")
    private String feedback;

    @NotNull(message = "Remarks is required.")
    private String remarks;

    private boolean rated;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
}
