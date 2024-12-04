<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Artist</title>
</head>
<body>

	<div class = "container">
	    <nav class='navbar navbar-light bg-dark text-white'>
            <a href = "/dashboard">Go To Dashboard</a>
            <form action = "songs/search" method = "post">
            	<input type = "hidden" name = "_method" value = "search">
            	<input type = "submit" value = "Delete" class = "btn btn-outline-light">
            </form>
        </nav>
        <h1><c:out value = "${artist}"/></h1>
		<table class = "table table-striped">
		    <thead class = "thead-dark">
		        <tr>
		            <th scope = "col">Name</th>
		            <th scope = "col">Rating</th>
		            <th scope = "col">Actions</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
		        <tr>
		            <td scope = "row"><a href = "/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		            <td scope = "row"><c:out value="${song.rating}"/></td>
		            <td scope = "row">
		            	<form action="/songs/${song.id}" method="post">
	  							<input type="hidden" name="_method" value="delete">
	  							<input type="submit" value="Delete" class = "btn btn-outline-danger">
						</form>
		            </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>

</body>
</html>