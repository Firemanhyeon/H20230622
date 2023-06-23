<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
	<h3>상세화면입니다(boardOne.jsp)</h3>
	
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
		<form action = "modifyForm.do" method="post" name="myFrm">
			<input type = "hidden" name = "bno" value="<%=vo.getBrdNo() %>">
	    <table border="1" class= "table">
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
            <tr>
            	<td colspan = "2" align = "center">
            		<button type="submit" >수정</button>
            		<button type= "button">삭제</button>
            	</td>
            </tr>
        </table>
    <%
	   }
    %>
        </form>
    <a href="boardList.do">목록으로이동</a>
    
    <script >
      console.log(this);
    	document.querySelector('form[name="myFrm"] button[type = "button"]').addEventListener('click',function(e){
        console.log(e);
        document.forms.myFrm.action = "boardRemove.do";
        document.forms.myFrm.submit();

        // window.location.href = "boardRemove.do?bno=3"//얘도삭제임
        
      });
    </script>
<jsp:include page ="footer.jsp"></jsp:include>