var check = function () {
    let bt = document.getElementById('btSubmit');
    if (document.getElementById('password').value == document.getElementById('confrimpassword').value) {
        document.getElementById('warning').style.color = 'green';
        document.getElementById('warning').innerHTML = 'Password Matching';
        bt.disabled = false;
    } else {
        document.getElementById('warning').style.color = 'red';
        document.getElementById('warning').innerHTML = '"Confirm Password" does not match "Password"';
        bt.disabled = true;
    }
}