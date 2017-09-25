<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>    

<html>
<head>
<title>layouts-tiles</title>
<!-- (css, js)스타일 영역 -->
<tiles:insertAttribute name="head"/>
</head>
<body>
<!-- 상단메뉴영역 -->
<tiles:insertAttribute name="navbar"/>
<!-- 안에콘텐츠영역 -->
<div class="container-fluid">
  <div class="row content">
<tiles:insertAttribute name="sidenav"/>
<tiles:insertAttribute name="main"/>
</div>
</div>
<!-- 푸터영역 -->
<tiles:insertAttribute name="footer"/>
</body>
</html>