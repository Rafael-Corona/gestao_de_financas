/**
 * Representa um registro financeiro do usuário.
 * Um registro financeiro é composto por:
 * 	-Valor do registro
 * 	-numero de parcelas
 *  -descricao
 *  -categoria
 *  -data
 *
 */

public class RegistroFinanceiro {
	private double valor;
	private int numeroParcelas;
	private String descricao;
	private String categoria;
	private String data;


public RegistroFinanceiro () {

	valor = 0;
	numeroParcelas = 0;
	descricao = null;
	categoria = null;
	data = null;
}

//Getters

/**
 * Retorna o valor de um registro.
 * @return o valor do registro financeiro.
 */
public double getValor() {
	return valor;
}

/**
 * Retorna o número de parcelas de um registro.
 * @return o número de parcelas do registro financeiro.
 */
public int getNumeroParcelas() {
	return numeroParcelas;
}

/**
 * Retorna a descrição de um registro.
 * @return a descrição do registro financeiro.
 */
public String getDescricao() {
	return descricao;
}

/**
 * Retorna a categoria de um registro.
 * @return a categoria do registro financeiro.
 */
public String getCategoria() {
	return categoria;
}

/**
 * Retorna a data de um registro.
 * @return a data do registro financeiro.
 */
public String getData() {
	return data;
}

//Setters
/**
 * Atribui um float para o valor de um registro.
 * @param valor float que armazena o valor de um registro.
 */
public void setValor(double valorR) throws IllegalArgumentException {
	if(valorR == 0) {
		throw new IllegalArgumentException("Registro com valor zero");
	}
	valor = valorR;
}

/**
 * Atribui um int para o número de parcelas de um registro.
 * @param numParcelas int que armazena o número de parcelas de um registro.
 */
public void setNumeroParcelas(int numParcelas) throws IllegalArgumentException {
	if(numParcelas <= 0) {
		throw new IllegalArgumentException("Número de parcelas com valor inválido");
	}
	numeroParcelas = numParcelas;
}

/**
 * Atribui uma String para a descrição de um registro.
 * @param des que armazena a descrição de um registro.
 */
public void setDescricao(String des) {
	descricao = des;
}

/**
 * Atribui uma String para a data de um registro.
 * @param des que armazena a data de um registro.
 */
public void setData(String date) {
	data = date;
}


/**
 * Atribui uma String para a categoria de um registro.
 * @param cat que armazena a categoria de um registro.
 */
public void setCategoria(String cat) {
	categoria = cat;
}


//comparacoes


/**
 * Retorna true se é um gasto, false se for um ganho.
 * @return true caso seja um gasto, caso contrário false.
 */
public boolean isGasto() {
	if(valor < 0) {
		return true;
	}
	return false;

}

/**
 * Retorna true se é um ganho, false se for um gasto.
 * @return true caso seja um ganho, caso contrário false.
 */
public boolean isGanho() {
	if(valor < 0) {
		return false;
	}
	return true;
}

/**
 * Retorna true se é parcelado, false se for à vista.
 * @return true caso seja parcelado, caso contrário false.
 */
public boolean isParcelado()  {
	if(numeroParcelas > 1) {
		return true;
	}
	return false;
}

/**
 * Retorna true se é à vista, false se for parcelado.
 * @return true caso seja à vista, caso contrário false.
 */
public boolean isAVista() throws Exception {
	if(numeroParcelas > 1) {
		return false;
	}
	return true;
	
}

/**
 * Compara a categoria do registro com a categoria do registro r2.
 * Retorna true caso sejam iguais, false caso sejam diferentes.
 * @return true caso sejam da mesma categoria, caso contrário false.
 */
public boolean mesmaCategoria(RegistroFinanceiro r2) {
	
	if(categoria.compareTo(r2.categoria) == 0) {
		return true;
	}
	return false;
}
/**
 * Função main para testar o código.
 * Sem função real no programa.
 * @param args
 * @throws Exception
 */
public static void main(String args[]) throws Exception{
	RegistroFinanceiro teste = new RegistroFinanceiro();
	
	teste.setCategoria("Mercado");
	teste.setData("30 de janeiro de 2020");
	teste.setDescricao("As compras do mês de janeiro");
	teste.setNumeroParcelas(1);
	teste.setValor(-289.99);
	
	System.out.printf("Categoria: %s\n", teste.getCategoria());
	System.out.printf("Data: %s\n", teste.getData());
	System.out.printf("Descrição: %s\n", teste.getDescricao());
	System.out.printf("Valor: %f\n", teste.getValor());
	System.out.printf("Numero de parcelas: %d\n", teste.getNumeroParcelas());
	
	if(teste.isGanho() == true) {
		System.out.println("É um ganho");
	}
	if(teste.isGasto() == true) {
		System.out.println("É um gasto");
	}
	
	if(teste.isAVista() == true) {
		System.out.println("É a vista");
	}
	
	if(teste.isParcelado() == true) {
		System.out.println("É parcelado");
	}
	
}

}