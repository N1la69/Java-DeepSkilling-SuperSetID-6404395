"use client";

import CurrencyConvertor from "@/components/CurrencyConvertor";
import { useState } from "react";

const App = () => {
  const [count, setCount] = useState(0);

  const increment = () => {
    setCount((prev) => prev + 1);
  };

  const sayHello = () => {
    alert("Hello! This is a static message.");
  };

  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const handleWelcome = (msg) => {
    alert(msg);
  };

  return (
    <div className="p-4">
      <h1>Counter Value: {count}</h1>

      <div className="flex gap-2 mt-2">
        <button
          className="px-4 py-2.5 border border-blue-500 hover:bg-blue-500 transition-colors duration-300 rounded-md cursor-pointer"
          onClick={handleIncrement}
        >
          Increment
        </button>
        <button
          className="px-4 py-2.5 border border-green-500 hover:bg-green-500 transition-colors duration-300 rounded-md cursor-pointer"
          onClick={() => setCount(count - 1)}
        >
          Decrement
        </button>
      </div>

      <div className="flex gap-2 mt-4">
        <button
          className="px-4 py-2.5 border border-yellow-500 hover:bg-yellow-500 transition-colors duration-300 rounded-md cursor-pointer"
          onClick={() =>
            handleWelcome("Welcome to the React Event Handling Example!")
          }
        >
          Say Welcome
        </button>
        <button
          onClick={() => alert("I am clicked")}
          className="px-4 py-2.5 border border-violet-500 hover:bg-violet-500 transition-colors duration-300 rounded-md cursor-pointer"
        >
          Click Me
        </button>
      </div>

      <div className="mt-6">
        <CurrencyConvertor />
      </div>
    </div>
  );
};

export default App;
