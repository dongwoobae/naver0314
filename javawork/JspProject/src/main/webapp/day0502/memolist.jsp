<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="data.dto.MemoDao"%>
<%@page import="data.dao.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <!--��Ʈ��Ʈ��-->
    <!-- Latest compiled and minified CSS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <!--�۲�-->
    <link
      href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
      rel="stylesheet"
    />
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css"
    />
    <style>
      body * {
        font-family: "Gowun Batang";
      }
    </style>
  </head>
  <%
  
  MemoDao dao=new MemoDao();
  List <MemoDto> list = dao.getAllMemo();
  SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");  
  %>
  <body>
    <div style="margin: 10px; width: 500px">
      <table class="table table-striped">
        <caption align="top">
          <h5><b>총 <%=list.size()%>개의 메모가 있습니다</b></h5>
          <button
            type="button"
            class="btn btn-success btn-sm"
            style="float: right"
            onclick="location.href='memoform.jsp'"
          >
            메모 추가
          </button>
        </caption>
        <tr class="talbe-info">
          <th width="60">번호</th>
          <th width="300">제목</th>
          <th>작성일</th>
        </tr>
        <% int n=0; for(MemoDto dto:list){ int no=list.size()-n++; %>
        <tr>
        <td><%=dto.getNum() %></td>
          <td>
            <a
              href="memodetail.jsp?num=<%=dto.getNum()%>"
              style="text-decoration: none; color: black"
              ><%=dto.getTitle()%></a
            >
          </td>
          <td><%=sdf.format(dto.getWriteday())%></td>
        </tr>
        <%} %>
      </table>
    </div>
  </body>
</html>
