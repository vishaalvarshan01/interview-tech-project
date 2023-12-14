<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.wipro.its.entity.Candidate" %>
<%@ page import="com.wipro.its.entity.CandidateRating" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Rate Candidate Page</title>
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

    form {
      margin-top: 20px;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
    }

    .form-group input {
      width: 100%;
      padding: 8px;
      border: 1px solid #ddd;
    }

    .form-group textarea {
      width: 100%;
      height: 100px;
      padding: 8px;
      border: 1px solid #ddd;
    }

    .submit-button {
      background-color: #0077ff;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
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
  <script>
    function setActionURL() {
      var form = document.getElementById("ratingForm");
      var url = window.location.href;
      var candidateId = url.substring(url.lastIndexOf("/") + 1);
      form.action = "/tech/submitRating/" + candidateId;
    }
  </script>

</head>
<body>
<main>
<a class="return-button" href="/tech/techWelcome">&larr; Return</a>
  <h1>Rate Candidate</h1>
  <form id="ratingForm" method="post" modelAttribute="rating">
    <div class="form-group">
      <label for="rating">Rating:</label>
      <input type="number" id="rating" name="rating" min="1" max="5" required>
    </div>
    <div class="form-group">
      <label for="feedback">Feedback:</label>
      <textarea id="feedback" name="feedback" required></textarea>
    </div>
    <div class="form-group">
      <label for="remarks">Remarks:</label>
      <textarea id="remarks" name="remarks" required></textarea>
    </div>
    <input type="hidden" id="candidateId" name="candidateId" value="<%= request.getParameter("candidateId") %>">
    <input type="submit" value="Submit" class="submit-button" onclick="setActionURL()">
  </form>
</main>
</body>

</html>
