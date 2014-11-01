
public class Maquina {
	private String id;
	private CentroControl objCentroControl;
	private final static double MINIMO_MATERIA_PRIMA = 3.0;
	private String marca;
	private String modelo;
	private String annoFabricacion;
	private boolean modoOperacion;
	private double cantMateriaPrima;
	private boolean activo;
	private int condicion;
	private boolean enMarcha;
	private int cantEnvasesProd = 0;
	private Molde moldeEnvases;
	
	
	public Maquina(CentroControl pobjCentroControl, int pcontadorMaquinas){
		setCentroControl(pobjCentroControl);
		setId(pcontadorMaquinas);
		crearMolde();
	}
	
	private void setCentroControl(CentroControl pobjCentroControl){
		objCentroControl = pobjCentroControl;
	}
	
	private void crearMolde() {
		moldeEnvases = new Molde();
		establecerParametros(true, 0, 'p', 1);
	}
	
	private void setId(int pcontadorMaquinas){
		id = "MQ-"+pcontadorMaquinas;
	}
	
	public void establecerParametros(boolean pmodoOp, int pcantEnvases, char ptamannoEnvases, int pgrosorEnvases){
		
		setModoOperacion(pmodoOp);
		setCantEnvasesProd(pcantEnvases);
		setMolde(ptamannoEnvases, pgrosorEnvases);
		
	}
	
	private void setModoOperacion(boolean pmodOper){
		modoOperacion = pmodOper;
	}
	
	public boolean getModoOperacion(){
		return modoOperacion;
	}
	
	private void setCantEnvasesProd() {
		cantEnvasesProd ++;
	}
	
	public int getCantEnvasesProd() {
		return cantEnvasesProd;
	}
	
	private void setMolde(char ptamannoEnvases, int pgrosorEnvases){
		moldeEnvases.setTamannoEnvase(ptamannoEnvases);
		moldeEnvases.setGrosorEnvase(pgrosorEnvases);
	}
	
	private void setMarca(String pmarca) {
		marca = pmarca;
	}
	
	public String getMarca() {
		return marca;
	}
	
	private void setModelo(String pmodelo) {
		modelo = pmodelo;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setAnnoFabricacion(String pannoFabricacion) {
		annoFabricacion = pannoFabricacion;
	}
	
	public String getAnnoFabricacion() {
		return annoFabricacion;
	}
	
	public void setCantMateriaPrima(double pcantMateriaPrima) {
		cantMateriaPrima = pcantMateriaPrima;
	}
	
	public double getCantMateriaPrima() {
		return cantMateriaPrima;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	private boolean getActivo() {
		return activo;
	}
	
	private void setCondicion(int pcondicion) {
		condicion = pcondicion;
	}
	
	public int getCondicion() {
		return condicion;
	}
	
	public void setEnMarcha(boolean penMarcha) {
		enMarcha = penMarcha;
	}
	
	public boolean getEnmarcha(){
		return enMarcha;
	}

}
