package pe.edu.upc.pandemia.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.EmployeeService;
import pe.edu.upc.pandemia.model.entity.Employee;
import pe.edu.upc.pandemia.model.repository.EmployeeRepository;
import pe.edu.upc.pandemia.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService{

	@Inject //Esto hace que injecto el objeto que declare en el RepositoryImpl
	private EmployeeRepository employeeRepository;
	
	@Override
	public JpaRepository<Employee, Integer> getJpaRepository() {
		return employeeRepository;
	}

	@Override
	public List<Employee> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return employeeRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
