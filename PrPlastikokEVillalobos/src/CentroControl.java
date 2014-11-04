import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Centro de control
 * Administra las solicitudes de reparacion de las maquinas.
 * @author Elizabeth Villalobos
 */
public class CentroControl {
	private ArrayList<Operario> listaOperarios;
	private ArrayList<Solicitud> solicitudesDespachadas;
	private ArrayList<Solicitud> solicitudesAtendidas;
	private Fabrica fabrica;
	
	/**
	 * Centro de control
	 * Constructor por defecto. Realiza las siguientes operaciones:
	 * 	1. Crea un nuevo operario.
	 *  2. Inicializa la lista de solicitudes despachadas.
	 *  3. Inicializa la lista de solicitudes atendidas.
	 *  @param pfabrica Fabrica a la que pertenece el centro de control.
	 */
	public CentroControl(Fabrica pfabrica) {
		listaOperarios = new ArrayList<Operario>();
		
		// Agregar un operario. Debe haber al menos uno.
		Operario operario = new Operario("1-0222-0333", "Juan Perez", this);
		listaOperarios.add(operario);
		
		// Inicializar las listas de solicitudes.
		solicitudesDespachadas = new ArrayList<Solicitud>();
		solicitudesAtendidas = new ArrayList<Solicitud>();
		
		// Establecer la relacion con la fabrica a la que pertenece el centro
		// de control.
		setFabrica(pfabrica);
	}

	/**
	 * obtenerOperario
	 * Retorna el operario que se encuentre en una posicion especifica del array.
	 * @param pposicion posicion en la lista donde se encuentra el operario.
	 * @return Operario operario del centro de control
	 */
	public Operario obtenerOperario(int pposicion) {
		return listaOperarios.get(pposicion);
	}
	
	/**
	 * crearOperario
	 * Crear un nuevo operario y lo agrega a la lista de operarios del 
	 * centro de control.
	 * @param pcedula cedula del operario a crear.
	 * @param pnombre nombre del operario a crear.
	 */
	public void crearOperario(String pcedula, String pnombre) {
		if (listaOperarios.size() <= 2) {
			Operario objOperario = new Operario(pcedula, pnombre, this);
			listaOperarios.add(objOperario);
		}
	}
	
	/**
	 * listarOperarios
	 * Lista los operarios que tiene el centro de control.
	 * @return String texto que contiene la informacion de los operarios
	 * 				  del centro de control.
	 */
	private String listarOperarios() {
		String lista = "";
		
		for (Operario objOperario: listaOperarios) {
			lista += objOperario.toString();
		}
		return lista;
	}
	
	public void crearSolicitud(String pidMaquina, SimpleDateFormat pfechaHoraAveria, int pcantEnvases, char ptamano, int pgrosor, String pproblema) {
		// Crear una nueva solicitud.
		Solicitud objSolicitud = new Solicitud(pidMaquina, pfechaHoraAveria, pcantEnvases, ptamano, pgrosor, pproblema);
		// Despachar la solicitud a un operario.		
		despacharSolicitud(objSolicitud);
	}
	
	/**
	 * despacharSolicitud
	 * Despacha una solicitud de reparacion a un operario. Si hay mas de un
	 * operario es necesario determinar cual tiene menos solicitudes asignadas.
	 * @param psolicitud solicitud a despachar.
	 */
	private void despacharSolicitud(Solicitud psolicitud) {
		Operario operario1 = (Operario) listaOperarios.get(0);
		
		// Si hay mas de un operario, entonces asignar la solicitud a quien
		// tenga menos asignadas.
		if (listaOperarios.size() > 1 && solicitudesDespachadas.size() > 0) {	
			Operario operario2 = (Operario) listaOperarios.get(1);
			
			int op1Cont = 0;
			int op2Cont = 0;
			
			for (int i = 0; i < solicitudesDespachadas.size(); i++) {
				Solicitud solicitud = (Solicitud) solicitudesDespachadas.get(i);
				if (solicitud.getOperarioEncargado().getCedula() == operario1.getCedula()) {
					op1Cont++;
				} else {
					op2Cont++;
				}
			}
			
			// Si el operario 1 tiene mas solicitudes asignadas que el operario 2
			// entonces asignarle la solicitud al operario 2.		
			if (op1Cont > op2Cont) {
				psolicitud.asignarOperarioEncargado(operario2);
			} else {
				// Si el operario 2 tiene igual cantidad o mas solicitudes que
				// el operario 1, entonces asignar la solicitud al operario 1.
				psolicitud.asignarOperarioEncargado(operario1);
			}
		} else {
			// Si solo hay un operario en el centro, entoces asignarle 
			// la solicitud.
			psolicitud.asignarOperarioEncargado(operario1);
		}
		// Cambiar el estado de la solicitud y agregarla a la lista de despachadas.
		psolicitud.setCondicionAtencion(Constantes.SOLICITUD_CONDICION_DESPACHADA);
		solicitudesDespachadas.add(psolicitud);
	}
	
