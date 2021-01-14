<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="newTask.css">
    <link href="../static/css/newTask.css" th:href="@{/css/newTask.css}" rel="stylesheet" />
	<title>Створення завдань</title>
	<style>
	    .nav-link{
          color: #CACACA;
          font-family: Times New Roman;
          font-style: normal;
          font-weight: normal;
          font-size: 24px;
          line-height: 37px;
        }

        .pageName{
        position: absolute;
        width: 275px;
        height: 45px;
        left: 70px;
        top: 80px;

        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 36px;
        line-height: 46px;
        color: #000000;

        }

        .imageBack{
          position: absolute; /* Абсолютное позиционирование */
          top: 80px; /* Положение от нижнего края */
          left: 5px; /* Положение от правого края */
        }

        .topnav-centered{
          float: none;
          position: absolute;
          font-family: Times New Roman;
          font-style: normal;
          font-weight: normal;
          font-size: 48px;
          line-height: 37px;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -50%);
          color: #CACACA;
        }

        .nav-to-right {
          float: right;
        }

        .footer{
         /* min-height:100%;*/
         background: #333333;
         flex: 0 0 auto;

        }

        .userName{
          font-family: Times New Roman;
          font-style: normal;
          font-weight: normal;
          font-size: 24px;
          line-height: 28px;
          color: #CACACA;
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

        body, html {
          height: 100%;
          font-family: Raleway-Regular, sans-serif;
        }

        .container-login100 {
          width: 100%;
          min-height: 89.4vh;
          display: -webkit-box;
          display: -webkit-flex;
          display: -moz-box;
          display: -ms-flexbox;
          display: flex;
          flex-wrap: wrap;
          justify-content: center;
          align-items: center;
          padding: 15px;

          background-color: #ebebeb;
        }

        .inputData{
        position: absolute;
        width: 200px;
        height: 45px;
        left: 75px;
        top: 180px;

        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;

        color: #000000;
        }

        input{
          border-radius: 25px;
        }

        .taskArea{
        position: absolute;
        width: 200px;
        height: 45px;
        left: 800px;
        top: 180px;

        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;

        color: #000000;
        }

        textarea{
          resize: none;
        }

        .testCases{
        position: absolute;
        width: 200px;
        height: 45px;
        left: 75px;
        top: 600px;

        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;

        color: #000000;
        }

        .select-css {
          display: block;
          font-size: 16px;
          font-family: sans-serif;
          font-weight: 700;
          color: #444;
          line-height: 1.3;
          padding: .6em 1.4em .5em .8em;
          width: 100%;
          max-width: 100%; /* useful when width is set to anything other than 100% */
          box-sizing: border-box;
          margin: 0;
          border: 1px solid #aaa;
          box-shadow: 0 1px 0 1px rgba(0,0,0,.04);
          border-radius: .5em;
          -moz-appearance: none;
          -webkit-appearance: none;
          appearance: none;
          background-color: #fff;
          /* note: bg image below uses 2 urls. The first is an svg data uri for the arrow icon, and the second is the gradient.
            for the icon, if you want to change the color, be sure to use `%23` instead of `#`, since it's a url. You can also swap in a different svg icon or an external image reference

          */
          background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),
            linear-gradient(to bottom, #ffffff 0%,#e5e5e5 100%);
          background-repeat: no-repeat, repeat;
          /* arrow icon position (1em from the right, 50% vertical) , then gradient position*/
          background-position: right .7em top 50%, 0 0;
          /* icon size, then gradient */
          background-size: .65em auto, 100%;
        }
        /* Hide arrow icon in IE browsers */
        .select-css::-ms-expand {
          display: none;
        }
        /* Hover style */
        .select-css:hover {
          border-color: #888;
        }
        /* Focus style */
        .select-css:focus {
          border-color: #aaa;
          /* It'd be nice to use -webkit-focus-ring-color here but it doesn't work on box-shadow */
          box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
          box-shadow: 0 0 0 3px -moz-mac-focusring;
          color: #222;
          outline: none;
        }

        /* Set options to normal weight */
        .select-css option {
          font-weight:normal;
        }

        /* Support for rtl text, explicit support for Arabic and Hebrew */
        *[dir="rtl"] .select-css, :root:lang(ar) .select-css, :root:lang(iw) .select-css {
          background-position: left .7em top 50%, 0 0;
          padding: .6em .8em .5em 1.4em;
        }

        /* Disabled styles */
        .select-css:disabled, .select-css[aria-disabled=true] {
          color: graytext;
          background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22graytext%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),
            linear-gradient(to bottom, #ffffff 0%,#e5e5e5 100%);
        }

        .select-css:disabled:hover, .select-css[aria-disabled=true] {
          border-color: #aaa;
        }
	</style>
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
<![CDATA[

    var message = /[[${message}]]/ 'default';
    console.log(message);

]]>
</script>