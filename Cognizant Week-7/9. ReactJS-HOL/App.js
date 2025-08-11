import React from 'react';
import ListofPlayers from './ListofPlayers';
import Scorebelow70 from './Scorebelow70';
import OddPlayers from './OddPlayers';
import EvenPlayers from './EvenPlayers';
import ListofIndianPlayers from './ListofIndianPlayers';
import { players, IndianTeam, IndianPlayers } from './playersData';

function App() {
  const flag = false; // Set to true to show player scores

  if (flag) {
    return (
      <div>
        <h1>List of Players</h1>
        <ListofPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <Scorebelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Indian Team</h1>
        <h2>Odd Players</h2>
        <OddPlayers players={IndianTeam} />
        <hr />
        <h2>Even Players</h2>
        <EvenPlayers players={IndianTeam} />
        <hr />
        <h2>List of Indian Players Merged:</h2>
        <ListofIndianPlayers players={IndianPlayers} />
      </div>
    );
  }
}

export default App;
