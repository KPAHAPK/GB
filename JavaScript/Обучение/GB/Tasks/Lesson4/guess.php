<meta charset="utf-8">
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
	<meta charset="utf-8">
	<title>Угадайка|Личный сайт студента GeekBrains</title>
	<link rel="stylesheet" href="styles.css">
	<script type="text/javascript">
	
		var answer = parseInt(Math.random() * 100);
		var tryCount = 0;
		var maxTryCount = 3;
		
		function readInt() {
			var number = document.getElementById("userAnswer").value;
			return parseInt(number);
			//return +document.getElementById("userAnswer").value;
		}

		function write(text) {
			document.getElementById("info").innerHTML = text;

		}

		function hide(id) {
			document.getElementById(id).style.display = "none";
		}

		function guess() {
			tryCount ++;
			var userAnswer = readInt();
			if (userAnswer == answer) {
				write("<br>Поздравляю!<br>");
				hide("start");
				hide("userAnswer");
			} else if (tryCount >= maxTryCount) {
				write("<br>Вы проиграли<br> Правильный ответ: " + answer);
				hide("start");
				hide("userAnswer");
			} else if (userAnswer > answer){
				write("<br>Слишком большое число<br>");
			} else if (userAnswer < answer){
				write("<br>Слишком маленькое число<br>");
			}
			
		}
	</script>
</head>
<body>
	
	<meta charset="utf-8">
<div class="content">
	<?php
		include "menu.php";
	?>


	<div class="contentWrap">
		<div class="content">
			<div class="center">
				
				<h1>Игра угадайка</h1>

				<div class="box">

					<p id="info">Угадай число от 0 до 100</p>
					<input type="text" id="userAnswer">
					<br>
					<a href="#" id="start" onclick="guess()">Начать.</a>

				</div>
			</div>
		</div>
	</div>
</div>

<div class="footer">
Copyright &copy; Roman Zakharov
</div>

</body>
</html>