package br.simgeh.run;


import br.simgeh.control.ControladorFarmaco;
import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;

import java.io.IOException;
import java.util.Scanner;
import br.simgeh.control.IGerenciadorFarmaco;

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
		IGerenciadorFarmaco fachada = ControladorFarmaco.getInstance();

		Scanner ler = new Scanner(System.in);

		while (cont == 0) {
                        
			System.out.println("********  Menu  *********");
			System.out
					.printf("1 Cadastra Produto\n2 Exibi Produto\n3 Excluir Produto\n4 Procurar Produto\n5 Cadastra Requisição\n6 SAIR");
			System.out.println("\n");

			escolha = ler.nextInt();
			System.out.println();

			switch (escolha) {
                        
                            
			case 1:

				

				try {
					           
                    
                                        
					fachada.cadatrarProduto("Dipirona","analgesico","tira dor",10);
					fachada.cadatrarProduto( "Rivotril","Calmante","Deixa calmo",20);
					fachada.cadatrarProduto( "Amaxilina","Antibiotico","Tira bacteria",5);
					
					
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
                            
                                fachada.cadatrarRequisicao("Clinica", "Aberto", "paciente em caso de vida",5);
                                fachada.cadatrarRequisicao("teste", "teste", "teste", 3);
                                fachada.cadatrarRequisicao("teste2", "teste2", "teste3", 63);
                                
                                
                                
                                System.out.println("CADASTRO COM SUCESSO");
                        
                        
                        case 6:
				++cont;
				break;
			}

		}

		ler.close();

	}
    
}
