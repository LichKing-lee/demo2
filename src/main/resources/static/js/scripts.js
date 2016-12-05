$(".answer-write input[type='submit']").on("click", function (e) {
    e.preventDefault();

    var queryString = $(".answer-write").serialize();
    var url = $(".answer-write").attr("action");

    $.ajax({
        url: url,
        data: queryString,
        method: "post",
        dataType: "json",
        success: function (data) {
            var answerTemplate = $("#answerTemplate").html();
            var template = answerTemplate.format(data.user.userId, "", data.contents, data.question.id,
                data.id);

            $(".qna-comment-slipp-articles").prepend(template);
            $("textarea[name=contents]").val("");
        },
        error: function () {
            alert("fail!!");
        }
    });
});

$(".form-delete button[type='submit']").on("click", function(e){
    e.preventDefault();
    var url = $(e.target).parent().attr("action");

    $.ajax({
        url : url,
        method : "delete",
        dataType : "json",
        success : function(){
            $(e.target).parent().parent().parent().parent().parent().remove();
        },
        error : function(){
            alert("fail!!!");
        }
    });
});

String.prototype.format = function () {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function (match, number) {
        return typeof args[number] != 'undefined'
            ? args[number]
            : match
            ;
    });
};