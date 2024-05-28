<%--
  Created by IntelliJ IDEA.
  User: DONGWOOBAE
  Date: 2024-05-28
  Time: 오전 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Pretendard';
        }
    </style>
</head>
<body>
<table width="600">
    <tr>
        <th><h2>${dto.subject}</h2></th>
    </tr>
    <tr>
        <td><fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/></td>
        <td style="text-align: right;vertical-align: middle"><i class="bi bi-chat-dots"></i>댓글 조회수 ${dto.readcount}</td>
    </tr>
    <tr>
        <td colspan="2">
            <hr>
        </td>
    </tr>
    <tr>
        <td colspan="2" style="display: block; min-height: 250px;">
            <c:if test="${dto.uploadphoto!='no'}">
                <img src="../save/${dto.uploadphoto}" width="200px;">
            </c:if><br>
            ${dto.content}
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <hr>
        </td>
    </tr>
    <tr>
        <td>
            <c:if test="${sessionScope.loginok=='yes'}">
                <button type="button" class="btn btn-outline-success btn-sm"><i class="bi bi-pencil"></i>글쓰기</button>
                <button type="button" class="btn btn-outline-secondary btn-sm">답글</button>
            </c:if>
            <c:if test="${sessionScope.loginok=='yes' and sessionScope.loginid==dto.myid}">
                <button type="button" class="btn btn-outline-secondary btn-sm"
                        onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정
                </button>
                <button type="button" class="btn btn-outline-secondary btn-sm"
                        id="detailbtnDelete">삭제
                </button>
            </c:if>
        </td>
        <td align="right">
            <button type="button" class="btn btn-outline-secondary btn-sm"
                    onclick="location.href='./list?currentPage=${currentPage}'">목록
            </button>
            <button type="button" class="btn btn-outline-secondary btn-sm"
                    onclick="$('html, body').animate({ scrollTop: 0 }, 'fast');">top
            </button>
        </td>
    </tr>
</table>
<script>
    $("#detailbtnDelete").click(function () {
        let a = confirm("정말 삭제하시겠습니까?");
        if (a) {
            location.href = "./delete?num=${dto.num}&currentPage=${currentPage}";
        }
    });
</script>
</body>
</html>