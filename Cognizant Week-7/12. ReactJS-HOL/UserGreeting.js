import React from 'react';

function UserGreeting() {
  return (
    <div>
      <h2>Welcome back, User! You can now book your flight tickets.</h2>
      <h3>✈️ Available Flights</h3>
      <ul>
        <li>Chennai → Mumbai - ₹3,500 <button>Book</button></li>
        <li>Delhi → Bangalore - ₹4,200 <button>Book</button></li>
        <li>Hyderabad → Kolkata - ₹2,900 <button>Book</button></li>
      </ul>
    </div>
  );
}

export default UserGreeting;
    