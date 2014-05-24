<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>읽기</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="bs-docs-grid">
    <h1>읽기</h1>
    <div class="row">
        <div class="span9">
            <table class="table">
                <tr>
                    <th>이름</th>
                    <td>${customer.customerName}</td>
                </tr>
                <tr>
                    <th>폰번호</th>
                    <td>${customer.phoneNumber}</td>
                </tr>
                <tr>
                    <th>Note</th>
                    <td>${customer.note}</td>
                </tr>
            </table>
        </div>
        <div class="span9 text-right">
            <a href="<c:url value="/customer/edit" />" class="btn">수정</a>
            <a href="<c:url value="/customer/list" />" class="btn">목록</a>
        </div>
    </div>
</div>
</body>
</html>