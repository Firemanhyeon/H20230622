<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardOne.jsp</title>
</head>
<body>
	<%
		BoardVO vo = (BoardVO) request.getAttribute("board");
	%>
	
	<%
	  if(vo==null){
	%>
	  <p>조회된결과값이 없습니다</p>
	<%
	  }else{
	%>
	    <table border="1">
            <tr>
                <th>제목</th>
                <td><input type="text" name="title" value = "<%=vo.getBrdTitle()%>"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" name="writer"value = "<%=vo.getBrdWriter()%>"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><textarea name="content" cols="30" rows="10"><%=vo.getBrdContent()%></textarea></td>
            </tr>
            
        </table>
    <%
	   }
    %>
    <a href="boardList.do">목록으로이동</a>
</body>
</html>