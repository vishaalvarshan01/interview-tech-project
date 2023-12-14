<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.its.entity.Candidate" %>
<%@ page import="com.wipro.its.entity.CandidateRating" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Candidates</title>
    <style>
        /* CSS styles */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        main {
            padding-top: 40px; /* Add padding to the top of the main container */
        }

        h1 {
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            text-align: center;
            margin-top: 20px;
        }

        th, td {
            padding: 8px;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }

        .no-candidates {
            color: #f00;
            font-weight: bold;
            margin-top: 20px;
        }

        .rate-button {
            padding: 5px 10px;
            border: none;
            border-radius: 4px;
            background-color: #0077ff;
            color: #fff;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .rate-button.disabled {
            background-color: #ccc;
            cursor: not-allowed;
        }

        .rate-button:hover {
            background-color: #005eff;
        }
        .return-button {
                  position: absolute;
                  top: 10px;
                  left: 10px;
                  background-color: #f0f0f0;
                  color: #333;
                  padding: 8px 12px;
                  border: none;
                  font-size: 16px;
                  cursor: pointer;
              }
    </style>
</head>
<body>
<main>
<a class="return-button" href="/hr/hrWelcome">&larr; Return</a>
    <h1>View Candidates</h1>

    <% List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
       if (candidates != null && !candidates.isEmpty()) {
    %>
           <table>
               <tr>
                   <th>Candidate ID</th>
                   <th>Name</th>
                   <th>Location</th>
                   <th>Experience</th>
                   <th>Eligibility</th>
                   <th>Action</th>
               </tr>
               <% for (Candidate candidate : candidates) { %>
                   <% CandidateRating candidateRating = candidate.getCandidateRating(); %>
                   <tr>
                       <td><%= candidate.getCandidateId() %></td>
                       <td><%= candidate.getCandidateName() %></td>
                       <td><%= candidate.getCandidateLocation() %></td>
                       <td><%= candidate.getCandidateExp() %></td>
                       <td><%= candidate.getCandidateEligibility() %></td>
                       <td>
                           <% if (candidateRating != null && candidateRating.isRated()) { %>
                               <span class="rate-button disabled">Rated</span>
                           <% } else { %>
                               <a href="/hr/rateCandidate/<%= candidate.getCandidateId() %>" class="rate-button">Rate</a>
                           <% } %>
                       </td>
                   </tr>
               <% } %>
           </table>
    <% } else { %>
           <div class="no-candidates">No candidates available.</div>
    <% } %>
</main>
</body>
</html>
