import java.text.SimpleDateFormat;

/**
 * Solicitud de reparación
 * Contiene la informacion necesaria para que un operario pueda
 * reparar una maquina.
 * @author Elizabeth Villalobos
 */
public class Solicitud {
	private static int contadorSolicitudes;
	private String id;
	// Puede ser uno de tres estados: pendiente, despachada o atendida.
	private String condicionAtencion;
	private String idMaquina;
	private SimpleDateFormat fechaHoraAveria;
	private int numEnvasesProducidos;
	private char tamano;
	private int grosor;
	private Operario operarioEncargado;
	private String problema;
	private String solucion;
	
	/**
	 * Solicitud
	 * Constructor. Crear una solicitud de reparación.	
	 * @param pidMaquina		identificador de la máquina averiada.
	 * @param pfechaHoraAveria  fecha y hora en que se produjo la avería.
	 * @param pcantEnvases		cantidad de envases producidos desde la última 
	 * 							activación.
	 * @param ptamano			tamaño del envase que produce la máquina.
	 * @param pgrosor			grosor del envase que produce la máquina.
	 * @param pproblema			problema que se presentó en la máquina.
	 */
	public Solicitud(String pidMaquina, SimpleDateFormat pfechaHoraAveria, int pcantEnvases, char ptamano, int pgrosor, String pproblema) {
		setId();
		// Cuando se crea una solicitud siempre tiene estado "pendiente".
		setCondicionAtencion(Constantes.SOLICITUD_CONDICION_PENDIENTE);
		setIdMaquina(pidMaquina);
		setFechaHoraAveria(pfechaHoraAveria);
		setNumEnvasesProducidos(pcantEnvases);
		setTamano(ptamano);
		setGrosor(pgrosor);
		setProblema(pproblema);
	}
	
	/**
	 * getId
	 * Retorna el valor del atributo id.
	 * @return String identificador de la solicitud.
	 */
	public String getId() {
		return condicionAtencion;
	}
	
	/**
	 * setId
	 * Establece un valor para el identificador de la solicitud.
	 */
	public void setId() {
		contadorSolicitudes++;
		id = "Solicitud-" + contadorSolicitudes;
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
	 * Retorna la fecha y hora en que se presento la averia.
	 * @return SimpleDateFormat fecha y hora de la averia.
	 */
	private SimpleDateFormat getFechaHoraAveria() {
		return fechaHoraAveria;
	}
	
	/**
	 * setFechaAveria
	 * Establece un valor para la fecha y hora en que se produjo la averia.
	 * @param SimpleDateFormat fecha y hora de la averia.
	 */
	private void setFechaHoraAveria(SimpleDateFormat pfechaHoraAveria) {
		fechaHoraAveria = pfechaHoraAveria;
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
	public void setProblema(String pproblema) {
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
	public void setSolucion(String psolucion) {
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
				  "Fecha y hora de la averia: " + getFechaHoraAveria() + "\n" +
				  "Cantidad de envases producidos: " + getNumEnvasesProducidos() + "\n" + 
				  "Tamaño: " + getTamano() + "\n" + 
				  "Grosor: " + getGrosor() + "\n" +
				  "Operario encargado: " + getOperarioEncargado().getNombre() + "\n" +
				  "Problema: " + getProblema() + "\n" +
				  "Solucion: " + getSolucion() + "\n";
		
		return estado;
	}
}
