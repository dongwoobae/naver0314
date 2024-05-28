
<%@page import="data.dto.DrivetrainDto"%>
<%@page import="data.dao.DrivetrainDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int uploadSize=1024*1024*10;
ServletContext context=getServletContext();
String realFolder=context.getRealPath("/save");

MultipartRequest multi=null;
DrivetrainDao dao = new DrivetrainDao();

try{
multi=new MultipartRequest(request,realFolder,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());
String name=multi.getParameter("name");
String price=multi.getParameter("price");
String company=multi.getParameter("company");
String photo=multi.getFilesystemName("photo");

DrivetrainDto dto = new DrivetrainDto();
dto.setCompany(company);
dto.setName(name);
dto.setPhoto(photo);
dto.setPrice(price);

dao.insertDrivetrain(dto);
response.sendRedirect("drivetraininsert.jsp");
}catch(Exception e){%>
<script>
	alert("파일 업로드 오류: <%=e.getMessage()%>");
	</script>
<%}

%>
