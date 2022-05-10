package pe.edu.upc.pandemia.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//Composite Primary Key Class 
public class JobHistoryId implements Serializable {//Se pone Serializable porque este data va viajar
	private static final long serialVersionUID = 1L; //esto tiene que ir includio con Serializable
	
	private Integer employee; //Como Employee es un entity, pongo Integer porque tiene que ser el tipo de dato origen de Employee
	private Date startDate; //Date no es un entity, asi que se puede copiar normal de JobHistory
	
	//esto es constructor sin argumentos, osea paramentros para que en el JobHistory funcione el idclass 
	public JobHistoryId() {
		super();
	}

	// Constructor, esto se autogenera con SOurce->Construcctor using files
	public JobHistoryId(Integer employee, Date startDate) {
		super();
		this.employee = employee;
		this.startDate = startDate;
	}

	// Getter y Setter
	public Integer getEmployee() {
		return employee;
	}

	public void setEmployee(Integer employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(employee, startDate);//Estoy generando un hash con la combinacion del employee y el startdate porque al ser un indice compuesto, yo necesito garantizar que estot 2 valores son unicos dentro de la tabla
	}

	/** JobHistoryId jobHistoryId1 = new JobHistoryId(1, new Date("2021", "01", "10"));
	 * JobHistoryId jobHistoryId2 = new JobHistoryId(2, new Date("2021", "03", "10"));
	 * if (jobHistoryId1 == employee)
	 * if(this == obj) -> representativo
	 */	
	// if (a == b) -> Comparar Objetos
	@Override
	public boolean equals(Object obj) {
		// Si el objeto k ingresa para la comparacion es igual al objeto actual, entonces es return true porque es el mismo objeto
		if(this == obj)
			return true;
		// Si el objeto actal es null o las clases de los objetos son diferentes
		if(obj == null || this.getClass() != obj.getClass())
			return false;
		// Ahora voy a Verificar que los atributos sean iguales.
		// Realizo un Cast, osea convertir el objeto que entra en el objeto de esta clase
		JobHistoryId jobHistoryId = (JobHistoryId)obj;
		
		//Esto es: si el employee id del objeto actual es diferente al employee id del objeto que estoy comparando, es return false 
		if(this.employee != jobHistoryId.employee)
			return false;
		if(this.startDate != jobHistoryId.startDate)
			return false;
		return true;
	}
	
	
	//Para sacar el boolean equals, se hace llendo a source->Override/Implement Methods->selecciona equal y dar ok, tambien se pudo hacerlo con el hash
	//Esto solo crea el public boolean equals(...){} pero lo que va adentro lo tienes que hacer tu
	
	
}






