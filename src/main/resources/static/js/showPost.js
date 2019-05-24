//adding event listener to upvote button

function upvoteListener(){
    document.getElementById('upvote').addEventListener('click',function (e) {
        e.preventDefault();
        console.log('WERE LISTENING');
    });

}
upvoteListener();

function cardListener() {
    document.getElementById('card-create').addEventListener('click', function (e) {
        e.preventDefault();
        console.log('the CARD is listening');
    });
}

cardListener();