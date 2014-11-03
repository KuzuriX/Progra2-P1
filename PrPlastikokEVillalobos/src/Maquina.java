/**
 * Maquina
 * @author Miguel García
 */
public class Maquina {
	private static int contadorMaquinas = 0;
	private String id;
	private CentroControl objCentroControl;
	private final static double MINIMO_MATERIA_PRIMA = 3.0;
	private String marca;
	private String modelo;
	private String annoFabricacion;
	private boolean modoOperacion;
	private double cantMateriaPrima;
	private boolean activo;
	private int condicion;
	private boolean enMarcha;
	private int cantEnvasesProd = 0;
	private Molde moldeEnvases;
	private int numEnvases;
	
	/**
	 * Maquina. 
	 * Constructor. Recibe el centro de control al que debe reportar averias.
	 * @param pobjCentroControl Centro de control al que la maquina debe reportar
	 * 						    averias.
	 */
	public Maquina(CentroControl pobjCentroControl){
		setCentroControl(pobjCentroControl);
		setId();
		crearMolde();
	}
	
	/**
	 * getId
	 * Retorna el identificador de la maquina.
	 * @return String identificador de la maquina
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * setId
	 * Establece un valor para el identificador de la maquina.
	 */
	private void setId() {
		contadorMaquinas++;
		id = "MQ-" + contadorMaquinas;
	}
	
	/**
	 * setCentroControl
	 * Establece una referencia al centro de control con el cual se 
	 * comunicará la máquina en caso de averías.
	 * @param pobjCentroControl Centro de control de averías.
	 */
	private void setCentroControl(CentroControl pobjCentroControl){
		objCentroControl = pobjCentroControl;
	}
	
	/**
	 * crearMolde
	 * Crea un molde por defecto. El molde por defecto será de tamaño "P" y
	 * con grosor de 1.
	 */
	private void crearMolde() {
		moldeEnvases = new Molde();
	}
	
	/**
	 * establecerParametros
	 * Pone a disposición del cliente un servicio que le permita cambiar los
	 * parámetros con que va a funcionar la máquina.
	 * @param pmodoOp			Modo de operación. True indica modo de operación continuo.
	 * 				   			False, indica modo a intervalos.
	 * @param pnumEnvases		Número de envases a producir por intervalo.
	 * @param ptamannoEnvases	Tamaño de los envases a producir.
	 * @param pgrosorEnvases 	Grosor de los envases a producir.
	 */
	public void establecerParametros(boolean pmodoOp, int pnumEnvases, char ptamannoEnvases, int pgrosorEnvases){
		setModoOperacion(pmodoOp);
		setNumEnvases(pnumEnvases);
		setMolde(ptamannoEnvases, pgrosorEnvases);		
	}
	
	/**
	 * getModoOperacion
	 * Retorna el modo de operación en que opera la máquina.
	 * @return boolean Modo de operación. True indica modo de operación continuo.
	 * 				   False, indica modo a intervalos.
	 */
	public boolean getModoOperacion(){
		return modoOperacion;
	}
	
	/**
	 * setModoOperacion
	 * Establece un modo de operación para la máquina. Si el parámetro es true,
	 * el modo de operación será continuo. Si es false, entonces el modo será
	 * a intervalos.
	 * @param pmodOper Modo de operación de la máquina.
	 */
	private void setModoOperacion(boolean pmodOper){
		modoOperacion = pmodOper;
	}
	
	/**
	 * getCantEnvasesProd
	 * Retorna la cantidad de envases producidos por la máquina.
	 * @return int cantidad de envases.
	 */
	public int getCantEnvasesProd() {
		return cantEnvasesProd;
	}
	
	/**
	 * incrementarCantEnvasesProd
	 * Incrementa en uno la cantidad de envases producidos por la máquina.
	 */
	private void incrementarCantEnvasesProd() {
		cantEnvasesProd ++;
	}
	
	/**
	 * setMolde
	 * Establece las características del envase que va a producir la máquina.
	 * @param ptamannoEnvases	Tamaño del envase puede ser: "P", "M" o "G".
	 * @param pgrosorEnvases	Grosor del envase a producir.
	 */
	private void setMolde(char ptamannoEnvases, int pgrosorEnvases){
		moldeEnvases.setTamannoEnvase(ptamannoEnvases);
		moldeEnvases.setGrosorEnvase(pgrosorEnvases);
	}
	
