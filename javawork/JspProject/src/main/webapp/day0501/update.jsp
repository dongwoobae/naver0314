<%@page import="java.sql.Timestamp"%>
<%@page import="data.dao.StudentDao"%>
<%@page import="data.dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//encoding
request.setCharacterEncoding("UTF-8");
//dao,dto
StudentDto dto = new StudentDto();
StudentDao dao = new StudentDao();

int num=Integer.parseInt(request.getParameter("num"));
String name=request.getParameter("name");
String blood=request.getParameter("blood");
char license=request.getParameter("license")==null?'n':'y';
int java=Integer.parseInt(request.getParameter("java"));
int spring=Integer.parseInt(request.getParameter("spring"));
int html=Integer.parseInt(request.getParameter("html"));


dto.setNum(num);
dto.setName(name);
dto.setBlood(blood);
dto.setLicense(license);
dto.setJava(java);
dto.setSpring(spring);
dto.setHtml(html);

boolean success=true;
try{
	dao.updateStudent(dto);
} catch(Exception e){
	success=false;
}
if(success){
%>
<script>
alert("수정 완료!");
window.location.href="detail.jsp?num=<%=num%>";
</script>
<%
}else{}
%>