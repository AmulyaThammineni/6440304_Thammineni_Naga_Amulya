function isValidEvent(event) {
  return new Date(event.date) > new Date() && event.seats > 0;
}
