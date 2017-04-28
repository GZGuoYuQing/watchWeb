<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>帖子管理</title>
    <link rel="shortcut icon" href="<%=path%>/images/webLogo.ico" type="image/x-icon" />
    <link rel = "stylesheet" href = "<%=path %>/jquery-easyui/themes/default/easyui.css"/>
    <link rel = "stylesheet" href = "<%=path %>/jquery-easyui/themes/icon.css"/>
    <link rel = "stylesheet" href = "<%=path %>/css/texteditor.css"/>
    <link rel = "stylesheet" href = "<%=path %>/css/main.css"/>
    <script type = "text/javascript" src = "<%=path %>/js/jquery.min.js"></script>
    <script type = "text/javascript" src = "<%=path %>/jquery-easyui/jquery.min.js"></script>
    <script type ="text/javascript" src="<%=path %>/js/jquery-form.js"></script>
    <script type = "text/javascript" src = "<%=path %>/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type ="text/javascript" src="<%=path %>/js/jquery.texteditor.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/json2.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/forum.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/main.js"></script>


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
			url:'<%=path %>/forum/queryAll',
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
        <th data-options="field:'title',width:100,align:'center'">标题</th>
        <th data-options="field:'type',width:80,align:'center'" formatter="showDes">类型</th>
        <th data-options="field:'admin',width:80,align:'center'" formatter="showName">发布人</th>
        <th data-options="field:'dateTime',width:80,align:'center'" formatter="formatterDate">发布时间</th>
<%--        <th data-options="field:'des',width:80,align:'center'">内容</th>--%>
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

<div id="addWin" class="easyui-window" title="添加帖子" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:750px;height:590px;padding:15px;">
    <form id = "addForm"   modelAttribute="forum" enctype="multipart/form-data">
        <table class = "table">
            <tr>
                <td>标题:</td>
                <td><input class="easyui-validatebox textbox" name="title"   data-options = "required:true" /></td>
                <td>帖子类型:</td>
                <td>
                    <input id="addType" class="easyui-combobox" name="type.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'100px' "/>
                </td>
            </tr>
            <tr>
                <td>发布时间:</td>
                <td><input class="easyui-datetimebox" name="dateTime"  id="time1" /></td>
                <td>发布人:</td>
                <td>
                    <input id="addAdmin" class="easyui-combobox" name="admin.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'100px' "/>
                </td>
            </tr>
            <tr>
                <td>主图:</td>
                <td><input name="imageFile" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/></td>
                <td><a href="javascript:;" class="easyui-linkbutton" onclick="showImage()" iconCls="icon-search">查看图片</a></td>
            </tr>
            <tr>
                <td>视频：</td>
                <td><input name="videoFile" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true" accept="video/avi, video/mp4, audio/mkv"/></td>
                <td><a href="javascript:;" class="easyui-linkbutton" onclick="showVideo()" iconCls="icon-search">查看视频</a></td>
            </tr>

        </table>
        <div class="easyui-texteditor" title="内容" name="des" style="width: 100%;height:200px;padding:20px">
        </div>
        <p></p>
        <div>
            <a href="javascript:;"onclick="editWatch();"class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
        </div>
    </form>
</div>

<div id="editWin" class="easyui-window" title="修改帖子" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:750px;height:590px;padding:5px;">
    <form id = "editForm" modelAttribute="forum" enctype="multipart/form-data" method="post">
        <input type="hidden" name="id" />
        <input type="hidden" name="image" />
        <input type="hidden" name="video" />
        <table class = "table">
            <tr>
                <td>标题:</td>
                <td><input class="easyui-validatebox textbox" name="title"   data-options = "required:true" /></td>
                <td>帖子类型:</td>
                <td>
                    <input id="editType" class="easyui-combobox" name="type.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'100px' "/>
                </td>
            </tr>
            <tr>
                <td>发布时间:</td>
                <td><input class="easyui-datetimebox" name="dateTime"  id="time" /></td>
                <td>发布人:</td>
                <td>
                    <input id="editAdmin" class="easyui-combobox" name="admin.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'100px' "/>
                </td>
            </tr>
            <tr>
                <td>主图:</td>
                <td><input name="imageFile" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/></td>
                <td><a href="javascript:;" class="easyui-linkbutton" onclick="showImage()" iconCls="icon-search">查看图片</a></td>
            </tr>
            <tr>
                <td>视频：</td>
                <td><input name="videoFile" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true" accept="video/avi, video/mp4, audio/mkv"/></td>
                <td><a href="javascript:;" class="easyui-linkbutton" onclick="showVideo()" iconCls="icon-search">查看视频</a></td>
            </tr>

        </table>
        <div class="easyui-texteditor" title="内容" name="des" style="width: 100%;height:200px;padding:20px">
        </div>
        <p></p>
        <div>
            <a href="javascript:;"onclick="editWatch();"class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
        </div>
    </form>
</div>

<div id="showVideoWin" class="easyui-window" title="查看视频" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:100%;height:100%;">
    <video src="" id = "video" controls="controls" >
    </video>
</div>

<div id="showImageWin" class="easyui-window" title="查看主图" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:800px;height:500px;">
    <img style = "width:100%;height:100%;" id = "image" src="">
</div>
</body>

</html>