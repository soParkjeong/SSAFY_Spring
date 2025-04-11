<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전달 받은 모든 데이터 출력</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        .section {
            margin-bottom: 30px;
        }
        h2 {
            color: #333;
            border-bottom: 1px solid #ccc;
            padding-bottom: 5px;
        }
    </style>
</head>
<body>
    <h1>전달 받은 모든 데이터 출력</h1>
    
    <!-- 1. 요청 파라미터(GET/POST) 출력 -->
    <div class="section">
        <h2>1. 요청 파라미터(Request Parameters)</h2>
        <table>
            <tr>
                <th>파라미터 이름</th>
                <th>파라미터 값</th>
            </tr>
            <%
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String name = paramNames.nextElement();
                String[] values = request.getParameterValues(name);
                
                if (values.length == 1) {
                    %>
                    <tr>
                        <td><%= name %></td>
                        <td><%= values[0] %></td>
                    </tr>
                    <%
                } else {
                    %>
                    <tr>
                        <td><%= name %></td>
                        <td>
                            <%
                            for (int i = 0; i < values.length; i++) {
                                out.println(values[i]);
                                if (i < values.length - 1) {
                                    out.println(", ");
                                }
                            }
                            %>
                        </td>
                    </tr>
                    <%
                }
            }
            if (!paramNames.hasMoreElements()) {
                %><tr><td colspan="2">전달된 파라미터가 없습니다.</td></tr><%
            }
            %>
        </table>
    </div>
    
    <!-- 2. 요청 헤더 정보 출력 -->
    <div class="section">
        <h2>2. 요청 헤더(Request Headers)</h2>
        <table>
            <tr>
                <th>헤더 이름</th>
                <th>헤더 값</th>
            </tr>
            <%
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String value = request.getHeader(name);
                %>
                <tr>
                    <td><%= name %></td>
                    <td><%= value %></td>
                </tr>
                <%
            }
            %>
        </table>
    </div>
    
    <!-- 3. 세션 속성 출력 -->
    <div class="section">
        <h2>3. 세션 속성(Session Attributes)</h2>
        <table>
            <tr>
                <th>속성 이름</th>
                <th>속성 값</th>
            </tr>
            <%
            Enumeration<String> sessionAttrs = session.getAttributeNames();
            boolean hasSessionAttrs = false;
            while (sessionAttrs.hasMoreElements()) {
                hasSessionAttrs = true;
                String name = sessionAttrs.nextElement();
                Object value = session.getAttribute(name);
                %>
                <tr>
                    <td><%= name %></td>
                    <td><%= value != null ? value.toString() : "null" %></td>
                </tr>
                <%
            }
            if (!hasSessionAttrs) {
                %><tr><td colspan="2">세션에 저장된 속성이 없습니다.</td></tr><%
            }
            %>
        </table>
    </div>
    
    <!-- 4. 애플리케이션 속성 출력 -->
    <div class="section">
        <h2>4. 애플리케이션 속성(Application Attributes)</h2>
        <table>
            <tr>
                <th>속성 이름</th>
                <th>속성 값</th>
            </tr>
            <%
            Enumeration<String> appAttrs = application.getAttributeNames();
            boolean hasAppAttrs = false;
            while (appAttrs.hasMoreElements()) {
                hasAppAttrs = true;
                String name = appAttrs.nextElement();
                Object value = application.getAttribute(name);
                %>
                <tr>
                    <td><%= name %></td>
                    <td><%= value != null ? value.toString() : "null" %></td>
                </tr>
                <%
            }
            if (!hasAppAttrs) {
                %><tr><td colspan="2">애플리케이션에 저장된 속성이 없습니다.</td></tr><%
            }
            %>
        </table>
    </div>
    
    <!-- 5. 쿠키 정보 출력 -->
    <div class="section">
        <h2>5. 쿠키(Cookies)</h2>
        <table>
            <tr>
                <th>쿠키 이름</th>
                <th>쿠키 값</th>
                <th>유효 기간</th>
                <th>도메인</th>
                <th>경로</th>
            </tr>
            <%
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    %>
                    <tr>
                        <td><%= cookie.getName() %></td>
                        <td><%= cookie.getValue() %></td>
                        <td><%= cookie.getMaxAge() %></td>
                        <td><%= cookie.getDomain() != null ? cookie.getDomain() : "-" %></td>
                        <td><%= cookie.getPath() != null ? cookie.getPath() : "/" %></td>
                    </tr>
                    <%
                }
            } else {
                %><tr><td colspan="5">전달된 쿠키가 없습니다.</td></tr><%
            }
            %>
        </table>
    </div>
    
    <!-- 6. 요청 속성 출력 -->
    <div class="section">
        <h2>6. 요청 속성(Request Attributes)</h2>
        <table>
            <tr>
                <th>속성 이름</th>
                <th>속성 값</th>
            </tr>
            <%
            Enumeration<String> reqAttrs = request.getAttributeNames();
            boolean hasReqAttrs = false;
            while (reqAttrs.hasMoreElements()) {
                hasReqAttrs = true;
                String name = reqAttrs.nextElement();
                Object value = request.getAttribute(name);
                %>
                <tr>
                    <td><%= name %></td>
                    <td><%= value != null ? value.toString() : "null" %></td>
                </tr>
                <%
            }
            if (!hasReqAttrs) {
                %><tr><td colspan="2">요청에 저장된 속성이 없습니다.</td></tr><%
            }
            %>
        </table>
    </div>
    
    <!-- 7. 서버 정보 출력 -->
    <div class="section">
        <h2>7. 서버 정보</h2>
        <table>
            <tr><th>항목</th><th>값</th></tr>
            <tr><td>서버 이름</td><td><%= request.getServerName() %></td></tr>
            <tr><td>서버 포트</td><td><%= request.getServerPort() %></td></tr>
            <tr><td>컨텍스트 경로</td><td><%= request.getContextPath() %></td></tr>
            <tr><td>서블릿 경로</td><td><%= request.getServletPath() %></td></tr>
            <tr><td>프로토콜</td><td><%= request.getProtocol() %></td></tr>
            <tr><td>요청 방식</td><td><%= request.getMethod() %></td></tr>
            <tr><td>문자 인코딩</td><td><%= request.getCharacterEncoding() %></td></tr>
            <tr><td>콘텐츠 타입</td><td><%= request.getContentType() %></td></tr>
            <tr><td>원격 주소</td><td><%= request.getRemoteAddr() %></td></tr>
            <tr><td>원격 호스트</td><td><%= request.getRemoteHost() %></td></tr>
            <tr><td>로컬 주소</td><td><%= request.getLocalAddr() %></td></tr>
            <tr><td>로컬 이름</td><td><%= request.getLocalName() %></td></tr>
        </table>
    </div>
</body>