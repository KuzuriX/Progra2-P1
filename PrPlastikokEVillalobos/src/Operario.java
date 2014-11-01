/**
 * Operario
 * @author Elizabeth Villalobos
 */
public class Operario {
	private String cedula;
	private String nombre;
	private static int cantReparaciones = 0;
	
	/**
	 * Operario
	 * Constructor.
	 * @param pcedula número de cedula del operario
	 * @param pnombre nombre completo del operario
	 */
	public Operario(String pcedula, String pnombre) {
		setCedula(pcedula);
		setNombre(pnombre);
	}
	
	/**
	 * getCedula
	 * Retorna el valor del atributo cedula del operario.
	 * @return String cedula de la operario.
	 */
	private String getCedula() {
		return cedula;
	}
	
	/**
	 * setCedula
	 * Estable un valor para el atributo cédula del operario.
	 * @param pcedula cédula de la operario.
	 */
	private void setCedula(String pcedula) {
		cedula = pcedula;
	}
	
	/**
	 * getNombre
	 * Retorna el valor del atributo nombre del operario.
	 * @return String nombre de la operario.
	 */
	private String getNombre() {
		return nombre;
	}
	
	/**
	 * setNombre
	 * Estable un valor para el atributo nombre del operario.
	 * @param pnombre nombre de la operario.
	 */
	private void setNombre(String pnombre) {
		nombre = pnombre;
	}
	
	/**
	 * incrementarCantReparaciones
	 * Incrementa en uno el total de máquinas reparadas por el operario.
	 */
	private void incrementarCantReparaciones() {
		cantReparaciones++;
	} 
	
	/**
	 * repararMaquina
	 * Repara una máquina averiada.
	 * 
	 */
	public void repararMaquina() {
		// TODO @eli: agregar toda la logica para reparar la maquina.
		
		// Una vez finalizada la reparacion, se debe incrementar en uno
		// el total de maquinas reparadas.
		incrementarCantReparaciones();
	}
}
