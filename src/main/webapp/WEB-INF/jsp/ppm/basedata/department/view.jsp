<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/ppm/public/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link type="text/css" rel="stylesheet" href="css/blue/pageCommon.css"/>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
	<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
        	
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/static/assets/avatars/user.jpg"/> 部门信息
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="departmentAction_update.action">
    	<s:hidden name="did"></s:hidden>
       
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                  
                    <tr><td>部门名称</td>
                        <td><s:textfield name="name" cssClass="InputStyle"></s:textfield>
						</td>
                    </tr>
                
					<tr><td>部门描述</td>
                        <td>
                        	<s:textfield name="description" cssClass="InputStyle" ></s:textfield>
						</td>
                    </tr>
					
                </table>
            </div>
        </div>
        
		
        
		
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="submit" class="buttonsave" value="保存"/>
            <a href="javascript:history.back();;">返回</a>
        </div>
    </s:form>
</div> 
</body>
</html>
