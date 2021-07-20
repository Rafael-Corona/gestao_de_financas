
public class Categoria {
	
	String nome;
	int numeroMembros;
	float valorTotal;

	
	public Categoria() {
		nome = null;
		numeroMembros = 0;
		valorTotal = 0;
	}
	
	public Categoria(String name) {
		nome = name;
		numeroMembros = 0;
		valorTotal = 0;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getNumeroMembros(){
		return numeroMembros;
	}
	
	public double getValorTotal(){
		return valorTotal;
	}

	public void setNome(String n) {
		nome = n;
	}
	
	public void addElemento(double valor) {
		numeroMembros++;
		valorTotal += valor;
	}
	
	public void removeElemento(double valor) {
		numeroMembros--;
		valorTotal -= valor;
	}
	
}
