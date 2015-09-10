<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Basic DataGrid - jQuery EasyUI Demo</title>
<link rel="stylesheet" type="text/css"
	href="../js/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../js/demo/demo.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript">
$(function(){ 
    $("#search").click(function() {
        $('#list_data').datagrid({
            title : '充值',
            iconCls : 'icon-ok',
            width : 'auto',
            queryParams: {
            	startTime: $('#startTime').datebox('getValue'),
       			endTime: $('#endTime').datebox('getValue'),
       			jieru:$('#jieru').combobox('getValue')
        	}
       	  ,
            pageSize : 30,//默认选择的分页是每页5行数据
            pageList : [30,40,80 ],//可以选择的分页集合
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
            striped : true,//设置为true将交替显示行背景。
            collapsible : true,//显示可折叠按钮
            toolbar:"#tb",//在添加 增添、删除、修改操作的按钮要用到这个
            url:'getPay',//url调用Action方法
            loadMsg : '数据装载中......',
//             singleSelect:true,//为true时只能选择单行
            fitColumns:true,//允许表格自动缩放，以适应父容器
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            remoteSort : false,
             frozenColumns : [ [ {
                field : 'ck',
                checkbox : true
            } ] ],
            pagination : true,//分页
            rownumbers : true//行数
        });
         
    });
});



</script>

</head>
<body >
<!-- 	<div style="margin: 20px 0;"></div> -->
    <div id="toolbar">
    
  开始时间：<input id="startTime" class="easyui-datebox"></input>  结束时间：<input id="endTime"  class="easyui-datebox"></input>
  接入选择：<select id="jieru" class="easyui-combobox">
  								<option value="byhd0001">心跳斗地主</option>
  								<option value="kxw0001">全民国战</option>
  							</select>
  <button id="search">查询</button>
    </div>
<!--     <div region="south" border="true" split="true" style="overflow: hidden; height: 60px;"> -->
<!--      		 <div class="footer">   -->
<!--      			<div id="pp" style="background:#efefef;border:1px solid #ccc;"></div> -->
<!-- 			</div> -->
<!--     </div> -->
	<table class="easyui-datagrid" id="list_data" 
		style="width: 'auto'; height: '500px'"; toolbar="#toolbar";">
		<thead>
			<tr>
				<th data-options="field:'userId',width:'auto'">用户ID</th>
<!-- 				<th data-options="field:'state',width:'auto'"></th> -->
				<th data-options="field:'amt',width:'auto'">金额</th>
				<th data-options="field:'time',width:'auto'">时间</th>
			</tr>
		</thead>
		
	</table>
</body>
</html>