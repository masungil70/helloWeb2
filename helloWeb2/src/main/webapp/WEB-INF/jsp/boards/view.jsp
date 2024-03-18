<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시물 상세보기</title>
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
        게시물 상세보기
    </h1>
   
      <label>게시물 번호: ${board.bno}</label> <br/>
      <label>제목 : ${board.btitle}</label><br/>
      <label>내용 : ${board.bcontent}</label><br/>
      <label>작성자 : ${board.bwriter}</label><br/>
      <label>작성일 : ${board.bdate}</label><br/>

<script>
function jsDelete() {
	if (confirm("정말로 삭제하시겠습니까?")) {
		//서버의 URL을 설정한다 
		action.value = "delete";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}
}

function jsUpdateForm() {
	if (confirm("정말로 수정하시겠습니까?")) {
		//서버의 URL을 설정한다 
		action.value = "updateForm";
	
		//서버의 URL로 전송한다 
		viewForm.submit();
	}	
}
</script>
<!-- 두개의 폼을 하나로 합치는 방법 , js를 사용하여 처리  -->
	<form id="viewForm" method="post" action="boards">
		<input type="hidden" id="action" name="action" value="">
		<input type="hidden" name="bno" value="${board.bno}">
		<input type="button" value="삭제" onclick="jsDelete()">
		<input type="button" value="수정" onclick="jsUpdateForm()">
	</form>     
 
    <div>
        <a href="boards?action=list">목록</a>
        <a href="boards?action=updateForm&bno=${board.bno}">수정</a>
        <a href="boards?action=delete&bno=${board.bno}">삭제</a>
    </div>
</body>
</html>

