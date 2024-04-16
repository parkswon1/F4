let basicDatas = [
    { id: 1, title: "Todo 1", done: false },
    { id: 2, title: "Todo 2", done: true },
];

const todoBtn = document.getElementById("todoBtn");
const ul = document.getElementById("todo-item-list");
const todoInput = document.getElementById("todo-value");

setTodo();

function setTodo() {
    ul.innerHTML = "";
    basicDatas.forEach((data) => {
        const li = document.createElement("li");
        li.classList.add("todo-item");

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.id = `todo-${data.id}`;
        checkbox.checked = data.done;

        const label = document.createElement("label");
        label.htmlFor = checkbox.id;
        label.textContent = data.title;
        label.classList.add("todo-text")

        checkbox.addEventListener("change", () => {
        const updatedTodo = basicDatas.find((todo) => todo.id === data.id);
        updatedTodo.done = checkbox.checked;
        });

        const removeButton = document.createElement("button");
        removeButton.classList.add("remove-button");
        removeButton.textContent = "x";
        removeButton.addEventListener("click", (event) => {
        const li = event.target.parentNode;
        const id = parseInt(li.id.split("-")[1]);

        const todoIndex = basicDatas.findIndex((todo) => todo.id === id);
        basicDatas.splice(todoIndex, 1);

        li.parentNode.removeChild(li);
        });

        li.appendChild(checkbox);
        li.appendChild(label);
        li.appendChild(removeButton);

        ul.appendChild(li);
    });
    }

function enterkey() {
    if(window.event.keyCode == 13) {
        newTodo();
    }
}

todoBtn.addEventListener("click", () => {
    newTodo();
});

function newTodo() {
    const newId = Math.max(...basicDatas.map((todo) => todo.id)) + 1;
    const newTitle = todoInput.value.trim();

    if (!newTitle) {
        alert("할 일을 입력하세요!");
        return;
    }

    const newTodo = {
        id: newId,
        title: newTitle,
        done: false,
    };

    basicDatas.push(newTodo);
    setTodo();

    todoInput.value = "";
}