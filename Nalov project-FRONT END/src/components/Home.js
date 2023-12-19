import React from 'react';
import './Home.css'; // Import a CSS file for styling
import image from'./image.jpg'

const Home = () => (
  <div className="home-container">
    <div className="content">
      <h2>Welcome to Home Page</h2>
      {/* Add home page content here */}
      <p><h2>Natlov Technologies Private Limited </h2>Is an unlisted private company incorporated on 05 April, 2023. It is classified as a private limited company and is located in Ranchi, Jharkhand. It's authorized share capital is INR 10.00 lac and the total paid-up capital is INR 1.00 lac.

The current status of Natlov Technologies Private Limited is - Active.

Details of the last annual general meeting of Natlov Technologies Private Limited are not available. The company is yet to submit its first full-year financial statements to the registrar.

Natlov Technologies Private Limited has two directors - Muskan and Sarita Devi.

The Corporate Identification Number (CIN) of Natlov Technologies Private Limited is U58201JH2023PTC020227. The registered office of Natlov Technologies Private Limited is at MAHLIPAPA BARE Brambe, Mandar, Ranchi, Jharkhand.</p>
    </div>
    <div className="image-container">
      <img
        src={image} // Replace with the actual image URL
        alt="Description of the image"
        className="image"
      />
    </div>
  </div>
);

export default Home;
