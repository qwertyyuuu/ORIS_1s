
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add</title>
</head>
<body>
	<jsp:include page="/jsp/Header.jsp" />
	<div class="mt-3 ml-3">
		<form action="" method="post" class="w-50 mx-auto">
			<div class="mb-3">
				<label for="title" class="form-label">Название поста</label>
				<input name="title" type="text" class="form-control" id="title">
			</div>

			<div class="mb-3">
				<label for="text" class="form-label">Текст поста</label>
				<textarea rows="9" name="text" class="form-control" id="text"></textarea>
			</div>

			<button class="btn btn-outline-primary">Добавить</button>
		</form>
	</div>
</body>
</html>
