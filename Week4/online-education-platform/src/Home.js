import React from "react";
import "./Home.css"; // Import the specific CSS file

const Home = () => {
    return (
        <div className="home-container">
            <div className="home">
                <div className="contentsofhome">
                    <h1>EduPlatform</h1>
                    <p>Your gateway to quality education</p>
                </div>
            </div>

            {/* About Us Section */}
            <section className="about">
                <div className="about-content">
                    <h2>About Us</h2>
                    <p>
                        Welcome to EduPlatform! We are dedicated to providing high-quality educational content
                        through an intuitive online platform. Our mission is to bridge the gap between students 
                        and educators, making learning accessible and engaging.
                    </p>
                </div>
            </section>
        </div>
    );
};

export default Home;
