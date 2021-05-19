<meta charset="utf-8">
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
	<meta charset="utf-8">
	<title>Личный сайт студента GeekBrains</title>
	<link rel="stylesheet" href="styles.css">
	<script type="text/javascript">
	
		var answer = parseInt(Math.random() * 100);
		var players = ["P1", "P2"];
		
		function readInt(userAnswer) {
			var number = document.getElementById(userAnswer).value;
			return parseInt(number);
			//return +document.getElementById("userAnswer").value;
		}

		function write(text, player) {
			
			document.getElementById(player).innerHTML = text;

		}

		function hide(id) {
			document.getElementById(id).style.display = "none";
		}

		function start(){
			guess("user1Answer", players[0]);
			guess("user2Answer", players[1]);
			
		}

		function guess(userAnswer, player) {
			var userAnswer = readInt(userAnswer);
			if (userAnswer == answer) {
				write("<br>Поздравляю! Ты победил!<br>", player);
				hide("start");
				hide("user1Answer");
				hide("user2Answer");
			} else if (userAnswer > answer){
				write("<br>Слишком большое число<br>", player);
			} else if (userAnswer < answer){
				write("<br>Слишком маленькое число<br>", player);
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
					<p>Игрок 1:</p><input type="text" id="user1Answer"><p id="P1"></p>
					<p>Игрок 2:</p><input type="text" id="user2Answer"><p id="P2"></p>
					<a href="#" id="start" onclick="start()">Ответить.</a>

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