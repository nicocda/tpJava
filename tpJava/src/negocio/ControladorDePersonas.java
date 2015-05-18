package negocio;
import entidades.Persona;
import datos.CatCliente;
//Declaracion de la clase
public class ControladorDePersonas
{
	
	CatCliente cc= new CatCliente();
	
	public Persona buscarPersona(int docu)
		{
			return(cc.buscarDni(docu));
		}//Cierro Buscar

	public Persona guardar(int dni, String nombre, String apellido, String email)
	{ 
	
		Persona p= cc.buscarDni(dni);
		if(p==null)	{p= new Persona(dni,nombre,apellido,email);
		cc.agregarAlArray(p);
					}//cierro if
		return(p);// Si p==null, p toma el valor de agregarPersona, sino p sale con el valor de buscarDni
	}//cierre de guardar
	
		}//Cierro clase
