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

    <link
      href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css"
      rel="stylesheet"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="./style.css" rel="stylesheet" />
    <title>Document</title>
  </head>
  <%
  
  %>
  <body>
    <nav class="sidebar">
      <div class="logo-menu">
        <h2 class="logo"><a href="mypage.jsp"></a></h2>
        <i class="bx bx-menu toggle-btn"></i>
      </div>
      <ul class="list">
        <li class="list-item active">
          <a href="#">
            <i class="bx bx-grid-alt"></i>
            <span class="link-name" style="--i: 1">Dashboard</span>
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
            <li>Frame</li>
            <li>Wheel</li>
            <li>Drivetrain</li>
            <li>others</li>
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
        <li class="list-item">
          <a href="#">
            <i class="bx bx-cart-alt"></i>
            <span class="link-name" style="--i: 6">MyCart</span>
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
    <main>
    <div class="loginmain">
      <div class="loginhead">
        <h1 class="text text-large">Sign In</h1>
        <p class="text text-normal">
          New user?
          <span
            ><a href="insertuser.jsp" class="text text-links"
              >Create an account</a
            ></span
          >
        </p>
      </div>
      <form name="signin" class="form" action="loginaction.jsp">
        <div class="input-control">
          <label for="email" class="input-label" hidden>Email Address</label>
          <input
            type="email"
            name="email"
            id="email"
            class="input-field"
            placeholder="Email Address"
          />
        </div>
        <div class="input-control">
          <label for="password" class="input-label" hidden>Password</label>
          <input
            type="password"
            name="password"
            id="password"
            class="input-field"
            placeholder="Password"
          />
        </div>
        <div class="input-control">
          <a href="#" class="text text-links">Forgot Password</a>
          <input
            type="submit"
            name="submit"
            class="input-submit"
            value="Sign In"
            disabled
          />
        </div>
      </form>
    </div>
    </main>
    <script src="script.js"></script>
  </body>
</html>
