
public class Detector {
	
	private Maquina objMaquina;
	private int tipoAveria;
	
	public Detector(Maquina pobjMaquina){
		setObjMaquina(pobjMaquina);
		setTipoAveria(0);
	}
	
	public void setObjMaquina(Maquina pobjMaquina) {
		objMaquina = pobjMaquina;
	}
	
	public Maquina getObjMaquina() {
		return objMaquina;
	}
	
	public void setTipoAveria(int ptipoAveria) {
		tipoAveria = ptipoAveria;
	}
	
	public int getTipoAveria() {
		return tipoAveria;
	}
	
	public int verificarFalla(){
		verificarCantMaterial();
		verificarEnvase();
		
		return getTipoAveria();
	}
	
	private void verificarCantMaterial(){
		if(objMaquina.getCantMateriaPrima() < objMaquina.MINIMO_MATERIA_PRIMA){
			setTipoAveria(1);
		}
		
	}
	
	private void verificarEnvase(){
		Molde moldeObjMaquinaMolde = objMaquina.moldeEnvases;
		if(moldeObjMaquinaMolde.getTamannoEnvase() == 'p'){
			if(moldeObjMaquinaMolde.getGrosorEnvase() != 1){
				setTipoAveria(2);
			}
		}else{
			if(moldeObjMaquinaMolde.getTamannoEnvase() == 'm'){
				if(moldeObjMaquinaMolde.getGrosorEnvase() == 3){
					setTipoAveria(2);
				}
			}else{
				if(moldeObjMaquinaMolde.getGrosorEnvase() == 1){
					setTipoAveria(2);
				}
			}
		}
	}

}
