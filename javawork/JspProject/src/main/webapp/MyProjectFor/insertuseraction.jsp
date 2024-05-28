<%@page import="data.dto.UserDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="data.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

int uploadSize=1024*1024*10;
ServletContext context=getServletContext();
String realFolder=context.getRealPath("/save");

MultipartRequest multi=null;
UserDao dao = new UserDao();
try{
multi=new MultipartRequest(request,realFolder,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());

String username=multi.getParameter("username");
String userphoto=multi.getFilesystemName("userphoto");
String useraddr=multi.getParameter("useraddr");
int userage=Integer.parseInt(multi.getParameter("userage"));
String userclass=multi.getParameter("userclass");

UserDto dto = new UserDto();
dto.setAge(userage);
dto.setInfoname(username);
dto.setUseraddr(useraddr);
dto.setUserphoto(userphoto);
dto.setUserclass(userclass);

dao.insertUserinfo(dto);
response.sendRedirect("MainPage.jsp");
} catch(Exception e){%>
	<script>
	alert("파일 업로드 오류: ")+e.getMessage();
	</script>
<%}

%>