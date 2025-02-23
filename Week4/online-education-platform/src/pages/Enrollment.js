import React, { useState } from 'react';
import styled from 'styled-components';
import coursesData from '../data/courses.json'; // Import the JSON data

const Enrollment = () => {
  const [enrolledCourses, setEnrolledCourses] = useState(
    Object.keys(coursesData).filter(courseId => coursesData[courseId].enrolled)
  );

  const handleRemoveClick = (courseId) => {
    setEnrolledCourses(prevCourses => prevCourses.filter(id => id !== courseId));
  };

  return (
    <StyledEnrollment>
      <h1>Enrolled Courses</h1>
      {enrolledCourses.length === 0 ? (
        <p>No courses enrolled yet.</p>
      ) : (
        <div className="courses-container">
          {enrolledCourses.map(courseId => (
            <CourseItem key={courseId} courseId={courseId} onRemove={handleRemoveClick} />
          ))}
        </div>
      )}
    </StyledEnrollment>
  );
};

const CourseItem = ({ courseId, onRemove }) => {
  const course = coursesData[courseId];
  const enrolledDate = new Date().toLocaleDateString();
  const expiringDate = new Date(new Date().setMonth(new Date().getMonth() + parseInt(course.duration))).toLocaleDateString();

  return (
    <StyledCourseItem>
      <h2>{course.name}</h2>
      <p>Enrolled Date: {enrolledDate}</p>
      <p>Expiring Date: {expiringDate}</p>
      <button onClick={() => onRemove(courseId)}>Remove</button>
    </StyledCourseItem>
  );
};

const StyledEnrollment = styled.div`
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

  .courses-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 20px; 
    width: 100%;
    max-width: 900px;
  }
`;

const StyledCourseItem = styled.div`
  background: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  text-align: center;
  max-width: 350px;
  width: 100%;
  transition: transform 0.2s ease-in-out;

  &:hover {
    transform: scale(1.05);
  }

  h2 {
    font-size: 1.5em;
    margin-bottom: 10px;
    color: #333;
  }

  p {
    font-size: 1em;
    color: #666;
    margin-bottom: 15px;
  }

  button {
    padding: 10px 20px;
    font-size: 1em;
    cursor: pointer;
    background-color: #d9534f;
    color: white;
    border: none;
    border-radius: 5px;
    transition: background-color 0.3s;

    &:hover {
      background-color: #c9302c;
    }
  }
`;

export default Enrollment;
