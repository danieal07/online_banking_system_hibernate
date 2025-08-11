import React, { useState } from 'react';

function CurrencyConverter() {
  const [amount, setAmount] = useState('');
  const [converted, setConverted] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault(); // synthetic event
    const rate = 0.011; // Example: 1 INR = 0.011 EUR
    const result = parseFloat(amount) * rate;
    setConverted(result.toFixed(2));
  };

  return (
    <div style={{ marginTop: '30px' }}>
      <h2>Convert INR to Euro</h2>
      <form onSubmit={handleSubmit}>
        <label>Amount in INR: </label>
        <input
          type="number"
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          required
        />
        <button type="submit">Convert</button>
      </form>
      {converted && <h3>Converted Amount: € {converted}</h3>}
    </div>
  );
}

export default CurrencyConverter;
