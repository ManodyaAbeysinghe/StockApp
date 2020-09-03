<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Customer Manager</h1>

<s:form action="add" method="POST" enctype="multipart/form-data">
<s:textfield name="customer.name" label="Title"></s:textfield>
<s:textfield name="customer.address" label="Description"></s:textfield>
<s:textfield name="customer.phoneNumber" label="Price"></s:textfield>
<s:file name="customer.photo" label="Photo"></s:file>
<img src="uploads/<s:property value="customer.photoFileName"/>"/>
<s:submit value="Save"></s:submit>
</s:form>


<table>
<tr><th>Image</th><th>Description</th><th>Price</th><th>Date</th>
</tr>
<s:iterator value="customerList" var="customer">
<tr>
<td><img src="uploads/<s:property value="photoFileName"/>" width="100px" height="100px"/></td>
<td><s:property value="name"/></td>
<td><s:property value="address"/></td>
<td><s:property value="phonenumber"/></td>


</tr>
</s:iterator>

</table>



</body>
</html>