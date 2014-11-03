/**
 * Molde
 * Molde que utilizan las máquinas para producir envases.
 * @author Miguel García
 */
public class Molde {
	private char tamannoEnvase;
	private int grosorEnvase;
	
	/**
	 * Molde.
	 * Constructor por defecto. Crea un molde con tamaño "P" y grosor 1.
	 */
	public Molde() {
		setTamannoEnvase('P');
		setGrosorEnvase(1);
	}
	
	/**
	 * getTamannoEnvase
	 * Retorna el tamaño del envase.
	 * @return char Tamaño del envase. Puede ser: 'P' (pequeño),
	 * 				'M' (mediano) o 'G' (grande).
	 */
	public char getTamannoEnvase() {
		return tamannoEnvase;
	}
	
	/**
	 * setTamannoEnvase
	 * Establece un valor para el tamaño del envase.
	 * @param ptamannoEnvase Tamaño del envase. Puede ser: 'P' (pequeño),
	 * 						 'M' (mediano) o 'G' (grande).
	 */
	public void setTamannoEnvase(char ptamannoEnvase) {
		tamannoEnvase = ptamannoEnvase;
	}
	
	/**
	 * getGrosorEnvase
	 * Retorna el grosor del envase.
	 * @return int grosor del envase.
	 */
	public int getGrosorEnvase() {
		return grosorEnvase;
	}
	
	/**
	 * setGrosorEnvase
	 * Establece un valor para el grosor del envase.
	 * @param pgrosorEnvase grosor del envase.
	 */
	public void setGrosorEnvase(int pgrosorEnvase) {
		grosorEnvase = pgrosorEnvase;
	}
	
	/**
	 * toString
	 * Retorna el estado del molde.
	 * @return String estado del molde.
	 */
	public String toString() {
		String estado = "Tamaño: " + getTamannoEnvase() + "\n" +
						"Grosor: " + getGrosorEnvase();
		
		return estado;
	}
}
