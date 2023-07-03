
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Customer List</title>
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
  <h1>Customer Listing</h1>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>ShortName</th>
        <th>FullName</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${customers}">
        <tr>
          <td>${item.id}</td>
          <td>${item.shortName}</td>
          <td>${item.fullName}</td>
          <td>
						<form action="/getAddressesByCustomerId" method="get">
							<input type="hidden" name="customerId" value="${item.id}" id="${item.id}" />
							<input type="hidden" name="fullName" value="${item.fullName}" id="${item.fullName}" />
							<button type="submit">View Addresses</button>
						</form>


					</td>
          
        </tr>
      </c:forEach>
    </tbody>
  </table>
</body>
</html>