	/**
	 * getMarca
	 * Retorna la marca de la máquina.
	 * @return String marca de la máquina.
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * setMarca
	 * Establece la marca de la máquina.
	 * @param pmarca marca de la máquina.
	 */
	private void setMarca(String pmarca) {
		marca = pmarca;
	}	
	
	/**
	 * getModelo
	 * Retorna el modelo de la máquina.
	 * @return String modelo de la máquina.
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * setModelo
	 * Establece el valor para el modelo de la máquina. 
	 * @param pmodelo modelo de la máquina.
	 */
	private void setModelo(String pmodelo) {
		modelo = pmodelo;
	}
	
	/**
	 * getAnnoFabricacion
	 * Retorna el año en que se fabricó la máquina.
	 * @return String Año de fabricación.
	 */
	public String getAnnoFabricacion() {
		return annoFabricacion;
	}
	
	/**
	 * setAnnoFabricacion
	 * Establece el año de fabricación de la máquina.
	 * @param pannoFabricacion año de fabricación.
	 */
	public void setAnnoFabricacion(String pannoFabricacion) {
		annoFabricacion = pannoFabricacion;
	}	
	
	/**
	 * getCantMateriaPrima
	 * Retorna la cantidad de materia prima que tiene la maquina.
	 * @return double cantidad de materia prima disponible.
	 */
	public double getCantMateriaPrima() {
		return cantMateriaPrima;
	}
	
	/**
	 * setCantMateriaPrima
	 * Establece un valor para la cantidad de materia.
	 * @param pcantMateriaPrima cantidad de materia que tendrá disponible
	 * 							la máquina.
	 */
	public void setCantMateriaPrima(double pcantMateriaPrima) {
		cantMateriaPrima = pcantMateriaPrima;
	}
	
	/**
	 * getActivo
	 * Retorna el valor del atributo activo.
	 * @return boolean indica true o false si la máquina está activa o no.
	 */
	private boolean getActivo() {
		return activo;
	}
	
	/**
	 * setActivo
	 * Establece si la máquina está activa o no.
	 * @param pactivo valor booleano que indica si la máquina está activa o no.
	 */
	private void setActivo(boolean pactivo) {
		activo = pactivo;
	}
	
	/**
	 * getCondicion
	 * Retorna la condición de la máquina.
	 * @return int indica la condición de la máquina.
	 */
	public int getCondicion() {
		return condicion;
	}
	
	/**
	 * setCondicion
	 * Establece un valor para la condición de la máquina.
	 * @param pcondicion indica la condición en que se encuentra la máquina.
	 */
	private void setCondicion(int pcondicion) {
		condicion = pcondicion;
	}	
	
	/**
	 * getEnMarcha
	 * Retorna true o false si la máquina se encuentra en marcha.
	 * @return boolean indica si la máquina se encuentra en marcha.
	 */
	public boolean getEnMarcha(){
		return enMarcha;
	}
	
	/**
	 * setEnMarcha
	 * Establece si la máquina se encuentra en marcha o no.
	 * @param penMarcha booleano que indica si la máquina se encuentra en
	 * 					marcha o no.
	 */
	public void setEnMarcha(boolean penMarcha) {
		enMarcha = penMarcha;
	}
	
	/**
	 * getNumEnvases
	 * Retorna el número de envases que ha producido la máquina desde la
	 * última activación.
	 * @return int cantidad de envases producidos desde la última activación.
	 */
	public int getNumEnvases() {
		return numEnvases;
	}
	
	/**
	 * setNumEnvases
	 * Establece un valor para el número de envases producidos por la máquina.
	 * @param pnumEnvases número de envases producidos.
	 */
	public void setNumEnvases(int pnumEnvases) {
		numEnvases = pnumEnvases;
	}	

	/**
	 * cargarMateriaPrima
	 * Carga al 100% la materia prima de la máquina.
	 */
	public void cargarMateriaPrima() {
		setCantMateriaPrima(100);
	}
	
	/**
	 * activar
	 * Activa la máquina para entrar en producción.
	 */
	public void activar() {
		// Cuando se activa la máquina se debe resetear el contador de envases.
		setNumEnvases(0);
		setActivo(true);
	}
	
	/**
	 * desactivar
	 * Desactiva la máquina.
	 */
	public void desactivar() {
		setActivo(false);
	}
}
