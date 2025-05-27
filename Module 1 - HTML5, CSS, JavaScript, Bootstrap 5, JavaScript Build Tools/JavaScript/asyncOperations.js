fetch("data/events.json")
  .then(res => res.json())
  .then(data => console.log(data))
  .catch(err => console.error("Error fetching events:", err));
