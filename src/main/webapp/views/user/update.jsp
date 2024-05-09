<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/style/form.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="/resources/script/validation-login.js"></script>
<script src="/resources/script/validation-password.js"></script>
</head>
<body>
	<section id="root">
		<h2>회원정보 수정</h2>
		<form method="POST" action="/UpdateAction">
			<div>
				<input type="text" id="id" name="id" value="${user.id}" disabled>
				<input type="password" id="password" name="password" placeholder="비밀번호">
				<input type="password" id="password-new" name="password-new" placeholder="새로운비밀번호">
				<input type="text" id="email" name="email" value="${not empty user.email ? user.email : ''}" placeholder="[선택] 이메일주소">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-password">* 비밀번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-password-dupl">* 비밀번호: 비밀번호가 일치하지 않습니다.</p>
				<p class="error-msg" id="error-msg-email">* 이메일: 이메일 주소가 정확한지 확인해 주세요.</p>
			</div>
			<div>
				<input type="text" id="name" name="name" placeholder="이름" value="${user.name}">
				<input type="text" id="birth" name="birth" placeholder="생년월일 8자리" value="${user.birth}">
				<div id="radio-container">
					<input type="radio" class="gender" id="gender-man"  ${user.gender eq 'M' ? 'checked' : '' } name="gender" value="M">
					<input type="radio" class="gender" id="gender-woman" ${user.gender eq 'F' ? 'checked' : '' } name="gender" value="F">
					<div>
						<label for="gender-man" id="gender-man-label"><div>남자</div></label>
						<label for="gender-woman" id="gender-woman-label"><div>여자</div></label>
					</div>
				</div>
				<input type="text" id="phone" name="phone" placeholder="휴대전화번호" value="${user.phone}">
			</div>
			<div class="error-container">
				<p class="error-msg" id="error-msg-name">* 이름: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-birth">* 생년월일: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-birth-pattern">* 생년월일은 8자리 숫자로 입력해주세요.</p>
				<p class="error-msg" id="error-msg-gender">* 성별: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone">* 휴대전화번호: 필수 정보입니다.</p>
				<p class="error-msg" id="error-msg-phone-pattern">* 휴대전화번호: 필수 정보입니다.</p>
				
			</div>
			<input type="submit" value="정보수정">
		</form>
	</section>
</body>
</html>