<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Список завдань</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/tasksList.css">
	<link rel="stylesheet" type="text/css" href="css/saarch.css">
	<style>
	    .button {
          position: absolute;
          right: 20px;
          top: 300px;
          background-color: #4CAF50; /* Green */
          border: none;
          color: white;
          padding: 15px 32px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 15px;
        }

        .custom-checkbox {
          position: absolute;
          z-index: -1;
          opacity: 0;
        }
        .custom-checkbox+label {
          display: inline-flex;
          align-items: center;
          user-select: none;
        }
        .custom-checkbox+label::before {
          content: '';
          display: inline-block;
          width: 1em;
          height: 1em;
          flex-shrink: 0;
          flex-grow: 0;
          border: 1px solid #adb5bd;
          border-radius: 0.25em;
          margin-right: 0.5em;
          background-repeat: no-repeat;
          background-position: center center;
          background-size: 50% 50%;
        }
        .custom-checkbox:checked+label::before {
          border-color: #0b76ef;
          background-color: #0b76ef;
          background-image: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23fff' d='M6.564.75l-3.59 3.612-1.538-1.55L0 4.26 2.974 7.25 8 2.193z'/%3e%3c/svg%3e");
        }

        .tasks{
          position: absolute;
          left: 80px;
          top: 200px;
        }

        .complexityName{
        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 36px;
        color: #000000;
        }
        .statusName{
        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 24px;
        line-height: 36px;
        color: #000000;
        }

        .filtr{
          position: absolute;
          right: 300px;
          top: 200px;
        }
        .taskName{
          font-family: Lora;
          font-style: normal;
          font-weight: normal;
          font-size: 24px;
          line-height: 30px;
          color: black;
        }

        .toRight{
          position: relative;
          left: 50px;
        }

        .taskTegs{
        background:  #D3D4DA;
        background: linear-gradient(90deg,  #D3D4DA 92%, rgba(26,121,9,1) 92%, rgba(82,255,0,1) 100%);

        }
        .rectangle {
        width: 900px;
        counter-reset: li;
        list-style: none;
        font: 14px "Trebuchet MS", "Lucida Sans";
        padding: 0;
        text-shadow: 0 1px 0 rgba(255,255,255,.5);
        }
        .rectangle a {
        position: relative;
        display: block;
        padding: .4em .4em .4em .8em;
        margin: .5em 0 .5em 2.5em;
        background: #D3D4DA;
        color: #444;
        text-decoration: none;
        transition: all .3s ease-out;
        }
        .rectangle a:hover {background: #DCDDE1;}
        .rectangle a:before {
        content: counter(li);
        counter-increment: li;
        position: absolute;
        left: -2.5em;
        top: 50%;
        margin-top: -1em;
        background: #9097A2;
        height: 2em;
        width: 2em;
        line-height: 2em;
        text-align: center;
        font-weight: bold;
        }
        .rectangle a:after {
        position: absolute;
        content: "";
        border: .5em solid transparent;
        left: -1em;
        top: 50%;
        margin-top: -.5em;
        transition: all .3s ease-out;
        }
        .rectangle a:hover:after {
        left: -.5em;
        border-left-color: #9097A2;
        }
        /*.container-for-task{
         position: absolute;
        width: 852px;
        height: 113px;
        left: 70px;
        top: 150px;
        background: white;
        border: solid;
        background: #FFFFFF;
        border: 1px solid #000000;
        box-sizing: border-box;
        border-radius: 30px 30px 0px 0px;

        font-family: Lora;
        font-style: normal;
        font-weight: normal;
        font-size: 20px;
        line-height: 25px;
        color: #000000;
        }
        .task{

        }



        .taskTegs{
          position: absolute;
          left: 25px;
          top: 25px;
          font-family: Lora;
          font-style: normal;
          font-weight: normal;
          font-size: 14px;
          line-height: 60px;
          color: black;
        }

        .Start-btn{
          position: absolute;
          right: 20px;
          top: 70px;
          font-family: Lora;
          font-style: normal;
          font-weight: normal;
          line-height: 0px;

          background-color: #4CAF50; /* Green
          border: none;
          color: white;
          padding: 15px 32px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
        }

        .taskStatus{
          position: absolute;
          right: 50px;
          top: 30px;
          font-family: Lora;
          font-style: normal;
          font-weight: normal;
          line-height: 0px;
        }*/

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
        /*//////////////////////////////////////////////////////////////////
        [ FONT ]*/

        @font-face {
          font-family: Raleway-Regular;
          src: url('../fonts/raleway/Raleway-Regular.ttf');
        }

        @font-face {
          font-family: Raleway-Medium;
          src: url('../fonts/raleway/Raleway-Medium.ttf');
        }

        @font-face {
          font-family: Raleway-SemiBold;
          src: url('../fonts/raleway/Raleway-SemiBold.ttf');
        }

        @font-face {
          font-family: Raleway-Bold;
          src: url('../fonts/raleway/Raleway-Bold.ttf');
        }


        a {
          font-family: Lora;
          font-style: normal;
          font-weight: normal;
          font-size: 24px;
          line-height: 30px;
          color: black;
        }

        p {
          font-family: Raleway-Regular;
          font-size: 14px;
          line-height: 1.7;
          color: #666666;
          margin: 0px;
        }

        ul, li {
          margin: 0px;
          list-style-type: none;
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


        .wrap-login100 {
          width: 560px;
          background: #fff;
          border-radius: 60px;
          position: relative;
        }


        /*==================================================================
        [ Form ]*/

        .login100-form {
          width: 100%;
        }

        .login100-form-title {
          font-family: Raleway-Medium;
          font-size: 30px;
          color: #555555;
          line-height: 1.2;
          text-transform: uppercase;
          text-align: left;

          width: 100%;
          display: block;
        }



        /*------------------------------------------------------------------
        [ Input ]*/

        .wrap-input100 {
          width: 100%;
          position: relative;
          background-color: #fff;
          border: 1px solid #e6e6e6;
          border-radius: 2px;
        }


        /*---------------------------------------------*/
        .input100 {
          font-family: Raleway-Medium;
          color: #555555;
          line-height: 1.2;
          font-size: 18px;

          display: block;
          width: 100%;
          background: transparent;
          height: 55px;
          padding: 0 25px 0 25px;
        }
        /*------------------------------------------------------------------
        [ Focus Input ]*/

        .focus-input100 {
          position: absolute;
          display: block;
          width: calc(100% + 2px);
          height: calc(100% + 2px);
          top: -1px;
          left: -1px;
          pointer-events: none;
          border: 1px solid #57b846;
          border-radius: 3px;

          visibility: hidden;
          opacity: 0;

          -webkit-transition: all 0.4s;
          -o-transition: all 0.4s;
          -moz-transition: all 0.4s;
          transition: all 0.4s;

          -webkit-transform: scaleX(1.1) scaleY(1.3);
          -moz-transform: scaleX(1.1) scaleY(1.3);
          -ms-transform: scaleX(1.1) scaleY(1.3);
          -o-transform: scaleX(1.1) scaleY(1.3);
          transform: scaleX(1.1) scaleY(1.3);
        }

        .input100:focus + .focus-input100 {
          visibility: visible;
          opacity: 1;

          -webkit-transform: scale(1);
          -moz-transform: scale(1);
          -ms-transform: scale(1);
          -o-transform: scale(1);
          transform: scale(1);
        }

        .eff-focus-selection {
          visibility: visible;
          opacity: 1;

          -webkit-transform: scale(1);
          -moz-transform: scale(1);
          -ms-transform: scale(1);
          -o-transform: scale(1);
          transform: scale(1);
        }

        /*---------------------------------------------*/
        .btn-show-pass {
          font-size: 15px;
          color: #999999;

          display: -webkit-box;
          display: -webkit-flex;
          display: -moz-box;
          display: -ms-flexbox;
          display: flex;
          align-items: center;
          position: absolute;
          height: 100%;
          top: 0;
          right: 12px;
          padding: 0 5px;
          cursor: pointer;
          -webkit-transition: background 0.4s;
          -o-transition: background 0.4s;
          -moz-transition: background 0.4s;
          transition: background 0.4s;
        }

        .btn-show-pass:hover {
          color: #57b846;
        }

        .btn-show-pass.active {
          color: #57b846;
        }

        /*==================================================================
        [ Restyle Checkbox ]*/

        .input-checkbox100 {
          display: none;
        }

        .label-checkbox100 {
          font-family: Raleway-Regular;
          font-size: 13px;
          color: #999999;
          line-height: 1.4;

          display: block;
          position: relative;
          padding-left: 26px;
          cursor: pointer;
        }

        .label-checkbox100::before {
          content: "\f00c";
          font-family: FontAwesome;
          font-size: 13px;
          color: transparent;

          display: -webkit-box;
          display: -webkit-flex;
          display: -moz-box;
          display: -ms-flexbox;
          display: flex;
          justify-content: center;
          align-items: center;
          position: absolute;
          width: 18px;
          height: 18px;
          border-radius: 2px;
          background: #fff;
          border: 1px solid #e6e6e6;
          left: 0;
          top: 50%;
          -webkit-transform: translateY(-50%);
          -moz-transform: translateY(-50%);
          -ms-transform: translateY(-50%);
          -o-transform: translateY(-50%);
          transform: translateY(-50%);
        }

        .input-checkbox100:checked + .label-checkbox100::before {
          color: #57b846;
        }


        /*------------------------------------------------------------------
        [ Button ]*/
        .container-login100-form-btn {
          width: 100%;
          display: -webkit-box;
          display: -webkit-flex;
          display: -moz-box;
          display: -ms-flexbox;
          display: flex;
          flex-wrap: wrap;
        }

        .login100-form-btn {
          font-family: Raleway-Bold;
          font-size: 16px;
          color: #fff;
          line-height: 1.02;

          display: -webkit-box;
          display: -webkit-flex;
          display: -moz-box;
          display: -ms-flexbox;
          display: flex;
          justify-content: center;
          align-items: center;
          padding: 0 200px;
          min-width: 150px;
          height: 55px;
          background-color: #333333;
          border-radius: 27px;

          -webkit-transition: all 0.4s;
          -o-transition: all 0.4s;
          -moz-transition: all 0.4s;
          transition: all 0.4s;
        }

        .login100-form-btn:hover {
          background-color: #57b846;
        }


        /*------------------------------------------------------------------
        [ Alert validate ]*/

        .validate-input {
          position: relative;
        }

        .alert-validate .btn-show-pass {
          visibility: hidden;
        }

        .alert-validate::before {
          content: attr(data-validate);
          position: absolute;
          max-width: 70%;
          background-color: #fff;
          border: 1px solid #c80000;
          border-radius: 3px;
          padding: 4px 25px 5px 10px;
          top: 50%;
          -webkit-transform: translateY(-50%);
          -moz-transform: translateY(-50%);
          -ms-transform: translateY(-50%);
          -o-transform: translateY(-50%);
          transform: translateY(-50%);
          right: 12px;
          pointer-events: none;

          font-family: Raleway-Medium;
          color: #c80000;
          font-size: 14px;
          line-height: 1.4;
          text-align: left;

          visibility: hidden;
          opacity: 0;

          -webkit-transition: opacity 0.4s;
          -o-transition: opacity 0.4s;
          -moz-transition: opacity 0.4s;
          transition: opacity 0.4s;
        }

        .alert-validate::after {
          content: "\f12a";
          font-family: FontAwesome;
          display: block;
          position: absolute;
          color: #c80000;
          font-size: 18px;
          top: 50%;
          -webkit-transform: translateY(-50%);
          -moz-transform: translateY(-50%);
          -ms-transform: translateY(-50%);
          -o-transform: translateY(-50%);
          transform: translateY(-50%);
          right: 18px;
        }

        .alert-validate:hover:before {
          visibility: visible;
          opacity: 1;
        }

        @media (max-width: 992px) {
          .alert-validate::before {
            visibility: visible;
            opacity: 1;
          }
        }

        .rowLayout {
          display: inline;
        }

        /*//////////////////////////////////////////////////////////////////
        [ Responsive ]*/

        @media (max-width: 576px) {
          .wrap-login100 {
            padding-left: 15px;
            padding-right: 15px;
          }
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

    <form >
        <div class="limiter">
            <div class="container-login100">
                <div class="container">
                    <a href="#" class="imageBack"><img src="images/blackback_arrow_50px.png" alt=""></a>
                    <p class="pageName">Список завдань</p>
                    <!-- Load icon library -->
                    <div class="search" action="/action_page.php" style="margin:auto;max-width:300px">
                    <input type="text" placeholder="Пошук.." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </div>
                <div class="tasks">
                    <ul th:if="${tasks.empty}">
                        <li colspan="2"> No Task Available </li>
                    </ul>
                    <ol class="rectangle">
                        <li th:each="task : ${tasks}" >
                            <div class="taskTegs">
                                <a class="taskName" th:href="@{/task/{id}(id=${task.id})}" th:text="${task.title}">Назва завдання</a>
                                <ul>
                                    <span class="rowLayout" th:each ="label : ${task.labels}"  th:text="${label.text + ' '} ">Labels</span>
                                </ul>
                            </div>
                        </li>
                    </ol>
                </div>
                <!--<div class="container-for-task">
                    <div class="task">
                        <div class="taskName">
                            Name our task
                        </div>
                        <div class="taskTegs">
                            #asdasd, #asdasd, #asdsad
                        </div>
                        <div class="taskStatus">
                            Green
                        </div>
                        <button class="Start-btn">Start</button>
                    </div>
                </div>	-->
                    <div class="filtr">
                        <div class="taskStatus">
                            <div class="statusName">
                                Статус завдання
                            </div>
                            <div class="">
                              <input type="checkbox" class="custom-checkbox" id="complete" name="complete">
                              <label for="complete">Виконані</label>
                            </div>

                            <div>
                              <input type="checkbox" class="custom-checkbox" id="uncomplete" name="uncomplete">
                              <label for="uncomplete">Невиконані</label>
                            </div>

                            <div>
                              <input type="checkbox"  class="custom-checkbox" id="onWork" name="onWork">
                              <label for="onWork">Виконуються</label>
                            </div>
                        </div>
                        <div class="taskComplexity">
                            <div class="complexityName">
                                Складність завдання
                            </div>
                            <div>
                              <input type="checkbox" class="custom-checkbox" id="easy" name="easy">
                              <label for="easy">Простий</label>
                            </div>

                            <div>
                              <input type="checkbox" class="custom-checkbox" id="medium" name="medium">
                              <label for="medium">Середній</label>
                            </div>

                            <div>
                              <input type="checkbox" class="custom-checkbox" id="hard" name="hard">
                              <label for="hard">Складний</label>
                            </div>
                        </div>
                        <div class="forButton">
                            <button class="button">Застосувати</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>

    <div class="footer">
        <p class="footerText">ВЛ 2020</p>
    </div>

    <script src = "js/jquery-3.3.1.min.js"></script>
    <script src = "js/bootstrap.min.js"></script>
</body>
</html>