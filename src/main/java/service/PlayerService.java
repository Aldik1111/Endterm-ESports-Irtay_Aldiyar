    package service;

    import model.Player;
    import repository.PlayerRepository;
    import exception.ValidationException;

    import java.util.List;
    import java.util.Optional;

    public class PlayerService {

        private final PlayerRepository playerRepository = new PlayerRepository();

        public void createPlayer(Player player) {
            validatePlayer(player);
            playerRepository.save(player);
        }

        public Optional<Player> getPlayerById(int id) {
            return playerRepository.findById(id);
        }

        public List<Player> getAllPlayers() {
            return playerRepository.findAll();
        }

        public void updatePlayer(Player player) {
            validatePlayer(player);
            playerRepository.save(player);
        }

        public void deletePlayer(int id) {
            playerRepository.deleteById(id);
        }

        public List<Player> getByTeam(int teamId) {
            return playerRepository.findByTeamId(teamId);
        }
        private void validatePlayer(Player player) {
            if (player.getName() == null || player.getName().isEmpty()) {
                throw new ValidationException("Player nickname cannot be empty");
            }
            if (player.getAge() <= 0) {
                throw new ValidationException("Player age must be positive");
            }
        }
    }
