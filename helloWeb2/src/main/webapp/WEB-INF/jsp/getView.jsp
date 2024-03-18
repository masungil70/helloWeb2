<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>get 방식으로 호출한 결과 출력</h1>
<c:forEach var="i" begin="1" end="10">
	<h3>변수 i = ${i} </h3>
</c:forEach>  
서블릿에서 설정한 배열을 출력한다
<table border="1"> 
<c:forEach var="user" items="${list}" varStatus="status">
	<tr>
		<td>${status.index % 2 == 0 ? "짝수" : "홀수"}</td>
		<td>
			<c:choose>
				<c:when test="${status.index % 2 == 0}">
					짝수
				</c:when>
				<c:otherwise>
					홀수
				</c:otherwise>
			</c:choose>
		</td>
		<td>${user.numberLabel}</td>
		<td>${status.count}</td>
		<td>${status.index}</td>
		<td>${user.userid}</td>
		<td>${user.username}</td>
		<td>${user.userage}</td>
		<td>${user.useremail}</td>
	</tr>
</c:forEach>
</table>
<h2><label>name = </label> ${param.name}</h2>
<h2><label>name = </label> ${param["name"]}</h2>
<h2><label>a = </label> ${a}</h2>
<h2><label>b = </label> ${b}</h2>
<h2><label>c = </label> ${c}</h2>
<h2><label>result = </label> ${result}</h2>
<h2>${result} = ${a} + ${b}</h2>
<h3>아이디 : ${users.userid}</h3>
<h3> 비번: ${users.userpassword}</h3>
<hr/>
map을 사용하는 것 
<h3>이름 : ${map.name}</h3>
<h3>나이: ${map.age}</h3>
<h3>나이: ${map["age"]}</h3>

</body>
</html>









