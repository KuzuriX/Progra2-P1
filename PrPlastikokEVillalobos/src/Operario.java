/**
 * Operario
 * @author Elizabeth Villalobos
 */
public class Operario {
	private String cedula;
	private String nombre;
	private int cantMaquinasRep = 0;
	private CentroControl centroControl;
	
	/**
	 * Operario
	 * Constructor.
	 * @param pcedula número de cedula del operario
	 * @param pnombre nombre completo del operario
	 */
	public Operario(String pcedula, String pnombre, CentroControl pCentroControl) {
		setCedula(pcedula);
		setNombre(pnombre);
		setCentroControl(pCentroControl);
	}
	
	/**
	 * getCedula
	 * Retorna el valor del atributo cedula del operario.
	 * @return String cedula de la operario.
	 */
	public String getCedula() {
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
	public String getNombre() {
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
	 * getCantMaquinasRep
	 * Retorna la cantidad de maquinas reparadas por el operario.
	 * @return int total de maquinas reparadas.
	 */
	private int getCantMaquinasRep() {
		return cantMaquinasRep;
	}
	
	/**
	 * incrementarCantMaquinasRep
	 * Incrementa en uno la cantidad de máquinas reparadas por el operario.
	 */
	private void incrementarCantMaquinasRep() {
		cantMaquinasRep++;
	}
	
	/**
	 * getCentroControl
	 * Retorna el centro de control de averias relacionado con el operario.
	 * @return CentroControl el centro de control asociado al operario.
	 */
	private CentroControl getCentroControl() {
		return centroControl;
	}
	
	/**
	 * setCentroControl
	 * Establece una referencia con un centro de control de averias.
	 * @param pcentroControl el centro de control que debe asociarse 
	 * con el operario.
	 */
	private void setCentroControl(CentroControl pcentroControl) {
		centroControl = pcentroControl;
	}
	
	/**
	 * repararMaquina
	 * Repara una máquina averiada. Si la falla de la maquina se debe a que la 
	 * materia prima se ha acabado, entonces se debe cargar la maquina.
	 * Luego la materia se debe activar y se debe reportar al centro de control
	 * la reparacion de la maquina. Finalmente se incrementa el numero de maquinas
	 * que ha reparado el operario.
	 * @param psolicitud solicitud de reparacion.
	 */
	public void repararMaquina(Solicitud psolicitud) {
		// Solicitar una referencia a la maquina a reparar.
		Maquina maqAReparar = centroControl.obtenerMaquina(psolicitud.getIdMaquina());
		
		if (maqAReparar != null) {
			if (psolicitud.getProblema() == Constantes.FALLA_MATERIA_PRIMA) {
				maqAReparar.cargarMateriaPrima();
				psolicitud.setSolucion(Constantes.FALLA_MATERIA_PRIMA_SOLUCION);
			}
			// Activar la maquina para que vuelva a funcionamiento.
			maqAReparar.activar();
			// Solicitar al Centro de Control que mueva la solicitud de la lista
			// de despachadas a atendidas.
			centroControl.moverSolicitudAtendida(psolicitud);
			// Una vez finalizada la reparacion, se debe incrementar en uno
			// el total de maquinas reparadas.
			incrementarCantMaquinasRep();
		}
	}
	
	/**
	 * toString
	 * Retorna el estado del objeto Operario.
	 * @return String estado del objeto Operario.
	 */
	public String toString() {
		String estado = "Cedula: " + getCedula() + "\n" +
						"Nombre: " +  getNombre() + "\n" +
						"Maquinas reparadas: " + getCantMaquinasRep();
		
		return estado;
	}
}
