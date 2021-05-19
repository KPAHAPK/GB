<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>ГлавнаяЛичный сайт студента GeekBrains</title>
	<link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="content">
	
	<?php
		include "menu.php";
	?>

	<h1>Личный сайт студента GeekBrains</h1>

	<div class="center">
		<img src="img/Programmist.jpg">
		<div class="box_text">
			<p><b>Добрый день.</b><br>. Меня зовут <i>Роман Захаров</i>. Я совсем недавно начал программировать. однако уже написал свой первый сайт.</p>

			<p>В этом мне помог IT-портал <a href='https://geekbrains.ru'>GeekBrains</a>.</p>

			<p>На этом сайте вы можете сыграть в несколько игр, которые я написал: <br>
			<a href = 'index.php'>Главная,</a>
			<a href = 'puzzle.php'>Загадки,</a>
			<a href = 'guess.php'>Угадайка,</a>
			<a href = 'guess_multiplayer.php'>Угадайка мультиплеер.</a>
			<a href = 'Password.php'>Генератор паролей</a>
			</p>
		</div>
	</div>
</div>
<div class="footer">
	Copyright &copy; <?php echo date("Y");?> Roman Zakharov
</div>

</body>
</html>