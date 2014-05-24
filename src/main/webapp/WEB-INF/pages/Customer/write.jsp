<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>고객 정보 입력</title>
    <!-- Bootstrap -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="bs-docs-grid">
    <h1>수정</h1>
    <form:form commandName="customer" method="post">
        <div class="row">
            <div class="span9">
                <table class="table">
                    <tr>
                        <th><form:label path="customerName">이름</form:label></th>
                        <td><form:input path="customerName"/><form:errors path="customerName" /></td>
                    </tr>
                    <tr>
                        <th><form:label path="phoneNumber">폰번호</form:label></th>
                        <td><form:input path="phoneNumber"/><form:errors path="phoneNumber" /></td>
                    </tr>
                    <tr>
                        <th><form:label path="Note">Note</form:label></th>
                        <td><form:textarea path="Note"/><form:errors path="Note" /></td>
                    </tr>
                </table>
            </div>
            <div class="span9 text-right">
                <input type="submit" class="btn" value="입력"/>
                <a href="<c:url value="/customer/list" />" class="btn">목록</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>