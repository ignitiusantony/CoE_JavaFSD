import React from "react";
import styled from "styled-components";
import InstructorCard from "./components/InstructorCard";
import instructorsData from "./data/instructors.json"; // Import the JSON data

const Instructors = () => {
  return (
    <StyledInstructors>
      <h1>Meet Our Instructors</h1>
      <p>Our expert instructors are here to guide you every step of the way.</p>
      <div className="instructors-container">
        {instructorsData.map((instructor) => (
          <InstructorCard
            key={instructor.name}
            name={instructor.name}
            role={instructor.role}
            facebook={instructor.facebook}
            twitter={instructor.twitter}
            linkedin={instructor.linkedin}
          />
        ))}
      </div>
    </StyledInstructors>
  );
};

const StyledInstructors = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  padding: 40px 20px;

  h1 {
    font-size: 2.5em;
    margin-bottom: 20px;
    color: #333;
  }

  p {
    font-size: 1.2em;
    color: #666;
    margin-bottom: 40px;
  }

  .instructors-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px;
    width: 100%;
    max-width: 1200px;
  }
`;

export default Instructors;
