/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroProntuarioExistenteException;
import br.simgeh.exeception.ProcuraProntuarioInexistenteException;
import br.simgeh.model.Prontuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Michel Perilo
 */
public class RepositorioProntuario {
    
     // atributos
	private Prontuario[] prontuario;
	private int proxima;

	private static RepositorioProntuario instance;

	// contrutor
	private RepositorioProntuario(int tamanho) {

		this.prontuario = new Prontuario[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioProntuario getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioProntuario) instance;
	}

	private static RepositorioProntuario abrirArquivo() throws IOException {

		RepositorioProntuario instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE PRONTUARIOS\\cadastroprontuario.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioProntuario) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioProntuario(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE PRONTUARIOS");
		dir.mkdirs();
		File out = new File(dir,"cadastroprontuario.bin");
        
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

	public void cadastra(Prontuario p) throws IOException,
			CadastroProntuarioExistenteException{

	    	if (p != null)
				if (this.existe(p.getAnimal().getId())) {
				throw new CadastroProntuarioExistenteException(
							);                                    
                                }else{
					this.prontuario[proxima] = p;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.prontuario.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Prontuario procurar(String nome)	throws ProcuraProntuarioInexistenteException {

		int i = this.procurarIndice(nome);
		Prontuario resultado = null;
		if (i != this.proxima)
			resultado = this.prontuario[i];
		else throw new ProcuraProntuarioInexistenteException(); 
		
		
		

		return  resultado;

	}
	


	public boolean existe(String nome) {

		boolean existe = false;
		int indice = this.procurarIndice(nome);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(String nome) throws IOException, ProcuraProntuarioInexistenteException {

		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.prontuario[i] = this.prontuario[this.proxima - 1];
			this.prontuario[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraProntuarioInexistenteException(); 
		
		salvarArquivo();

	}

	private int procurarIndice(String nome){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(this.prontuario[i].getAnimal())) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}

	private void duplicaArrayCliente() {

		if (this.prontuario != null && this.prontuario.length > 0) {
			Prontuario[] arrayDuplicado = new Prontuario[this.prontuario.length * 2];
                    System.arraycopy(this.prontuario, 0, arrayDuplicado, 0, this.prontuario.length);

			this.prontuario = arrayDuplicado;
		}
	}

	public void  imprimiProduto() throws IOException{
            
            for (int aux = 0;aux < prontuario.length;aux++ ) {
                if(prontuario[aux]!= null){
                System.out.println(prontuario[aux].toString());
                }
            }
            

	}
    
}
