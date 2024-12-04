<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<div class="container">
        <nav class='navbar navbar-light bg-dark text-white'>
            <a class='navbar brand text-white' href="/dashboard">Dashboard</a>
            <h3>Add a new song!</h3>
        </nav>
        <form action="/songs/create" method="POST">
            <div class="row">
                <div class="col-4">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" name="title" id = "title">
  					<label for="artist">Artist:</label>
                    <input type="text" class="form-control" name="artist" id = "artist">
                    <label for="rating">Rating:</label>
                    <input type="number" class="form-control" name="rating" id = "rating">
                </div>
            </div>
            <div class='row'>
                <input type="hidden" name="_method">
                <button class='btn btn-outline-success ml-3 mt-3'>Add</button>
            </div>
        </form>
    </div>

</body>
</html>