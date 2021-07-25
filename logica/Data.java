
public class Data {

	private Integer dia, mes, ano;
	
	/**
	 * Construtor da classe Data
	 * Deve receber uma string que representa data no formato DD/MM/AAA
	 * Caso a entrada não represente uma data nesse formato gera exceção DataException
	 * @param data
	 * @throws DataException
	 */
	public Data(String data) throws DataException {
		
		String tmp = new String();
		char day[], month[], year[];
		
		day = new char[2];
		month = new char[2];
		year = new char[4];
		
		if(data.length() != 10 ||data.charAt(2) != '/' || data.charAt(5) != '/') {
			throw new DataException();
		}
		
		day[0] = data.charAt(0);
		day[1] = data.charAt(1);

		tmp = String.valueOf(day);
		try {
		dia = Integer.parseInt(tmp);
		}catch(Exception e) {
			throw new DataException();
		}
		
		if(dia < 1 || dia > 31) {	
			throw new DataException();
		}
		
		month[0] = data.charAt(3);
		month[1] = data.charAt(4);
		
		tmp = String.valueOf(month);
		try {
		mes = Integer.parseInt(tmp);
		}catch(Exception e1){
			throw new DataException();
		}
		if(mes < 1 || mes > 12) {
			
			throw new DataException();
		
		}
		
		year[0] = data.charAt(6);
		year[1] = data.charAt(7);
		year[2] = data.charAt(8);
		year[3] = data.charAt(9);

		tmp = String.valueOf(year);
		try {
		ano = Integer.parseInt(tmp);
		}catch(Exception e2) {
			throw new DataException();
		}
	}
	/**
	 * Construtor vazio para a classe data
	 * Caso o objeto seja iniciado por esse construtor, ele deve set configurado com as funções de set
	 */
	public Data() {
		dia = 0;
		mes = 0;
		ano = 0;
	}
	/**
	 * retorna o dia como String
	 * @return
	 */
	public String getDiaString() {
		return dia.toString();
	}
	/**
	 * retorna o mês como String
	 * @return
	 */
	public String getMesString() {
		return mes.toString();
	}
	/**
	 * retorna o ano como String
	 * @return
	 */
	public String getAnoString() {
		return ano.toString();
	}
	
	/**
	 * retorna o dia
	 * @return
	 */
	public int getDia() {
		return dia;
	}
	/**
	 * retorna o mês
	 * @return
	 */
	public int getMes() {
		return mes;
	}
	/**
	 * retorna o ano
	 * @return
	 */
	public int getAno() {
		return ano;
	}
	
	/**
	 * Define o dia da data como o inteiro d
	 * @param d inteiro que representa o dia
	 * @throws DataException caso não seja um dia válido, lança exceção
	 */
	public void setDia(int d) throws DataException {
		if(d< 1 || d > 31) {
			throw new DataException();
		}
		dia = d;
	}
	/**
	 * Define o mês da data como o inteiro m
	 * @param m inteiro que representa um mês
	 * @throws DataException caso não seja um mês válido, lança exceção
	 */
	public void setMes(int m) throws DataException {
		if(mes < 1 || mes > 12) {
			throw new DataException();
		}
		mes = m;
	}
	/**
	 * define o ano da data como o inteiro a
	 * @param a inteiro que representa um ano
	 */
	public void setAno(int a) {
		ano = a;
	}
	
	
	/**
	 * Compara duas datas e informa qual é mais recente
	 * Retorna 1 caso a primeira data seja mais recente
	 * Retorna -1 caso a segunda data seja mais recente
	 * Retorna 0 caso sejam datas iguais
	 * 
	 * @param d1 Primeira data 
	 * @param d2 Segunda data
	 * @return 
	 */
	public int dataCompare(Data d1, Data d2) {
		
		if(d1.ano > d2.ano) {
			return 1;
		}
		
		if(d1.ano < d2.ano) {
			return -1;
		}
		
		if(d1.mes > d2.mes) {
			return 1;
		}
		
		if(d1.mes < d2.mes) {
			return -1;
		}
		
		if(d1.dia > d2.dia) {
			return 1;
		}
		
		if(d1.dia < d2.dia) {
			return -1;
		}
		
		return 0;
	}
	

	/**
	 * Converte a data em uma String no formato DD/MM/AAAA
	 * 
	 */
	public String toString() {
		
		String dataAsString = new String();
		
		if(dia < 10) {
			dataAsString += "0";
		}
		dataAsString += dia.toString();
		dataAsString += "/";
		
		if(mes < 10) {
			dataAsString += "0";
		}
		dataAsString += mes.toString();

		dataAsString += "/";
		
		if(ano < 10) {
			dataAsString += "000";
		}
		else {
			if(ano < 100) {
				dataAsString += "00";
			}
			else {
				if(ano < 1000) {
					dataAsString += "0";
				}
			}
		}
		dataAsString += ano.toString();
		
			
		return dataAsString;
	}
	
	/**
	 * Função main para teste do código
	 * Sem função real na aplicação 
	 * @param args
	 * @throws DataException
	 */
	public static void main(String args[]) throws DataException {
		
		Data date;
		
		date = new Data("03/01/0099");
		String data = new String("ola");
		data = date.toString();
		
		System.out.printf("A data é %s\n", data);
	}
}

	
