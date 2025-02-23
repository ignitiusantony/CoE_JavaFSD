import React from "react";
import Card from './components/Card'; // Import the Card component

const Courses = () => {
  return (
    <div className="courses-container">
      <h1>Our Courses</h1>
      <Card /> {/* Use the Card component */}
    </div>
  );
};

export default Courses;
