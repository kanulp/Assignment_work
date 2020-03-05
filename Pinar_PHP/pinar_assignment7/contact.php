<?php
if(isset($_POST['contact'])) 
{

if(!empty($_POST['name'])  && !empty($_POST['email']) && !empty($_POST['comment']))
{
    if (!filter_var($_POST['email'], FILTER_VALIDATE_EMAIL)) {
        $err = "Invalid email format";
      }
      else{

    ini_set("SMTP","smtp.gmail.com");
    ini_set("smtp_port","25");

    $body = "Name: {$_POST['name']}\n\nComments: {$_POST['comment']}";
    $body = wordwrap($body,70);

    mail('karangajjar.lp@gmail.com','Contact Form Submission', $body, "From: {$_POST['email']}");

    echo '<p><em>Thank you for contacting me. I will reply soon.</em></p>';

    $_POST = [];

    
      }
}
else
{
$err="Please fill out the form completely.";
}
}
?>

<html>
<head>
    <title>Contact</title>
    <link href='style.css' rel='stylesheet' type='text/css'>
</head>
<body>
   
    <?php if(isset($err)){ echo $err; } ?> 
    <div class="login-block">
<h1>Contact Me</h1>
<p>Fill out this form to contact me.</p>
<form method="POST" name="contact" target="_self">

Name : <input name="name" placeholder="Name" type="text" />
<br/><br/>
Email : <input name="email" placeholder="Email Address" size="30" />
<br/><br/>
Comment : <textarea name="comment" placeholder="Comments" rows="5" cols="30"></textarea>
<br/><br/>
<input name="contact" type="submit" value="Send" />

</form>
</div>
</body>
</html>