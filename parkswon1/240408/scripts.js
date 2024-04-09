let basicDatas = [
    { id: 1, title: "Todo 1", done: false },
    { id: 2, title: "Todo 2", done: true },
];

//페이지 로드시 실행
window.onload = function() {
    //basicDatas추가
    basicDatas.forEach(item => {
        var createTodo = createTodoElement(item.id, item.title, item.done);
        document.getElementById('todoList').appendChild(createTodo);
    });

    //Enter로 입력
    document.getElementById('todoInput').addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            addToDo();
        }
    });

    //버튼으로 입력
    document.getElementById('todoBtn').addEventListener('click', function(event) {
        event.preventDefault();
        addToDo();
    });
};

function addToDo() { //새로운 Todo를 추가하는 함수
    var todo = document.getElementById('todoInput').value;
    if (todo === '') { //입력값이 있는지 확인
        alert("Todo를 입력하세요");
        return;
    }

    var id = Math.max(...basicDatas.map(item => item.id)) + 1; //할일 목록중 가장큰 id에 1추가
    var done = false;

    //Todo 추가
    var createTodo = createTodoElement(id, todo, done);
    document.getElementById('todoList').appendChild(createTodo);
    basicDatas.push({ id: id, title: todo, done: done });
    document.getElementById('todoInput').value = ''; //입력칸 빈칸으로 만들기
}

//새로운 Todo 추가
function createTodoElement(id, todo, done) {
    var createTodo = document.createElement('li');
    createTodo.textContent = todo;
    if (done) {
        createTodo.classList.add('done');
    }
    createTodo.addEventListener('click', function() { //Todo를 클릭할 때 완료 상태를 변경
        done = !done;
        this.classList.toggle('done'); //class변경으로 취소선 추가제거
    });

    //삭제 버튼을 생성
    var deleteBtn = document.createElement('button');
    deleteBtn.textContent = "📌";
    deleteBtn.classList.add('deleteBtn');
    deleteBtn.onclick = function() { //삭제 버튼을 클릭 제거
        var itemId = parseInt(createTodo.getAttribute('data-id'));
        var index = basicDatas.findIndex(item => item.id === itemId);
        basicDatas.splice(index, 1); //basicDatas에서 제거
        createTodo.remove(); //화면에서 제거
    };
    
    //Todo 추가
    createTodo.appendChild(deleteBtn);
    createTodo.setAttribute('data-id', id);
    return createTodo;
}