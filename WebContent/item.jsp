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

<h1>Item Manager</h1>

<s:form action="add" method="POST" enctype="multipart/form-data">
<s:textfield name="item.title" label="Title"></s:textfield>
<s:textfield name="item.description" label="Description"></s:textfield>
<s:textfield name="item.price" label="Price"></s:textfield>
<s:textfield name="item.date" label="Date"></s:textfield>
<s:file name="item.photo" label="Photo"></s:file>
<img src="uploads/<s:property value="item.photoFileName"/>"/>
<s:submit value="Save"></s:submit>



</s:form>


<table>
<tr><th>Image</th><th>Description</th><th>Price</th><th>Date</th>
</tr>
<s:iterator value="itemList" var="item">
<tr>
<td><img src="uploads/<s:property value="photoFileName"/>" width="100px" height="100px"/></td>
<td><s:property value="title"/></td>
<td><s:property value="description"/></td>
<td><s:property value="price"/></td>
<td><s:property value="date"/></td>

</tr>
</s:iterator>

</table>



</body>
</html>