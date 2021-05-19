<meta charset="utf-8">
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
	<meta charset="utf-8">
	<title>Угадайка|Личный сайт студента GeekBrains</title>
	<link rel="stylesheet" href="styles.css">
	<script type="text/javascript">
	
		var symbolsArr= ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
		
		function write(fill,text) {
			document.getElementById(fill).innerHTML = text;
		}

		function readInt() {
			return +document.getElementById("passLength").value;
		}

		function getRandomSymbol(length) {
			var rnd;
			var generatedPass = "";

			for(i = 0; i < (length); i ++){
				rnd = parseInt(Math.random() * (symbolsArr.length - 1));
				generatedPass = generatedPass + symbolsArr[rnd];
			}
			write("password", generatedPass);
		}


		function generate() {
			write("result", "Ваш пароль:")
			getRandomSymbol(readInt())
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
				
				<h1>Генератор паролей</h1>

				<div class="box">

					<p id="info">Укажите из скольки символов сгенерировать пароль:</p>
					<input type="text" id="passLength">
					<br>
					<a href="#" onclick="generate()">Генерировать.</a>
					<br>
					<br>
					<br>
					<br>
					<br>
					<br>
					<p id="result"></p>
					<p id="password"></p>

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