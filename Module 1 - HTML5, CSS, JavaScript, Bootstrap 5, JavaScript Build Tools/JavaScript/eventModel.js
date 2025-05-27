class Event {
  constructor(name, date, category, seats) {
    this.name = name;
    this.date = date;
    this.category = category;
    this.seats = seats;
  }
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};
