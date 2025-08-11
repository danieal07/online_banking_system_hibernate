import React from 'react';

const EvenPlayers = ({ players }) => {
  return (
    <div>
      <li> Second: {players[1]} </li>
      <li> Fourth: {players[3]} </li>
      <li> Sixth: {players[5]} </li>
    </div>
  );
};

export default EvenPlayers;
