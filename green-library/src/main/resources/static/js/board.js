let currentPage = 0;
const itemsPerPage = 10;
let currentData = [];
let currentCondition = "";  // 전역 변수로 condition 설정

function updateTable(condition, data) {
    currentData = data;
    currentCondition = condition;  // 현재 condition 저장
    currentPage = 0;
    renderTable();
}

function renderTable() {
    const headers = {
        rentHistory: ["No", "등록번호", "신청도서정보", "대출일", "반납일", "상태", "기록제거"],
        borrow: ["No", "등록번호", "신청도서정보", "대출일", "반납일", "상태", "대출연장"],
        reserve: ["No", "예약번호", "도서제목", "예약일", "예약순위", "상태", "예약취소"],
        interest: ["No", "관심도서번호", "도서제목", "도서저자", "장르", "상태", "관심도서제거"]
    };

    const dataKeys = {
        rentHistory: ["no", "rentNum", "bookTitle", "rentDate", "returnDate", "status"],
        borrow: ["no", "rentNum", "bookTitle", "rentDate", "returnDate", "status"],
        reserve: ["no", "reservationId", "bookTitle", "reservationDate", "reservationRank", "availability"],
        interest: ["no", "interestId", "bookTitle", "bookAuthor", "genre", "availability"]
    };

    const captions = {
        rentHistory: "전체 대출 이력",
        borrow: "대출중인 도서",
        reserve: "신청한 예약도서",
        interest: "관심도서 조회"
    };

    document.getElementById('caption').innerText = captions[currentCondition];

    const tableHeader = document.getElementById('table-header');
    tableHeader.innerHTML = "";
    
    const headersArray = headers[currentCondition];
    for (let i = 0; i < headersArray.length; i++) {
        const th = document.createElement('th');
        th.innerText = headersArray[i];
        tableHeader.appendChild(th);
    }

    const tableBody = document.getElementById('table-body');
    tableBody.innerHTML = "";

    const startIndex = currentPage * itemsPerPage;
    const endIndex = Math.min(startIndex + itemsPerPage, currentData.length);

    if (currentData.length === 0) {
        const tr = document.createElement('tr');
        const td = document.createElement('td');
        td.colSpan = headers[currentCondition].length;
        td.innerText = "데이터가 없습니다.";
        tr.appendChild(td);
        tableBody.appendChild(tr);
    } else {
        for (let i = startIndex; i < endIndex; i++) {
            const tr = document.createElement('tr');
            for (let j = 0; j < dataKeys[currentCondition].length; j++) {
                const key = dataKeys[currentCondition][j];
                const td = document.createElement('td');
                td.innerText = currentData[i][key];
                tr.appendChild(td);
            }

            const actionTd = document.createElement('td');
            if (currentCondition === "rentHistory") {
                if (currentData[i]["status"] === "반납완료") {
                    actionTd.innerHTML = '<input type="button" class="btn" value="제거" onclick="confirmAction(\'deleteRentHistory\', \'' + currentData[i]["rentNum"] + '\')">';
                } else {
                    actionTd.innerHTML = "<input type='button' class='btn' value='불가능' disabled='true'>";
                }
            } else if (currentCondition === "borrow") {
                const rentDate = new Date(currentData[i]["rentDate"]);
                const returnDate = new Date(currentData[i]["returnDate"]);
                const diffTime = Math.abs(returnDate - rentDate);
                const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
                if (diffDays > 14) {
                    actionTd.innerHTML = "<input type='button' class='btn' value='불가능' disabled='true'>";
                } else {
                    actionTd.innerHTML = '<input type="button" class="btn" value="연장" onclick="window.open(\'bookLoanExtension\', \'_blank\', \'noopener,noreferrer\');">';
                }
            } else if (currentCondition === "reserve") {
                actionTd.innerHTML = '<input type="button" class="btn" value="취소" onclick="confirmAction(\'cancelReserve\', \'' + currentData[i]["reservationId"] + '\')">';
            } else if (currentCondition === "interest") {
                actionTd.innerHTML = '<input type="button" class="btn" value="제거" onclick="confirmAction(\'deleteInterest\', \'' + currentData[i]["interestId"] + '\')">';
            }
            tr.appendChild(actionTd);

            tableBody.appendChild(tr);
        }
    }

    document.getElementById('prev-button').disabled = currentPage === 0;
    document.getElementById('next-button').disabled = endIndex >= currentData.length;
    if(currentPage === 0 && endIndex >= currentData.length){
    	document.getElementById('prev-button').classList.add("hidden");
    	document.getElementById('next-button').classList.add("hidden");
    } else {
		document.getElementById('prev-button').classList.remove("hidden");
    	document.getElementById('next-button').classList.remove("hidden");
	}
}

function prevPage() {
    if (currentPage > 0) {
        currentPage--;
        renderTable();
    }
}

function nextPage() {
    if ((currentPage + 1) * itemsPerPage < currentData.length) {
        currentPage++;
        renderTable();
    }
}

function confirmAction(action, id) {
    let message = "이 작업을 수행하시겠습니까?";
    if (action === 'deleteRentHistory') {
        message = "대출 기록을 삭제하시겠습니까?";
    } else if (action === 'cancelReserve') {
        message = "예약을 취소하시겠습니까?";
    } else if (action === 'deleteInterest') {
        message = "관심 목록에서 삭제하시겠습니까?";
    }
    const confirmed = confirm(message);

    if (confirmed) {
        submitForm(action, id);
    }
}

function submitForm(action, id) {
    const csrfToken = document.querySelector('input[name="_csrf"]').value;

    const formData = new FormData();
    formData.append("id", id);
    formData.append("_csrf", csrfToken);

    fetch(action, {
        method: "POST",
        body: formData
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === "success") {
                updateTable(currentCondition, data.data);

                alert("작업이 성공적으로 완료되었습니다.");
            } else {
                alert("오류 발생: " + data.message);
            }
        })
        .catch(error => {
            alert("오류 발생: " + error);
        });
}

window.addEventListener('message', function (event) {
    const condition = event.data.condition;
    const data = event.data.data;
    updateTable(condition, data);
});
