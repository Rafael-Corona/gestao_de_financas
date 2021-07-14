/**
 * Representa os dados de um usuário do programa.
 * Esses dados são:
 * 	-saldo: o dinheiro que o usuário possui atualmente 
 * 	-lista: uma lista com todos os registros financeiros que o usuario fez
 * 	-gastosTotais: a soma de todos os gastos do usuário
 * 	-tetoGastos: meta estipulada pelo usuário para limitar seus gastos
 */
public class Usuario {

	private ListaRegistros lista;
	private float saldo;
	private float tetoGastos;
	private float gastosTotais;
}
