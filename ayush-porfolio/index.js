document.getElementById("contactForm").addEventListener("submit", function (e) {
    e.preventDefault();
  
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const message = document.getElementById("message").value.trim();
  
    const requestBody = {
      name: name,
      email: email,
      message: message
    };
  
    fetch("http://localhost:7979/api/v1/contact/message", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(requestBody)
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to send message");
        }
        return response.json();
      })
      .then((data) => {
        document.getElementById("responseMessage").textContent = "Message sent successfully!";
        document.getElementById("contactForm").reset();
      })
      .catch((error) => {
        document.getElementById("responseMessage").textContent = "Something went wrong. Please try again.";
        console.error("Error:", error);
      });
  });
  