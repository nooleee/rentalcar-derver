<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/header"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<section id="root">
		<input type="submit" value="게시글 작성">
			<div id="car-section">
				<h1>고객후기</h1>
					<div id="content">
				<!-- 차량 정보가 동적으로 로드될 공간 -->
					<c:forEach var="board" items="${boardList }">
						<h4><a href="/board/${board.code }">${board.title }</a></h4>
						<p>${board.contents }</p>
						<p>${board.userId }</p>
					</c:forEach>
				
				</div>
		</div>

		<div id="board-section">
			<div id="content">
				<!-- 게시판 글 내용이 동적으로 로드될 공간 -->
				
				<h1>메거진</h1>
			</div>
		</div>
	</section>
</body>
</html>