import React, { useState } from "react";
import { Outlet } from "react-router-dom";
import Navbar from "./Navbar";
import "./Layout.css"; // Import layout styles

const Layout = () => {
const [activeSection] = useState("home");

return (
    <div className="layout" style={{ margin: 0, padding: 0 }}>
    <Navbar activeSection={activeSection} />
    <main className="content">
        <Outlet />
    </main>
    </div>
  );
};

export default Layout;
