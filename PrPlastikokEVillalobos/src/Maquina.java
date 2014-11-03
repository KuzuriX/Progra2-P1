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
	 * @param pcontadorMaquinas
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
	 * @param pid identificador de la maquina.
	 */
	public void setId(String pid) {
		id = pid;
	}
	
	private void setCentroControl(CentroControl pobjCentroControl){
		objCentroControl = pobjCentroControl;
	}
	
	private void crearMolde() {
		moldeEnvases = new Molde();
		establecerParametros(true, 0, 'p', 1);
	}
	
	private void setId(){
		contadorMaquinas++;
		id = "MQ-" + contadorMaquinas;
	}
	
	public void establecerParametros(boolean pmodoOp, int pnumEnvases, char ptamannoEnvases, int pgrosorEnvases){
		setModoOperacion(pmodoOp);
		setNumEnvases(pnumEnvases);
		setMolde(ptamannoEnvases, pgrosorEnvases);		
	}
	
	private void setModoOperacion(boolean pmodOper){
		modoOperacion = pmodOper;
	}
	
	public boolean getModoOperacion(){
		return modoOperacion;
	}
	
	private void setCantEnvasesProd() {
		cantEnvasesProd ++;
	}
	
	public int getCantEnvasesProd() {
		return cantEnvasesProd;
	}
	
	private void setMolde(char ptamannoEnvases, int pgrosorEnvases){
		moldeEnvases.setTamannoEnvase(ptamannoEnvases);
		moldeEnvases.setGrosorEnvase(pgrosorEnvases);
	}
	
	private void setMarca(String pmarca) {
		marca = pmarca;
	}
	
	public String getMarca() {
		return marca;
	}
	
	private void setModelo(String pmodelo) {
		modelo = pmodelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setAnnoFabricacion(String pannoFabricacion) {
		annoFabricacion = pannoFabricacion;
	}
	
	public String getAnnoFabricacion() {
		return annoFabricacion;
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
	 * @param pcantMateriaPrima cantidad de materia que tendra disponible
	 * 							la maquina.
	 */
	public void setCantMateriaPrima(double pcantMateriaPrima) {
		cantMateriaPrima = pcantMateriaPrima;
	}
	
	/**
	 * getActivo
	 * Retorna el valor del atributo activo.
	 * @return boolean indica true o false si la maquina esta activa o no.
	 */
	private boolean getActivo() {
		return activo;
	}
	
	/**
	 * setActivo
	 * Establece si la maquina esta activa o no.
	 * @param pactivo valor booleano que inidica si la maquina esta activa o no.
	 */
	private void setActivo(boolean pactivo) {
		activo = pactivo;
	}
	
	/**
	 * getCondicion
	 * Retorna la condicion de la maquina.
	 * @return int indica la condicion de la maquina.
	 */
	public int getCondicion() {
		return condicion;
	}
	
	/**
	 * setCondicion
	 * Establece un valor para la condicion de la maquina.
	 * @param pcondicion indica la condicion en que se encuentra la maquina.
	 */
	private void setCondicion(int pcondicion) {
		condicion = pcondicion;
	}	
	
	/**
	 * getEnMarcha
	 * Retorna true o false si la maquina se encuentra en marcha.
	 * @return boolean indica si la maquina se encuentra en marcha.
	 */
	public boolean getEnMarcha(){
		return enMarcha;
	}
	
	/**
	 * setEnMarcha
	 * Establece si la maquina se encuentra en marcha o no.
	 * @param penMarcha booleano que indica si la maquina se encuentra en
	 * 					marcha o no.
	 */
	public void setEnMarcha(boolean penMarcha) {
		enMarcha = penMarcha;
	}
	
	/**
	 * getNumEnvases
	 * Retorna el numero de envases que ha producido la maquina desde la
	 * ultima activacion.
	 * @return int cantidad de envases producidos desde la ultima activacion.
	 */
	public int getNumEnvases() {
		return numEnvases;
	}
	
	/**
	 * setNumEnvases
	 * Establece un valor para el numero de envases producidos por la maquina.
	 * @param pnumEnvases numero de envases producidos.
	 */
	public void setNumEnvases(int pnumEnvases) {
		numEnvases = pnumEnvases;
	}	

	/**
	 * cargarMateriaPrima
	 * Carga al 100% la materia prima de la maquina.
	 */
	public void cargarMateriaPrima() {
		setCantMateriaPrima(100);
	}
	
	/**
	 * activar
	 * Activa la maquina para entrar en produccion.
	 */
	public void activar() {
		// Cuando se activa la maquina se debe resetear el contador de envases.
		setNumEnvases(0);
		setActivo(true);
	}
	
	/**
	 * desactivar
	 * Desactiva la maquina.
	 */
	public void desactivar() {
		setActivo(false);
	}
}
