"use client";

import IndianPlayers from "@/components/IndianPlayers";
import ListOfPlayers from "@/components/ListOfPlayers";
import { useState } from "react";

const players = [
  { name: "Rohit Sharma", score: 87, format: "Ranji" },
  { name: "Shubman Gill", score: 73, format: "T20" },
  { name: "Virat Kohli", score: 92, format: "Ranji" },
  { name: "Shreyas Iyer", score: 65, format: "T20" },
  { name: "KL Rahul", score: 78, format: "Ranji" },
  { name: "Hardik Pandya", score: 70, format: "T20" },
  { name: "Ravindra Jadeja", score: 81, format: "Ranji" },
  { name: "Jasprit Bumrah", score: 69, format: "T20" },
  { name: "Mohammed Siraj", score: 61, format: "Ranji" },
  { name: "Kuldeep Yadav", score: 75, format: "T20" },
  { name: "Ravichandran Ashwin", score: 80, format: "Ranji" },
];

const App = () => {
  const [flag, setFlag] = useState(true);

  return (
    <div className="p-4">
      <h1 className="text-3xl font-bold mb-4">Cricket App</h1>
      <button
        className="mb-4 px-4 py-2 bg-blue-500 text-white rounded"
        onClick={() => setFlag(!flag)}
      >
        Click to Switch
      </button>
      {flag === true ? (
        <ListOfPlayers players={players} />
      ) : (
        <IndianPlayers players={players} />
      )}
    </div>
  );
};

export default App;
