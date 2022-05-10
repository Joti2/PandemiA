package pe.edu.upc.pandemia.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.DepartmentService;
import pe.edu.upc.pandemia.model.entity.Department;
import pe.edu.upc.pandemia.model.repository.DepartmentRepository;
import pe.edu.upc.pandemia.model.repository.JpaRepository;

//Esto named y scoped se repiten en el repository y service(crud)
//Named es para instanciar el objeto(Creacion del objeto y manterlo alli, o sea crear un bin)
@Named

//Este objeto que acabo de crear tiene un alcanze, asi que tengo que definir el alcance con applicaction scoped
@ApplicationScoped


public class DepartmentServiceImpl implements DepartmentService {
	//inject lo que hace es lo que ya tenias instanciado y esta listo para insertar, aqui se injecta
	@Inject
	private DepartmentRepository departmentRepository;

	@Override
	public JpaRepository<Department, Integer> getJpaRepository() {
		return departmentRepository;
	}
	
	
	
}
