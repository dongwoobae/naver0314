<%--
  Created by IntelliJ IDEA.
  User: DONGWOOBAE
  Date: 2024-05-28
  Time: 오전 9:46
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
<c:if test="${sessionScope.loginok==null}">
    <script>
        alert("먼저 로그인 후 글을 작성해주세요");
        history.back();
    </script>
</c:if>
<c:set var="stPath" value="https://kr.object.ncloudstorage.com/bitcamp-bucket-56/photocommon"/>
<script>
    function preview(tag) {
        if (tag.files[0]) {
            let f = tag.files[0];
            //   let reg = /(.*?)\/(jpg|jpeg|png|gif)$/;
            //   //type이 file인 경우 배열타입으로 넘어와서 [0]을 붙여준다
            //   if (!f.type.match(reg)) {
            //     alert("이미지 파일만 가능합니다");
            //     retrun;
            //   }
            //아래와 같이 작성해도 됨
            if (!f.type.match("image.*")) {
                alert("이미지 파일만 가능합니다");
                return;
            }
            if (f) {
                let reader = new FileReader();
                reader.onload = function (e) {
                    $("#showimg1").attr("src", e.target.result);
                };
                reader.readAsDataURL(tag.files[0]);
            }
        }
    }
</script>
<body>
<form action="./update" method="post" enctype="multipart/form-data">
    <table class="table" style="width: 600px;">
        <caption align="top">
            <h4><b>글 수정</b></h4>
        </caption>
        <input type="hidden" name="num" value="${dto.num}">
        <input type="hidden" name="currentPage" value="${currentPage}">
        <tbody>
        <tr>
            <th width="100" class="table-warning">제목</th>
            <td>
                <input type="text" name="subject" required="required" value="${dto.subject}" class="form-control">
            </td>
            <td rowspan="4" style="border-color: white"><h4>Preview</h4><img src="${stPath}/${dto.uploadphoto}"
                                                                             onerror="this.src='../image/noimage1.png'"
                                                                             id="showimg1" style="width: 200px;"><br>
            <b>사진을 선택하지 않으면 기존사진이 유지됩니다</b></td>
        </tr>
        <tr>
            <th class="table-warning">사진</th>
            <td>
                <input type="file" name="upload" id="upload" class="form-control"
                       onchange="preview(this)">
            </td>
        </tr>
        <tr>
            <td colspan="2" class="table-warning">
                <textarea name="content" cols="30" rows="10" placeholder="내용을 입력하세요"
                          style="width: 100%;" required>${dto.content}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center" class="table-warning">
                <button type="submit" class="btn btn-primary" style="width: 100px;">글 수정</button>
                <button type="button" class="btn btn-secondary" style="width: 100px;"
                        onclick="history.back()">이전으로
                </button>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>