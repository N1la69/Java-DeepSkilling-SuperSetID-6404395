const heading = "Office Space";
const imgElement = (
  <img
    src="https://goyalco.com/wp-content/uploads/2024/09/how-to-choose-an-office-space.png"
    alt="office"
  />
);
const officeObj = [
  {
    name: "DBS",
    rent: 53000,
    location: "Bangalore",
  },
  {
    name: "HDFC",
    rent: 70000,
    location: "Chennai",
  },
];

const App = () => {
  return (
    <div className="p-4 flex flex-col items-center">
      <h1 className="text-3xl font-bold mb-3">{heading} at Affordable Range</h1>
      <div className="w-2xl">{imgElement}</div>
      <div className="mt-4 flex gap-2">
        {officeObj.map((office, index) => (
          <div key={index} className="border p-4 mb-4">
            <h2 className="text-2xl font-semibold">Name: {office.name}</h2>
            <p
              className={`text-xl font-medium ${
                office.rent > 60000 ? "text-green-500" : "text-red-500"
              }`}
            >
              Rent: ₹{office.rent}
            </p>
            <p>Location: {office.location}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default App;
