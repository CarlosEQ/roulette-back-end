package co.roulette.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.roulette.model.Roulette;

/**
 * This class allows basic operations on the roulette
 * 
 * @author Carlos Quiñones
 * @version 1.0
 */
@Repository
public interface RouletteRepository extends CrudRepository<Roulette, Long> {

}
