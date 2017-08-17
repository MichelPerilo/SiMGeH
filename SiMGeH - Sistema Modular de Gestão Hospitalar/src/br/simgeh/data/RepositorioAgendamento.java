/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroAgendamentoExistenteException;
import br.simgeh.exeception.ProcuraAgendamentoInexistenteException;
import br.simgeh.model.Agendamento;
import br.simgeh.model.Animal;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Michel Perilo
 */
public class RepositorioAgendamento implements IRepositorioAgendamento, Serializable {
     private Agendamento[] agendamento;
        private int proxima;
        private static RepositorioAgendamento instance;

	// contrutor
	private RepositorioAgendamento(int tamanho) {

		this.agendamento = new Agendamento[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioAgendamento getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioAgendamento) instance;
	}

	private static RepositorioAgendamento abrirArquivo() throws IOException {

		RepositorioAgendamento instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE AGENDAMENTOS\\cadastroagendamento.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioAgendamento) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioAgendamento(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE AGENDEDAMENTOS");
		dir.mkdirs();
		File out = new File(dir,"cadastroagendamento.bin");
        
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

	public void cadastra(Agendamento a) throws IOException,
			CadastroAgendamentoExistenteException{

	    	if (a != null)
				if (this.existe(a)) {
				throw new CadastroAgendamentoExistenteException(
							);                                    
                                }else{
					this.agendamento[proxima] = a;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.agendamento.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Agendamento procurar(Agendamento a) throws ProcuraAgendamentoInexistenteException {

		int i = this.procurarIndice(a);
		Agendamento resultado = null;
		if (i != this.proxima)
			resultado = this.agendamento[i];
		else throw new ProcuraAgendamentoInexistenteException(); 
		
		
		

		return  resultado;

	}
	


	public boolean existe(Agendamento a) {

		boolean existe = false;
		int indice = this.procurarIndice(a);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(Agendamento a) throws IOException, ProcuraAgendamentoInexistenteException {

		int i = this.procurarIndice(a);
		if (i != this.proxima) {
			this.agendamento[i] = this.agendamento[this.proxima - 1];
			this.agendamento[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraAgendamentoInexistenteException(); 
		
		salvarArquivo();

	}

	private int procurarIndice(Agendamento a){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if ( a.equals(this.agendamento[i])) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}
        
        public ArrayList<Agendamento> agendamentosPorProntuario(Animal animal){
            ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
            for (int i =0; i < agendamento.length; i++){
                if (agendamento[i] != null && animal.equals(agendamento[i].getAnimal())){
                    agendamentos.add(agendamento[i]);
                }
            }
            
            return agendamentos;
        }
        
        public ArrayList<Agendamento> allAgendamentos(){
             ArrayList<Agendamento> agendamentos = new ArrayList<Agendamento>();
            for (int i =0; i < agendamento.length; i++){
                if (agendamento[i] != null){
                    agendamentos.add(agendamento[i]);
                }
            }
            
            return agendamentos;
        }
        
        
        
        

	private void duplicaArrayCliente() {

		if (this.agendamento != null && this.agendamento.length > 0) {
			Agendamento[] arrayDuplicado = new Agendamento[this.agendamento.length * 2];
                    System.arraycopy(this.agendamento, 0, arrayDuplicado, 0, this.agendamento.length);

			this.agendamento = arrayDuplicado;
		}
	}

	public void  imprimiAgendamento() throws IOException{
            
            for (int aux = 0;aux < agendamento.length;aux++ ) {
                if(agendamento[aux]!= null){
                System.out.println(agendamento[aux].toString());
                }
            }
            

	}
}
