<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userFinding</title>
<!-- <link href="../CSS/public/header.css" type="text/css" rel="stylesheet"> -->
<link href="/css/public/footer.css" type="text/css" rel="stylesheet">
<link href="/css/public/header.css" type="text/css" rel="stylesheet">
<link href="/css/public/nav.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="/css/userFindingAlt.css">
</head>
<body>

	

	<div class="testContainer"><!-- IHM ììë¡ ì¶ê°í ì»¨íì´ë ë°ì¤ -->

		<header id="header" class="footer"></header>
		<nav class="bannerBgr">
			<div class="Banner">
				<div class="pageTitle"><span class="mainName">ìì´ë ì°¾ê¸°</span></div>
				<div class="pageRoute">í > <span class="mainName">ìì´ë ì°¾ê¸°</span></div>
			</div>
		</nav><Br><Br>
		<main>
			<div class="container">
				<input type="button" onclick="ID()" value="ìì´ë ì°¾ê¸°" id="id" class="btn"><input
					type="button" onclick="PW()" value="ë¹ë°ë²í¸ ì°¾ê¸°" id="pw" class="btn">
			</div>
			<br> <br> <br>
			<div class="container">
				<div class="checkBtn">
					<img src="/images/check-button.jpg"
						style="width: 100%; height: auto;">
				</div>
				<span class="choose" id="choose">ìì´ë
					ì°¾ê¸° ë³¸ì¸ì¸ì¦</span>
			</div>
			<Br> <br><Br>
			<div class="container">
				<div class="modalBtnBox">
					<a id="modalOpenButton" class="modalOpenButton"><img
						src="/images/userfind.png" style="height: 100%; width: auto;"></a>
				</div>
			</div>
			<div class="container"> <!-- ìì¹ë¥¼ main ë°ê¹¥ìì main ìì¼ë¡ ë³ê²½ -->
				<span class="choose">ì¸ì¦ì í´ì£¼ì¸ì.</span>
			</div>
		</main>
	
	
	
		<div id="modalContainer" class="hidden">
			<div id="modalContent" class="modalContent">
				<h3 style="text-align:center;"><b class="mainName">ìì´ë ì°¾ê¸°</b></h3>
				<br>
				<form action="userFinding-perform" method="post">
					<table id="table">
						<tr>
							<td class="text"><div>ì´ë©ì¼</div></td>
							<td class="input"><input type="text" name="#" class="short"> @ <input type="text" name="#" class="short"></td>
						</tr>
						<tr>
							<td class="text"><div>ì±ëª</div></td>
							<td class="input"><input type="text" name="#"></td>
						</tr>
						<tr>
							<td class="text"><div>ìëìì¼</div></td>
							<td class="input"><input type="text" name="#"><br>
								<span>* ìë ¥ ì : 2000-10-10</span>
							</td>
						</tr>
					</table>
					<div class="submitBtn"><input type="submit" value="íì¸"></div>
				</form>
				<button id="modalCloseButton"><img src="/images/x-icon.png" style="width:100%; height:auto;"></button>
			</div>
		</div>

		<footer id="footer" class="footer"></footer>

	</div><!-- ì¬ê¸°ê¹ì§ê° íì¤í¸ ì»¨íì´ë -->
	
	

	

	<script defer src="/js/HeadFoot.js" type="text/javascript"></script>
	<script src="/js/userFinding.js"></script>
</body>
</html>