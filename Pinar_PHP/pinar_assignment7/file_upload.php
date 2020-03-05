<?php
   if(isset($_FILES['image'])){
      if($_FILES['image']['size'] == 0)
      {
         $err = 'Please select image to upload.';
      }
      else{
      $errors= array();
      $file_name = $_FILES['image']['name'];
      $file_size = $_FILES['image']['size'];
      $file_tmp = $_FILES['image']['tmp_name'];
      $file_type = $_FILES['image']['type'];
      $file_ext=pathinfo($file_name, PATHINFO_EXTENSION);
      
      $extensions= array("jpeg","jpg","png");
      
      if(in_array($file_ext,$extensions)=== false){
         $errors[]="Extension not allowed, please choose a JPEG or PNG file.";
      }
      
      if($file_size > 2097152) {
         $errors[]='File size must be excately 2 MB';
      }
      
      if(empty($errors)==true) {
         $dirpath = dirname(getcwd()) . "/uploads/";
         if (!file_exists($dirpath)) {
            mkdir($dirpath, 0777, true);
        }
         move_uploaded_file($file_tmp,$dirpath.$file_name);
         $err = "Image uploaded successfully.";
      }else{
         $err = implode('<br>',$errors);
      }
   }
   }
?>
<html>
   <head>
      <title>Upload</title>
      <link href='style.css' rel='stylesheet' type='text/css'>
</head>
   <body>
     <center>
     <?php if(isset($err)){ echo $err; } ?> 
    <div class="login-block">
<h1>Image Upload</h1>
      <form action="" method="POST" enctype = "multipart/form-data">
         <input type="file" name="image" />
         <input type="submit"/>
      </form>
</div>
</center>
   </body>
</html>