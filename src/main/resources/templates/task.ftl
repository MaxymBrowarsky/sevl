<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Робота над завданням</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/workOnTask.css">
	<style>
	    .nav-link{
          color: #CACACA;
          font-family: Times New Roman;
          font-style: normal;
          font-weight: normal;
          font-size: 24px;
          line-height: 37px;
        }

        .nav-to-right {
          float: right;
        }

        .pageName{
        position: absolute;
        width: 275px;
        height: 45px;
        left: 70px;
        top: 75px;

        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 36px;
        line-height: 46px;
        color: #000000;

        }

        .footer{
            /*flex: 0 0 auto;*/
          position: fixed;
          left: 0;
          bottom: 0;
          width: 100%;
          background-color: #333333;
          color: white;
          text-align: center;
        }

        .userName{
          font-family: Times New Roman;
          font-style: normal;
          font-weight: normal;
          font-size: 24px;
          line-height: 28px;
          color: #CACACA;
        }

        .aboutTask{
        position: absolute;
        width: 673px;
        height: 91px;
        left: 50px;
        top: 138px;
        background: #FFFFFF;
        border-radius: 30px;
        }

        .textAboutTask{

        }
        .textCreator{
          position: absolute;
        left: 36px;
        top: 15px;
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 21px;
        line-height: 30px;
        /* identical to box height */
        color: #000000;

        }

        .textCreatorName{
        position: absolute;
        left: 100px;
        top: 15px;
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 20px;
        line-height: 30px;
        /* identical to box height */
        color: blue;
        }

        .textComplexityLevel{
        position: absolute;
        left: 150px;
        top: 50px;
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 20px;
        line-height: 30px;
        /* identical to box height */
        color: green;

        }

        .textComplexity{
        position: absolute;
        left: 36px;
        top: 50px;
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 21px;
        line-height: 30px;
        /* identical to box height */
        color: #000000;
        }

        .taskDescription{
        position: absolute;
        width: 673px;
        height: 674px;
        left: 50px;
        top: 285px;

        background: #FFFFFF;
        border-radius: 30px 30px 0px 0px;
        }

        .textInDescription{
        position: absolute;
        width: 592px;
        height: 204px;
        left: 37px;
        top: 10px;

        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 18px;
        line-height: 21px;

        color: #000000;
        }

        .exampleCode{
        width: 576px;
        height: 100px;
        background: #C4C4C4;
        border-radius: 30px;
        }

        .codeForCopy{
        text-align: center;
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;
        color: #000000;
        }

        .codeResult{
        text-align: center;
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;
        color: #000000;
        }

        p {
          font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;
        }

        .inputCode{
        position: absolute;
        width: 900px;
        height: 700px;
        left: 920px;
        top: 138px;
        }

        textarea{
          resize: none;
        }

        .sendTask-btn{
        position: absolute;
        width: 100px;
        height: 38px;
        left: 1720px;
        top: 850px;

         background-color: #4CAF50; /* Green */
         border: none;
         color: white;
         text-align: center;
         text-decoration: none;
         display: inline-block;
         font-size: 16px;
        }

        .runTask-btn{
        position: absolute;
        width: 100px;
        height: 38px;
        left: 920px;
        top: 850px;

         background-color: #F68500; /* Orange */
         border: none;
         color: white;
         text-align: center;
         text-decoration: none;
         display: inline-block;
         font-size: 16px;

        }

        .footerText{
        font-family: Times New Roman;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 28px;
        text-align: center;
        color: #CACACA;
        }

        .testcaseclass{
        position:relative;
        bottom: 100px;
        right: 300px;
        }

	</style>
</head>


<body style="background-color: #ebebeb;">
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #333333">
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-list-4" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <ul class="navbar-nav mr-auto">
      		<li class="nav-item active">
        		<a class="nav-link" href="#">ВЛ</a>
      		</li>
    	</ul>
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


<div class="row">
	<div class="arowBack">
		<a href="#" class="imageBack"><img src="images/blackback_arrow_50px.png" alt=""></a>
 		<p class="pageName" th:text="${task.title}" >Назва завдання</p>
	</div>
	<div class="aboutTask">
		<div >
			<div class="textCreator" >Автор: </div>
			<div class="textCreatorName" th:text="${task.author}" >User Name</div>
		</div>
	</div>
	<div class="taskDescription">
		<div class="textInDescription" th:text="${task.description}">
		</div>
	</div>

	<form action="#" th:action="@{/task/{id}(id=${id})}" th:object="${attempt}" method="post">
	<input  type="hidden" name="id" th:value="${id}"></input>
        <div class="workPlace">
            <div  th:if="${currentSolution != null}">
                <textarea class="inputCode" name="solution" id="solution" th:text="${currentSolution}"> ddd </textarea>
            </div>

            <input class="sendTask-btn" type="submit" ></input>
            <input class="runTask-btn" type="submit" ></input>

        </div>
    </form>
</div>
<div class="row">
        <div class="testcaseclass"  th:each="testcase : ${results}" >
            <div>
                <span th:text="${testcase.success}" > </span>
                <span th:text="${testcase.current}" > </span>
                <span th:text="${testcase.expected}" > </span>
            </div>
        </div>
</div>

    <div class="footer">
  		<p class="footerText">ВЛ 2020</p>
	</div>

 <script src = "js/jquery-3.3.1.min.js"></script>
 <script src = "js/bootstrap.min.js"></script>

</body>
</html>