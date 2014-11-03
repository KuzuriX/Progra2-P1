import java.util.ArrayList;

/**
 * Fabrica
 * @author Miguel García
 */
public class Fabrica {
	private ArrayList<Maquina> listaMaquinas = new ArrayList<>();
	private CentroControl objCentroControl;
	
	/**
	 * Fábrica.
	 * Constructor por defecto. Crea un centro de control y al menos una máquina.
	 */
	public Fabrica(){
		crearCentroControl();
		// Crear al menos una máquina. No puede existir una fábrica sin máquinas.
		crearMaquina();
	}
	
	/**
	 * getCentroControl
	 * Retorna la referencia al centro de control que administra.
	 * @return CentroControl referencia al centro de control.
	 */
	public CentroControl getCentroControl(){
		return objCentroControl;
	}
	
	/**
	 * crearCentroControl
	 * Crea un centro de control. Establece una referencia con el centro de control 
	 * que la fábrica administra.
	 */
	private void crearCentroControl(){
		objCentroControl = new CentroControl(this);
	}
	
	/**
	 * getMaquinas
	 * Retorna la lista de máquinas que la fábrica tiene disponible.
	 * @return ArrayList<Maquina> lista de máquinas que tiene la fábrica.
	 */
	public ArrayList<Maquina> getMaquinas() {
		return listaMaquinas;
	}
	
	/**
	 * getMaquina
	 * Retorna la maquina en una posicion especifica del arrya
	 * @param pindex posicion en que se encuentra la maquina.
	 * @return Maquina maquina en la posicion dada.
	 */
	public Maquina getMaquina(int pindex) {
		return listaMaquinas.get(pindex);
	}
	
	/**
	 * agregarMaquina
	 * Agrega una máquina a la lista de máquinas de la fábrica.
	 */
	private void agregarMaquina() {
		listaMaquinas.add(new Maquina(getCentroControl()));
	}

	/**
	 * crearMaquina
	 * Método que permite a clientes crear nuevas máquinas en la fábrica.
	 */
	public void crearMaquina() {
		agregarMaquina();
	}
	
	/**
	 * establecerParametrosMaq
	 * Establece los parámetros que utilizarán las máquinas para producir envases.
	 * @param pindice 		    Indica en la lista de máquinas donde se encuentra 
	 * 						    la máquina a la cual se le van a cambiar los 
	 * 						    parámetros.
	 * @param pmodoOp 		    Modo de operación de la máquina. True indica modo
	 * 						    de operación continuo. False indica modo de 
	 * 							operación a intervalos.
	 * @param pnumEnvases		Cantidad de envases a producir por intervalo.
	 * @param tamanannoEnvases 	Indica el tamaño de los envases que producirá
	 * 						   	la máquina.
	 * @param grosorEnvases		Indica el grosor de los envases que producirá
	 * 							la máquina.
	 */
	public void establecerParametrosMaq(int pindice, char pmodoOp, int pnumEnvases, char tamanannoEnvases, int grosorEnvases) {
		listaMaquinas.get(pindice-1).establecerParametros(pmodoOp, pnumEnvases, tamanannoEnvases, grosorEnvases); 
	}
	
	/**
	 * obtenerMaquina
	 * Retorna la referencia a una de las maquinas de la fabrica. Se debe buscar
	 * la maquina mediante su atributo id.
	 * @param pidMaquina id de la maquina a retornar
	 * @return Maquina referencia a la maquina.
	 */
	public Maquina obtenerMaquina(String pidMaquina) {
		Maquina maquinaRetornar = null;
		
		if (listaMaquinas.size() > 0) {
			for (Maquina objMaquina: listaMaquinas) {
				if (objMaquina.getId() == pidMaquina) {
					maquinaRetornar = objMaquina;
				}
			}
		}
		return maquinaRetornar;
	}
	
	/**
	 * toString
	 * Retorna el estado de la fabrica.
	 * @return String estado de la fabrica.
	 */
	public String toString() {
		String estado = objCentroControl.toString() + "\n" +
						"Maquinas: \n";
		
		for (Maquina objMaquina: listaMaquinas) {
			estado += objMaquina.toString();
		}
		
		return estado;
	}
}
