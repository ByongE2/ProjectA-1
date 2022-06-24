function formCheck_Login(frm) {
    let msg ='';

    if(frm.email.value.length==0) {
        setMessage('id를 입력해주세요.', frm.id);
        return false;
    }

    if(frm.password.value.length==0) {
        setMessage('password를 입력해주세요.', frm.pwd);
        return false;
    }
    return true;
}

function setMessage_Login(msg, element){
    document.getElementById("msg").innerHTML = ` ${'${msg}'}`;

    if(element) {
        element.select();
    }
}

function loginCheck() {
	if (document.frm.email.value.length == 0) {
		alert("아이디를 써주세요");
		frm.email.focus();
		return false;
	}
	if (document.frm.password.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.password.focus();
		return false;
	}
	return true;
}