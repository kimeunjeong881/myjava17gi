function productCheck() {
	if (document.frm.name.value.length == 0) {
		alert("상품명을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.price.value.length == 0) {
		alert("가격을 써주세요");
		frm.price.focus();
		return false;
	}
	// isNaN 숫자형식이 아니면
	if (isNaN(document.frm.price.value)) {
		alert("숫자를 입력해야 합니다");
		frm.price.focus();
		return false;
	}
	// 중복클릭 방지
	// 최초클릭
	// 불리언변수 = false;
	// 최초클릭시 불리언변수 = true; 변경
	// 불리언변수의 true/false 조건을 보고 중복클릭인지 판단
	// 최초클릭 후에 버튼을 비활성화 시키는 방법도 있다
	
	return true;
}