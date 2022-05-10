package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;

@Named //Basicamente esto hace esto: EmployeeRepositoryImpl employeeRepositoryImpl = new EmployeeRepositoryImpl(); COMO CUANDO DECLARO UN OBJETO
@ApplicationScoped //Basicamente esto hace que el objeto que acabo de declarar(en este caso seria employeeRepositoryImpl) lo pueda usar en toda la aplicacion
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Employee> findById(Integer id) throws Exception {
		return findById(id,Employee.class);
	}

	@Override
	public List<Employee> findAll() throws Exception {
		String jpql= "SELECT employee FROM Employee employee";
		return this.findByQuery(Employee.class, jpql);
	}

	@Override
	public List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		String jpql= "SELECT em FROM Employee em WHERE em.lastName= '" + lastName + "' and em.firstName= '" + firstName + "'";
		return this.findByQuery(Employee.class, jpql);
	}

}
