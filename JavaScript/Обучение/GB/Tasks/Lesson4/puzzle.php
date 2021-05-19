
<!DOCTYPE html>
<html>
<head>
	<title>Загадки|Личный сайт студента GeekBrains</title>
	<link rel="stylesheet" href="styles.css">

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
			
			<h1>Игра загадки</h1>

			<div class="box">

				<?php

					if (isset($_GET['userAnswer1']) && isset($_GET['userAnswer2']) && isset($_GET['userAnswer3']) && isset($_GET['userAnswer4'])){
						$score = 0;
						$userAnswer = $_GET["userAnswer1"];
						if($userAnswer == "сон" || $userAnswer == "сновидение"){
							$score ++;
						}
						$userAnswer = $_GET["userAnswer2"];
						if($userAnswer == "бегемот" || $userAnswer == "гиппопотам"){
							$score ++;
						}
						$userAnswer = $_GET["userAnswer3"];
						if($userAnswer == "ежик" || $userAnswer == "еж"){
							$score ++;
						}
						$userAnswer = $_GET["userAnswer4"];
						if($userAnswer == "козел" || $userAnswer == "коза"){
							$score ++;
						}

						echo "Вы угадали " . $score . " загадок.";
					}

				?>

				<form method="GET">	
					<p>Загадка №1: Заплелись густые травы, <br>Закудрявились луга, <br>Да и сам я весь кудрявый,<br>Даже завитком рога.</p>
					<input type="text" name="userAnswer1">
				
					<p>Загадка №2: У него огромный рот, <br>Он зовется …</p>
					<input type="text" name="userAnswer2">

					<p>Загадка №3: Ползун ползёт, <br>Иголки везёт.</p>
					<input type="text" name="userAnswer3">

					<p>Загадка №4: Не усат, а бородат, <br>И сердит на всех ребят, <br>Но не дедушка он всё же. <br>Угадайте, дети, кто же?</p>
					<input type="text" name="userAnswer4">

					<br>
					<input type="submit" value="Ответить" name="">
				</form>
				
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