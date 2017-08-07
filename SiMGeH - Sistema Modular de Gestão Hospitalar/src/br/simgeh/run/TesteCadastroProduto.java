package br.simgeh.run;


import br.simgeh.control.ControladorProduto;
import br.simgeh.control.IGerenciadorProduto;
import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Raylison
 */
public class TesteCadastroProduto {

    
    public static void main(String[] agrs) throws IOException,
			ProcuraProdutoInexistenteExeception,
			CadatroProdutoExistenteExeception{

		int escolha;
		int cont = 0;
		String nome;
		      IGerenciadorProduto fachada = ControladorProduto.getInstance();

		Scanner ler = new Scanner(System.in);

		while (cont == 0) {
                        
			System.out.println("********  Menu  *********");
			System.out
					.printf("1 Cadastra Produto\n2 Exibi Produto\n3 Excluir Produto\n4 Procurar Produto\n5 SAIR");
			System.out.println("\n");

			escolha = ler.nextInt();
			System.out.println();

			switch (escolha) {
			case 1:

				

				try {
					           
                    
                    
					fachada.cadatrarProduto("Dipirona","analgesico","tira dor",01,10);
					fachada.cadatrarProduto( "Rivotril","Calmante","Deixa calmo",02,20);
					fachada.cadatrarProduto( "Amaxilina","Antibiotico","Tira bacteria",03,5);
					
					
					System.out.println("CADASTRO COM SUCESSO");

				} catch (CadatroProdutoExistenteExeception cpe) {

					System.out.println(cpe.getMessage());
				}  

				break;

			case 2:

				fachada.exibiProduto();
				break;

			case 3:

				try {
					System.out.println("DIGITE UM NOME A SER EXCLUIDO:\n");
					nome = ler.next();
					fachada.excluirProduto(nome);
				} catch (ProcuraProdutoInexistenteExeception ppi) {
					System.out.println(ppi.getMessage());
				}
				break;

			case 4:

				try {
					System.out.println("Pesquisa rapida digite nome: ");
					nome = ler.next();
					System.out.println(fachada.pesquisarProduto(nome));
				} catch (ProcuraProdutoInexistenteExeception ppi) {
					System.out.println(ppi.getMessage());
				}
				break;

			case 5:
				++cont;
				break;
			}

		}

		ler.close();

	}
    
}
