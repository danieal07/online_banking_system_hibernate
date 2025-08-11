import React from 'react';

function GuestGreeting() {
  return (
    <div>
      <h2>Welcome, Guest! Please log in to book your flight tickets.</h2>
      <h3>✈️ Available Flights (View Only)</h3>
      <ul>
        <li>Chennai → Mumbai - ₹3,500</li>
        <li>Delhi → Bangalore - ₹4,200</li>
        <li>Hyderabad → Kolkata - ₹2,900</li>
      </ul>
    </div>
  );
}

export default GuestGreeting;
