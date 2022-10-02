<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
/>
</head>

<body>
         
         
         
         <div id="wrapper">
         <div id="header">
         <h1>CRM: Customer Relationship Management</h1>
         </div>
         </div>
         
         <div id="container">
         <div id="content">
         
         <button onClick="window.location.href='showFormForAdd'; return false;" class="add-button">Add Customers</button>
             
             <table>
             <tr>
             <th>First Name</th>
             <th>Last Name</th>
             <th>Email</th>
             <th>Action</th>
             </tr>
             
             <c:forEach var="currCustomer" items="${customers}">
             
             
             <c:url var="updateLink" value="/customer/showFormForUpdate">
                 <c:param name="customerId" value="${currCustomer.id}" />
                 </c:url>
                 
                <c:url var="deleteLink" value="/customer/deleteFormItem">
                 <c:param name="customerId" value="${currCustomer.id}" />
                 </c:url>
                 <tr>
                 
                 <td>${currCustomer.firstName}</td>
                 <td>${currCustomer.lastName}</td>
                 <td>${currCustomer.email}</td>
                 <td>
                 <a href="${updateLink}">Update |</a>
                 <a href="${deleteLink }" onClick="if(!(confirm('Are You Sure You Want To Delete This Customer'))) return false"> Delete</a>
                 </td>
                 
                 </tr>
             </c:forEach>
             </table>
         
         </div>
         </div>
          
          

</body>

</html>