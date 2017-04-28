<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>产地管理</title>
    <link rel = "stylesheet" href = "<%=path %>/jquery-easyui/themes/default/easyui.css"/>
    <link rel = "stylesheet" href = "<%=path %>/jquery-easyui/themes/icon.css"/>
    <link rel = "stylesheet" href = "<%=path %>/css/main.css"/>
    <script type = "text/javascript" src = "<%=path %>/js/jquery.min.js"></script>
    <script type = "text/javascript" src = "<%=path %>/jquery-easyui/jquery.min.js"></script>
    <script type ="text/javascript" src="<%=path %>/js/jquery-form.js"></script>
    <script type = "text/javascript" src = "<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/json2.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/main.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/origin.js"></script>


    <style>
        .table tr{
            height: 43px;
        }
        .table td{
            width: 260px;
        }

    </style>
</head>
<body id = "body">
<table id = "list"class="easyui-datagrid"
       data-options="toolbar:'#tb',singleSelect:false,
			collapsible:true,
			url:'<%=path %>/origin/query_pager',
			method:'get',
			rownumbers:true,
			autoRowHeight:true,
			pagination:true,
			fitColumns:true,<!-- 表格面积是否全部占满 -->
			pageSize:20"
       style = "height:100%;"
>
    <thead>
    <tr>
        <th data-options="field:'id',checkbox:true"></th>
        <th data-options="field:'des',width:100,align:'center'">产地</th>
        <th data-options="field:'caozuo',width:100,align:'center'" formatter="formatterOpt">操作</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:;" onclick = "showAddWatchWin()"class="easyui-linkbutton" iconCls="icon-add" >添加</a>
        <a href="javascript:;" onclick = "showEditWatchWin()" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
        <a href="javascript:;" onclick = "removeWatch()"class="easyui-linkbutton" iconCls="icon-remove">删除</a>
    </div>
</div>

<div id="addWin" class="easyui-window" title="添加" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:650px;height:400px;padding:15px;">
    <form id = "addForm"   modelAttribute="watch" enctype="multipart/form-data">
        <table class = "table">
            <tr>
                <td>产地名:</td>
                <td><input class="easyui-validatebox textbox" name="des"   data-options = "required:true" /></td>
            </tr>
                <td>
                    <a href="javascript:;" onclick="addWatch();"class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="editWin" class="easyui-window" title="修改" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:650px;height:400px;padding:5px;">
    <form id = "editForm" modelAttribute="watch" enctype="multipart/form-data">
        <input type="hidden" name="id" />
        <table class = "table">
            <tr>
                <td>产地名:</td>
                <td><input class="easyui-validatebox textbox" name="des"   data-options = "required:true" /></td>
            </tr>
            <tr>
            <td>
                <a href="javascript:;" onclick="editWatch();"class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
            </td>
            </tr>
        </table>
    </form>
</div>
</body>

</html>