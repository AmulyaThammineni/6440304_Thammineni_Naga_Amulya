document.getElementById("regForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const name = e.target.elements["name"].value;
  const email = e.target.elements["email"].value;
  if (!name || !email) {
    alert("Please fill in all fields.");
  } else {
    console.log("Registered:", name, email);
  }
});
