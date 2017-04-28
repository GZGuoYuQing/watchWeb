

function showAddWatchWin(){
    $("#addWin").window("open");// 打开指定的window， open表示打开，close表示关闭
}
function showEditWatchWin(){
    var rows = $("#list").datagrid("getSelections");
    if(rows.length  > 1 ){
        $.messager.alert("提示","请选择一个要修改的产品","info");
    }else if(rows.length == 1){
        var row = rows[0];
        if(row){
            $("#editForm").form("load", row);
            $("#editWin").window("open");
        }
    }else if(rows.length == 0){
        $.messager.alert("提示","请选择一个要修改的产品","info");
    }

}


function addWatch() {
    if($("#addForm").form("validate")){
            $('#addForm').ajaxSubmit({
                url:'/material/add_material',
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


function editWatch(){
    if($("#editForm").form("validate")){
        $('#editForm').ajaxSubmit({
            url:'/material/update_material',
            type:'post',
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
                    $.get("/material/deleteById?ids=" + ids,
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
                $.get("/material/deleteById?ids=" + row.id,
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
    $.get("/material/query_pager?page=1&rows=20",
        function(data){
            $('#list').datagrid('reload',data.rows); // 重新加载数据表
        },"json");
}