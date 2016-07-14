<%--
  Created by IntelliJ IDEA.
  User: Владислав
  Date: 14.07.2016
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Жанр</title>
    <!--<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">-->
    <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>-->
    <!--<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<header>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="movies.html">КиноРейтинг</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="movies.html">Фильмы</a></li>
                    <li><a href="persons.html">Личности</a></li>
                    <li><a href="users.html">Пользователи</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Прочее <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="genres.html">Жанры</a></li>
                            <li><a href="countries.html">Страны</a></li>
                        </ul>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Выход</a></li>
                    <li class="active"><a href="#">RU</a></li>
                    <li><a href="#">EN</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<main class="container">
    <div class="jumbotron">
        <h3>Триллер</h3>
        <p>Три́ллер (от англ. thrill — трепет, волнение) — жанр произведений литературы и кино, нацеленный вызвать у зрителя или читателя внезапный прилив эмоций, чувство тревоги, возбуждение. Жанр не имеет чётких границ, элементы триллера присутствуют во многих произведениях разных жанров. В кинематографе к триллерам зачастую относят детективные и шпионские фильмы, фильмы ужасов, приключенческие фильмы, а также гангстерские фильмы и фильмы жанра нуар.</p>
        <form action="forms/genre-form.html" method="post" role="form">
            <div class="form-group">
                <button type="submit" class="btn btn-success">Редактировать</button>
            </div>
        </form>
        <form action="#" method="post" role="form">
            <div class="form-group">
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#remove-modal">Удалить</button>
            </div>
        </form>
    </div>
    <div id="remove-modal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Подтверждение удаления</h4>
                </div>
                <div class="modal-body">
                    <p>Вы уверены что хотите произвести удаление?</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-danger">Удалить</a>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                </div>
            </div>
        </div>
    </div>
</main>
<footer class="container-fluid">
    <p class="text-center">EPAM Training Center, Java 5 2016, Kostevich Vladislav</p>
</footer>
</body>
</html>