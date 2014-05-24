<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>시술 정보 입력</title>
    <!-- Bootstrap -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="bs-docs-grid">
    <h1>입력</h1>
    <form:form commandName="hairProcedure" method="post">
        <div class="row">
            <div class="span9">
                <table class="table">
                    <tr>
                        <th><form:label path="hairProcedureName">시술명</form:label></th>
                        <td><form:input path="hairProcedureName"/><form:errors path="hairProcedureName" /></td>
                    </tr>
                    <tr>
                        <th><form:label path="hairProcedureDate">일자</form:label></th>
                        <td><form:input path="hairProcedureDate"/><form:errors path="hairProcedureDate" /></td>
                    </tr>
                    <tr>
                        <th><form:label path="note">Note</form:label></th>
                        <td><form:textarea path="note"/><form:errors path="note" /></td>
                    </tr>
                </table>
            </div>
            <div class="span9 text-right">
                <input type="submit" class="btn" value="입력"/>
                <a href="<c:url value="/hairProcedure/${hairProcedure.customerId}/list" />" class="btn">목록</a>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>