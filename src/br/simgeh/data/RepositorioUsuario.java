/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroUsuarioExistenteException;
import br.simgeh.exeception.ProcuraUsuarioInexistenteException;
import br.simgeh.model.Usuario;
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
public class RepositorioUsuario implements IRepositorioUsuario, Serializable{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
        private Usuario[] usuario;
        private int proxima;
        private static RepositorioUsuario instance;

	// contrutor
	private RepositorioUsuario(int tamanho) {

		this.usuario = new Usuario[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioUsuario getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioUsuario) instance;
	}

	private static RepositorioUsuario abrirArquivo() throws IOException {

		RepositorioUsuario instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE USUARIOS\\cadastrousuario.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioUsuario) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioUsuario(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE USUARIOS");
		dir.mkdirs();
		File out = new File(dir,"cadastrousuario.bin");
        
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

	public void cadastra(Usuario u) throws IOException,
			CadastroUsuarioExistenteException{

	    	if (u != null)
				if (this.existe(u.getLogin())) {
				throw new CadastroUsuarioExistenteException(
							);                                    
                                }else{
					this.usuario[proxima] = u;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.usuario.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Usuario procurar(String login) throws ProcuraUsuarioInexistenteException {

		int i = this.procurarIndice(login);
		Usuario resultado = null;
		if (i != this.proxima)
			resultado = this.usuario[i];
		else throw new ProcuraUsuarioInexistenteException(); 
		
		
		

		return  resultado;

	}
	


	public boolean existe(String login) {

		boolean existe = false;
		int indice = this.procurarIndice(login);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(String login) throws IOException, ProcuraUsuarioInexistenteException {

		int i = this.procurarIndice(login);
		if (i != this.proxima) {
			this.usuario[i] = this.usuario[this.proxima - 1];
			this.usuario[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraUsuarioInexistenteException(); 
		
		salvarArquivo();

	}

	private int procurarIndice(String login){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if ( login.equals(this.usuario[i].getLogin())) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}
        
        public ArrayList<Usuario> allUsers(){
            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            for (int i =0; i < usuario.length; i++){
                if (usuario[i] != null){
                    usuarios.add(usuario[i]);
                }
            }
            
            return usuarios;
        }
        
        
        
        

	private void duplicaArrayCliente() {

		if (this.usuario != null && this.usuario.length > 0) {
			Usuario[] arrayDuplicado = new Usuario[this.usuario.length * 2];
                    System.arraycopy(this.usuario, 0, arrayDuplicado, 0, this.usuario.length);

			this.usuario = arrayDuplicado;
		}
	}

	public void  imprimiUsuario() throws IOException{
            
            for (int aux = 0;aux < usuario.length;aux++ ) {
                if(usuario[aux]!= null){
                System.out.println(usuario[aux].toString());
                }
            }
            

	}
	
	

    
}
