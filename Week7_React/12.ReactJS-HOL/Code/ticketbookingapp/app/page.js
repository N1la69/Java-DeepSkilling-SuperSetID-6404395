"use client";

import GuestPage from "@/components/GuestPage";
import LoginForm from "@/components/LoginForm";
import UserPage from "@/components/UserPage";
import { useEffect, useState } from "react";

const App = () => {
  const [loggedIn, setLoggedIn] = useState(false);

  useEffect(() => {
    const storedAuth = localStorage.getItem("auth");
    if (storedAuth === "true") {
      setLoggedIn(true);
    }
  }, []);

  const handleLogin = () => setLoggedIn(true);
  const handleLogout = () => {
    setLoggedIn(false);
    localStorage.removeItem("auth");
  };

  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold">Ticket Booking App</h1>
      {loggedIn ? (
        <>
          <UserPage />
          <button
            onClick={handleLogout}
            style={{
              padding: "10px 20px",
              borderRadius: "5px",
              cursor: "pointer",
              backgroundColor: "blue",
              color: "white",
            }}
          >
            Logout
          </button>
        </>
      ) : (
        <>
          <GuestPage handler={handleLogin} />
        </>
      )}
    </div>
  );
};

export default App;
