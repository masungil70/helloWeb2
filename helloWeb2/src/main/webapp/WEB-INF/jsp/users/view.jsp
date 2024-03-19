<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User insert form</title>
    <style>
        label {
            display: inline-block;
            width: 200px;
        }
        input {
            margin-bottom: 10px; 
        }
    </style>
</head>
<body>
    <h1>
        view 임시 화면
    </h1>
   
      <label>아이디 : ${user.userid}</label> <br/>
      <label>이름 : ${user.username}</label><br/>
      <label>나이: ${user.userage}</label><br/>
      <label>이메일: ${user.useremail}</label><br/>

<script>
function jsDelete() {
	if (confirm("정말로 삭제하시겠습니까?")) {
		//서버의 URL을 설정한다 
		viewForm.action = "delete.jsp";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}
}

function jsUpdateForm() {
	if (confirm("정말로 수정하시겠습니까?")) {
		//서버의 URL을 설정한다 
		viewForm.action = "updateForm.jsp";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}	
}
</script>
<!-- 두개의 폼을 하나로 합치는 방법 , js를 사용하여 처리  -->
	<form id="viewForm" method="post">
		<input type="hidden" name="userid" value="${user.userid}">
		<input type="button" value="삭제" onclick="jsDelete()">
		<input type="button" value="수정" onclick="jsUpdateForm()">
	</form>     
 
	<form action="delete.jsp" method="post">
		<input type="hidden" name="userid" value="${user.userid}">
		<input type="submit" value="삭제">
	</form>     
	
	<form action="updateForm.jsp" method="post">
		<input type="hidden" name="userid" value="${user.userid}">
		<input type="submit" value="수정">
	</form>     
	
    <div>
        <a href="list.jsp">목록</a>
        <a href="updateForm.jsp?userid=${user.userid}">수정</a>
        <a href="delete.jsp?userid=${user.userid}">삭제</a>
    </div>
</body>
</html>

