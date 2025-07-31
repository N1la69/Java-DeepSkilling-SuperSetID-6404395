import { useState } from "react";
import LoginForm from "./LoginForm";

const flights = [
  { id: 1, from: "Delhi", to: "Mumbai", time: "10:00 AM" },
  { id: 2, from: "Bangalore", to: "Chennai", time: "2:00 PM" },
  { id: 3, from: "Kolkata", to: "Hyderabad", time: "6:30 PM" },
];

const GuestPage = ({ handler }) => {
  const [open, setOpen] = useState(false);
  const handleLogin = () => {
    setOpen(false);
    handler();
  };

  return (
    <div style={{ paddingTop: "20px" }}>
      <h2 className="text-xl font-semibold">Available Flights</h2>
      <ul style={{ paddingTop: "10px" }}>
        {flights.map((flight) => (
          <li key={flight.id}>
            <span className="font-semibold">{flight.from}</span> →{" "}
            <span className="font-semibold">{flight.to}</span> at{" "}
            <span className="font-semibold">{flight.time}</span>
          </li>
        ))}
      </ul>
      <div className="mt-4">
        <p>Please login to book tickets</p>
        <button
          onClick={() => setOpen(true)}
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
      </div>
      <div>{open && <LoginForm onLogin={handleLogin} />}</div>
    </div>
  );
};

export default GuestPage;
