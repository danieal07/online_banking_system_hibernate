import React, { useState } from 'react';
import ReactDOM from 'react-dom/client';
import CurrencyConverter from './CurrencyConverter';

const App = () => {
  const [counter, setCounter] = useState(5);

  const incrementCounter = () => {
    setCounter(counter + 1);
    sayHello();
  };

  const decrementCounter = () => {
    setCounter(counter - 1);
  };

  const sayHello = () => {
    alert('Hello Member!');
  };

  const handleSyntheticEvent = () => {
    alert('I was clicked');
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  return (
    <div style={{ textAlign: 'center', padding: '20px' }}>
      <h1>Currency Converter!!!</h1>
      <p>Counter: {counter}</p>
      <button onClick={incrementCounter}>Increment</button>
      <button onClick={decrementCounter}>Decrement</button>
      <button onClick={() => sayWelcome('Welcome')}>Say Welcome</button>
      <button onClick={handleSyntheticEvent}>Click on me</button>
      <hr />
      <CurrencyConverter />
    </div>
  );
};

export default App;

// Use this in index.js
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<App />);
