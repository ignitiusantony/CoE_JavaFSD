import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Layout from "./Layout";
import Home from "./Home";
import Courses from "./Courses";
import Instructors from "./Instructors";
import Enrollment from "./pages/Enrollment"; // Import Enrollment component
import Footer from "./Footer"; // Import Footer component
import Loader from './Loader'; // Import Loader component
import CourseDetails from './pages/CourseDetails'; // Import CourseDetails component

const App = () => {
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const timer = setTimeout(() => {
      setLoading(false);
    }, 3000);

    return () => clearTimeout(timer);
  }, []);

  if (loading) {
    return <Loader />;
  }

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />
            <Route path="courses" element={<Courses />} />
            <Route path="about" element={<Instructors />} />
            <Route path="contact" element={<Enrollment />} />
            <Route path="course/:courseId" element={<CourseDetails />} />
          </Route>
        </Routes>
      </Router>
      <Footer /> 
    </div>
  );
};

export default App;
