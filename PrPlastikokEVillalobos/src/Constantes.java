/**
 * Constantes
 * Define constantes para ser utilizadas en la clase Fabrica.
 * @author Elizabeth Villalobos
 */
public final class Constantes {
	private Constantes() {}	
	
	public static final String FALLA_MATERIA_PRIMA = "Materia prima agotada.";
	public static final String FALLA_ENVASE = "Envase inválido.";
	
	public static final String FALLA_MATERIA_PRIMA_SOLUCION = "Se cargó materia prima a la máquina al 100%.";
	public static final String FALLA_ENVASE_SOLUCION = "";
	
	public static final double PORCENTAJE_ENVASE_P_1 = 1;
	
	public static final double PORCENTAJE_ENVASE_M_1 = 1.25;
	public static final double PORCENTAJE_ENVASE_M_2 = 1.4;
	
	public static final double PORCENTAJE_ENVASE_G_2 = 1.75;
	public static final double PORCENTAJE_ENVASE_G_3 = 1.9;
	
	public static final String SOLICITUD_CONDICION_PENDIENTE = "Pendiente";
	public static final String SOLICITUD_CONDICION_DESPACHADA = "Despachada";
	public static final String SOLICITUD_CONDICION_ATENDIDA = "Atendida";
}