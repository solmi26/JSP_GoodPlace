function deleteCheck() {
	if (confirm("정말 삭제하시겠습니까?")) {
		location.href = "./goodDelete.good?p_id=${good.p_id}";
	}
}

function checkAll(theForm) {
	if (theForm.remove.length == undefined) {
		theForm.remove.checked = theForm.allCheck.checked;
	} else {
		for (var i = 0; i < theForm.remove.length; i++) {
			theForm.remove[i].checked = theForm.allCheck.checked;
		}
	}
}

function cartAdd() {
	let val = document.getElementById("c_price").value;
	if (val == null || val == "" || val == undefined || val == 0) {
		alert("1원 이상 후원가능합니다.");
		return false
	} else {
		document.getElementById("frm").submit();
	}
}

function unrealized() {
	alert("아직 미구현 기능입니다. 죄송합니다.");
}