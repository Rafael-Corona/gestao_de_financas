import java.util.*; 
public class ListaCategorias extends Categoria {

	private ArrayList<Categoria> lista;
	
	public ListaCategorias(){
		
		 lista = new ArrayList<Categoria>();
	}

	public Categoria getCategoriaAt(int index) {
		return lista.get(index);
	}

	public ArrayList<Categoria> getArrayList() {
		return lista;
	}
	
	public int getLen() {
		return lista.size();
	}

	public void addInCategoria(String nomeCat, double valor) {
		int i=0;
		Categoria atual;
		while(i < lista.size())
		{
			atual = lista.get(i);
			if(atual.getNome() == nomeCat)
			{
				atual.addElemento(valor);
				return;
			}
			i++;
		}
		Categoria nova = new Categoria(nomeCat);
		nova.addElemento(valor);
		lista.add(nova);
	}
	
	public void removeFromCategoria(String nomeCat, double valor) {
		int i=0;
		Categoria atual;
		while(i < lista.size())
		{
			atual = lista.get(i);
			if(atual.getNome() == nomeCat)
			{
				atual.removeElemento(valor);
				if(atual.getNumeroMembros() <= 0) {
					lista.remove(i);
				}
				return;
			}
			i++;
		}
	}

	/**
	 * Função main para testar o código.
	 * Sem função real no programa.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception{
		RegistroFinanceiro teste = new RegistroFinanceiro();		
		RegistroFinanceiro teste2 = new RegistroFinanceiro();
		RegistroFinanceiro teste3 = new RegistroFinanceiro();
		RegistroFinanceiro teste4 = new RegistroFinanceiro();
		
		ListaCategorias lista = new ListaCategorias();
				
		teste.setCategoria("Mercado");
		teste.setValor(-189.99);
		
		teste2.setCategoria("Mercado");
		teste2.setValor(-575.59);

		teste3.setCategoria("Aluguel");
		teste3.setValor(-1565.00);

		teste4.setCategoria("Salário");
		teste4.setValor(-289.99);
	
		System.out.printf("A lista tem %d elementos\n", lista.getLen());

		lista.addInCategoria(teste.getCategoria(), teste.getValor());
		lista.addInCategoria(teste2.getCategoria(), teste2.getValor());
		lista.addInCategoria(teste3.getCategoria(), teste3.getValor());
		lista.addInCategoria(teste4.getCategoria(), teste4.getValor());
		
		Categoria atual;
		
		for(int i = 0; i < lista.getLen(); i++)
		{
			atual = lista.getCategoriaAt(i);
			System.out.printf("A categoria %s tem um valor de %f e %d membros\n", atual.getNome(), atual.getValorTotal(), atual.getNumeroMembros());
			
		}
		System.out.printf("A lista tem %d categorias\n", lista.getLen());
		
		lista.removeFromCategoria(teste.getCategoria(), teste.getValor());
		//lista.removeFromCategoria(teste2.getCategoria(), teste2.getValor());
		//lista.removeFromCategoria(teste3.getCategoria(), teste3.getValor());
		lista.removeFromCategoria(teste4.getCategoria(), teste4.getValor());
		System.out.printf("A lista tem %d categorias\n", lista.getLen());
		
		for(int i = 0; i < lista.getLen(); i++)
		{
			atual = lista.getCategoriaAt(i);
			System.out.printf("A categoria %s tem um valor de %f e %d membros\n", atual.getNome(), atual.getValorTotal(), atual.getNumeroMembros());
			
		}

	}
}
