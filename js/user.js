document.addEventListener('DOMContentLoaded', function () {
    const searchForm = document.getElementById('searchForm');
    const searchType = document.getElementById('searchType');
    const searchKeyword = document.getElementById('searchKeyword');
    const userTableBody = document.getElementById('userTableBody');
    const resultCount = document.getElementById('resultCount');
    const userName = document.getElementById('userName');
    const userId = document.getElementById('userId');
    const userEmail = document.getElementById('userEmail');
    const userPhone = document.getElementById('userPhone');
    const loanInfoBody = document.getElementById('loanInfoBody');
    const banInfoBody = document.getElementById('banInfoBody');

    searchForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const type = searchType.value;
        const keyword = searchKeyword.value;
        searchUsers(type, keyword);
    });

    async function searchUsers(type, keyword) {
        try {
            const response = await fetch(`/User/search?searchType=${type}&searchKeyword=${keyword}`);
            const data = await response.json();
            renderUserTable(data);
        } catch (error) {
            console.error('Error fetching user data:', error);
        }
    }

    function renderUserTable(users) {
        userTableBody.innerHTML = '';
        resultCount.textContent = users.length;
        users.forEach(user => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td><input type="checkbox" name="userCheckbox" id="userCheckbox"></td>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>${user.userEmail}</td>
                <td><button class="modifyBtn" data-userid="${user.userId}">수정</button></td>
            `;
            userTableBody.appendChild(row);
        });

        document.querySelectorAll('.modifyBtn').forEach(button => {
            button.addEventListener('click', function () {
                const userId = this.dataset.userid;
                loadUserDetails(userId);
            });
        });
    }

    async function loadUserDetails(userId) {
        try {
            const response = await fetch(`/User/details?userId=${userId}`);
            const user = await response.json();
            renderUserDetails(user);
        } catch (error) {
            console.error('Error fetching user details:', error);
        }
    }

    function renderUserDetails(user) {
        userName.textContent = user.userName;
        userId.textContent = user.userId;
        userEmail.textContent = user.userEmail;
        userPhone.textContent = user.userPhone;
        // Populate loanInfoBody and banInfoBody if necessary
    }
});
