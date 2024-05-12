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
			<h1>차량 정보</h1>
			<div id="content">
				<!-- 차량 정보가 동적으로 로드될 공간 -->
					<h4>
						<a> ${cars.code} ${cars.name}</a>
					</h4>
					<p>${cars.color}</p>
					<p>네비게이션 : ${cars.navigation ? 'yes' : 'no'}</p>
					<p>선루프 : ${cars.sunroof ? 'yes' : 'no'}</p>
			</div>
		</div>
	</section>	
</body>
</html>