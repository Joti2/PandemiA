package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	//Como employee tiene indices para buscar, podemos buscar por los nombres que estan en employees por indice
	List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
