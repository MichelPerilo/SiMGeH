/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroTutorExistenteException;
import br.simgeh.exeception.ProcurarTutorInexistenteException;
import br.simgeh.model.Animal;
import br.simgeh.model.Tutor;
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
public class RepositorioTutor {
    
     //atributos
	private Tutor[] tutor;
	private int proxima;

	private static RepositorioTutor instance;

	// contrutor
	private RepositorioTutor(int tamanho) {

		this.tutor = new Tutor[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioTutor getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioTutor) instance;
	}

	private static RepositorioTutor abrirArquivo() throws IOException {

		RepositorioTutor instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE TUTORES\\cadastrotutor.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioTutor) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioTutor(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE TUTORES");
		dir.mkdirs();
		File out = new File(dir,"cadastrotutor.bin");
        
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

	public void cadastra(Tutor t) throws IOException,
			CadastroTutorExistenteException{

	    	if (t != null)
				if (this.existe(t)) {
				throw new CadastroTutorExistenteException(
							);                                    
                                }else{
					this.tutor[proxima] = t;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.tutor.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Tutor procurar(Animal a) throws ProcurarTutorInexistenteException {

		int i = this.procurarIndice(a.getTutor());
		Tutor resultado = null;
		if (i != this.proxima)
			resultado = this.tutor[i];
		else throw new ProcurarTutorInexistenteException(); 
		
		
		

		return  resultado;

	}
	


	public boolean existe(Tutor t) {

		boolean existe = false;
		int indice = this.procurarIndice(t);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(Animal a) throws IOException, ProcurarTutorInexistenteException {

		int i = this.procurarIndice(a.getTutor());
		if (i != this.proxima) {
			this.tutor[i] = this.tutor[this.proxima - 1];
			this.tutor[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcurarTutorInexistenteException(); 
		
		salvarArquivo();

	}

	private int procurarIndice(Tutor t){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (t.equals(this.tutor[i])) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}

	private void duplicaArrayCliente() {

		if (this.tutor != null && this.tutor.length > 0) {
			Tutor[] arrayDuplicado = new Tutor[this.tutor.length * 2];
                    System.arraycopy(this.tutor, 0, arrayDuplicado, 0, this.tutor.length);

			this.tutor = arrayDuplicado;
		}
	}

	public void  imprimiTutor() throws IOException{
            
            for (int aux = 0;aux < tutor.length;aux++ ) {
                if(tutor[aux]!= null){
                System.out.println(tutor[aux].toString());
                }
            }
            

	}
    
}
