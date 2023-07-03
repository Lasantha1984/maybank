
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Addresses for Customer :${fullName}</title>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
<c:set var="listsize" value="${addresses.size()}" /> <!-- Replace with your list -->

  <h1>Customer : ${fullName}</h1>
  <h1>Addresses Listing</h1>
   <form action="/addAddress" method="GET">
	<input type="hidden" name="customerId" value="${customerId}" id=${customerId} />
	<button ${listsize<3 ? '' : 'disabled'} type="submit">Add</button>
</form> 
  
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Street</th>
        <th>City</th>
        <th>PostalCode</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${addresses}">
        <tr>
          <td>${item.id}</td>
          <td>${item.street}</td>
          <td>${item.city}</td>
          <td>${item.postalCode}</td>
          <td>
						 <form action="/updateAddress" method="POST">
						    <input type="hidden" name="customerId" value=${customerId} id=${customerId} />
							<input type="hidden" name="addressId" value=${item.id} id=${item.id} />
							<input type="hidden" name="street" value=${item.street} id=${item.street}  />
							<input type="hidden" name="city" value=${item.city} id=${item.city} />
							<input type="hidden" name="postalCode" value=${item.postalCode} id=${item.postalCode} />
							<button type="submit">Modify</button>
						</form> 

		 </td>
          <td>
          	 <form action="/delete" method="POST">
						    <input type="hidden" name="customerId" value=${customerId} id=${customerId} />
							<input type="hidden" name="addressId" value=${item.id} id=${item.id} />
							<button type="submit">Delete</button>
						</form> 
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
