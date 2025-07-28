const IndianPlayers = ({ players }) => {
  const oddPlayers = players.filter((player, idx) => idx % 2 !== 0);
  const evenPlayers = players.filter((player, idx) => idx % 2 === 0);

  const T20players = players.filter((player) => player.format === "T20");
  const RanjiPlayers = players.filter((player) => player.format === "Ranji");
  const AllIndianPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <div>
        <h1 className="text-2xl font-bold">Odd Players</h1>
        <div>
          {oddPlayers.map((player, index) => (
            <div key={index} className="flex items-center border-b py-2 gap-5">
              <h2>
                Name: <span className="font-semibold">{player.name}</span>
              </h2>
              <p>
                Score: <span className="font-semibold">{player.score}</span>
              </p>
            </div>
          ))}
        </div>
      </div>

      <div className="mt-8">
        <h1 className="text-2xl font-bold">Even Players</h1>
        <div>
          {evenPlayers.map((player, index) => (
            <div key={index} className="flex items-center border-b py-2 gap-5">
              <h2>
                Name: <span className="font-semibold">{player.name}</span>
              </h2>
              <p>
                Score: <span className="font-semibold">{player.score}</span>
              </p>
            </div>
          ))}
        </div>
      </div>

      <div className="mt-8">
        <h1 className="text-2xl font-bold">Indian Players</h1>
        <div>
          {AllIndianPlayers.map((player, index) => (
            <div key={index} className="flex items-center border-b py-2 gap-5">
              <h2>
                Name: <span className="font-semibold">{player.name}</span>
              </h2>
              <p>
                Score: <span className="font-semibold">{player.score}</span>
              </p>
              <p>
                Format: <span className="font-semibold">{player.format}</span>
              </p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default IndianPlayers;
