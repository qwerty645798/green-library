function updateTable(condition, data) {
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

        document.getElementById('caption').innerText = captions[condition];

        const tableHeader = document.getElementById('table-header');
        tableHeader.innerHTML = "";
        headers[condition].forEach(header => {
            const th = document.createElement('th');
            th.innerText = header;
            tableHeader.appendChild(th);
        });

        const tableBody = document.getElementById('table-body');
        tableBody.innerHTML = "";

        if (data.length === 0) {
            const tr = document.createElement('tr');
            const td = document.createElement('td');
            td.colSpan = headers[condition].length;
            td.innerText = "데이터가 없습니다.";
            tr.appendChild(td);
            tableBody.appendChild(tr);
        } else {
            data.forEach(item => {
                const tr = document.createElement('tr');
                dataKeys[condition].forEach(key => {
                    const td = document.createElement('td');
                    td.innerText = item[key];
                    tr.appendChild(td);
                });

                const actionTd = document.createElement('td');
                if (condition === "rentHistory") {
                    if (item["status"] === "반납완료") {
                        actionTd.innerHTML = '<input type="button" value="제거" onclick="confirmAction(\'deleteRentHistory\', \'' + item["rentNum"] + '\')">';
                    } else {
                        actionTd.innerHTML = "<span style='color:red;'>불가능</span>";
                    }
                } else if (condition === "borrow") {
                    const rentDate = new Date(item["rentDate"]);
                    const returnDate = new Date(item["returnDate"]);
                    const diffTime = Math.abs(returnDate - rentDate);
                    const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
                    if (diffDays > 14) {
                        actionTd.innerHTML = "<span style='color:red;'>불가능</span>";
                    } else {
                        actionTd.innerHTML = '<input type="button" value="연장" onclick="window.open(\'bookLoanExtension\', \'_blank\', \'noopener,noreferrer\');">';
                    }
                } else if (condition === "reserve") {
                    actionTd.innerHTML = '<input type="button" value="취소" onclick="confirmAction(\'cancelReserve\', \'' + item["reservationId"] + '\')">';
                } else if (condition === "interest") {
                    actionTd.innerHTML = '<input type="button" value="제거" onclick="confirmAction(\'deleteInterest\', \'' + item["interestId"] + '\')">';
                }
                tr.appendChild(actionTd);

                tableBody.appendChild(tr);
            });
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
    	console.log(id);
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
            	let condition;
                if (action === 'deleteRentHistory') {
                    condition = 'rentHistory';
                } else if (action === 'deleteBorrow') {
                    condition = 'borrow';
                } else if (action === 'cancelReserve') {
                    condition = 'reserve';
                } else if (action === 'deleteInterest') {
                    condition = 'interest';
                }
                updateTable(condition, data.data);

                alert("작업이 성공적으로 완료되었습니다.");
            } else {
                alert("오류 발생: " + data.message);
            }
        })
        .catch(error => {
            alert("오류 발생: " + error);
        });
    }

    window.addEventListener('message', function(event) {
        const condition = event.data.condition;
        const data = event.data.data;
        updateTable(condition, data);
    });