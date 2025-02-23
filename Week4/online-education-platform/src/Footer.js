import React from "react";
import "./Footer.css"; // Import styles

const Footer = () => {
    return (
        <footer className="footer">
            <p>&copy; 2023 EduPlatform. All rights reserved.</p>
            <p>
                <a href="/privacy">Privacy Policy</a> | <a href="/terms">Terms of Service</a>
            </p>
        </footer>
    );
};

export default Footer;
