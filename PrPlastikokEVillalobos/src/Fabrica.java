import java.util.ArrayList;

/**
 * Fabrica
 * Fabrica de maquinas productoras de envases de plastico.
 * @author Miguel García
 */
public class Fabrica {
	private ArrayList<Maquina> listaMaquinas = new ArrayList<Maquina>();
	private CentroControl objCentroControl;
	
	/**
	 * Fábrica.
	 * Constructor por defecto. Crea un centro de control y al menos una máquina.
	 */
	public Fabrica(){
		crearCentroControl();
		// Crear al menos una máquina. No puede existir una fábrica sin máquinas.
		crearMaquina(1, "", "", "");
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
	 * @return ArrayList lista de máquinas que tiene la fábrica.
	 */
	public ArrayList<Maquina> getMaquinas() {
		return listaMaquinas;
	}
	
	/**
	 * agregarMaquina
	 * Agrega una máquina a la lista de máquinas de la fábrica.
	 */
	private void agregarMaquina(int ptipoMaquina, String pmarca, String pmodelo, String pannoFabricacion) {
		if(ptipoMaquina == 1){
			listaMaquinas.add(new Maquina(getCentroControl(), pmarca, pmodelo, pannoFabricacion));
		}else{
			listaMaquinas.add(new Gamma(getCentroControl(), pmarca, pmodelo, pannoFabricacion));
		}
		
	}

	/**
	 * crearMaquina
	 * Método que permite a clientes crear nuevas máquinas en la fábrica.
	 * @param
	 */
	
	/**
	 * crearMaquina
	 * Método que permite a clientes crear nuevas máquinas en la fábrica.
	 * @param ptipoMaquina tipo de maquina, puede ser 1, maquina regular o 2 maquina gamma.
	 * @param pmarca marca de la maquina.
	 * @param pmodelo modelo de la maquina.
	 * @param pannoFabricacion Anno de fabricacion de la maquina.
	 */
	public void crearMaquina(Integer ptipoMaquina ,String pmarca, String pmodelo, String pannoFabricacion) {
		agregarMaquina(ptipoMaquina, pmarca, pmodelo, pannoFabricacion);
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
		listaMaquinas.get(pindice-1).establecerParametros(pmodoOp, pnumEnvases,tamanannoEnvases, grosorEnvases); 
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
}
