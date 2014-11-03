import java.io.PrintStream;

public class IUMaquinitas {
	public static void main(String [] args)	{	
		PrintStream out= System.out;
		
		Fabrica objFabrica = new Fabrica();		
		
		// Crear una nueva maquina.
		objFabrica.crearMaquina();
		objFabrica.getCentroControl().crearOperario("2-0444-0888", "Jose Mora");
		
		// Establecer nuevos parametros para las maquinas.
		objFabrica.establecerParametrosMaq(0, 'C', 0, 'P', 1);
		objFabrica.establecerParametrosMaq(1, 'I', 0, 'G', 3);
		
		out.println(objFabrica.toString());
		
		objFabrica.getMaquina(1).cargarMateriaPrima();
		objFabrica.getMaquina(1).activarMaquina();
		objFabrica.getMaquina(1).iniciarProduccion();
		
		out.println();
		out.println(objFabrica.getMaquina(1).toString());
	}
}
