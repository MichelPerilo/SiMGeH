/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroEnderecoExistenteException;
import br.simgeh.exeception.ProcuraEnderecoInexistenteException;
import br.simgeh.model.Endereco;
import br.simgeh.model.Tutor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Michel Perilo
 */
public class RepositorioEndereco implements IRepositorioEndereco, Serializable{
    // atributos
	private Endereco[] endereco;
	private int proxima;

	private static RepositorioEndereco instance;

	// contrutor
	private RepositorioEndereco(int tamanho) {

		this.endereco = new Endereco[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioEndereco getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioEndereco) instance;
	}

	private static RepositorioEndereco abrirArquivo() throws IOException {

		RepositorioEndereco instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE ENDERECOS\\cadastroendereco.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioEndereco) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioEndereco(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE ENDERECOS");
		dir.mkdirs();
		File out = new File(dir,"cadastroendereco.bin");
        
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

	public void cadastra(Endereco e) throws IOException,
			CadastroEnderecoExistenteException{

	    	if (e != null)
				if (this.existe(e)) {
				throw new CadastroEnderecoExistenteException(
							);                                    
                                }else{
					this.endereco[proxima] = e;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.endereco.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Endereco procurar(Tutor t) throws ProcuraEnderecoInexistenteException {

		int i = this.procurarIndice(t.getEndereco());
		Endereco resultado = null;
		if (i != this.proxima)
			resultado = this.endereco[i];
		else throw new ProcuraEnderecoInexistenteException(); 
		
		
		

		return  resultado;

	}
	


	public boolean existe(Endereco e) {

		boolean existe = false;
		int indice = this.procurarIndice(e);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(Tutor t) throws IOException, ProcuraEnderecoInexistenteException {

		int i = this.procurarIndice(t.getEndereco());
		if (i != this.proxima) {
			this.endereco[i] = this.endereco[this.proxima - 1];
			this.endereco[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraEnderecoInexistenteException(); 
		
		salvarArquivo();

	}

	private int procurarIndice(Endereco e){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (e.equals(this.endereco[i])) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}

	private void duplicaArrayCliente() {

		if (this.endereco != null && this.endereco.length > 0) {
			Endereco[] arrayDuplicado = new Endereco[this.endereco.length * 2];
                    System.arraycopy(this.endereco, 0, arrayDuplicado, 0, this.endereco.length);

			this.endereco = arrayDuplicado;
		}
	}

	public void  imprimiEndereco() throws IOException{
            
            for (int aux = 0;aux < endereco.length;aux++ ) {
                if(endereco[aux]!= null){
                System.out.println(endereco[aux].toString());
                }
            }
            

	}
}
