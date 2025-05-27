const events = [];

events.push(new Event("Yoga Day", "2025-07-01", "Health", 20));
const musicEvents = events.filter(e => e.category === "Music");
const cards = events.map(e => `${e.name} - ${e.category}`);
