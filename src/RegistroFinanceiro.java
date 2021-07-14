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
	private float valor;
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
public float getValor() {
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
public void setValor(float valorR) {
	valor = valorR;
}

/**
 * Atribui um int para o número de parcelas de um registro.
 * @param numParcelas int que armazena o número de parcelas de um registro.
 */
public void setNumeroParcelas(int numParcelas) {
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
	descricao = cat;
}


//comparacoes


/**
 * Retorna true se é um gasto, false se for um ganho.
 * @return true caso seja um gasto, caso contrário false.
 */
public boolean isGasto() throws Exception {
	if(valor < 0) {
		return true;
	}
	if(valor > 0) {
		return false;
	}
	throw new Exception("Registro com valor inválido: 0");
}

/**
 * Retorna true se é um ganho, false se for um gasto.
 * @return true caso seja um ganho, caso contrário false.
 */
public boolean isGanho() throws Exception {
	if(valor < 0) {
		return false;
	}
	if(valor > 0) {
		return true;
	}
	throw new Exception("Registro com valor inválido: 0");
}

/**
 * Retorna true se é parcelado, false se for à vista.
 * @return true caso seja parcelado, caso contrário false.
 */
public boolean isParcelado() throws Exception {
	if(numeroParcelas > 1) {
		return true;
	}
	if(numeroParcelas == 1) {
		return false;
	}
	throw new Exception("Registro com valor inválido");
}

/**
 * Retorna true se é à vista, false se for parcelado.
 * @return true caso seja à vista, caso contrário false.
 */
public boolean isAVista() throws Exception {
	if(numeroParcelas > 1) {
		return false;
	}
	if(numeroParcelas == 1) {
		return true;
	}
	throw new Exception("Registro com valor inválido");
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


}