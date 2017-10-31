$(document).ready(function () {
    $("#software_form_submit").on("click",function(){
        debugger
        $("#software_form").ajaxSubmit({
            dataType:'json',
            success:function(data){
                if (data.code >= 0) {
                    alert("更新成功");
                    $("#softEditModel").modal('hide');
                    window.location.reload();
                } else {
                    alert(data.msg);
                }
            }
        });
    })

    $("#uploadSubmit").on("click",function(){
        debugger
        $("#uploadForm").ajaxSubmit({
            //定义返回JSON数据，还包括xml和script格式
            dataType:'json',
            success: function(data) {
                if (data.code >= 0) {
                    //提交成功后调用
                    alert("上传成功");
                    $("#icon").val(data.data);
                } else {
                    alert(data.msg);
                }
            }
        });
    })
})