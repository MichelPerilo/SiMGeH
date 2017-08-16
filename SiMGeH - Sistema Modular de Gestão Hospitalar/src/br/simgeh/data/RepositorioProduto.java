package br.simgeh.data;

import br.simgeh.exeception.CadatroProdutoExistenteExeception;
import br.simgeh.exeception.ProcuraProdutoInexistenteExeception;
import br.simgeh.model.Produto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raylison
 */

public class RepositorioProduto implements IRepositorioProduto, Serializable{
    
    // atributos
	private Produto[] produto;
	private int proxima;

	private static RepositorioProduto instance;

	// contrutor
	private RepositorioProduto(int tamanho) {

		this.produto = new Produto[tamanho];
		this.proxima = 0;

	}

	// metodos

	public static IRepositorioProduto getInstance() throws IOException {
		if (instance == null) {
		    instance = abrirArquivo();
		}
		return (IRepositorioProduto) instance;
	}

	private static RepositorioProduto abrirArquivo() throws IOException {

		RepositorioProduto instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE PRODUTOS\\cadastroproduto.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioProduto) o;
		} catch (IOException | ClassNotFoundException e) {
			
			instanciaLocal = new RepositorioProduto(100);
			
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
                dir = new File("ARQUIVOS\\CADASTRO DE PRODUTOS");
		dir.mkdirs();
		File out = new File(dir,"cadastroproduto.bin");
        
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

	public void cadastra(Produto p) throws IOException,
			CadatroProdutoExistenteExeception{

	    	if (p != null)
				if (this.existe(p.getNome())) {
				throw new CadatroProdutoExistenteExeception(
							p.getNome());                                    
                                }else{
					this.produto[proxima] = p;
					this.proxima = this.proxima + 1;
				}
			if (this.proxima == this.produto.length) {

				this.duplicaArrayCliente();
			}
			salvarArquivo();
		
	}

	public Produto procurar(String nome)	throws ProcuraProdutoInexistenteExeception {

		int i = this.procurarIndice(nome);
		Produto resultado = null;
		if (i != this.proxima)
			resultado = this.produto[i];
		else throw new ProcuraProdutoInexistenteExeception(); 
		
		
		

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

	public void remover(String nome) throws IOException, ProcuraProdutoInexistenteExeception {

		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.produto[i] = this.produto[this.proxima - 1];
			this.produto[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraProdutoInexistenteExeception(); 
		
		salvarArquivo();

	}

	private int procurarIndice(String nome){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(this.produto[i].getNome())) {

				achou = true;

			} else {

				i = i + 1;
			}

		}
	
		return i;
	}

	private void duplicaArrayCliente() {

		if (this.produto != null && this.produto.length > 0) {
			Produto[] arrayDuplicado = new Produto[this.produto.length * 2];
                    System.arraycopy(this.produto, 0, arrayDuplicado, 0, this.produto.length);

			this.produto = arrayDuplicado;
		}
	}

       
	public List<Produto>  imprimiProduto() throws IOException{
            
            List<Produto> p = new ArrayList();
            for (int aux = 0 ; aux < produto.length; aux ++) {
                if (produto[aux] != null) {
                    p.add(produto[aux]);
                }
            }
            return p;     

	}
	
	
}
