<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Show song!</title>
</head>
<body>



<div class="container">
        <nav class='navbar navbar-light bg-dark text-white'>
            <form action="/dashboard" method="post">
    			<input type="hidden" name="_method" value="Dashboard">
    			<input type="submit" value="Dashboard" class = "btn btn-warning">
			</form>
        </nav>
        <div class="thisSong">
            <div class="song" style='margin: 25px; float: left; width: 55%;'>
                <h1>Title: <c:out value="${song.title}"/></h1>
				<p>Artist: <c:out value="${song.artist}"/></p>
				<p>Rating: <c:out value="${song.rating}"/></p>
				<p>ID: <c:out value="${song.id}"/></p>
				<a href="/${song.id}/edit">Edit Song</a>
					<form action="/${song.id}" method="post">
			   			 <input type="hidden" name="_method" value="delete">
			    		 <input type="submit" value="Delete" class = "btn btn-danger">
					</form>
            </div>
        </div>
    </div>

</body>
</html>