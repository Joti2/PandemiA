package pe.edu.upc.pandemia.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * 
 * @author Programación Web
 *
 * @param <T> Entity
 * @param <ID> Tipo de dato del ID del Entity
 */
public interface JpaRepository<T, ID> {//yo quiero un repository(interface) generica, el T significa entity o sea alli va ir una entidad cualesquiera
	//<> los valores dentro de eso significan que pueden ser cualquier dato(tipo)
	//ID es otro valor que representa el tipo de dato que representa el id del entity, o sea el ID puede ser String float, etc...
	EntityManager getEntityManager();
	
	default T save(T entity) throws Exception {
		getEntityManager().persist(entity);//con el persist, yo logro de mi clase, guardar en mi base de datos
		return entity;
	}
	
	default T update(T entity) throws Exception {		
		return getEntityManager().merge(entity);//merge se encarga de actualizar
	}
	
	Optional<T> findById(ID id) throws Exception;// esto busca por el ID
	
	
	default Optional<T> findById(ID id, Class<T> entityClass) throws Exception {
		Optional<T> optional = Optional.empty();
		T entity = getEntityManager().find(entityClass, id);
		if (entity != null) {
			optional = Optional.of(entity);
		}		
		return optional;
	}
	
	List<T> findAll() throws Exception;//esto es para tener todos los elementos de una tabla
	
	default List<T> findByQuery(Class<T> entityClass, String jpql) throws Exception {
		List<T> entities = new ArrayList<T>();
		// Execute Query
		TypedQuery<T> typedQuery = getEntityManager().createQuery(jpql, entityClass);
		// Getting result list
		entities = typedQuery.getResultList();		
		return entities;
	}
	
	default void deleteById(ID id) throws Exception {
		// Exist or not -> findById
		Optional<T> optional = findById(id);
		// If exist 
		if (optional.isPresent()) {
			// Remove the object from optional
			getEntityManager().remove(optional.get());
		}
	}
}
