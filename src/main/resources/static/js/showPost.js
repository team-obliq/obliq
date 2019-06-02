//adding event listener to upvote button

// function upvoteListener(){
//     document.getElementById('upvote').addEventListener('click',function (e) {
//         e.preventDefault();
//         console.log('WERE LISTENING');
//     });
//
// }
// upvoteListener();
$(document).ready(function() {
    console.log("hello");

    $('.eBtn').on('click', function(e) {
        console.log('hello again');
        e.preventDefault();
        let href = $(this).attr('href');
        $.get(href, function(comment, status) {
            $('.comment-edit #body').val(comment.body);

        })

        $('.comment-edit #editModal').modal();
    })


})