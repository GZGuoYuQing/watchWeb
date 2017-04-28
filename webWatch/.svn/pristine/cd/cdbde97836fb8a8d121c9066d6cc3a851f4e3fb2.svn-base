<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>

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
    <script type = "text/javascript" src = "<%=path %>/js/main.js"></script>
    <script type = "text/javascript" src = "<%=path %>/js/watch.js"></script>

    <script>
        $(function() {
            setPagination("list");
            $.get("/brand/query_brand",
                    function(data){
                        $("#brand").combobox("loadData", data);
                    }, "json");
        });

    </script>
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
			url:'<%=path %>/watch/query_pager',
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
        <th data-options="field:'brand',width:80,align:'center'" formatter="showDes">品牌</th>
        <th data-options="field:'price',width:80,align:'center'">价格</th>
        <th data-options="field:'type',width:80,align:'center'">款式</th>
        <th data-options="field:'size',width:80,align:'center'">大小</th>
        <th data-options="field:'colour',width:80,align:'center'">颜色</th>
        <th data-options="field:'title',width:80,align:'center'">标题</th>
        <th data-options="field:'material',width:80,align:'center'" formatter="showDes">材质</th>
        <th data-options="field:'function',width:80,align:'center'">功能</th>
        <th data-options="field:'table',width:80,align:'center'">标签</th>
        <th data-options="field:'core',width:80,align:'center'" formatter="showDes">机芯</th>
        <th data-options="field:'origin',width:80,align:'center'" formatter="showDes">生产地</th>
        <th data-options="field:'style',width:80,align:'center'" formatter="showDes">风格</th>
        <th data-options="field:'des',width:80,align:'center'">描述</th>
        <th data-options="field:'caozuo',width:80,align:'center'" formatter="formatterOpt">操作</th>
    </tr>
    </thead>
</table>
<div id="tb" style="padding:5px;height:auto">
    <div style="margin-bottom:5px">
        <a href="javascript:;" onclick = "showAddWatchWin()"class="easyui-linkbutton" iconCls="icon-add" >添加</a>
        <a href="javascript:;" onclick = "showEditWatchWin()" class="easyui-linkbutton" iconCls="icon-edit">编辑</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="showImg()" iconCls="icon-search">修改表图片</a>
        <a href="javascript:;" onclick = "removeWatch()"class="easyui-linkbutton" iconCls="icon-remove">删除</a>
    </div>
    <div>
        品牌: <input id="brand" class="easyui-combobox" data-options="
						valueField:'id',
						textField:'text',
						panelHeight:'200px' "/>
        标题: <input class="easyui-textbox" id = "title" style="width:80px">
        <a href="javascript:;" class="easyui-linkbutton" onclick="queryByTitle()" iconCls="icon-search">搜索</a>
        <a href="javascript:;" class="easyui-linkbutton" onclick="queryByPage()" iconCls="icon-search">查询所有</a>
    </div>
</div>

