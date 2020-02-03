<html>   
   <head>
   <link rel="stylesheet" type="text/css" href="./style/style.css">
   </head>
   
   <body> 
      <?php
         
         $nameErr = $emailErr = $genderErr = $dobErr = $itemsErr= "";
         $name = $email = $gender = $dob = $expectations = $items = "";
         
         //checking if server method is post.
         if ($_SERVER["REQUEST_METHOD"] == "POST") {
            //validating name
            if (empty($_POST["name"])) {
               $nameErr = "Name is required";
            }else {
               $name = test_input($_POST["name"]);
            }
            
            if (empty($_POST["email"])) {
               $emailErr = "Email is required";
            }else {
               $email = test_input($_POST["email"]);
               
               // check if e-mail address is in correct form
               if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
                  $emailErr = "Invalid email format"; 
               }
            }
            
            if (empty($_POST["dob"])) {
               $dob = "";
            }else {
               $dob = test_input($_POST["dob"]);
            }
            
            if (empty($_POST["expectations"])) {
               $expectations = "";
            }else {
               $expectations = test_input($_POST["expectations"]);
            }
            
            if (empty($_POST["gender"])) {
               $genderErr = "Gender is required";
            }else {
               $gender = test_input($_POST["gender"]);
            }
            
            //getting items
            if (empty($_POST["items"])) {
               $itemsErr = "You must select 1 or more";
            }else {
               $items = $_POST["items"];	
            }
         }
         
         //formatting data 
         function test_input($data) {
            $data = trim($data);
            $data = stripslashes($data);
            $data = htmlspecialchars($data);
            return $data;
         }
      ?>
		
      <h2>Trip Registration form : Pinar Ovali</h2>
      
      <p><span class = "error">* required field.</span></p>
      
      <form method = "POST" action = "<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
         <table>
            <tr>
               <td>Name:<span class = "error">* <?php echo $nameErr;?></span></td>
               <td><input type = "text" name = "name">
               </td>
            </tr>
            
            <tr>
               <td>E-mail:<span class = "error">* <?php echo $emailErr;?></span>
                </td>
               <td><input type = "text" name = "email">
               </td>
            </tr>
            
            <tr>
               <td>DOB: </td>
               <td> <input type = "text" name = "course" placeholder="MM/DD/YYYY" >
                  <span class = "error"><?php echo $dobErr;?></span>
               </td>
            </tr>
            
            <tr>
               <td>Gender:
               <span class = "error">* <?php echo $genderErr;?></span> 
               </td>
               <td>
                  <input type = "radio" name = "gender" value = "female"> Female<br/>
                  <input type = "radio" name = "gender" value = "male"> Male <br/>
               </td>
            </tr>
            
            <tr>
               <td>Select Which Items you need:</td>
               <td>
                  <select name = "items[]" size = "4" multiple>
                     <option value = "Boots">Winter Boots</option>
                     <option value = "Jacket">Winter Jacket</option>
                     <option value = "Cap">Cap</option>
                     <option value = "Bag">Bag</option>
                  </select>
               </td>
            </tr>
            
          
            <tr>
               <td>Expectations:</td>
               <td> <textarea name = "expectations" rows = "5" cols = "40"></textarea></td>
            </tr>

         
            <tr>
               <td>Agree</td>
               <td><input type = "checkbox" name = "checked" value = "1"></td>
               <?php
               //checkbox validation
               if(!isset($_POST['checked'])){ ?>
               <span class = "error">* <?php echo "You must agree to terms";?></span>
               <?php } ?> 
            </tr>

            
            <tr>
               <td>
                  <input type = "submit" name = "submit" value = "Submit"> 
               </td>
            </tr>
            
            
         </table>
      </form>
      
      //printing details after submitting
      <?php
         echo "<h3>Your given values are as :</h3>";
         echo ("<p>Name : $name</p>");
         echo ("<p>Email : $email</p>");
         echo ("<p>Expectations : $expectations </p>");
         echo ("<p>Gender : $gender</p>");
         echo ("<p>Items : </p>");
         for($i = 0; $i < 6; $i++) {
             if($items[$i]!="")
            echo(($i+1).") ".$items[$i] . "</br>");
         }
      ?>
      
   </body>
</html>