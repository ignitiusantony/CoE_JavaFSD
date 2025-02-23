import React from "react";
import { Link } from "react-router-dom"; // Import Link from react-router-dom
import "./Navbar.css"; // Import styles
import logo from "./open-book (1).png"; // Import logo

const Navbar = ({ activeSection }) => {
  return (
    <nav className="navbar sticky capsule small far-right">
      <h2 className="navbar-brand">
        <img src={logo} alt="Logo" />
      </h2>
      <ul className="navbar-nav">
        <li className={`nav-item ${activeSection === "home" ? "active" : ""}`}>
          <Link to="/">Home</Link>
        </li>
        <li className={`nav-item ${activeSection === "courses" ? "active" : ""}`}>
          <Link to="/courses">Courses</Link>
        </li>
        <li className={`nav-item ${activeSection === "about" ? "active" : ""}`}>
          <Link to="/about">Instructors</Link>
        </li>
        <li className={`nav-item ${activeSection === "contact" ? "active" : ""}`}>
          <Link to="/contact">Enrollment</Link>
        </li>
      </ul>
    </nav>
  );
};

export default Navbar;
