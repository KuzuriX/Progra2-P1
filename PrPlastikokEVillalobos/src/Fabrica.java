import java.util.ArrayList;


public class Fabrica {
	private ArrayList<Maquina> listaMaquinas = new ArrayList<>();
	private ObjetoControl objCentroControl;
	
	public Fabrica(){
		objCentroControl = new CentroControl();
	}

}
