import java.util.ArrayList;

/**
 * Fabrica
 * @author Miguel García
 */
public class Fabrica {
	private ArrayList<Maquina> listaMaquinas = new ArrayList<>();
	private CentroControl objCentroControl;
	
	/**
	 * Fabrica.
	 * Constructor por defecto. Crea un centro de control y al menos una maquina.
	 */
	public Fabrica(){
		setCentroControl();
		
		// TODO: agregar al menos una maquina. No puede existir una fabrica
		// sin maquinas.
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
	 * setCentroControl
	 * Establece una referencia con el centro de control que administra.
	 */
	private void setCentroControl(){
		objCentroControl = new CentroControl(this);
	}
	
	public ArrayList<Maquina> getMaquinas(){
		return listaMaquinas;
	}
	
	private void setMaquina(CentroControl pobjCentroControl){
		listaMaquinas.add(new Maquina(pobjCentroControl));
	}
		
	public void crearMaquina(){
		setMaquina(objCentroControl);
	}
	
	public void establecerParametrosMaq(int pindice, boolean pmodoOp, int pnumEnvases, char tamanannoENvases, int grosorEnvases){
		listaMaquinas.get(pindice-1).establecerParametros(pmodoOp, pnumEnvases, tamanannoENvases, grosorEnvases); 
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
