import React from 'react';

const OddPlayers = ({ players }) => {
  return (
    <div>
      <li> First: {players[0]} </li>
      <li> Third: {players[2]} </li>
      <li> Fifth: {players[4]} </li>
    </div>
  );
};

export default OddPlayers;
