import java.util.ArrayList;


public class Fabrica {
	private ArrayList<Maquina> listaMaquinas = new ArrayList<>();
	private CentroControl objCentroControl;
	private int contadorMaquinas = 0;
	
	public Fabrica(){
		setCentroControl();
	}
	
	private void setCentroControl(){
		objCentroControl = new CentroControl();
	}
	
	public CentroControl getCentroControl(){
		return objCentroControl;
	}
	
	private void setMaquina(CentroControl pobjCentroControl){
		listaMaquinas.add(new Maquina(pobjCentroControl, contadorMaquinas));
	}
	
	public ArrayList<Maquina> getMaquinas(){
		return listaMaquinas;
	}
	
	public void crearMaquina(){
		contadorMaquinas ++;
		setMaquina(objCentroControl);
	}
	
	public void establecerParametros(int pindice, boolean pmodoOp, int cantEnvases, char tamanannoENvases, int grosorEnvases){
		listaMaquinas<pindice-1>.establecerParametros(pmodoOp, cantEnvases, tamanannoENvases, grosorEnvases); 
	}
	
	

}
