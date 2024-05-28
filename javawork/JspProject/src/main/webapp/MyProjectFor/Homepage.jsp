<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <!-- Latest compiled JavaScript -->
    <!--�۲�-->
    <link
      href="https://fonts.googleapis.com/css2?family=Dokdo&family=Dongle&family=Gaegu&family=Gowun+Batang&family=Reem+Kufi+Fun:wght@400..700&family=Song+Myung&family=Dancing+Script&family=Tilt+Neon&display=swap"
      rel="stylesheet"
    />
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	 <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="./style.css?after" rel="stylesheet" />
    <title>Document</title>
  </head>  	  
  <body class="homepage">
  <span class="mainpage-Sentence">Express<br>Your</span>
  <span class="mainpage-Sentence2">Life</span>
    <nav class="sidebar">
      <div class="logo-menu">
        <h2 class="logo"><a href="#">Admin</a></h2>
        <i class="bx bx-menu toggle-btn"></i>
      </div>
      <ul class="list">
        <li class="list-item active">
          <a href="#">
            <i class="bx bx-grid-alt"></i>
            <span class="link-name" style="--i: 1" id="dashboard">Dashboard</span>
          </a>
        </li>
        <li class="list-item">
          <a href="#">
            <i class="bx bx-user"></i>
            <span class="link-name" style="--i: 2">User</span>
          </a>
          <ul class="submenu">
            <li>Members</li>
            <li>Ranking</li>
            <li>UserPhotos</li>
          </ul>
        </li>
        <li class="list-item">
          <a href="#">
            <i class="bx bx-store-alt"></i>
            <span class="link-name" style="--i: 3">Bicycle</span>
          </a>
          <ul class="submenu">
            <li value="Frame"><a href="Framelist.jsp">Frame</a></li>
            <li value="Wheel"><a href="Wheellist.jsp">Wheel</a></li>
            <li value="Drivetrain"><a href="Drivetrainlist.jsp">Drivetrain</a></li>
            <li value="Others"><a href="Otherslist.jsp">Others</a></li>
          </ul>
        </li>
        <li class="list-item">
          <a href="#">
            <i class="bx bx-menu toggle-btn"></i>
            <span class="link-name" style="--i: 4">Accessories</span>
          </a>
          <ul class="submenu">
            <li>Helmet</li>
            <li>Goggle</li>
            <li>cycling computer</li>
            <li>blackbox</li>
          </ul>
        </li>
        <li class="list-item">
          <a href="#">
            <i class="bx bx-navigation"></i>
            <span class="link-name" style="--i: 5">Course</span>
          </a>
          <ul class="submenu">
            <li>east seoul</li>
            <li>west seoul</li>
            <li>gangwondo</li>
            <li>jeju</li>
          </ul>
        </li>
        <li class="list-item" id="cart">
          <a href="#">
            <i class="bx bx-cart-alt"></i>
            <span class="link-name" style="--i: 6">Cart</span>
          </a>
        </li>
        <li class="list-item">
          <a href="#">
            <i class="bx bx-cog"></i>
            <span class="link-name" style="--i: 7">Settings</span>
          </a>
        </li>
      </ul>
    </nav>
    <script src="script.js?after"></script>
  </body>
</html>
