package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Job;
import pe.edu.upc.pandemia.model.repository.JobRepository;

@Named
@ApplicationScoped
public class JobRepositoryImpl implements JobRepository{

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Job> findById(String id) throws Exception {
		return this.findById(id, Job.class);
	}

	@Override
	public List<Job> findAll() throws Exception {
		String jpql="SELECT job FROM Job job";
		return this.findByQuery(Job.class, jpql);
	}

}
