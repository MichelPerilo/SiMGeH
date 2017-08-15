/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;


import br.simgeh.exeception.CadastroServicoExistenteException;
import br.simgeh.exeception.ProcuraServicoInexistenteException;
import br.simgeh.model.Servico;
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
public class RepositorioServico implements IRepositorioServico, Serializable{
     private Servico[] servico;
        private int proxima;
        private static RepositorioServico instance;

	// contrutor
	private RepositorioServico(int tamanho) {

		this.servico = new Servico[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioServico getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioServico) instance;
	}

	private static RepositorioServico abrirArquivo() throws IOException {

		RepositorioServico instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE SERVICO\\cadastroservico.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioServico) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioServico(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE Servico");
		dir.mkdirs();
		File out = new File(dir,"cadastroservico.bin");
        
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

	public void cadastra(Servico s) throws IOException, CadastroServicoExistenteException{

	    	if (s != null)
				if (this.existe(s)) {
                                    throw new CadastroServicoExistenteException();                           
                                }else{
					this.servico[proxima] = s;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.servico.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Servico procurar(Servico s) throws ProcuraServicoInexistenteException  {

		int i = this.procurarIndice(s);
		Servico resultado = null;
		if (i != this.proxima)
			resultado = this.servico[i];
                else throw new ProcuraServicoInexistenteException();
		
		
		

		return  resultado;

	}
	


	public boolean existe(Servico s) {

		boolean existe = false;
		int indice = this.procurarIndice(s);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(Servico s) throws IOException, ProcuraServicoInexistenteException {

		int i = this.procurarIndice(s);
		if (i != this.proxima) {
			this.servico[i] = this.servico[this.proxima - 1];
			this.servico[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else  throw new ProcuraServicoInexistenteException();
		
		salvarArquivo();

	}

	private int procurarIndice(Servico s){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if ( s.equals(this.servico[i])) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}
        
        /*
        public ArrayList<Servico> servicosPorProntuario(int prontuario_id){
            ArrayList<Servico> servicos = new ArrayList<Servico>();
            for (int i =0; i < servico.length; i++){
                if (servico[i] != null && prontuario_id == servico[i].getProtuario_id()){
                    servicos.add(servico[i]);
                }
            }
            return servicos;
        }
        */
        
        
        

	private void duplicaArrayCliente() {

		if (this.servico != null && this.servico.length > 0) {
			Servico[] arrayDuplicado = new Servico[this.servico.length * 2];
                    System.arraycopy(this.servico, 0, arrayDuplicado, 0, this.servico.length);

			this.servico = arrayDuplicado;
		}
	}

	public void  imprimiServico() throws IOException{
            
            for (int aux = 0;aux < servico.length;aux++ ) {
                if(servico[aux]!= null){
                System.out.println(servico[aux].toString());
                }
            }
            

	}
}
