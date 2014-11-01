import java.util.ArrayList;

/**
 * Centro de control
 * @author Elizabeth Villalobos
 */
public class CentroControl {
	private ArrayList<Operario> listaOperarios;
	private ArrayList<Solicitud> solicitudesDespachadas;
	private ArrayList<Solicitud> solicitudesAtendidas;
	private final int MAX_OPERARIOS = 2;
	
	/**
	 * Centro de control
	 * Constructor por defecto. Realiza las siguientes operaciones:
	 * 	1. Crea un nuevo operario.
	 *  2. Inicializa la lista de solicitudes despachadas.
	 *  3. Inicializa la lista de solicitudes atendidas.
	 */
	public CentroControl() {
		// Agregar un operario.
		Operario operario = new Operario("1-0222-0333", "Juan Perez");
		listaOperarios.add(operario);
		
		// Inicializar las listas de solicitudes.
		solicitudesDespachadas = new ArrayList<Solicitud>();
		solicitudesAtendidas = new ArrayList<Solicitud>();
	}

	/**
	 * obtenerOperario
	 * Retorna el operario que se encuentre en una posicion especifica del array.
	 * @return Operario operario del centro de control
	 */
	private Operario obtenerOperario(int pposicion) {
		return listaOperarios.get(pposicion);
	}
	
	/**
	 * crearOperario
	 * Crear un nuevo operario y lo agrega a la lista de operarios del 
	 * centro de control.
	 * @param pcedula cedula del operario a crear.
	 * @param pnombre nombre del operario a crear.
	 */
	private void crearOperario(String pcedula, String pnombre) {
		if (listaOperarios.size() <= MAX_OPERARIOS) {
			Operario objOperario = new Operario(pcedula, pnombre);
			listaOperarios.add(objOperario);
		}
	}
	
	/**
	 * despacharSolicitud
	 * Despacha una solicitud de reparacion a un operario. Si hay mas de un
	 * operario es necesario determinar cual tiene menos solicitudes asignadas.
	 */
	private void despacharSolicitud() {
		if (listaOperarios.size() > 0) {
			
		}
	}
}