package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	List<Location> findByCity(String city) throws Exception;
	List<Location> findByStateProvince(String stateProvince) throws Exception;
}
