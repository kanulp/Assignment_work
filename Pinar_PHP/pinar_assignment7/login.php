<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>" method="post">

      <label for="uname"><b>Username :</b></label>
      <input type="text" placeholder="Enter Username" name="name" required><br>

      <label for="psw"><b>Password :</b></label>
      <input type="password" placeholder="Enter Password" name="pass" required><br>
        
      <button type="submit" name="but_submit">Login</button><br>
      <label>
        <input type="checkbox" checked="checked" name="remember"> Remember me
      </label>
    
  </form>
</body>
<?php
require("connect.php");

if(isset($_POST['but_submit'])){

    $uname = mysqli_real_escape_string($connection,$_POST['name']);
    $password = mysqli_real_escape_string($connection,$_POST['pass']);

    if ($uname != "" && $password != ""){

        $sql_query = "select count(*) as cntUser from customer where Email='".$uname."' and Password='".$password."'";
        $result = mysqli_query($connection,$sql_query);
        $row = mysqli_fetch_array($result);

        $count = $row['cntUser'];

        if($count > 0){
            echo "Login Success";
        }else{
            echo "Invalid username and password";
        }

    }

}
?>
</html>