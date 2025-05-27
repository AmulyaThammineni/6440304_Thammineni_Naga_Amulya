function addEvent(event) {
  events.push(event);
}

function registerUser(event) {
  try {
    if (event.seats > 0) {
      event.seats--;
    } else {
      throw "No seats available";
    }
  } catch (err) {
    console.error("Registration failed:", err);
  }
}
