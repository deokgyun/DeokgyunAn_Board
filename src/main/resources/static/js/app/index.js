var main = {
    init :function(){
        var _this = this;
        $('#btn-save').on('click', function(){
            _this.save();
        });

        $('#freeBoard').on('click', function(){
            _this.boardMove();
        })
    },
    save : function(){
        var data = {
            title : $('#title').val(),
            writer : $('#writer').val(),
            content : $('#content').val()
        };

        $.ajax({
            type:'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function(){
            alert('글이 등록되었습니다.');
            console.log(data);
            window.location.href='/';
        }).fail(function(error){
            console.log(data);
            alert(JSON.stringify(error));
        })
    },
    boardMove : function(){
        var url = "/posts";
        location.href=url;
    }
};

main.init();