<div id="addWin" class="easyui-window" title="添加产品" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:650px;height:500px;padding:5px;">
    <form id = "addForm"   modelAttribute="watch" enctype="multipart/form-data">
        <table class = "table">
            <tr>
                <td>品牌</td>
                <td>
                    <input id="addBrand" class="easyui-combobox" name="brand.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px'"/>

                </td>

                <td>价格</td>
                <td><input class="easyui-numberbox" name="price" data-options = "precision:2,required:true" /></td>
            </tr>
            <tr>
                <td>款式</td>
                <td>
                    <input type = "radio"  name="type" value= "男款"/>男款
                    <input type = "radio"  name="type" value= "女款"/>女款
                </td>
                <td>大小</td>
                <td><select name="size" class="easyui-combobox" style="width: 150px;">
                    <option value="40"selected = "selected">40</option>
                    <option value="39">39</option>
                    <option value="38">38</option>
                    <option value="37">37</option>
                    <option value="36">36</option>
                    <option value="35">35</option>
                    <option value="34">34</option>
                    <option value="33">33</option>
                    <option value="32">32</option>
                    <option value="31">31</option>
                    <option value="30">30</option>
                    <option value="29">29</option>
                    <option value="28">28</option>
                    <option value="27">27</option>
                    <option value="26">26</option>
                    <option value="25">25</option>
                    <option value="24">24</option>
                    <option value="23">23</option>
                    <option value="22">22</option>
                    <option value="21">21</option>
                </select></td>
            </tr>
            <tr>
                <td>颜色</td>
                <td><select name="colour" class="easyui-combobox" style="width: 150px;">
                    <option value="典雅白色"selected = "selected">典雅白色</option>
                    <option value="睿智黑色">睿智黑色</option>
                    <option value="奢侈金色">奢侈金色</option>
                    <option value="星空灰色">星空灰色</option>
                    <option value="水鬼绿色">水鬼绿色</option>
                    <option value="水鬼蓝色">水鬼蓝色</option>
                    <option value="金属银色">金属银色</option>
                </select></td>
                <td>材质</td>
                <td>
                    <input id="addMaterial" class="easyui-combobox" name="material.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px'"/>

                </td>
            </tr>
            <tr>
                <td>表镜材质</td>
                <td><select name="lens" class="easyui-combobox" style="width: 150px;">
                    <option value="耐磨蓝宝石"selected = "selected">耐磨蓝宝石</option>
                    <option value="矿物质玻璃">矿物质玻璃</option>
                    <option value="科技树脂">科技树脂</option>
                    <option value="钢化玻璃">钢化玻璃</option>
                    <option value="亚克力玻璃">亚克力玻璃</option>
                </select></td>
                <td>手表功能</td>
                <td><select name="function" class="easyui-combobox" style="width: 200px;">
                    <option value="三针计时"selected = "selected">三针计时</option>
                    <option value="三针计时/日历显示">三针计时/日历显示</option>
                    <option value="三针计时/日历显示 ">三针计时/日历显示/外圈旋转</option>
                    <option value="三针计时/日历显示/秒针计时">三针计时/日历显示/秒针计时</option>
                    <option value="三针计时/日历显示/音锤报时">三针计时/日历显示/音锤报时</option>
                </select></td>
            </tr>
            <tr>
                <td>机芯</td>
                <td>
                    <input id="addCore" class="easyui-combobox" name="core.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px'"/>

                </td>
                <td>生产地</td>
                <td>
                    <input id="addOrigin" class="easyui-combobox" name="origin.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px' "/>

                </td>
            </tr>

            <tr>
                <td>风格</td>
                <td>
                    <input id="addStyle" class="easyui-combobox" name="style.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px'"/>

                </td>

                <td>标题</td>
                <td><input class="easyui-validatebox textbox" name="title" /></td>
            </tr>

            <tr>
                <td>主图</td>
                <td>
                    <input name="fileImg" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true" />
                </td>

                <td>标签</td>
                <td><select name="table" class="easyui-combobox" style="width: 150px;">
                    <option value="定制复刻"selected = "selected">定制复刻</option>
                    <option value="正品原单">正品原单</option>
                    <option value="顶级组装">顶级组装</option>
                    <option value="-10%">-10%</option>
                    <option value="-15%">-15%</option>
                    <option value="-20%">-20%</option>
                </select></td>
            </tr>

            <tr>

                <td>图片</td>
                <td>
                    <input name="files" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择一个或多个文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true" multiple="true"/>
                </td>

                <td>视频</td>
                <td>
                    <input name="videofile" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true" accept="video/avi, video/mp4, audio/mkv"/>
                </td>
            </tr>

        </table>
        <div>
            <label>描述 ：</label>
            <p></p>
            <input class="easyui-textbox"   data-options="multiline:true" name="des"  style = "height:50px;width:100%"/>
        </div>
        <p></p>
        <div>
            <a href="javascript:;"onclick="addWatch();"class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
        </div>
    </form>
</div>

