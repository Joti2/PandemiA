package pe.edu.upc.pandemia.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.JobService;
import pe.edu.upc.pandemia.model.entity.Job;
import pe.edu.upc.pandemia.model.repository.JobRepository;
import pe.edu.upc.pandemia.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class JobServiceImpl implements JobService {

	@Inject
	private JobRepository jobRepository;
	
	@Override
	public JpaRepository<Job, String> getJpaRepository() {
		return jobRepository;
	}

}
