<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section id="root">
		<div id="car-section">
			<h1>고객후기</h1>
			<div id="content">
				<!-- 차량 정보가 동적으로 로드될 공간 -->
					<h4>
						<a> ${board.code } ${board.title }</a>
					</h4>
					<p>${board.userId }</p>
					<p>${board.contents }</p>
			</div>
		</div>
	</section>
</body>
</html>