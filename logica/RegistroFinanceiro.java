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
	private Data data;

public RegistroFinanceiro () {

	valor = 0;
	numeroParcelas = 0;
	descricao = null;
	categoria = null;
	data = new Data();
}
/**
 * Construtor da classe que preenche todos os dados do registro financeiro
 * Converte as Strings recebidas nos valores adequados aos campos.
 * Caso haja alguma inconsistência lança exeção
 * 
 * @param isDespesa booleano que indica que o valor do registro é uma despesa
 * @param description String que contém a descrição do registro
 * @param date String no formato DD/MM/AAA que representa uma data
 * @param value String que representa o valor do registro
 * @param nroParc String que representa o número de parcelas desse registro
 * @throws DataException Exceção lançada caso haja inconsistencias no formato de "date"
 * @throws ValorException Exceção lançada caso haja inconsistencias no formato de "value"
 * @throws NumeroParcelasException Exceção lançada caso haja inconsistencias no formato de "nroParc"
 */
public RegistroFinanceiro (boolean isDespesa, String description, String date, String value, String nroParc) 		
		throws DataException, ValorException, NumeroParcelasException {

	value = value.replaceAll(",", ".");
	try {
	valor = Double.parseDouble(value);
	}catch(Exception e){
		throw new ValorException();
	}
	if(valor <= 0) {
		throw new ValorException();
	}
	
	if(isDespesa == true)
	{
		valor = valor*(-1);
	}
	
	try {
	numeroParcelas = Integer.parseInt(nroParc);
	}catch(Exception e1) {
		throw new NumeroParcelasException();
	}
	if(numeroParcelas <= 0) {
		throw new NumeroParcelasException();
	}
	
	descricao = description;
	categoria = null; //voltar aqui
	data = new Data(date);
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
 * Retorna o valor de um registro como uma String.
 * @return String que representa o valor do registro financeiro.
 */
public String getValorString() {
	return String.valueOf(valor);
}

/**
 * Retorna o número de parcelas de um registro.
 * @return o número de parcelas do registro financeiro.
 */
public int getNumeroParcelas() {
	return numeroParcelas;
}

/**
 * Retorna o número de parcelas de um registro em formato de String.
 * @return String que representa o número de parcelas do registro financeiro.
 */
public String getNumeroParcelasString() {
	return String.valueOf(numeroParcelas);
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
public Data getData() {
	return data;
}
/**
 * Retorna a data de um registro em formato de uma String "DD/MM/AAAA".
 * @return String que representa a data do registro financeiro.
 */
public String getDataString() {
	return data.toString();
}

//Setters
/**
 * Atribui um float para o valor de um registro.
 * @param valorR float que armazena o valor de um registro.
 */
public void setValor(double valorR) throws IllegalArgumentException {
	if(valorR == 0) {
		throw new IllegalArgumentException("Registro com valor zero");
	}
	valor = valorR;
}

/**
 * Atribui uma String para o valor de um registro.
 * @param valorR String que armazena o valor de um registro.
 */
public void setValor(String valorR) throws IllegalArgumentException {
	
	valorR = valorR.replaceAll(",", ".");
	try {
	valor = Double.parseDouble(valorR);
	}catch(Exception e){
		throw new IllegalArgumentException("Valor inválido");
	}
	if(valor == 0) {
		throw new IllegalArgumentException("Registro com valor zero");
	}
	

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
 * Atribui uma String para o número de parcelas de um registro.
 * @param numParcelas String que representa o número de parcelas de um registro.
 */
public void setNumeroParcelas(String numParcelas) throws IllegalArgumentException {
	
	try {
	numeroParcelas = Integer.parseInt(numParcelas);
	}catch(Exception e1) {
		throw new IllegalArgumentException();
	}
	if(numeroParcelas <= 0) {
		throw new IllegalArgumentException("Número de parcelas com valor inválido");
	}
	
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
public void setData(String date) throws DataException {
	data = new Data(date);
}


/**
 * Atribui uma String para a categoria de um registro.
 * @param cat que armazena a categoria de um registro.
 */
public void setCategoria(String cat) {
	categoria = cat;
}


//Comparacoes
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
	teste.setData("30/01/2002");
	teste.setDescricao("As compras do mês de janeiro");
	teste.setNumeroParcelas("1");
	teste.setValor("-289.99");
	
	System.out.printf("Categoria: %s\n", teste.getCategoria());
	System.out.printf("Data: %s\n", teste.getData());
	System.out.printf("Descrição: %s\n", teste.getDescricao());
	System.out.printf("Valor: %s\n", teste.getValorString());
	System.out.printf("Numero de parcelas: %s\n", teste.getNumeroParcelasString());
	
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
	
	System.out.println();
	RegistroFinanceiro teste2 = new RegistroFinanceiro(true,"Minha viagem para praia","16/01/1985","3504,56","13");
	System.out.printf("Categoria: %s\n", teste2.getCategoria());
	System.out.printf("Data: %s\n", teste2.getData());
	System.out.printf("Descrição: %s\n", teste2.getDescricao());
	System.out.printf("Valor: %s\n", teste2.getValorString());
	System.out.printf("Numero de parcelas: %s\n", teste2.getNumeroParcelasString());
	
	if(teste2.isGanho() == true) {
		System.out.println("É um ganho");
	}
	if(teste2.isGasto() == true) {
		System.out.println("É um gasto");
	}
	
	if(teste2.isAVista() == true) {
		System.out.println("É a vista");
	}
	
	if(teste2.isParcelado() == true) {
		System.out.println("É parcelado");
	}
}

}