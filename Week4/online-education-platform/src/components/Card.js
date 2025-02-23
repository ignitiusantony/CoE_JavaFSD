import React from 'react';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom'; // Import useNavigate
import { FaPython, FaJava, FaPlus, FaLeaf, FaReact } from 'react-icons/fa';
import { SiDjango } from 'react-icons/si';

const Card = () => {
  const navigate = useNavigate(); // Initialize useNavigate

  const handleCardClick = (course) => {
    navigate(`/course/${course}`);
  };

  return (
    <StyledWrapper>
      <div className="cards">
        <div className="card dark-blue" onClick={() => handleCardClick('python')}>
          <div className="icon-and-name">
            <FaPython className="icon" />
            <p className="tip">Python</p>
          </div>
          <p className="second-text">
            A beginner-friendly and versatile programming language used in web development, 
            data science, AI, automation, and more. Its simplicity and rich ecosystem make 
            it a favorite among developers.
          </p>
        </div>
        <div className="card dark-gray" onClick={() => handleCardClick('java')}>
          <div className="icon-and-name">
            <FaJava className="icon" />
            <p className="tip">Java</p>
          </div>
          <p className="second-text">
            A robust, object-oriented language widely used in enterprise applications, 
            Android development, and backend systems. Known for its platform independence 
            and security.
          </p>
        </div>
        <div className="card dark-cyan" onClick={() => handleCardClick('cpp')}>
          <div className="icon-and-name">
            <FaPlus className="icon" />
            <FaPlus className="icon" />
            <p className="tip">C++</p>
          </div>
          <p className="second-text">
            A high-performance language with low-level memory control, often used in 
            game development, competitive programming, and system software like operating systems.
          </p>
        </div>
        <div className="card dark-green" onClick={() => handleCardClick('spring')}>
          <div className="icon-and-name">
            <FaLeaf className="icon" />
            <p className="tip">Spring</p>
          </div>
          <p className="second-text">
            A powerful Java framework used for building scalable, enterprise-grade applications. 
            It simplifies backend development with features like dependency injection and MVC architecture.
          </p>
        </div>
        <div className="card dark-gold" onClick={() => handleCardClick('django')}>
          <div className="icon-and-name">
            <SiDjango className="icon" />
            <p className="tip">Django</p>
          </div>
          <p className="second-text">
            A high-level Python web framework that promotes rapid development and clean, pragmatic 
            design. Ideal for building secure and scalable web applications efficiently.
          </p>
        </div>
        <div className="card dark-purple" onClick={() => handleCardClick('reactjs')}>
          <div className="icon-and-name">
            <FaReact className="icon" />
            <p className="tip">ReactJS</p>
          </div>
          <p className="second-text">
            A JavaScript library for building dynamic, interactive user interfaces. Used for 
            developing modern single-page applications with reusable components and fast rendering.
          </p>
        </div>
      </div>
    </StyledWrapper>
  );
};

const StyledWrapper = styled.div`
  @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@600&family=Poppins:wght@300;400&display=swap');

  .cards {
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px;
    justify-content: center;
    align-items: center;
    padding: 20px;
  }

  .cards .card {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-between;
    text-align: center;
    height: 250px;
    width: 420px;
    border-radius: 12px;
    cursor: pointer;
    transition: 400ms;
    padding: 25px;
    box-shadow: 0px 4px 10px rgba(255, 255, 255, 0.1);
    font-family: 'Poppins', sans-serif;
  }

  .cards .icon-and-name {
    display: flex;
    align-items: center;
    gap: 10px;
  }

  .cards .card .icon {
    font-size: 2.5em; /* Increased icon size */
  }

  .cards .card p.tip {
    font-size: 1.5em;
    font-weight: 600;
    font-family: 'Montserrat', sans-serif;
  }

  .cards .card p.second-text {
    font-size: 1em;
    line-height: 1.5;
    max-width: 90%;
    padding-bottom: 3em;
  }

  .cards .card:hover {
    transform: scale(1.05);
    box-shadow: 0px 6px 15px rgba(255, 255, 255, 0.2);
  }

  .cards:hover > .card:not(:hover) {
    filter: brightness(0.7);
    transform: scale(0.95);
  }

  /* Background colors */
  .cards .dark-blue {
    background-color: #1e3a8a; /* Dark navy blue */
    color: white;
  }

  .cards .dark-gray {
    background-color: #374151; /* Dark gray */
    color: white;
  }

  .cards .dark-cyan {
    background-color: #065f46; /* Dark teal/cyan */
    color: white;
  }

  .cards .dark-green {
    background-color: #166534; /* Deep forest green */
    color: white;
  }

  .cards .dark-gold {
    background-color: #b68c2e; /* Elegant gold */
    color: white;
  }

  .cards .dark-purple {
    background-color: #4c1d95; /* Rich dark purple */
    color: white;
  }
`;

export default Card;
