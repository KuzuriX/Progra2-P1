import java.sql.Date;
import java.sql.Time;

/**
 * Solicitud de reparacion
 * @author Elizabeth Villalobos
 */
public class Solicitud {
	// Puede ser uno de tres estados: pendiente, despachada o atendida.
	private String condicion;
	private Maquina maquina;
	private Date fechaAveria;
	private Time horaAveria;
	private int cantEnvasesProducidos;
	private Molde molde;
	private Operario operarioEncargado;
	private String problema;
	private String solucion;
	
	/**
	 * Solicitud
	 * Constructor. Crear una solicitud de reparacion.
	 * 
	 */
	public Solicitud(String pcondicion, Maquina pmaquina, Date pfechaAveria, Time phoraAveria, int pcantEnvases, Molde pmolde, String pproblema) {
		setCondicion(pcondicion);
		setMaquina(pmaquina);
		setFechaAveria(pfechaAveria);
		setHoraAveria(phoraAveria);
		setCantEnvasesProducidos(pcantEnvases);
		setMolde(pmolde);
		setProblema(pproblema);
	}
	
	/**
	 * getCondicion
	 * Retorna la condicion de la solicitud. Puede ser "pendiente", "despachada" o "atendida".
	 * @return String condicion de la solicitud.
	 */
	private String getCondicion() {
		return condicion;
	}
	
	/**
	 * setCondicion
	 * Establece un valor para la condicion de la solicitud.
	 * @param pcondicion condicion de la solicitud. Puede ser "pendiente", "despachada" o "atendida".
	 */
	private void setCondicion(String pcondicion) {
		condicion = pcondicion;
	}
	
	/**
	 * getMaquina
	 * Retorna la maquina averiada.
	 * @return Maquina maquina averiada.
	 */
	private Maquina getMaquina() {
		return maquina;
	}
	
	/**
	 * setMaquina
	 * Establece la referencia a un objeto de tipo maquina.
	 * @param Maquina maquina averiada.
	 */
	private void setMaquina(Maquina pmaquina) {
		maquina = pmaquina;
	}
	
	/**
	 * getFechaAveria
	 * Retorna la fecha en que se presento la averia.
	 * @return Date fecha de la averia.
	 */
	private Date getFechaAveria() {
		return fechaAveria;
	}
	
	/**
	 * setFechaAveria
	 * Establece un valor para la fecha de la averia.
	 * @param Date fecha en que se presento la averia.
	 */
	private void setFechaAveria(Date pfechaAveria) {
		fechaAveria = pfechaAveria;
	}
	
	/**
	 * getHoraAveria
	 * Retorna la hora en que se presento la averia.
	 * @return Time hora de la averia.
	 */
	private Time getHoraAveria() {
		return horaAveria;
	}
	
	/**
	 * setHoraAveria
	 * Establece un valor para la hora de la averia
	 * @param Time hora en que se presento la averia.
	 */
	private void setHoraAveria(Time phoraAveria) {
		horaAveria = phoraAveria;
	}
	
	/**
	 * getCantEnvasesProducidos
	 * Retorna la cantidad de envases producidos por la maquina desde la ultima
	 * activacion.
	 * @return int cantidad de envases producidos.
	 */
	private int getCantEnvasesProducidos() {
		return cantEnvasesProducidos;
	}
	
	/**
	 * setCantEnvasesProducidos
	 * Establece un valor para la cantidad de envases producidos por la maquina
	 * desde la ultima activacion.
	 * @param pcantEnvases cantidad de envases.
	 */
	private void setCantEnvasesProducidos(int pcantEnvases) {
		cantEnvasesProducidos = pcantEnvases;
	}
	
	/**
	 * getMolde
	 * Retorna el molde utilizado por la maquina averiada.
	 * @return Molde cantidad de envases producidos.
	 */
	private Molde getMolde() {
		return molde;
	}
	
	/**
	 * setMolde
	 * Establece un valor el molde utilizado por la maquina averiada.
	 * @param pmolde molde de la maquina averiada.
	 */
	private void setMolde(Molde pmolde) {
		molde = pmolde;
	}
	
	/**
	 * getOperarioEncargado
	 * Retorna el operario encargado de la reparacion de la maquina averiada.
	 * @return Operario cantidad de envases producidos.
	 */
	private Operario getOperarioEncargado() {
		return operarioEncargado;
	}
	
	/**
	 * setOperarioEncargado
	 * Establece una referencia al operario encargado de la reparacion.
	 * @param poperario operario que realiza la reparacion.
	 */
	private void setOperarioEncargado(Operario poperario) {
		operarioEncargado = poperario;
	}
	
	/**
	 * getProblema
	 * Retorna la descripcion del problema que tenia la maquina averiada.
	 * @return String descripcion del problema.
	 */
	private String getProblema() {
		return problema;
	}
	
	/**
	 * setProblema
	 * Establece un valor para el atributo problema.
	 * @param pproblema descripcion del problema que tiene la maquina.
	 */
	private void setProblema(String pproblema) {
		problema = pproblema;
	}
	
	/**
	 * getSolucion
	 * Retorna la descripcion de la solucion al problema que tenia la maquina.
	 * @return String descripcion de la solucion.
	 */
	private String getSolucion() {
		return solucion;
	}
	
	/**
	 * setSolucion
	 * Establece un valor para el atributo solucion.
	 * @param psolucion descripcion de la solucion al problema que tiene la maquina.
	 */
	private void setSolucion(String psolucion) {
		solucion = psolucion;
	}
}
