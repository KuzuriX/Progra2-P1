
/**
 * Detector
 * Detecta averias en las maquinas y las reporta.
 * @author Elizabeth Villalobos
 */
public class Detector {
	private String tipoAveria;
	private Maquina maquina;
	
	/**
	 * Detector.
	 * Constructor. Detecta fallas en la máquina productora de envases.
	 * @param pmaquina Maquina a la que esta asociado el detector.
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
		if (maquina.getCantMateriaPrima() < maquina.MINIMO_MATERIA_PRIMA) {
			averia = Constantes.FALLA_MATERIA_PRIMA;
		}
		
		return averia;
	}

}
