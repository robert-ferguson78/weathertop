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

// The following code is used to toggle menu
const burgerIcon = document.querySelector('#burger');
const navbarMenu = document.querySelector('#nav-links');

burgerIcon.addEventListener('click', () => {
    navbarMenu.classList.toggle('is-active');
});

function confirmdelete() {
    var x = document.getElementById("confirmDelete");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function cancel() {
    var y = document.getElementById("confirmDelete");
    if (y.style.display === "none") {
        y.style.display = "block";
    } else {
        y.style.display = "none";
    }
}

