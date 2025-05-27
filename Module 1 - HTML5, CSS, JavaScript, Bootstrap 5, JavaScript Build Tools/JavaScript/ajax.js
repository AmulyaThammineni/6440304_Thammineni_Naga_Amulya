const user = { name: "Amulya", email: "amulya@example.com" };

fetch("https://mock.api/register", {
  method: "POST",
  headers: { "Content-Type": "application/json" },
  body: JSON.stringify(user),
})
  .then(res => res.json())
  .then(data => alert("Registration successful!"))
  .catch(err => alert("Error: " + err));
