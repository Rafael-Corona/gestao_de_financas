import java.util.*; 

/**
 * Representa uma lista de registros financeiros de um usuário.
 * Os registros serão armazenados em um ArrayList
 *
 */
public class ListaRegistros extends RegistroFinanceiro {

	ArrayList<RegistroFinanceiro> lista;
	
	
	public ListaRegistros(){
		
		 lista = new ArrayList<RegistroFinanceiro>();
	}

	public void addRegistro(RegistroFinanceiro r) {
		lista.add(r);
	}

	public void addRegistro(int index, RegistroFinanceiro r) {
		lista.add(index, r);
	}
	
	public void removeRegistro(int index) {
		lista.remove(index);
	}
	
	public RegistroFinanceiro getRegistroAt(int index) {
		return lista.get(index);
	}

	public ArrayList<RegistroFinanceiro> getArrayList() {
		return lista;
	}
	
	public int getLen() {
		return lista.size();
	}
}
