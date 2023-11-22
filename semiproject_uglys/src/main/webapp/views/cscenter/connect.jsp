<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023-11-19
  Time: 오후 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WebSocket Example</title>
</head>
<body>
<input type="text" id="messageInput" placeholder="Type a message">
<button onclick="sendMessage()">Send</button>

<ul id="messageList"></ul>

<script>
    const socket = new WebSocket('ws://localhost:3000');

    socket.addEventListener('open', (event) => {
        console.log('WebSocket connection opened');
    });

    socket.addEventListener('message', (event) => {
        const messageList = document.getElementById('messageList');
        const messageItem = document.createElement('li');
        messageItem.textContent = event.data;
        messageList.appendChild(messageItem);
    });

    function sendMessage() {
        const messageInput = document.getElementById('messageInput');
        const message = messageInput.value;

        socket.send(message);

        // Clear the input field
        messageInput.value = '';
    }
</script>
</body>
</html>

$END$
</body>
</html>
