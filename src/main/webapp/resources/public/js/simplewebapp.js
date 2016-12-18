/**
 * Created by Tan Dat on 16/12/2016.
 */
$(document).ready(function(){
    $('.ui.dropdown')
        .dropdown()
    ;
    $('#login-button').click(function(){
        $("#login-modal").modal('show');
    })
    $('#signup-button').click(function(){
        $("#signup-modal").modal('show');
    })
})