<div id="editWin" class="easyui-window" title="修改产品" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:650px;height:520px;padding:5px;">
    <form id = "editForm" modelAttribute="watch" enctype="multipart/form-data">
        <input type="hidden" name="id" />
        <input type="hidden" name="video"/>
        <table class = "table">
            <tr>
                <td>品牌</td>
                <td>
                    <input id="editBrand" class="easyui-combobox" name="brand.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px' "/>
                </td>

                <td>价格</td>
                <td><input class="easyui-numberbox" name="price" data-options = "precision:2,required:true" /></td>
            </tr>
            <tr>
                <td>款式</td>
                <td>
                    <input type = "radio"  name="type" value= "男款"/>男款
                    <input type = "radio"  name="type" value= "女款"/>女款
                </td>
                <td>大小</td>
                <td><select name="size" class="easyui-combobox" style="width: 150px;">
                    <option value="40"selected = "selected">40</option>
                    <option value="39">39</option>
                    <option value="38">38</option>
                    <option value="37">37</option>
                    <option value="36">36</option>
                    <option value="35">35</option>
                    <option value="34">34</option>
                    <option value="33">33</option>
                    <option value="32">32</option>
                    <option value="31">31</option>
                    <option value="30">30</option>
                    <option value="29">29</option>
                    <option value="28">28</option>
                    <option value="27">27</option>
                    <option value="26">26</option>
                    <option value="25">25</option>
                    <option value="24">24</option>
                    <option value="23">23</option>
                    <option value="22">22</option>
                    <option value="21">21</option>
                </select></td>
            </tr>
            <tr>
                <td>颜色</td>
                <td><select name="colour" class="easyui-combobox" style="width: 150px;">
                    <option value="典雅白色"selected = "selected">典雅白色</option>
                    <option value="睿智黑色">睿智黑色</option>
                    <option value="奢侈金色">奢侈金色</option>
                    <option value="星空灰色">星空灰色</option>
                    <option value="水鬼绿色">水鬼绿色</option>
                    <option value="水鬼蓝色">水鬼蓝色</option>
                    <option value="金属银色">金属银色</option>
                </select></td>
                <td>材质</td>
                <td>
                    <input id="editMaterial" class="easyui-combobox" name="material.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px' "/>

                </td>
            </tr>
            <tr>
                <td>表镜材质</td>
                <td><select name="lens" class="easyui-combobox" style="width: 150px;">
                    <option value="耐磨蓝宝石"selected = "selected">耐磨蓝宝石</option>
                    <option value="矿物质玻璃">矿物质玻璃</option>
                    <option value="科技树脂">科技树脂</option>
                    <option value="钢化玻璃">钢化玻璃</option>
                    <option value="亚克力玻璃">亚克力玻璃</option>
                </select></td>
                <td>手表功能</td>
                <td><select name="function" class="easyui-combobox" style="width: 200px;">
                    <option value="三针计时"selected = "selected">三针计时</option>
                    <option value="三针计时/日历显示">三针计时/日历显示</option>
                    <option value="三针计时/日历显示 ">三针计时/日历显示/外圈旋转</option>
                    <option value="三针计时/日历显示/秒针计时">三针计时/日历显示/秒针计时</option>
                    <option value="三针计时/日历显示/音锤报时">三针计时/日历显示/音锤报时</option>
                </select></td>
            </tr>
            <tr>
                <td>机芯</td>
                <td>
                    <input id="editCore" class="easyui-combobox" name="core.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px' "/>

                </td>
                <td>生产地</td>
                <td>
                    <input id="editOrigin" class="easyui-combobox" name="origin.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px' "/>

                </td>
            </tr>
            <tr>
                <td>风格</td>
                <td>
                    <input id="editStyle" class="easyui-combobox" name="style.id" data-options="required:true,
						valueField:'id',
						textField:'text',
						panelHeight:'200px'
						"/>

                </td>

                <td>标题</td>
                <td><input class="easyui-validatebox textbox" name="title" /></td>
            </tr>

            <tr>
                <td></td>
                <td><a href="javascript:;" class="easyui-linkbutton" onclick="showVideo()" iconCls="icon-search">查看视频</a></td>
                <td>视频</td>
                <td>
                    <input name="videofile" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true" accept="video/avi, video/mp4, audio/mkv"/>
                </td>
            </tr>
            <tr>
                <td>标签</td>
                <td><select name="table" class="easyui-combobox" style="width: 150px;">
                    <option value="定制复刻"selected = "selected">顶级复刻</option>
                    <option value="正品原单">正品原单</option>
                    <option value="顶级组装">定制组装</option>
                    <option value="-10%">-10%</option>
                    <option value="-15%">-15%</option>
                    <option value="-20%">-20%</option>
                </select></td>
            </tr>
        </table>
        <div>
            <label>描述 ：</label>
            <p></p>
            <input class="easyui-textbox"   data-options="multiline:true" name="des"  style = "height:50px;width:100%"/>
        </div>
        <p></p>
        <div>
            <a href="javascript:;" onclick="editWatch();"class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认</a>
        </div>
    </form>
</div>
<div id="showVideoWin" class="easyui-window" title="查看视频" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:800px;height:500px;">
    <video src="" id = "video" controls="controls">
    </video>
</div>

<div id="showImgWin" class="easyui-window" title="修改图片" data-options="closed:true" data-options="iconCls:'icon-save'" style="width:700px;height:450px;">
    <img style = "width:190px;height:90px;" id = "img" src="">
    <img style = "width:190px;height:90px;" id = "img1" src="">
    <img style = "width:190px;height:90px;" id = "img2" src="">
    <img style = "width:190px;height:90px;" id = "img3" src="">
    <img style = "width:190px;height:90px;" id = "img4" src="">
    <img style = "width:190px;height:90px;" id = "img5" src="">
    <img style = "width:190px;height:90px;" id = "img6" src="">
    <img style = "width:190px;height:90px;" id = "img7" src="">
    <img style = "width:190px;height:90px;" id = "img8" src="">
    <form id = "imgForm" modelAttribute="watch" enctype="multipart/form-data">
        <input type="hidden" name="id" />
        <table>
            <tr>
                <td>主图</td>
                <td>
                    <input name="file1" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
                <td>图片1</td>
                <td>
                    <input name="file2" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
                <td>图片2</td>
                <td>
                    <input name="file3" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
            </tr>
            <tr>
                <td>图片3</td>
                <td>
                    <input name="file4" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
                <td>图片4</td>
                <td>
                    <input name="file5" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
                <td>图片5</td>
                <td>
                    <input name="file6" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
            </tr>
            <tr>
                <td>图片6</td>
                <td>
                    <input name="file7" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
                <td>图片7</td>
                <td>
                    <input name="file8" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
                <td>图片8</td>
                <td>
                    <input name="file9" class="easyui-validatebox easyui-filebox" data-options="prompt:'请选择文件',buttonText:'选择文件'"
                           data-options="required:true,novalidate:true"/>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:;" onclick="editImg();"class="easyui-linkbutton" data-options="iconCls:'icon-add'" style = "height: 30px;">确认</a>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>