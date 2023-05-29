var main = {
    init: function () {
        var _this = this;
        $('#board-save').on('click', function () {
            _this.boardSave();
        });

        $('#notice-save').on('click', function () {
            _this.noticeSave();
        })
    },
    boardSave: function () {

        var data = {
            b_type : '자유',
            b_title: $('#title').val(),
            b_content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/board/write',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            console.log(data);
            window.location.href = '/board';
        }).fail(function (error) {
            console.log(data);
            alert(JSON.stringify(error));
        })
    },
    noticeSave: function () {

        var data = {
            b_type : '공지',
            b_title: $('#title').val(),
            b_content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/notice/write',
            dataType: 'text',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            console.log(data);
            window.location.href = '/notice';
        }).fail(function (error) {
            console.log(data + "오류");
            alert(JSON.stringify(error));
        })

    }
};

main.init();