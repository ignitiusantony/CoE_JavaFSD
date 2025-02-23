import React from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import coursesData from '../data/courses.json'; // Import the JSON data

const CourseDetails = () => {
  const { courseId } = useParams();
  const navigate = useNavigate();
  const course = coursesData[courseId];

  if (!course) {
    return <div>Course not found</div>;
  }

  const handleEnrollClick = () => {
    course.enrolled = true;
    navigate('/contact');
  };

  return (
    <StyledCourseDetails>
      <h1>{course.name}</h1>
      <p>{course.description}</p>
      <h2>Instructor: {course.instructor}</h2>
      <p>Cost: {course.cost}</p>
      <p>Duration: {course.duration}</p>
      <button onClick={handleEnrollClick}>Enroll Now</button>
    </StyledCourseDetails>
  );
};

const StyledCourseDetails = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  padding: 20px;

  h1 {
    font-size: 2.5em;
    margin-bottom: 20px;
  }

  p {
    font-size: 1.2em;
    margin-bottom: 10px;
  }

  h2 {
    font-size: 1.5em;
    margin-bottom: 10px;
  }

  button {
    padding: 10px 20px;
    font-size: 1em;
    cursor: pointer;
    background-color: #4c1d95;
    color: white;
    border: none;
    border-radius: 5px;
    transition: background-color 0.3s;

    &:hover {
      background-color: #3a0d75;
    }
  }
`;

export default CourseDetails;
