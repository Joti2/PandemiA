package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Region;

//esta interface va heredar todo lo que tiene JpaRepositoyr por eso se pone extends, dentro de <> colocan el nombre del entity y el tipo de dato del id
public interface RegionRepository extends JpaRepository<Region, Integer> {
	List<Region> findByName(String name) throws Exception;
}
