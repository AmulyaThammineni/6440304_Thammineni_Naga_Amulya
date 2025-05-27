const container = document.querySelector("#events-container");

function displayEvent(event) {
  const card = document.createElement("div");
  card.className = "event-card";
  card.textContent = `${event.name} - ${event.date}`;
  container.appendChild(card);
}
