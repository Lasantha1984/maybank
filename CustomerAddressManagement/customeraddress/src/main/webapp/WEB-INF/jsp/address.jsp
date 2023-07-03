<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Address</title>
<script>
        function validateNumber(event) {
            var input = event.target;
            var value = input.value;
            var pattern = /^\d+$/; 
            
            if (!pattern.test(value)) {
                input.setCustomValidity("Only Numbers Allowed For Postal Code....!");
            } else {
                input.setCustomValidity(""); 
            }
        }
    </script>
      <script>
        function setDefaultValue() {
            var input = document.getElementById("addressId");
            
            if (input.value === "") {
                input.value = "1";
            }
        }
    </script>
</head>
<body>
<form action="/update" method="POST">
	<br><label>Address ID </label><input type="text" default value="${addressId}" name="addressId" id="addressId"  /></br>
	<br><label>Street </label><input type="text" value= "${street}" name="street" id= "${street}" required/></br>
	<br><label>City </label><input type="text" value="${city}" name="city" id="${city}" required/></br>
	<br><label>PostalCode </label><input type="text" value="${postalCode}" name="postalCode" id=${postalCode} pattern="\d+" oninput="validateNumber(event)" required/></br>
	<input type="hidden" value="${customerId}" name="customerId" id=${customerId}/>
	<button type="submit" onClick="setDefaultValue()">Update</button>
</form> 
</body>
</html>