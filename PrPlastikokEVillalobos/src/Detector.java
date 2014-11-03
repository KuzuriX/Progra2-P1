/*

public class Detector {
	
	private Maquina objMaquina;
	private int tipoAveria;
	
	public Detector(Maquina pobjMaquina){
		setObjMaquina(pobjMaquina);
		setTipoAveria(0);
	}
	
	public void setObjMaquina(Maquina pobjMaquina) {
		objMaquina = pobjMaquina;
	}
	
	public Maquina getObjMaquina() {
		return objMaquina;
	}
	
	public void setTipoAveria(int ptipoAveria) {
		tipoAveria = ptipoAveria;
	}
	
	public int getTipoAveria() {
		return tipoAveria;
	}
	
	public int verificarFalla(){
		verificarCantMaterial();
		verificarEnvase();
		
		return getTipoAveria();
	}
	
	private void verificarCantMaterial(){
		if(objMaquina.getCantMateriaPrima() < objMaquina.MINIMO_MATERIA_PRIMA){
			setTipoAveria(1);
		}
		
	}
	
	private void verificarEnvase(){
		Molde moldeObjMaquinaMolde = objMaquina.moldeEnvases;
		if(moldeObjMaquinaMolde.getTamannoEnvase() == 'p'){
			if(moldeObjMaquinaMolde.getGrosorEnvase() != 1){
				setTipoAveria(2);
			}
		}else{
			if(moldeObjMaquinaMolde.getTamannoEnvase() == 'm'){
				if(moldeObjMaquinaMolde.getGrosorEnvase() == 3){
					setTipoAveria(2);
				}
			}else{
				if(moldeObjMaquinaMolde.getGrosorEnvase() == 1){
					setTipoAveria(2);
				}
			}
		}
	}*/

/**
 * Detector
 * @author Elizabeth Villalobos
 */
public class Detector {
	private String tipoAveria;
	private Maquina maquina;
	
	/**
	 * Detector.
	 * Constructor. Detecta fallas en la máquina productora de envases.
	 */
	public Detector(Maquina pmaquina) {
		setTipoAveria("");
		setMaquina(pmaquina);
	}

	/**
	 * getTipoAveria
	 * Retorna el tipo de averia que se ha producido en una máquina.
	 * @return String Tipo de avería.
	 */
	private String getTipoAveria() {
		return tipoAveria;
	}

	/**
	 * setTipoAveria
	 * Establecer un tipo de avería que se ha producido en la máquina.
	 * @param ptipoAveria Tipo de avería.
	 */
	private void setTipoAveria(String ptipoAveria) {
		tipoAveria = ptipoAveria;
	}
	
	/**
	 * getMaquina
	 * Retorna la referencia a la máquina a la cual pertenece el detector.
	 * @return Maquina máquina a la que está ligada el detector.
	 */
	private Maquina getMaquina() {
		return maquina;
	}

	/**
	 * setMaquina
	 * Establecer una referencia a la máquina a la que estará relacionada el 
	 * detector.
	 * @param pmaquina Máquina a la esta se relacionará el detector.
	 */
	private void setMaquina(Maquina pmaquina) {
		maquina = pmaquina;
	}
	
	/**
	 * verificarAveria
	 * Verifica si hay averias en la máquina e indica cual es.
	 * @return String averia que se ha producido en la máquina.
	 */
	public String verificarAveria() {
		String averia = "";
		
		// Verificar si la configuración del envase a producir es correcta.
		if (maquina.getCantMateriaPrima() < maquina.getMoldeEnvases().obtenerPorcMateria()) {
			averia = Constantes.FALLA_ENVASE;
		}
		
		// Verificar si la cantidad de materia prima es suficiente para producir
		// el siguiente envase.
		if (maquina.getCantMateriaPrima() < maquina.getMoldeEnvases().obtenerPorcMateria()) {
			averia = Constantes.FALLA_MATERIA_PRIMA;
		}
		
		return averia;
	}

}
