<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Vue 测试实例 - 菜鸟教程(runoob.com)</title>
    <script src="<%=request.getContextPath()%>/vue/vue.min.js"></script>

    <script src="<%=request.getContextPath()%>/jquery/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7/dist/css/bootstrap.min.css">
    <script src="<%=request.getContextPath()%>/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

</head>
<body>
<button type="button" class="btn btn-danger">危险按钮</button>
<div id="vue_det">
    <h1>site : {{site}}</h1>
    <h1>url : {{url}}</h1>
    <h1>{{details()}}</h1>

</div>

<c:forEach var="i" begin="1" end="5">
   <p>aa</p>
    </c:forEach>


</body>
<script type="text/javascript">
    var vm = new Vue({
        el: '#vue_det',
        data: {
            site: "菜鸟教程",
            url: "www.runoob.com",
            alexa: "10000"
        },
        methods: {
            details: function () {
                return this.site + " - 学的不仅是技术，更是梦想！";
            }
        }
    })

</script>
</html>