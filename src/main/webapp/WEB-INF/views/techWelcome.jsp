<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>HR Welcome Page</title>
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

    .nav-links {
      margin-top: 20px;
    }

    .nav-links a {
      display: inline-block;
      margin-right: 10px;
      padding: 5px 10px;
      border: none;
      border-radius: 4px;
      background-color: #0077ff;
      color: #fff;
      text-decoration: none;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .nav-links a:hover {
      background-color: #005eff;
    }
  </style>
</head>
<body>
<main>
  <h1>Welcome to Tech Page</h1>
  <div class="nav-links">
    <a href="logout">Logout</a>
    <a href="/tech/viewCandidates" >View Candidates</a>
    <a href="/tech/changePassword" >Change Password</a>
  </div>
</main>
</body>
</html>
