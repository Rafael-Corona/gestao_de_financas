import java.util.ArrayList;

/**
 * Representa os dados de um usuário do programa.
 * Esses dados são:
 * 	-saldo: o dinheiro que o usuário possui atualmente 
 * 	-lista: uma lista com todos os registros financeiros que o usuario fez
 * 	-gastosTotais: a soma de todos os gastos do usuário
 * 	-tetoGastos: meta estipulada pelo usuário para limitar seus gastos
 * 	-lista de categorias: uma lista com todas as categorias de gastos ou ganhos do usuário
 */
public class Usuario {

	private ListaRegistros listaReg;
	private double saldo;
	private double tetoGastos;
	private double gastosTotais;
	private ListaCategorias listaCat ;

public Usuario() {
	saldo = 0;
	tetoGastos = 0;
	gastosTotais = 0;
	listaReg = new ListaRegistros();
	listaCat = new ListaCategorias();
}

/**
 * Insere um novo registro financeiro no final da lista de registros do usuário.
 * Também insere o valor em uma categoria. Caso essa categoria não exista na lista, a cria.
 * Já atualiza os valores do saldo e dos gastos totais.
 * 
 * 
 * @param r o Registro a ser inserido na lista de registros e lista de categorias
 */
public void addRegistro(RegistroFinanceiro r) {
	//adiciona na lista de registros
	ArrayList<RegistroFinanceiro> registros = listaReg.getArrayList();
	registros.add(r);
	saldo += r.getValor();
	if(r.getValor() < 0) {
		gastosTotais += r.getValor();
	}
	//adiciona na lista de categorias
	listaCat.addInCategoria(r.getCategoria(), r.getValor());
}
/**
 * Insere um novo registro financeiro na posição indicada em index na lista de registros do usuário.
 * Também insere o valor em uma categoria. Caso essa categoria não exista na lista, a cria.
 * Já atualiza os valores do saldo e dos gastos totais.
 * 
 * @param index a posição onde o registro será inserido
 * @param r O registro inserido
 */
public void addRegistro(int index, RegistroFinanceiro r) {
	ArrayList<RegistroFinanceiro> registros = listaReg.getArrayList();
	registros.add(index, r);
	saldo += r.getValor();
	if(r.getValor() < 0) {
		gastosTotais += r.getValor(); 
	}
	//adiciona na lista de categorias
	listaCat.addInCategoria(r.getCategoria(), r.getValor());
}
/**
 * remove um registro financeiro na posição indicada em index na lista de registros do usuário.
 * Também remove o valor de sua categoria. Caso não restem valores nessa categoria, a exclui.
 * Já atualiza os valores do saldo e dos gastos totais.
 * 
 * @param index a posição onde o registro será removido
 */

public void removeRegistro(int index) {
	//remove da lista de registros
	ArrayList<RegistroFinanceiro> registros = listaReg.getArrayList();
	RegistroFinanceiro r = registros.get(index);
	saldo -= r.getValor();
	if(r.getValor() < 0) {
		gastosTotais -= r.getValor(); 
	}
	
	//remove da categoria
	listaCat.removeFromCategoria(r.getCategoria(), r.getValor());
	
	registros.remove(index);
}

/**
 * retorna o ArrayList que contém os registros do usuário
 * @return
 */
public ArrayList<RegistroFinanceiro> getListaRegistros() {
	
	return listaReg.getArrayList();
}

/**
 * função que retorna o saldo de um usuário
 * @return o valor do saldo do usuário
 */
public double getSaldo() {
	return saldo;
}

/**
 * função que atualiza o saldo
 */
public void updateSaldo() {
	
	int len = listaReg.getLen();
	RegistroFinanceiro regAtual;
	saldo = 0;
	for(int i = 0; i < len; i++) {
		regAtual = listaReg.getRegistroAt(i);
		saldo += regAtual.getValor();
	}
}

/**
 * função que retorna o teto de gastos do usuário
 * @return tetoGastos
 */
public double getTetoGastos() {
	return tetoGastos;
}

/**
 * Define o teto de gastos do usuário como teto
 * @param teto
 */
public void setTetoGastos(float teto) {
	tetoGastos = teto;
}

/**
 * retorna o total de gastos do usuário até o momento
 * @return gastosTotais
 */
public double getGastosTotais() {
	return gastosTotais;
}

/**
 * função que atualiza os gastos totais de um usuário
 */
public void updateGastosTotais() {
	int len = listaReg.getLen();
	RegistroFinanceiro regAtual;
	gastosTotais = 0;
	for(int i = 0; i < len; i++) {
		regAtual = listaReg.getRegistroAt(i);
		if(regAtual.getValor() < 0) {
		gastosTotais += regAtual.getValor();
		}
	}
}

}