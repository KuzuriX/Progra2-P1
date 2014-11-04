import java.text.SimpleDateFormat;

/**
 * Maquina
 * @author Miguel Garcia
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
	public Maquina(CentroControl pobjCentroControl, String pmarca, String pmodelo, String pannoFabricacion){
		setCentroControl(pobjCentroControl);
		setId();
		setMarca(pmarca);
		setModelo(pmodelo);
		setAnnoFabricacion(pannoFabricacion);
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
	 * comunicarÃ¡ la mÃ¡quina en caso de averÃ­as.
	 * @param pobjCentroControl Centro de control de averÃ­as.
	 */
	private void setCentroControl(CentroControl pobjCentroControl){
		objCentroControl = pobjCentroControl;
	}
	
	/**
	 * crearMolde
	 * Crea un molde por defecto. El molde por defecto serÃ¡ de tamaÃ±o "P" y
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
	 * Pone a disposiciÃ³n del cliente un servicio que le permita cambiar los
	 * parÃ¡metros con que va a funcionar la mÃ¡quina.
	 * @param pmodoOp			Modo de operaciÃ³n. True indica modo de operaciÃ³n continuo.
	 * 				   			False, indica modo a intervalos.
	 * @param pnumEnvases		NÃºmero de envases a producir por intervalo.
	 * @param ptamannoEnvases	TamaÃ±o de los envases a producir.
	 * @param pgrosorEnvases 	Grosor de los envases a producir.
	 */
	public void establecerParametros(char pmodoOp, int pnumEnvases, char ptamannoEnvases, int pgrosorEnvases){
		setModoOperacion(pmodoOp);
		setNumEnvases(pnumEnvases);
		setMolde(ptamannoEnvases, pgrosorEnvases);		
	}
	
	/**
	 * getModoOperacion
	 * Retorna el modo de operaciÃ³n en que opera la mÃ¡quina.
	 * @return boolean Modo de operaciÃ³n. True indica modo de operaciÃ³n continuo.
	 * 				   False, indica modo a intervalos.
	 */
	public char getModoOperacion(){
		return modoOperacion;
	}
	
	/**
	 * setModoOperacion
	 * Establece un modo de operaciÃ³n para la mÃ¡quina. Si el parÃ¡metro es true,
	 * el modo de operaciÃ³n serÃ¡ continuo. Si es false, entonces el modo serÃ¡
	 * a intervalos.
	 * @param pmodOper Modo de operaciÃ³n de la mÃ¡quina.
	 */
	private void setModoOperacion(char pmodOper){
		modoOperacion = pmodOper;
	}
	
	/**
	 * getCantEnvasesProd
	 * Retorna la cantidad de envases producidos por la mÃ¡quina.
	 * @return int cantidad de envases.
	 */
	public int getCantEnvasesProd() {
		return cantEnvasesProd;
	}
	
	/**
	 * setCantEnvasesProd
	 * Establece la cantidad de envases producidos 
	 * @param pcantEnvasesProd	cantidad de envases producidos.
	 */
	public void setCantEnvasesProd(int pcantEnvasesProd) {
		cantEnvasesProd = pcantEnvasesProd;
	}
	
	/**
	 * incrementarCantEnvasesProd
	 * Incrementa en uno la cantidad de envases producidos por la mÃ¡quina.
	 */
	protected void incrementarCantEnvasesProd() {
		setCantEnvasesProd(getCantEnvasesProd()+1);
	}
	
	/**
	 * setMolde
	 * Establece las caracterÃ­sticas del envase que va a producir la mÃ¡quina.
	 * @param ptamannoEnvases	TamaÃ±o del envase puede ser: "P", "M" o "G".
	 * @param pgrosorEnvases	Grosor del envase a producir.
	 */
	private void setMolde(char ptamannoEnvases, int pgrosorEnvases){
		moldeEnvases.setTamannoEnvase(ptamannoEnvases);
		moldeEnvases.setGrosorEnvase(pgrosorEnvases);
	}
	
	/**
	 * getMarca
	 * Retorna la marca de la mÃ¡quina.
	 * @return String marca de la mÃ¡quina.
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * setMarca
	 * Establece la marca de la mÃ¡quina.
	 * @param pmarca marca de la mÃ¡quina.
	 */
	private void setMarca(String pmarca) {
		marca = pmarca;
	}	
	
	/**
	 * getModelo
	 * Retorna el modelo de la mÃ¡quina.
	 * @return String modelo de la mÃ¡quina.
	 */
	public String getModelo() {
		return modelo;
	}
	
	/**
	 * setModelo
	 * Establece el valor para el modelo de la mÃ¡quina. 
	 * @param pmodelo modelo de la mÃ¡quina.
	 */
	private void setModelo(String pmodelo) {
		modelo = pmodelo;
	}
	
	/**
	 * getAnnoFabricacion
	 * Retorna el aÃ±o en que se fabricÃ³ la mÃ¡quina.
	 * @return String AÃ±o de fabricaciÃ³n.
	 */
	public String getAnnoFabricacion() {
		return annoFabricacion;
	}
	
	/**
	 * setAnnoFabricacion
	 * Establece el aÃ±o de fabricaciÃ³n de la mÃ¡quina.
	 * @param pannoFabricacion aÃ±o de fabricaciÃ³n.
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
	 * @param pcantMateriaPrima cantidad de materia que tendrÃ¡ disponible
	 * 							la mÃ¡quina.
	 */
	public void setCantMateriaPrima(double pcantMateriaPrima) {
		cantMateriaPrima = pcantMateriaPrima;
	}
	
	/**
	 * isActivo
	 * Retorna el valor del atributo activo.
	 * @return boolean indica true o false si la mÃ¡quina estÃ¡ activa o no.
	 */
	protected boolean isActivo() {
		return activo;
	}
	
	/**
	 * setActivo
	 * Establece si la mÃ¡quina estÃ¡ activa o no.
	 * @param pactivo valor booleano que indica si la mÃ¡quina estÃ¡ activa o no.
	 */
	private void setActivo(boolean pactivo) {
		activo = pactivo;
	}
	
	/**
	 * getCondicion
	 * Retorna la condiciÃ³n de la mÃ¡quina.
	 * @return int indica la condiciÃ³n de la mÃ¡quina.
	 */
	public int getCondicion() {
		return condicion;
	}
	
	/**
	 * setCondicion
	 * Establece un valor para la condiciÃ³n de la mÃ¡quina.
	 * @param pcondicion indica la condiciÃ³n en que se encuentra la mÃ¡quina.
	 */
	private void setCondicion(int pcondicion) {
		condicion = pcondicion;
	}	
	
	/**
	 * getEnMarcha
	 * Retorna true o false si la mÃ¡quina se encuentra en marcha.
	 * @return boolean indica si la mÃ¡quina se encuentra en marcha.
	 */
	public boolean getEnMarcha(){
		return enMarcha;
	}
	
	/**
	 * setEnMarcha
	 * Establece si la mÃ¡quina se encuentra en marcha o no.
	 * @param penMarcha booleano que indica si la mÃ¡quina se encuentra en
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
	 * Retorna el nÃºmero de envases que ha producido la mÃ¡quina desde la
	 * Ãºltima activaciÃ³n.
	 * @return int cantidad de envases producidos desde la Ãºltima activaciÃ³n.
	 */
	public int getNumEnvases() {
		return numEnvases;
	}
	
	/**
	 * setNumEnvases
	 * Establece un valor para el nÃºmero de envases producidos por la mÃ¡quina.
	 * @param pnumEnvases nÃºmero de envases producidos.
	 */
	public void setNumEnvases(int pnumEnvases) {
		numEnvases = pnumEnvases;
	}	

	/**
	 * cargarMateriaPrima
	 * Carga al 100% la materia prima de la mÃ¡quina.
	 */
	public void cargarMateriaPrima() {
		setCantMateriaPrima(100);
	}
	
	/**
	 * activarMaquina
	 * Activa la mÃ¡quina para entrar en producciÃ³n.
	 */
	public void activarMaquina() {
		// Cuando se activa la mÃ¡quina se debe resetear el contador de envases.
		//setNumEnvases(0);
		
		setActivo(true);
	}
	
	/**
	 * desactivarMaquina
	 * Desactiva la mÃ¡quina.
	 */
	public void desactivarMaquina() {
		setActivo(false);
	}
	
	/**
	 * iniciarProduccion
	 * Iniciar la produccion de envases.
	 */
	public String iniciarProduccion() {	
		double materiaPrima = getCantMateriaPrima();
		String averia = "";
		String msj = "";
		if(isActivo()){
			if(modoOperacion == 'C'){
				while (getCantMateriaPrima() > 0) {
					materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria();
					setCantMateriaPrima(materiaPrima);
					
					// Se ha producido un envase mas.
					incrementarCantEnvasesProd();
					
					// Llamar al detector cada vez que se produce un envase.
					averia = detectorFallas.verificarAveria();
					if (averia != "") {
						desactivarMaquina();
						reportarAveria(averia);
						msj = averia;
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
						msj = averia;
					}
					
				}
			}
			msj += "Se produjeron "+getCantEnvasesProd()+" envases \n";
			msj += "Quedan "+getCantMateriaPrima()+" de materia prima";
		}else{
			msj = "La maquina se encuentra desactivada";
		}
		
		
		return msj;
		
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
			condicion = "Daño por "+Constantes.FALLA_MATERIA_PRIMA;
		}else{
			condicion = "Daño por envase "+Constantes.FALLA_ENVASE;
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
