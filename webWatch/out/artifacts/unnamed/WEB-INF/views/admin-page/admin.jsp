<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
    	String path = request.getContextPath();
    %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>姜戈名品平台管理</title>
<link rel = "stylesheet" href = "<%=path%>/jquery-easyui/themes/default/easyui.css"/>
<link rel = "stylesheet" href = "<%=path%>/jquery-easyui/themes/icon.css"/>
<link rel = "stylesheet" href = "<%=path%>/css/main.css"/>
<script type = "text/javascript" src = "<%=path%>/js/jquery.min.js"></script>
<script type = "text/javascript" src = "<%=path%>/jquery-easyui/jquery.min.js"></script>
<script type = "text/javascript" src = "<%=path%>/jquery-easyui/jquery.easyui.min.js"></script>
<script type = "text/javascript" src = "<%=path%>/js/main.js"></script>
	<script>
        $(document).ready(function() {
            tabCloseEven();
        });
	</script>
</head>
<body class="easyui-layout">
		<div data-options="region:'north'" style="height:60px">
			<img src = "<%=path%>/images/logo.png" class = "logo"/>
			<div id="wel">
				<a href = "javascript:;" onclick = "refresh()">刷新</a>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您&nbsp;:&nbsp;&nbsp;${sessionScope.admin.name}
					<a href = "/admin/logout">安全退出</a>
			</div>
		</div>
		<div data-options="region:'west',split:true" title="姜戈名品平台管理" style="width:235px;">
			<div class="easyui-accordion menu" style="width:235px;">
				<div title="页面链接">
					<ul>
							<li><a href="javascript:;" onclick="addTab('前台主页','<%=path%>/index');">前台主页</a></li>
							<li><a href="javascript:;" onclick="addTab('姜戈贴吧','http://tieba.baidu.com/f?ie=utf-8&kw=姜戈名品');">姜戈贴吧</a></li>
							<li><a href="javascript:;" onclick="addTab('论坛显示','<%=path%>/forum/forum');">论坛显示</a></li>
							<li><a href="javascript:;" onclick="addTab('姜戈微店','http://weidian.com/?userid=1093447508');">姜戈微店</a></li>
					</ul>
				</div>
				<div title="基础管理">
					<ul>
							<li><a href="javascript:;" onclick="addTab('品牌管理','<%=path%>/brand/brand_page');">品牌管理</a></li>
							<li><a href="javascript:;" onclick="addTab('材质管理','<%=path%>/material/material_page');">材质管理</a></li>
							<li><a href="javascript:;" onclick="addTab('产地管理','<%=path%>/origin/origin_page');">产地管理</a></li>
							<li><a href="javascript:;" onclick="addTab('机芯管理','<%=path%>/core/core_page');">机芯管理</a></li>
							<li><a href="javascript:;" onclick="addTab('风格管理','<%=path%>/style/style_page');">风格管理</a></li>
					</ul>
				</div>
				<div title="论坛管理">
					<ul>
						<li><a href="javascript:;" onclick="addTab('帖子类型','<%=path%>/type/type_page');">帖子类型</a></li>
						<li><a href="javascript:;" onclick="addTab('论坛管理','<%=path%>/forum/forum_page');">论坛管理</a></li>
					</ul>
				</div>
				<div title="手表管理">
					<ul>
						<li><a href="javascript:;" onclick="addTab('手表管理','<%=path%>/watch/watch_page');">手表管理</a></li>
					</ul>
				</div>
				<div title="皮具管理">
					<ul>
						<li><a href="javascript:;" onclick="addTab('皮具管理','<%=path%>/leather/leather_page');">皮具管理</a></li>
					</ul>
				</div>
				<div title="鞋子管理">
					<ul>
						<li><a href="javascript:;" onclick="addTab('鞋子管理','<%=path%>/shose/shose_page');">鞋子管理</a></li>
					</ul>
				</div>
				<div title="用户管理">
					<ul>
						<li><a href="javascript:;" onclick="addTab('用户管理','<%=path%>/admin/admin-page');">用户管理</a></li>
					</ul>
				</div>

			</div>
		</div>
		<div data-options="region:'center'">
			<div id="tabs" class="easyui-tabs" style="width:100%;height:100%;">
				<div title="主页" style="padding:10px" >
				</div>
			</div>
		</div>
		<div data-options="region:'south',split:false" class = "down">姜戈名品2013&copy;姜戈团队版权所有 2013-2020</div>

		<div id="mm" class="easyui-menu cs-tab-menu">
			<div id="mm-tabupdate">刷新</div>
			<div class="menu-sep"></div>
			<div id="mm-tabclose">关闭</div>
			<div id="mm-tabcloseleft">关闭左边选项卡</div>
			<div id="mm-tabcloseright">关闭右边选项卡</div>
			<div id="mm-tabcloseother">关闭其他</div>
			<div id="mm-tabcloseall">关闭全部</div>
		</div>
</body>
</html>