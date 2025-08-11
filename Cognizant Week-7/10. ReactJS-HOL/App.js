import React from 'react';
import office1 from './assets/office1.jpg';
import office2 from './assets/office2.jpg';
import office3 from './assets/office3.jpg';

function App() {
  const element = "Office Space";

  const officeList = [
    { Name: "DBS", Rent: 50000, Address: "Chennai", Img: office1 },
    { Name: "Regus", Rent: 75000, Address: "Mumbai", Img: office2 },
    { Name: "SmartWorks", Rent: 58000, Address: "Bangalore", Img: office3 }
  ];

  const textRed = { color: 'red', fontWeight: 'bold' };
  const textGreen = { color: 'green', fontWeight: 'bold' };

  return (
    <div style={{ textAlign: 'center', padding: '30px' }}>
      <h1>{element}, at Affordable Range</h1>

      {officeList.map((ItemName, index) => {
        const colorStyle = ItemName.Rent <= 60000 ? textRed : textGreen;

        return (
          <div key={index} style={{ marginBottom: '50px' }}>
            <img
              src={ItemName.Img}
              alt="Office Space"
              width="25%"
              height="25%"
              style={{ borderRadius: '8px', boxShadow: '0px 2px 10px rgba(0,0,0,0.2)' }}
            />
            <h1>Name: {ItemName.Name}</h1>
            <h3 style={colorStyle}>Rent: Rs. {ItemName.Rent}</h3>
            <h3>Address: {ItemName.Address}</h3>
          </div>
        );
      })}
    </div>
  );
}

export default App;
