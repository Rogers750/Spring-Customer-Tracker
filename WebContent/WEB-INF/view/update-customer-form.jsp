<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
/>

<link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"
/>
</head>

<body>
         
      <h1>CRM: Add Customer</h1>   
      
      <div id="wrapper">
      <div id="header">
      </div>
      </div>
      
      
      <div id="container">
      <h3>Save Customer</h3>
      
      <form:form action="saveCustomer" modelAttribute="currCustomer" method="POST">
            
            <table>
            <tbody>
                
             <tr>
               <td> <label>First Name: </label></td>
               <td> <form:input path="firstName" value="${currCustomer.firstName}"/> </td>
             </tr>
             
              <tr>
               <td> <label>Last Name: </label></td>
               <td> <form:input path="lastName" value="${currCustomer.lastName}"/> </td>
             </tr>
             
             <tr>
               <td> <label>Email: </label></td>
               <td> <form:input path="email" value="${currCustomer.email}"/> </td>
             </tr>
             
             <tr>
              <td> <form:button type="submit" value="Save" class="save" style="border-radius:20px">Save</form:button> </td>
             </tr>
             
             
                
            </tbody>
            </table>
            
               <br><br>
               <a href="list">Customer Page</a>
            
      </form:form>
      
      </div>
   
        
          
          

</body>

</html>