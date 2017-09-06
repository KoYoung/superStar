<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- js文件 -->
<script type="text/javascript" src="../js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../easyui/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet"
	href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" type="text/css"></link>
<link rel="stylesheet" href="../easyui/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="../easyui/themes/bootstrap/easyui.css"
	type="text/css"></link>
</head>
<body>
	<table id="dg"></table>
</body>
<script type="text/javascript">
	$("#dg").datagrid({
		url : "/badLoan/find/findBorGuarantor",
		pagination:true,//开启分页功能
		pageNumber:1,
		pageSize:5,
		pageList:[5,10,15,20,25,30],
	    fitColumns:true,
		striped:true,
		loadMsg:"努力加载中......",
		columns : [[
			{field:'borName',title:'贷款人'},
			{field:'guaName',title:'担保人'},
			{field:'guaPhone',title:'联系电话'},
			{field:'guaCardtype',title:'证件类型'},
			{field:'guaCardnumber',title:'证件号码'},
			{field:'guaUnit',title:'工作单位'},
			{field:'guaPosition',title:'职位'},
			{field:'guaEducation',title:'学历'},
			{field:'guaIncome',title:'收入'}
		]]
	});
</script>
</html>