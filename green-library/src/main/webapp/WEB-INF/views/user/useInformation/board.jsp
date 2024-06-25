<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useInformationBoard</title>
<style>
body{
    display:flex;
    justify-content:center;
}
table#board {
    width: 1290px;
    border-collapse: collapse;
    border-top: 2px #ADADAD solid;
}

table#board th {
    background: #F7F7F7;
}

table#board th, table#board td {
    height: 50px;
    text-align: center;
}
table#board th {
    border-bottom: 2px #D7D7D7 solid;
}
table#board td {
    border-top: 2px #D7D7D7 solid;
}
.hidden {
    display: none;
}
#message {
    margin-top: 20px;
    font-size: 1.2em;
    color: green;
}
#error {
    margin-top: 20px;
    font-size: 1.2em;
    color: red;
}
</style>
</head>
<body>
    <form method="post" id="form">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <table id="board">
        <caption id="caption" style="margin-bottom: 40px; font-size: 2em; font-weight: bold;"></caption>
        <thead>
            <tr id="table-header"></tr>
        </thead>
        <tbody id="table-body">
            <!-- Data will be dynamically added here -->
        </tbody>
    </table>
    </form>
    <script>
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
        data.forEach(item => {
            const tr = document.createElement('tr');
            dataKeys[condition].forEach(key => {
                const td = document.createElement('td');
                td.innerText = item[key];
                tr.appendChild(td);
            });

            const actionTd = document.createElement('td');
            if (condition === "rentHistory") {
                actionTd.innerHTML = '<input type="button" value="제거" onclick="confirmAction(\'deleteRentHistory\', ${item["rentNum"]})">';
            } else if (condition === "borrow") {
                actionTd.innerHTML = '<input type="button" value="연장" onclick="window.open(\'bookLoanExtension\', \'_blank\', \'noopener,noreferrer\');">';
            } else if (condition === "reserve") {
                actionTd.innerHTML = '<input type="button" value="취소" onclick="confirmAction(\'cancelReserve\', ${item["reservationId"]})">';
            } else if (condition === "interest") {
                actionTd.innerHTML = '<input type="button" value="제거" onclick="confirmAction(\'deleteInterest\', ${item["interestId"]})">';
            }
            tr.appendChild(actionTd);

            tableBody.appendChild(tr);
        });
    }

    function confirmAction(action, id) {
        const confirmed = confirm("이 작업을 수행하시겠습니까?");
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

        fetch(`/your-endpoint/${action}`, {
            method: "POST",
            body: formData
        })
        .then(response => response.json())
        .then(data => {
            if (data.status === "success") {
                updateTable(action.replace('delete', '').toLowerCase(), data.data);
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
    </script>
</body>
</html>
