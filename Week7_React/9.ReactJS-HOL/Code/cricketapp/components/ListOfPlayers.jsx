const ListOfPlayers = ({ players }) => {
  const filteredPlayers = players.filter((player) => player.score < 70);

  return (
    <div>
      <div>
        <h1 className="text-2xl font-bold">List of Indian Players</h1>
        <div>
          {players.map((player, index) => (
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
        <h1 className="text-2xl font-bold">
          List of Players having score less than 70
        </h1>
        <div>
          {filteredPlayers.map((player, index) => (
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
    </div>
  );
};

export default ListOfPlayers;
