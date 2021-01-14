<!DOCTYPE html>
<html lang="en">
<head>
    <link rel='stylesheet' type='text/css' media='screen' href='styles.css'>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta charset="UTF-8">
	<title>Створення завдань</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #333333">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">ВЛ</a>
            </li>
        </ul>
        <div class="topnav-centered">
            Кодування
        </div>
        <div class="nav-to-right">
 		    <div class="collapse navbar-collapse" id="navbar-list-4">
 		        <div class="userName">User Name</div>
 		            <ul class="navbar-nav">
 		                <li class="nav-item dropdown">
 		                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="	false">
 		                        <img src="https://s3.eu-central-1.amazonaws.com/bootstrapbaymisc/blog/24_days_bootstrap/fox.jpg" width="40" height="40" class="rounded-circle">
 		                    </a>
 		                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
 		                    <a class="dropdown-item" href="#">Dashboard</a>
 		                    <a class="dropdown-item" href="#">Edit Profile</a>
 		                    <a class="dropdown-item" href="#">Log Out</a>
 		    	        </li>
    			    </ul>
 		        </div>
            </div>
        </div>
    </nav>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <form action="#" th:action="@{/task/create}" th:object="${task}" method="post">
	    <div class="limiter">
			<div class="container-login100">
				<div class="container">
				    <a href="#" class="imageBack"><img src="images/blackback_arrow_50px.png" alt=""></a>
				    <p class="pageName">Нове завдання</p>
				</div>
				<div class="inputData">
					<p>Назва завдання</p>
					<p><input type="text" size="50" th:field="*{title}"></p>

                    <p>Тема</p>
                    <p><input type="text" size="50" th:field="*{theme}"></p>

					<p>Теги</p>
					<p><input type="text" size="50" th:field="*{labels}"></p>
			    </div>
				<div class="taskArea">
					<p>Опис завдання</p>
					<p><textarea rows="10" cols="80" name="text" th:field="*{description}" ></textarea></p>
				</div>
				<div class="testCases">
					<p>Test case </p>
					<p>Вхідні дані</p>
					<p><input type="text" size="50"></p>
				</div>
				<input type="submit" > Створити завдання </input>
			</div>
	    </div>
	</form>
    <div class="footer">
  		<p class="footerText">ВЛ 2020</p>
	</div>
</body>
</html>

<script th:inline="javascript">
/<![CDATA[/

    var message = /[[${message}]]/ 'default';
    console.log(message);

/]]>/
</script>