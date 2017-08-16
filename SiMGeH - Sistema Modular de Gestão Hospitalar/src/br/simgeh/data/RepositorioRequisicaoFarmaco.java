/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.ProcuraRFInexistenteExeception;
import br.simgeh.model.RequisicaoProduto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raylison
 */
public class RepositorioRequisicaoFarmaco implements IRepositorioRequisicaoFarmaco{

    // atributos
	private RequisicaoProduto[] requisicao;
	private int proxima;

	private static RepositorioRequisicaoFarmaco instance;

	// contrutor
	private RepositorioRequisicaoFarmaco(int tamanho) {

		this.requisicao = new RequisicaoProduto[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioRequisicaoFarmaco getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioRequisicaoFarmaco) instance;
	}

	private static RepositorioRequisicaoFarmaco abrirArquivo() throws IOException {

		RepositorioRequisicaoFarmaco instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE REQUISICOES FARMACO\\cadastroRequisicaoFarmaco.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioRequisicaoFarmaco) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioRequisicaoFarmaco(100);
			
		} finally {

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;

	}

	public static void salvarArquivo() throws IOException {

		if (instance == null) {
			return;
		}

		File dir;
                dir = new File("ARQUIVOS\\CADASTRO DE REQUISICOES FARMACO");
		dir.mkdirs();
		File out = new File(dir,"cadastroRequisicaoFarmaco.bin");
        
		if (!out.exists()){			
			out.createNewFile();
                }
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);

		} catch (IOException e) {
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent */
				}
			}
		}
	}

	public void cadastra(RequisicaoProduto RF) throws IOException{
			
	    	if (RF != null)
				if (this.existe(RF.getID())) {
				                                    
                                }else{
					this.requisicao[proxima] = RF;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.requisicao.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public RequisicaoProduto procurar(int id) throws ProcuraRFInexistenteExeception {

		int i = this.procurarIndice(id);
		RequisicaoProduto resultado = null;
		if (i != this.proxima)
			resultado = this.requisicao[i];
		else 
                    throw new ProcuraRFInexistenteExeception(); 	
		

		return  resultado;

	}
	


	public boolean existe(int id) {

		boolean existe = false;
		int indice = this.procurarIndice(id);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	

	private int procurarIndice(int id){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (id == this.requisicao[i].getID()) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}

	private void duplicaArrayCliente() {

		if (this.requisicao != null && this.requisicao.length > 0) {
			RequisicaoProduto[] arrayDuplicado = new RequisicaoProduto[this.requisicao.length * 2];
                    System.arraycopy(this.requisicao, 0, arrayDuplicado, 0, this.requisicao.length);

			this.requisicao = arrayDuplicado;
		}
	}

       
	public List<RequisicaoProduto>  imprimiRF() throws IOException{
            
            List<RequisicaoProduto> rf = new ArrayList();
            for (int aux = 0 ; aux < requisicao.length; aux ++) {
                if (requisicao[aux] != null) {
                    rf.add(requisicao[aux]);
                }
            }
            return rf;     

	} 
    
    
    
    
}
