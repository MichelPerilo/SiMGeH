/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroAnimalExistenteException;
import br.simgeh.exeception.ProcuraAnimalInexistenteException;
import br.simgeh.model.Animal;
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
public class RepositorioAnimal_A implements IRepositorioAnimal_A, Serializable{
    
        private Animal[] animal;
        private int proxima;
        private static RepositorioAnimal_A instance;

	// contrutor
	private RepositorioAnimal_A(int tamanho) {

		this.animal = new Animal[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioAnimal_A getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioAnimal_A) instance;
	}

	private static RepositorioAnimal_A abrirArquivo() throws IOException {

		RepositorioAnimal_A instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE ANIMAIS\\cadastroanimal.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioAnimal_A) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioAnimal_A(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE ANIMAIS");
		dir.mkdirs();
		File out = new File(dir,"cadastroanimal.bin");
        
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

	public void cadastra(Animal a) throws IOException,
			CadastroAnimalExistenteException{

	    	if (a != null)
				if (this.existe(a.getTutor().getCpf(), a.getNome())) {
				throw new CadastroAnimalExistenteException(
							);                                    
                                }else{
					this.animal[proxima] = a;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.animal.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Animal procurar(String cpf, String nome)	throws ProcuraAnimalInexistenteException {

		int i = this.procurarIndice(cpf, nome);
		Animal resultado = null;
		if (i != this.proxima)
			resultado = this.animal[i];
		else throw new ProcuraAnimalInexistenteException(); 
		
		
		

		return  resultado;

	}
	


	public boolean existe(String cpf, String nome) {

		boolean existe = false;
		int indice = this.procurarIndice(cpf, nome);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(String cpf, String nome) throws IOException, ProcuraAnimalInexistenteException {

		int i = this.procurarIndice(cpf, nome);
		if (i != this.proxima) {
			this.animal[i] = this.animal[this.proxima - 1];
			this.animal[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraAnimalInexistenteException(); 
		
		salvarArquivo();

	}

	private int procurarIndice(String cpf, String nome){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if ( cpf.equals(this.animal[i].getTutor().getCpf()) && nome.equals(this.animal[i].getNome())) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}

	private void duplicaArrayCliente() {

		if (this.animal != null && this.animal.length > 0) {
			Animal[] arrayDuplicado = new Animal[this.animal.length * 2];
                    System.arraycopy(this.animal, 0, arrayDuplicado, 0, this.animal.length);

			this.animal = arrayDuplicado;
		}
	}

	public void  imprimiAnimal() throws IOException{
            
            for (int aux = 0;aux < animal.length;aux++ ) {
                if(animal[aux]!= null){
                System.out.println(animal[aux].toString());
                }
            }
            

	}
	
	
}
