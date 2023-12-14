<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login Page</title>

  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
      padding: 0;
    }

    main {
      max-width: 400px;
      margin: 0 auto;
      padding: 20px;
      background-color: #ffffff;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      border-radius: 5px;
      margin-top: 100px;
    }

    h1 {
      text-align: center;
    }

    form {
      display: flex;
      flex-direction: column;
      margin-top: 20px;
    }

    label {
      margin-bottom: 10px;
    }

    input[type="email"],
    input[type="password"] {
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    input[type="submit"] {
      padding: 10px;
      background-color: #db4a40;
      color: #ffffff;
      border: none;
      cursor: pointer;
      border-radius: 5px;
    }

    input[type="submit"]:hover {
      background-color: #fff;
      color : #db4a40;
      border : 1px #db4a40 solid;
    }
    .hr-login-button {
      display: block;
      margin-top: 10px;
      text-align: center;
      text-decoration: none;
      color: #db4a40;
    }
  </style>
</head>
<body>
  <main>
    <h1>HR Login</h1>
    <h3>${msg}</h3>
    <form action="loginUser" modelAttribute="user" method="POST">
      <label for="email">Email:</label>
      <input type="email" name="email" required/>
      <label for="password">Password:</label>
      <input type="password" name="password" required/>
      <input type="submit" value="Login"/>
      <a href="/tech/login" class="hr-login-button">Tech Login</a>
      <br/>
    </form>
  </main>
  <script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function(event) {
      function preventBack() {
        window.history.forward();
      }

      setTimeout("preventBack()", 0);

      window.onunload = function () { null };
    });
  </script>

</body>

</html>
