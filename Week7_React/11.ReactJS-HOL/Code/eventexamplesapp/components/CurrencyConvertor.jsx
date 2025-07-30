"use client";

import React, { useState } from "react";

export default function CurrencyConvertor() {
  const [amount, setAmount] = useState("");
  const [converted, setConverted] = useState(null);
  const [direction, setDirection] = useState("INR_TO_EUR");

  const EXCHANGE_RATE = 90;

  const handleSubmit = () => {
    const input = parseFloat(amount);
    if (isNaN(input)) {
      alert("Please enter a valid number");
      return;
    }

    let result = 0;

    if (direction === "INR_TO_EUR") {
      result = input / EXCHANGE_RATE;
    } else {
      result = input * EXCHANGE_RATE;
    }

    setConverted(result.toFixed(2));
  };

  const toggleDirection = () => {
    setDirection((prev) =>
      prev === "INR_TO_EUR" ? "EUR_TO_INR" : "INR_TO_EUR"
    );
    setAmount("");
    setConverted(null);
  };

  return (
    <div className="flex flex-col items-center space-y-4 mt-6">
      <h1 className="text-2xl font-bold">Currency Converter</h1>

      <button
        onClick={toggleDirection}
        className="text-sm px-4 py-2 border cursor-pointer mb-2"
      >
        Switch to {direction === "INR_TO_EUR" ? "EUR ➝ INR" : "INR ➝ EUR"}
      </button>

      <input
        type="text"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
        placeholder={`Enter amount in ${
          direction === "INR_TO_EUR" ? "INR" : "EUR"
        }`}
        className="border p-2 rounded w-64 text-center"
      />

      <button
        onClick={handleSubmit}
        className="px-4 py-2 bg-indigo-500 text-white rounded hover:bg-indigo-600"
      >
        Convert
      </button>

      {converted !== null && (
        <p className="text-lg text-green-700 font-semibold">
          {direction === "INR_TO_EUR"
            ? `€ ${converted} EUR`
            : `₹ ${converted} INR`}
        </p>
      )}
    </div>
  );
}
