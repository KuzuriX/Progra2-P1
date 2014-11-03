import java.sql.Date;
import java.sql.Time;

/**
 * Solicitud de reparacion
 * @author Elizabeth Villalobos
 */
public class Solicitud {
	// Puede ser uno de tres estados: pendiente, despachada o atendida.
	private String condicionAtencion;
	private String idMaquina;
	private Date fechaAveria;
	private Time horaAveria;
	private int numEnvasesProducidos;
	private char tamano;
	private int grosor;
	private Operario operarioEncargado;
	private String problema;
	private String solucion;
	
	/**
	 * Solicitud
	 * Constructor. Crear una solicitud de reparacion.
	 * 
	 */
	public Solicitud(String pidMaquina, Date pfechaAveria, Time phoraAveria, int pcantEnvases, char ptamano, int pgrosor, String pproblema) {
		// Cuando se crea una solicitud siempre tiene estado "pendiente".
		setCondicionAtencion("pendiente");
		setIdMaquina(pidMaquina);
		setFechaAveria(pfechaAveria);
		setHoraAveria(phoraAveria);
		setNumEnvasesProducidos(pcantEnvases);
		setTamano(ptamano);
		setGrosor(pgrosor);
		setProblema(pproblema);
	}
	
	/**
	 * getCondicionAtencion
	 * Retorna la condicion de la solicitud. Puede ser "pendiente", "despachada" o "atendida".
	 * @return String condicion de la solicitud.
	 */
	private String getCondicionAtencion() {
		return condicionAtencion;
	}
	
	/**
	 * setCondicionAtencion
	 * Establece un valor para la condicion de la solicitud.
	 * @param pcondicion condicion de la solicitud. Puede ser "pendiente", "despachada" o "atendida".
	 */
	public void setCondicionAtencion(String pcondicion) {
		condicionAtencion = pcondicion;
	}
	
	/**
	 * getMaquina
	 * Retorna el identificador de la maquina averiada.
	 * @return String identificador de la maquina averiada.
	 */
	public String getIdMaquina() {
		return idMaquina;
	}
	
	/**
	 * setMaquina
	 * Establece la referencia a un objeto de tipo maquina.
	 * @param pidMaquina identificador de la maquina averiada.
	 */
	private void setIdMaquina(String pidMaquina) {
		idMaquina = pidMaquina;
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
	 * getNumEnvasesProducidos
	 * Retorna la cantidad de envases producidos por la maquina desde la ultima
	 * activacion.
	 * @return int cantidad de envases producidos.
	 */
	private int getNumEnvasesProducidos() {
		return numEnvasesProducidos;
	}
	
	/**
	 * setNumEnvasesProducidos
	 * Establece un valor para la cantidad de envases producidos por la maquina
	 * desde la ultima activacion.
	 * @param pnumEnvases cantidad de envases.
	 */
	private void setNumEnvasesProducidos(int pnumEnvases) {
		numEnvasesProducidos = pnumEnvases;
	}
	
	/**
	 * getTamano
	 * Retorna el tamaño del envase utilizado por la maquina averiada.
	 * Los posibles valores son: "P" (pequeño), "M" (mediano) y "G" (grande).
	 * @return char tamaño de envases producidos.
	 */
	private char getTamano() {
		return tamano;
	}
	
	/**
	 * setTamano
	 * Establece un valor para el tamaño de envases utilizado por la 
	 * maquina averiada.
	 * Los posibles valores son: "P" (pequeño), "M" (mediano) y "G" (grande).
	 * @param ptamano grosor del envase.
	 */
	private void setTamano(char ptamano) {
		tamano = ptamano;
	}
	
	/**
	 * getGrosor
	 * Retorna el grosor del envase utilizado por la maquina averiada.
	 * @return int grosor de envases producidos.
	 */
	private int getGrosor() {
		return grosor;
	}
	
	/**
	 * setGrosor
	 * Establece un valor para el grosor de envases utilizado por la 
	 * maquina averiada.
	 * @param pgrosor grosor del envase.
	 */
	private void setGrosor(int pgrosor) {
		grosor = pgrosor;
	}
	
	/**
	 * getOperarioEncargado
	 * Retorna el operario encargado de la reparacion de la maquina averiada.
	 * @return Operario cantidad de envases producidos.
	 */
	public Operario getOperarioEncargado() {
		return operarioEncargado;
	}
	
	/**
	 * asignarOperarioEncargado
	 * Establece una referencia al operario encargado de la reparacion.
	 * @param poperario operario que realiza la reparacion.
	 */
	public void asignarOperarioEncargado(Operario poperario) {
		operarioEncargado = poperario;
	}
	
	/**
	 * getProblema
	 * Retorna la descripcion del problema que tenia la maquina averiada.
	 * @return String descripcion del problema.
	 */
	public String getProblema() {
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
	
	/**
	 * toString
	 * Retorna el estado de la solicitud.
	 * @return String estado de los atributos de la solicitud.
	 */
	public String toString() {
		String estado = "";
		estado += "Condicion: " + getCondicionAtencion() + "\n" +
				  "Maquina averiada: " + getIdMaquina() + "\n" + 
				  "Fecha y hora de la averia: " + getFechaAveria() + " " + getHoraAveria() + "\n" +
				  "Cantidad de envases producidos: " + getNumEnvasesProducidos() + "\n" + 
				  "Tamaño: " + getTamano() + "\n" + 
				  "Grosor: " + getGrosor() + "\n" +
				  "Operario encargado: " + getOperarioEncargado().getNombre() + "\n" +
				  "Problema: " + getProblema() + "\n" +
				  "Solucion: " + getSolucion() + "\n";
		
		return estado;
	}
}
