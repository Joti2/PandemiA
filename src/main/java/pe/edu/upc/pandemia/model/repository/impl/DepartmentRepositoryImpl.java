package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Department;
import pe.edu.upc.pandemia.model.repository.DepartmentRepository;

@Named
@ApplicationScoped

public class DepartmentRepositoryImpl implements DepartmentRepository {

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Department> findById(Integer id) throws Exception {
		return this.findById(id, Department.class);
	}

	@Override
	public List<Department> findAll() throws Exception {
		String jpql="SELECT department FROM Department department";
		return this.findByQuery(Department.class, jpql);
	}

}
