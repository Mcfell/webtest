

$(document).ready(function() {

    $("#c_update").on("click",function () {
        $("#company .c_add").show();
        var title = $('<input type="text" name="name" value="'+ $("#company .title").text()  +'"/>');
        $("#company .title").html(title);
        var detail = $('<textarea name="detail" style="width:100%" rows="10"/></textarea>');
        detail.val($("#company .excerpt").text());
        $("#company .excerpt").html(detail);
    })

    $("#companyForm").on("submit",function(e){
        $(this).ajaxSubmit({
            //定义返回JSON数据，还包括xml和script格式
            dataType:'json',
            success: function(data) {
                if (data.code >= 0) {
                    //提交成功后调用
                    alert("更新成功");
                    $("#company .c_add").hide();
                    $("#company .title").html($("#company .title input").val());
                    $("#company .excerpt").html($("#company .excerpt textarea").val());
                } else {
                    alert(data.msg);
                }
                e.preventDefault();
            }
        });
        //非常重要，如果是false，则表明是不跳转
        //在本页上处理，也就是ajax，如果是非false，则传统的form跳转。
        return false;
    })

    $("#c_cancle").on("click",function(){
        $("#company .c_add").hide();
        $("#company .title").html($("#company .title input").val());
        $("#company .excerpt").html($("#company .excerpt textarea").val());
    })
})
