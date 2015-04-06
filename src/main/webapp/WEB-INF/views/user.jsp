<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: adrian
  Date: 31/3/15
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<html>
  <head>
      <title>User greetings</title>
  </head>
  <body>
    <h2><b>User name: </b>${fn:escapeXml(usergreeting.getUsername())}</h2>
    <p><b>User email: </b>${fn:escapeXml(user.getEmail())}</p>
    <h3>Greetings:</h3>
      <c:if test="${not empty user.getGreetings()}">
        <c:forEach var="usergreeting" items="${user.getGreetings()}">
          <li>
            <a href="/greetings/${usergreeting.getId()}">${usergreeting.getId()}</a>: ${fn:escapeXml(usergreeting.getContent())} <a href="/greetings/${usergreeting.getId()}/form">Edit greeting</a>
          </li>
        </c:forEach>
      </c:if>
    <a href="/users">Return to list</a>
  </body>
</html>
