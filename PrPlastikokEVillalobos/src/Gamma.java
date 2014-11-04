
/**
 * Gamma
 * Maquina especial que reduce su consumo de materia prima cuando
 * alcanza cierto nivel.
 * @author Miguel Garcia
 */
public class Gamma extends Maquina {
	private boolean modoGamma;
	private double consumoGamma;
	private final static double CANT_MATERIA_MODO_GAMMA = 12.0;
	
	public Gamma(CentroControl pobjCentroControl, String pmarca, String pmodelo, String pannoFabricacion){
		super(pobjCentroControl, pmarca, pmodelo,pannoFabricacion);
		setModoGamma(false);
		setConsumoGamma(0.06);
	}
	
	/**
	 * setModoGamma
	 * Establece si la máquina se encuentra en modo Gamma o no.
	 * @param pmodoGamma booleano que indica si la máquina se encuentra en
	 * 					modo Gamma o no.
	 */
	public void setModoGamma(boolean pmodoGamma) {
		modoGamma = pmodoGamma;
	}
	
	/**
	 * getModoGamma
	 * Retorna si la maquina se encuentra en modo Gamma o no.
	 * @return boolean si la maquina esta en modo Gamma.
	 */
	private boolean getModoGamma() {
		return modoGamma;
	}
	
	/**
	 * setConsumoGamma
	 * Establece la reduccion del consumo de la máquina si se encuentra en modo Gamma.
	 * @param pconsumoGamma entero que indica la reduccion del consumo.
	 */
	public void setConsumoGamma(double pconsumoGamma) {
		consumoGamma = pconsumoGamma;
	}
	
	/**
	 * getConsumoGamma
	 * Retorna la reduccion del consumo en modo Gamma.
	 * @return double la reduccion en el consumo por envase.
	 */
	public double getConsumoGamma() {
		return consumoGamma;
	}
	
	/**
	 * iniciarProduccion
	 * Iniciar la produccion de envases.
	 * Redefinido de la clase maquina a partir de la nueva maquina Gamma
	 */
	@Override
	public String iniciarProduccion() {
		double materiaPrima = getCantMateriaPrima();
		String averia = "";
		
		if(modoOperacion == 'C'){
			while (getCantMateriaPrima() > 0 && isActivo()) {
				if(verificarModoGamma()){
					materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria() + getConsumoGamma();
					setCantMateriaPrima(materiaPrima);
				}else{
					materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria();
					setCantMateriaPrima(materiaPrima);
				}
				
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
				if(verificarModoGamma()){
					materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria() + getConsumoGamma();
					setCantMateriaPrima(materiaPrima);
				}else{
					materiaPrima = materiaPrima - getMoldeEnvases().obtenerPorcMateria();
					setCantMateriaPrima(materiaPrima);
				}
				
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
		return averia;
	}
	
	/**
	 * verificarModoGamma
	 * Verifica cuando la maquina debe pasar a funcionar en modo gamma
	 * Retorna si la maquina esta en modo Gamma o no.
	 * @return boolean getModoGamma().
	 */
	public boolean verificarModoGamma(){
		if(getCantMateriaPrima() > CANT_MATERIA_MODO_GAMMA){
			setModoGamma(true);
		}
		
		return getModoGamma();
	}
}
