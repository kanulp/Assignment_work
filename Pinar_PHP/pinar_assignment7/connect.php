<?php


$connection = mysqli_connect("localhost","root","","mydb") or error("Unable to connect to database : " . mysqli_connect_errorno());


mysqli_set_charset($connection,"utf8");


?>
