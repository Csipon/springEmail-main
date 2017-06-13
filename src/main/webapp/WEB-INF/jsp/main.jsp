<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <spring:url value="/css/main.css" var="springCss"/>
    <spring:url value="/img/ico.png" var="springIcon"/>
    <spring:url value="/js/main.js" var="springMainScript"/>

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/chartist/0.11.0/chartist.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://cdn.rawgit.com/chingyawhao/materialize-clockpicker/master/dist/css/materialize.clockpicker.css">

    <link href="${springCss}" rel="stylesheet"/>
    <link href="${springIcon}" rel="icon"/>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <title>RENT CAR</title>
</head>
<body>
<header>
    <nav>
        <div class="nav-wrapper grey lighten-5">
            <div class="menu-left left-align">
                <div class="menu-block hide-on-med-and-down menu-left-item"></div>
                <a href="." data-activates="slide-out" class="button-collapse menu-left-item a-dummy"><i
                        class="black-text material-icons">menu</i></a>
                <a href="." class="hide-on-med-and-down menu-left-item burger a-dummy"><i
                        class="black-text material-icons">menu</i></a>
                <h1 id="current-page"></h1>
            </div>
            <ul class="menu-right">
                <li class="hide-on-med-and-up">
                    <a href="." class="a-logout a-dummy menu-left-item">
                        <i class="black-text material-icons">settings_power</i>
                        <form action="/logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </a>
                </li>
                <li class="menu-item-user hide-on-small-only" data-user-role="${role}">
                    <c:if test="${auth}">
                        <div>
                            <a class='dropdown-button a-dummy' href='.' data-activates='dropdown-user'>
                                <span class="black-text title" id="user-name">${user.lastName} ${user.firstName}</span>
                            </a>
                            <ul id='dropdown-user' class='dropdown-content'>
                                <li><a href="#profile"><i class="small material-icons">person_pin</i>My Profile</a></li>
                                <li><a href="#settings"><i class="small material-icons">settings</i>Setting</a></li>
                                <li>
                                    <a href="." class="a-logout a-dummy">
                                        <i class="small material-icons">settings_power</i>
                                        Log Out
                                        <form action="/logout" method="post">
                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                        </form>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </c:if>
                </li>
            </ul>
        </div>
    </nav>
    <div class="progress">
        <div class="indeterminate"></div>
    </div>
</header>

<div class=side-nav-wrapper>
    <ul id="slide-out" class="side-nav fixed z-depth-0 blue-grey lighten-2">
        <li>
            <a href="#" class="logo valign-wrapper menu-element">
                <i class="white-text material-icons">home</i>
                <h2>RENT CAR</h2>
            </a>
        </li>
        <li class="li-divider">
            <div class="divider"></div>
        </li>
        <%@ include file="/WEB-INF/jsp/menu.jsp" %>
    </ul>
</div>

<div class="content">
    <div class="content-body-wrapper"></div>
</div>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
<script src="https://cdn.rawgit.com/chingyawhao/materialize-clockpicker/master/dist/js/materialize.clockpicker.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/chartist/0.11.0/chartist.min.js"></script>
<%--Google API Key: AIzaSyCT7tBQN8l0fcDdcZUwuxD0XGjgM7qbTL4 sensor=false&--%>
<script src="${springMainScript}"></script>
</div>
</body>
</html>