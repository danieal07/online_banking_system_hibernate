import React from 'react';

const ListofIndianPlayers = ({ players }) => {
  return (
    <div>
      {players.map((player, index) => (
        <li key={index}>Mr. {player}</li>
      ))}
    </div>
  );
};

export default ListofIndianPlayers;
