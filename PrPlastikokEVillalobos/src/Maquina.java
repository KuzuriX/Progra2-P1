import java.text.SimpleDateFormat;

/**
 * Maquina
 * @author Miguel García
 */
public class Maquina {
	private static int contadorMaquinas = 0;
	private String id;

	protected CentroControl objCentroControl;
	public final static double MINIMO_MATERIA_PRIMA = 3.0;
	protected String marca;
	protected String modelo;
	protected String annoFabricacion;
	protected char modoOperacion;
	protected double cantMateriaPrima;
	protected boolean activo;
	protected int condicion;
	protected boolean enMarcha;
	protected int cantEnvasesProd = 0;

	public Molde moldeEnvases;
	protected int numEnvases;

	protected Detector detectorFallas;

	
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
		crearDetector(this);
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
	
	private void crearDetector(Maquina pobjMaquina){
		setDetectorFallas(pobjMaquina);
	}
	
	public void setDetectorFallas(Maquina pobjMaquina) {
		detectorFallas = new Detector(pobjMaquina);
	}
	
	public Detector detectorFallas() {
		return detectorFallas;
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
	public void establecerParametros(char pmodoOp, int pnumEnvases, char ptamannoEnvases, int pgrosorEnvases){
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
	public char getModoOperacion(){
		return modoOperacion;
	}
	
	/**
	 * setModoOperacion
	 * Establece un modo de operación para la máquina. Si el parámetro es true,
	 * el modo de operación será continuo. Si es false, entonces el modo será
	 * a intervalos.
	 * @param pmodOper Modo de operación de la máquina.
	 */
	private void setModoOperacion(char pmodOper){
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
	protected void incrementarCantEnvasesProd() {
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
	protected double getCantMateriaPrima() {
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
	 * isActivo
	 * Retorna el valor del atributo activo.
	 * @return boolean indica true o false si la máquina está activa o no.
	 */
	protected boolean isActivo() {
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
	 * getMoldeEnvases
	 * Retorna el molde que utiliza la maquina para producir envases.
	 * @return Molde molde que utiliza la maquina.
	 */
	public Molde getMoldeEnvases() {
		return moldeEnvases;
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
	 * activarMaquina
	 * Activa la máquina para entrar en producción.
	 */
	public void activarMaquina() {
		// Cuando se activa la máquina se debe resetear el contador de envases.
		setNumEnvases(0);
		setActivo(true);
	}
	
	/**
	 * desactivarMaquina
	 * Desactiva la máquina.
	 */
	public void desactivarMaquina() {
		setActivo(false);
	}
	
	/**
	 * iniciarProduccion
	 * Iniciar la produccion de envases.
	 */
	public void iniciarProduccion() {

		
		double materiaPrima = getCantMateriaPrima();
		String averia = "";
		
		if(modoOperacion == 'C'){
			while (getCantMateriaPrima() > 0 && isActivo()) {
				materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria();
				setCantMateriaPrima(materiaPrima);
				
				// Se ha producido un envase mas.
				incrementarCantEnvasesProd();
				
				// Llamar al detector cada vez que se produce un envase.
				averia = detectorFallas.verificarAveria();
				if (averia != "") {
					desactivarMaquina();
					reportarAveria(averia);
				}
			}
		}else{
			while (numEnvases > cantEnvasesProd) {
				materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria();
				setCantMateriaPrima(materiaPrima);
				
				// Se ha producido un envase mas.
				incrementarCantEnvasesProd();
				
				// Llamar al detector cada vez que se produce un envase.
				averia = detectorFallas.verificarAveria();
				if (averia != "") {
					desactivarMaquina();
					reportarAveria(averia);
				}
				
			}
		}
		
	}
	
	/**
	 * detenerProduccion
	 * Detiene la produccion de envases.
	 */
	/*public void detenerProduccion() {
		// TODO: agregar la logica de detener la produccion de envases.
		

		double materiaPrima = getCantMateriaPrima();
		String averia = "";
		
		while (getCantMateriaPrima() > 0 && isActivo()) {
			materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria();
			setCantMateriaPrima(materiaPrima);
			
			// Se ha producido un envase mas.
			incrementarCantEnvasesProd();
			
			// Llamar al detector cada vez que se produce un envase.
			averia = detectorFallas.verificarAveria();
			if (averia != "") {
				desactivarMaquina();
				reportarAveria(averia);
			}
		}

	}*/
	
	/**
	 * reportarAveria
	 * Reporta una averia al centro de control.
	 * @param ptipoAveria averia que se produjo en la maquina. Esta es la averia
	 * 					  reportada por el detector.
	 */
	public void reportarAveria(String ptipoAveria) {
		SimpleDateFormat fechaHora = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		objCentroControl.crearSolicitud(getId(), fechaHora, getCantEnvasesProd(), getMoldeEnvases().getTamannoEnvase(), getMoldeEnvases().getGrosorEnvase(), ptipoAveria);
	}
	
	/**
	 * toString
	 * Retorna el estado de la maquina.
	 * @return String estado de la maquina.
	 */
	public String toString(){
		String activo = "Inactiva";
		String condicion = "Buena";
		if(isActivo()){
			activo = "activa";
		}
		if(getCondicion() == 1){
			condicion = "Da�o por "+Constantes.FALLA_MATERIA_PRIMA;
		}else{
			condicion = "Da�o por envase "+Constantes.FALLA_ENVASE;
		}
		String estado = "Marca: "+getMarca()+"\n";
		estado += "Modelo: "+getModelo()+"\n";
		estado += "Modo de operacion: "+modoOperacion+"\n";
		estado += "Cantidad de materia prima: "+getCantMateriaPrima()+"\n";
		estado += "Estado de actividad"+activo+"\n";
		estado += "Condicion: "+condicion+"\n";
		estado += "Cantidad de envases producidos: "+getCantEnvasesProd()+"\n";
		
		return estado;
	}

}
