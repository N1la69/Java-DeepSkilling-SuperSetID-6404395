"use client";

import { useState } from "react";

const LoginForm = ({ onLogin }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    if (username === "user" && password === "password") {
      localStorage.setItem("auth", "true");
      onLogin();
    } else {
      setError("Invalid credentials. Try user/password.");
    }
  };

  return (
    <form
      onSubmit={handleSubmit}
      className="border border-gray-700 rounded-md p-4 flex flex-col gap-4"
    >
      <h2 className="text-2xl font-bold">Login Form</h2>
      {error && <p style={{ color: "red" }}>{error}</p>}
      <div>
        <label className="text-lg font-semibold">Username: </label>
        <input
          type="text"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          className="border border-gray-300 rounded-md p-1"
        />
      </div>
      <div>
        <label className="text-lg font-semibold">Password: </label>
        <input
          type="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          className="border border-gray-300 rounded-md p-1"
        />
      </div>
      <button
        type="submit"
        style={{
          padding: "10px 20px",
          borderRadius: "5px",
          cursor: "pointer",
          backgroundColor: "blue",
          color: "white",
        }}
      >
        Login
      </button>
    </form>
  );
};

export default LoginForm;