	/**
	 * moverSolicitudAtendida
	 * Mover una solicitud de la lista de despachadas a atendidas.
	 * @param psolicitud solicitud que debe ser movida.
	 */
	public void moverSolicitudAtendida(Solicitud psolicitud) {
		// Obtener el indice de la solicitud en la lista.
		int indice = solicitudesDespachadas.indexOf(psolicitud);
		
		// Agregar la solicitud a la lista de atendidas.
		psolicitud.setCondicionAtencion(Constantes.SOLICITUD_CONDICION_ATENDIDA);
		solicitudesAtendidas.add(psolicitud);
		
		// Eliminar la solicitud de la lista de despachadas.
		solicitudesDespachadas.remove(indice);
	}
	
	/**
	 * listarSolicitudes
	 * Retorna la lista de las solicitudes despachadas por el centro de control.
	 * @return String lista de solicitudes despachadas.
	 */
	public String listarSolicitudes() {
		String lista = "";
		
		for (Solicitud objSolicitud: solicitudesDespachadas) {
			lista += objSolicitud.toString();
		}
		return lista;
	}
	
	/**
	 * listarSolicitudesAtendidas
	 * Retorna la lista de las solicitudes atendidas por el centro de control.
	 * @return String lista de solicitudes atendidas.
	 */
	public String listarSolicitudesAtendidas() {
		String lista = "";
		
		for (Solicitud objSolicitud: solicitudesAtendidas) {
			lista += objSolicitud.toString();
		}
		return lista;
	}
	
	/**
	 * listarSolicDespachadasOperario
	 * Retorna la lista de las solicitudes despachadas a el operario pasado
	 * por parametro.
	 * @param poperario Operario de quien se quiere obtener la lista de solicitudes
	 * @return String lista de solicitudes despachadas por operario.
	 */
	public String listarSolicDespachadasOperario(Operario poperario) {
		String lista = "";
		
		for (Solicitud objSolicitud: solicitudesDespachadas) {
			if (objSolicitud.getOperarioEncargado().getCedula() == poperario.getCedula()) {
				lista += objSolicitud.toString();
			}
		}
		return lista;
	}
	
	/**
	 * listarSolicAtendidasOperario
	 * Retorna la lista de las solicitudes atendidas por el operario pasado
	 * por parametro.
	 * @param poperario Operario de quien se quiere obtener la lista de solicitudes
	 * @return String lista de solicitudes atendidas por operario.
	 */
	public String listarSolicAtendidasOperario(Operario poperario) {
		String lista = "";
		
		for (Solicitud objSolicitud: solicitudesAtendidas) {
			if (objSolicitud.getOperarioEncargado().getCedula() == poperario.getCedula()) {
				lista += objSolicitud.toString();
			}
		}
		return lista;
	}
	
	/**
	 * getFabrica
	 * Retorna la fabrica a la que pertenece el centro de control.
	 * @return Fabrica fabrica a la que pertenece el centro de control.
	 */
	private Fabrica getFabrica() {
		return fabrica;
	}
	
	/**
	 * setFabrica
	 * Establece una referencia a la fabrica a la que pertenece el centro de control.
	 * @return pfabrica fabrica a la que pertenece el centro de control.
	 */
	private void setFabrica(Fabrica pfabrica) {
		fabrica = pfabrica;
	}
	
	/**
	 * obtenerMaquina
	 * Retorna la referencia a una maquina de la fabrica.
	 * @param pidMaquina id de la maquina a obtener
	 * @return Maquina referencia a la maquina.
	 */
	public Maquina obtenerMaquina(String pidMaquina) {
		return fabrica.obtenerMaquina(pidMaquina);
	}
	
	/**
	 * getListaOperarios
	 * Retorna la lista de operarios en el centro de control.
	 * @return lista de operarios.
	 */
	public ArrayList<Operario> getListaOperarios() {
		return listaOperarios;
	}
	
	/**
	 * obtenerSolicitud
	 * @param pid identificador de la solicitud
	 * @return Solicitud objeto solicitud
	 */
	public Solicitud obtenerSolicitud(String pid) {
		Solicitud objSolicitud = null;
		
		for (Solicitud solicitud: solicitudesDespachadas) {
			if (solicitud.getId() == pid) {
				objSolicitud = solicitud;
			}
		}
		
		return objSolicitud;
	}
	
	/**
	 * toString
	 * Retorna el estado del centro de control.
	 * @return String estado de los atributos del centro de control.
	 */
	public String toString() {
		String estado = "Centro de Control \n" +
						"Operarios: \n" + listarOperarios() + "\n" + 
						"Solicitudes Despachadas: \n" + listarSolicitudes() + "\n" + 
						"Solicitudes Atendidas: \n" + listarSolicitudesAtendidas();
		
		return estado;
	}
}