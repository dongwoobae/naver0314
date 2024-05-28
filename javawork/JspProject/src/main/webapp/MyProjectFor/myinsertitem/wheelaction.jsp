<%@page import="data.dto.WheelDto"%>
<%@page import="data.dao.WheelDao"%>
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
WheelDao dao = new WheelDao();

try{
multi=new MultipartRequest(request,realFolder,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());
String name=multi.getParameter("name");
String price=multi.getParameter("price");
String company=multi.getParameter("company");
String photo=multi.getFilesystemName("photo");

WheelDto dto = new WheelDto();
dto.setCompany(company);
dto.setName(name);
dto.setPhoto(photo);
dto.setPrice(price);

dao.insertWheel(dto);
response.sendRedirect("wheelinsert.jsp");
}catch(Exception e){%>
<script>
	alert("파일 업로드 오류: <%=e.getMessage()%>");
	</script>
<%}

%>
