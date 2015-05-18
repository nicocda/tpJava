package datos;
import java.util.ArrayList;
import entidades.Persona;
//Declaracion de la clase
public class CatCliente 
{
ArrayList<Persona> arregloPersonas = new ArrayList<Persona>();
Persona p = new Persona();


public void agregarAlArray(Persona e ){
	arregloPersonas.add(e);
}


public Persona buscarDni(int doc){
	if(arregloPersonas.isEmpty())
	{
		p=null;
	}
	else
	{
		for (Persona s: arregloPersonas)
		{
			if( doc == s.getDni()) p = s; ;
		}//cierre for 
	}// cierre else
	
	return(p);
}

public Persona agregarPersona(int dni, String nombre, String apellido, String email) {
	p.setApellido(apellido);
	p.setDni(dni);
	p.setEmail(email);
	p.setNombre(nombre);
	return(p);
}};

