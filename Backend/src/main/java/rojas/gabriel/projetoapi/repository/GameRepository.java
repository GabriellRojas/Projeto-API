package rojas.gabriel.projetoapi.repository;

import rojas.gabriel.projetoapi.models.GameEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GameRepository extends CrudRepository<GameEntity, Long> {
}
