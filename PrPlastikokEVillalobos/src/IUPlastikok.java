import java.io.*;

public class IUPlastikok {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = System.out;
	private static Fabrica objFabrica = new Fabrica();

	public static void main(String[] args) throws java.io.IOException{
		int opc;
		boolean salir = false;
		String[] listaMenu={"1. Crear maquina",
							"2. Establecer parametros de funcionamiento",
							"3. Iniciar produccion",
                            "4. Desactivar maquina",
                            "5. Activar maquina",
                            "6. Cargar materia prima",
                            "7. Crear un operario",
                            "8. Listar solicitudes despachadas a un operario",
                            "9. Reparar máquina",
                            "10. Listar solicitudes despachadas por el Centro de Averías",
                            "11. Listar solicitudes atendidas",
                            "0. Salir"};

		do{
			mostrarMenu(listaMenu);
			opc = leerOpcion();
			salir = ejecutarAccion(opc);
		}while (!salir);

	}
	
	/*****************************************************************
	 * Rutina: mostrarMenu
	 * Propï¿½sito: Presentar el menï¿½ de opciones
	 * Parï¿½metros: plista
	 				La lista de opciones que debe tener el menu.
	 *			   
	 * Retorna: 
	 *****************************************************************/

	static void mostrarMenu(String[] plista){
				
		out.println();
		
		for(int i=0;i<plista.length;i++){
			out.println(plista[i]);
		}
		out.println();
	}

	/*****************************************************************
	 * Rutina: leerOpcion
	 * Propï¿½sito: Obtener del usuario la opcï¿½ï¿½n escogida
	 * Parï¿½metros: 
	 *			   
	 * Retorna: 
	 *****************************************************************/

	static int leerOpcion()throws java.io.IOException{	
		int opcion;
		
		out.print("Seleccione su opci\u00a2n: ");
		opcion = Integer.parseInt(in.readLine());

		return opcion;
	}

	/*****************************************************************
	 * Rutina: ejecutarAccion
	 * Propï¿½sito: Ejecutar la acciï¿½n que corresponde a la opcï¿½ï¿½n escogida
	 * Parï¿½metro: popcion
	 *			   
	 * Retorna: boolean
	 *			Un valor que indica si se desea continuar o salir del menï¿½
	 *****************************************************************/

	static boolean ejecutarAccion(int popcion)throws java.io.IOException{
        
		boolean salir = false;
			
		switch(popcion){
			
			case 1: //Crear Maquina
				crearMaquina();
			break;
		
			case 2: //Establecer parametros
				establecerParametrosFuncionamiento();
			break;
		
			case 3: // Iniciar produccion
				out.println(iniciarProduccion());

				break;

			case 4:// Desactivar maquina
				desactivarMaquina();
		     	break;

			case 5: //Activar maquina
				activarMaquina();
				break;  


			case 6: //Cargar materia prima 
				cargarMateriaPrima();
	     		break;
                            
            case 7: //Crear operario
            	crearOperario();
	     		break;    
                        
            case 8: //Listar solicitudes despachadas a un operario
            	out.println(listarSolicitudesDespachadasOper());
	     		break;    
			
			case 0: //Salir de la aplicacion

				salir = true;
				out.println("Muchas gracias y hasta la proxima");
				break;

			default: //Cualquier otro valor dado por el usuario se considera invï¿½lido

				out.println("Opcion inv\u00a0lida");
				out.println();
				break;
		}
		return salir;
	}	
	
	public static void crearMaquina()throws java.io.IOException{
		out.println("Ingrese la marca");
		String marca = in.readLine();
		out.println("Ingrese el modelo");
		String modelo = in.readLine();
		out.println("Ingrese el año de fabricacion");
		String annoFab = in.readLine();
		out.println("Ingrese el tipo de maquina. 1: Normal o 2: Gamma");
		int tipoMaquina = Integer.parseInt(in.readLine());
		
		objFabrica.crearMaquina(tipoMaquina, marca, modelo, annoFab);
	}
	
	private static void establecerParametrosFuncionamiento()throws java.io.IOException{
		int indiceMaquina = seleccionarMaquina();
		
		out.println("Establezca el modo de operacion C: Continua o I: Intervalo");
		char pmodoOp = in.readLine().charAt(0);
		out.println("Establezca el numero de envases a producir por intervalo.");
		int pnumEnvases = Integer.parseInt(in.readLine());
		out.println("Establezca el tamanno de los envases. P, M o G");
		char ptamannoEnvases = in.readLine().charAt(0);
		out.println("Establezca el grosor de los envases. 1, 2 o 3");
		int pgrosorEnvases = Integer.parseInt(in.readLine());
		
		objFabrica.getMaquinas().get(indiceMaquina).establecerParametros(pmodoOp, pnumEnvases, ptamannoEnvases, pgrosorEnvases);
	}
	
	private static String iniciarProduccion()throws java.io.IOException{
		int indiceMaquina = seleccionarMaquina();
		
		String msjMaquina = objFabrica.getMaquinas().get(indiceMaquina).iniciarProduccion();
		
		return msjMaquina;
	}
	
	private static void desactivarMaquina()throws java.io.IOException{
		int indiceMaquina = seleccionarMaquina();
		
		objFabrica.getMaquinas().get(indiceMaquina).desactivarMaquina();
	}
	
	private static void activarMaquina()throws java.io.IOException{
		int indiceMaquina = seleccionarMaquina();
		
		objFabrica.getMaquinas().get(indiceMaquina).activarMaquina();
	}
	
	private static void cargarMateriaPrima() throws java.io.IOException{
		int indiceMaquina = seleccionarMaquina();
		
		objFabrica.getMaquinas().get(indiceMaquina).cargarMateriaPrima();
	}
	
	private static void crearOperario()throws java.io.IOException{
		out.println("Cual es el nombre del operario");
		String pnombre = in.readLine();
		out.println("Cual es el numero de cedula del operario");
		String pcedula = in.readLine();
		
		objFabrica.getCentroControl().crearOperario(pcedula, pnombre);
	}
	
	private static String listarSolicitudesDespachadasOper()throws java.io.IOException{
		String msj = "Existen los sguientes operarios en la fabrica, seleccione alguno: \n";
		for (int i = 0; i < objFabrica.getCentroControl().getListaOperarios().size(); i++) {
			msj += (i+1)+" Operario: "+objFabrica.getCentroControl().getListaOperarios().get(i).getNombre()+"\n";
		}
		out.println(msj);
		
		int indiceOperario = Integer.parseInt(in.readLine())-1;
		
		String lista = objFabrica.getCentroControl().listarSolicDespachadasOperario(objFabrica.getCentroControl().getListaOperarios().get(indiceOperario));
		
		return lista;
	}
	
	private static void repararMaquina(){
		String msj = "Existen las sguientes solicitudes de reparacion, seleccione alguna: \n";
		msj += objFabrica.getCentroControl().listarSolicitudes();
		
	} 
	
	private static int seleccionarMaquina()throws java.io.IOException{
		String msj = "Existen las sguientes maquinas en la fabrica, seleccione alguna: \n";
		for (int i = 0; i < objFabrica.getMaquinas().size(); i++) {
			msj += (i+1)+"Maquina: "+objFabrica.getMaquinas().get(i).getId()+"\n";
		}
		out.println(msj);
		int indiceMaquina = Integer.parseInt(in.readLine())-1;
		
		return indiceMaquina;
	}
}