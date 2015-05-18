package entidades;
//Declaracion de la clase
public class Persona {
	private int dni;
	private String nombre,apellido,email;
	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;}
	
	
	public Persona(int dni,String nomb, String ape, String email){
		this.setDni(dni);
		this.setApellido(ape);
		this.setEmail(email);
		this.setNombre(nomb);
		
	}
	public Persona(){
		dni=0;
		nombre="";
		apellido="";
		email="";
	}
	
}
