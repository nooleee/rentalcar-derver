$(document).ready(() => {
	$('#id').change(e => {
		const id = $('#id').val();
		console.log(id);
		
		if(id !== '') {
			$.ajax({
				"method": "POST",
				"url": `/FindUserAction?id=${id}`
			}).done(response => {
				console.log(response);
				
				if(!response.isValid) {
					$('#id').val('');
					$('#error-msg-id-dupl').show();
				} else {
					$('#error-msg-id-dupl').hide();
				}
			})
		}
	})
	
});