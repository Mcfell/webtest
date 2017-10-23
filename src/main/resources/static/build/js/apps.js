
$(".softEdit").on("click",function(e){
    var id = $(this).parent().siblings(".softId").val();
    var url = "/app/update/" + id;
    $("#softEditModel").modal({
        remote: url
    });
});

$(".addSoft").on("click",function(e){
    var parentId = $(this).parent().siblings(".softId").val();
    var url = "/app/add?parentId=" + parentId;
    $("#softEditModel").modal({
        remote: url
    });
});

$(".addSoftCate").on("click",function(e){
    $("#softEditModel").removeData("bs.modal");
    var url = "/app/add";

    $("#softEditModel").modal({
        remote: url
    });
});

$(".softDelete").on("click",function(e){
    debugger
    var id = $(this).parent().siblings(".softId").val();
    var url = "/app/admin/delete/" + id;
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            console.log(data);
            if(data.code > 0){
                console.log('delete success');
            }else{
                console.log(data.message);
            }
        },
        error: function (data) {
            console.log(data.code);
        }
    });
})
/**清除模态窗口数据，避免只加载一次*/
$("#softEditModel").on("hidden.bs.modal", function() {
    $(this).removeData("bs.modal");
});

