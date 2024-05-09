$(document).ready(() => {
	$('#id').focusout(e => {
		if($('#id').val() === "") {
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-id').hide();
			$('#id').css('border', 'solid 1px lightgrey');
			$('#id').css('border-bottom', 'none');
		}
	});

	$('#password').focusout(e => {
		if ($('#password').val() === "") {
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-password').hide();
			$('#password').css('border', 'solid 1px lightgrey');
			$('#password').css('border-bottom', 'none');
		}
	});
	
	$('#name').focusout(e => {
		if ($('#name').val() === "") {
			$('#error-msg-name').show();
			$('#name').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-name').hide();
			$('#name').css('border', 'solid 1px lightgrey');
			$('#name').css('border-bottom', 'none');
		}
	});
	
	$('#birth').focusout(e => {
		if ($('#birth').val() === "") {
			$('#error-msg-birth').show();
			$('#birth').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-birth').hide();
			$('#birth').css('border', 'solid 1px lightgrey');
			$('#birth').css('border-bottom', 'none');
		}
	});
	
	$('#gender').focusout(e => {
		if ($('#gender').val() === "") {
			$('#error-msg-gender').show();
			$('#gender').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-gender').hide();
			$('#gender').css('border', 'solid 1px lightgrey');
			$('#gender').css('border-bottom', 'none');
		}
	});
	
	$('#phone').focusout(e => {
		if ($('#phone').val() === "") {
			$('#error-msg-phone').show();
			$('#phone').css('border', 'solid 1px tomato');
		} else {
			$('#error-msg-phone').hide();
			$('#phone').css('border', 'solid 1px lightgrey');
			$('#phone').css('border-bottom', 'none');
		}
	});
		
	$('form').submit(e => {
		e.preventDefault();
		
		const id = $('#id').val();
		const password = $('#password').val();
		
		// 유효성 검사
		let isValid = true;
		
		if(id === '') {
			isValid = false;
			$('#error-msg-id').show();
			$('#id').css('border', 'solid 1px tomato');
		} 
		if(password === '') {
			isValid = false;
			$('#error-msg-password').show();
			$('#password').css('border', 'solid 1px toamto');
		}

		if(isValid) {
			e.target.submit();
		}
	});	
})