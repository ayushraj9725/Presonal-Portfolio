const API_BASE = "http://localhost:7979/api/v1/admin";

window.onload = () => {
  fetchMessages();
};

function fetchMessages() {
  fetch(`${API_BASE}/messages`)
    .then((res) => res.json())
    .then((data) => {
      const tableBody = document.getElementById("messageBody");
      tableBody.innerHTML = "";

      data.forEach((msg) => {
        const row = `
          <tr>
            <td>${msg.id}</td>
            <td>${msg.name}</td>
            <td>${msg.email}</td>
            <td>${msg.message.substring(0, 50)}...</td>
            <td>${new Date(msg.sentAt).toLocaleString()}</td>
            <td>
              <button class="btn btn-sm btn-info" onclick="viewMessage(${msg.id})">View</button>
              <button class="btn btn-sm btn-danger" onclick="deleteMessage(${msg.id})">Delete</button>
            </td>
          </tr>
        `;
        tableBody.innerHTML += row;
      });
    })
    .catch((err) => alert("Error fetching messages: " + err.message));
}

function viewMessage(id) {
  fetch(`${API_BASE}/message/${id}`)
    .then((res) => res.json())
    .then((msg) => {
      alert(`Message from ${msg.name}:\n\n${msg.message}`);
    })
    .catch(() => alert("Message not found"));
}

function deleteMessage(id) {
  if (confirm("Are you sure you want to delete this message?")) {
    fetch(`${API_BASE}/message/${id}`, {
      method: "DELETE",
    })
      .then((res) => res.text())
      .then((msg) => {
        alert(msg);
        fetchMessages();
      })
      .catch(() => alert("Failed to delete message"));
  }
}
