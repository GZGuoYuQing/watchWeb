
var src='';
function showAddWatchWin(){
    getCombox("add");
    $("#addWin").window("open");// 打开指定的window， open表示打开，close表示关闭
}
function showEditWatchWin(){
    var rows = $("#list").datagrid("getSelections");
    getCombox("edit");
    if(rows.length  > 1 ){
        $.messager.alert("提示","请选择一个要修改的产品","info");
    }else if(rows.length == 1){
        var row = rows[0];
        if(row){
            getComboxValue(row);
            var time = row.dateTime;
            row.dateTime = "";
            $("#editForm").form("load", row);
            row.dateTime = time;
            $("#time").textbox("setValue", formatterDate(time));
            src=row;
            $("#editWin").window("open");
        }
    }else if(rows.length == 0){
        $.messager.alert("提示","请选择一个要修改的产品","info");
    }

}

function getComboxValue(row){
    $("#editType").combobox("setValue",row.type.id);
    $("#editAdmin").combobox("setValue",row.admin.id);
}


function addWatch() {
    if($("#addForm").form("validate")){
        $('#addForm').ajaxSubmit({
            url:'/forum/add_forum',
            type:'post',
            dataType: 'json',
            success: function (data) {
                if (data.result == "success") {
                    $("#addWin").window("close");
                    $("#list").datagrid("reload");
                    $("#addForm").form("clear");
                    $.messager.alert("提示",data.message,"info");
                } else if(data.result == "fail"){
                    $.messager.alert("提示",data.message,"info");

                }
            }
        });
    }else{
        $.messager.alert("提示","请输人正确的数据","info");
    }
}

function showVideo(){
    $("#showVideoWin").window("open");
    $("#video").attr("src","/"+src.video);
}

function showImage(){
    $("#showImageWin").window("open");
    $("#image").attr("src","/"+src.image);
}


function editWatch(){
    if($("#editForm").form("validate")){
        $('#editForm').ajaxSubmit({
            url:'/forum/update_forum',
            type:'POST',
            dataType: 'json',
            success: function (data) {
                if (data.result == "success") {
                    $("#editWin").window("close");
                    $("#list").datagrid("reload");
                    $("#editForm").form("clear");
                    $.messager.alert("提示",data.message,"info");
                } else if(data.result == "fail"){
                    $.messager.alert("提示",data.message,"info");

                }
            }

        });
    }else{
        $.messager.alert("提示","请输人正确的数据","info");
    }

}
function removeWatch(){
    var rows = $("#list").datagrid("getSelections");
    if(rows.length > 0){
        var ids = "";
        for(var i = 0, len = rows.length; i < len; i++){
            if(ids == ""){
                ids = rows[i].id;
            }else{
                ids += ","+rows[i].id
            }
        }
        if(ids != ""){
            $.messager.confirm('提示', '确定要删除吗?', function(r){
                if (r){
                    $.get("/forum/deleteById?ids=" + ids,
                        function(data){
                            $("#list").datagrid("reload"); // 重新加载指定数据网格数据
                        },"json");
                }
            });
        }
    }else{
        $.messager.alert("提示","请选中想要删除的产品","info");
    }
}

function removeWatch1(index){
    var row = $('#list').datagrid('getData').rows[index];
    if(row){
        $.messager.confirm('提示', '确定要删除吗?', function(r){
            if (r){
                $.get("/forum/deleteById?ids=" + row.id,
                    function(data){
                        $("#list").datagrid("reload"); // 重新加载指定数据网格数据
                    },"json");
            }
        });
    }else{
        $.messager.alert("提示","请选中想要删除的产品","info");
    }
}

function formatterOpt(value,row,index){
    return "<a href = 'javascript:;'onclick = 'showEditWatchWin1("+index+")'>编辑</a>&nbsp&nbsp"+
        "<a href = 'javascript:;' onclick = 'removeWatch1("+index+")'>删除</a>";
}


function queryByPage(){
    $.get("/forum/queryAll?page=1&rows=20",
        function(data){
            $('#list').datagrid('reload',data.rows); // 重新加载数据表
        },"json");
}


function showDes(value){
    return value.des;
}

function showName(value){
    return value.name;
}


function getCombox(id){
    //类型下拉菜单的级联查询
    $.get("/type/query_type",
        function(data){
            $("#"+id+"Type").combobox("loadData", data);
        }, "json");

    //用户下拉菜单的级联查询
    $.get("/admin/query_name",
        function(data){
            $("#"+id+"Admin").combobox("loadData", data);
        }, "json");

}


function formatterDate(value) {
    if (value == undefined || value == null || value == '') {
        return "";
    }
    else {
        var date = new Date(value);
        var year = date.getFullYear().toString();
        var month = (date.getMonth() + 1);
        var day = date.getDate().toString();
        var hour = date.getHours().toString();
        var minutes = date.getMinutes().toString();
        var seconds = date.getSeconds().toString();
        if (month < 10) {
            month = "0" + month;
        }
        if (day < 10) {
            day = "0" + day;
        }
        if (hour < 10) {
            hour = "0" + hour;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        if (seconds < 10) {
            seconds = "0" + seconds;
        }
        return year + "-" + month + "-" + day + " " + hour + ":" + minutes + ":" + seconds;
    }
}

















