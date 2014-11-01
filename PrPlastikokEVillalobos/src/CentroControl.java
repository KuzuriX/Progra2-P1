
/**
 * Centro de control
 * @author Elizabeth Villalobos
 */
public class CentroControl {
	private ArrayList<Operario> listaOperarios;
	private ArrayList<Solicitud> solicitudesDespachadas;
	private ArrayList<Solicitud> solicitudesAtendidas;
	
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
		
}