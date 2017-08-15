/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.exeception.CadastroRequisicaoExistenteException;
import br.simgeh.exeception.ProcuraRequisicaoInexistenteException;
import br.simgeh.model.Requisicao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Elal
 */
public class RepositorioRequisicoes implements IRepositorioRequisicoes, Serializable{

        // atributos
	private Requisicao[] requisicao;
	private int proxima;

	private static RepositorioRequisicoes instance;

	// contrutor
	private RepositorioRequisicoes(int tamanho) 
        {

		this.requisicao = new Requisicao[tamanho];
		this.proxima = 0;

	}
    
        public static IRepositorioRequisicoes getInstance() throws IOException 
        {
		if (instance == null) 
                {
                    instance = carregarArquivo();
		}
		return (IRepositorioRequisicoes) instance;
	}

	private static RepositorioRequisicoes carregarArquivo() throws IOException 
        {

		RepositorioRequisicoes instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO DE REQUISICOES\\cadastrorequisicao.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try 
                {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
                        
			instanciaLocal = (RepositorioRequisicoes) o;
		} 
                catch (IOException | ClassNotFoundException e) 
                {
			
			instanciaLocal = new RepositorioRequisicoes(100);
			
		} 
                finally 
                {

			if (ois != null) 
                        {
				try 
                                {
					ois.close();
				}
                                catch (IOException e) 
                                {
                                    /* Silent exception */
				}
			}
		}

		return instanciaLocal;

	}
        
        public static void salvarArquivo() throws IOException 
        {

		if (instance == null) 
                {
			return;
		}

		File dir;
                dir = new File("ARQUIVOS\\CADASTRO DE REQUISICOES");
		dir.mkdirs();
		File out = new File(dir,"cadastrorequisicao.bin");
        
		if (!out.exists())
                {			
			out.createNewFile();
                }
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try 
                {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);

		} 
                catch (IOException e) 
                {
		} 
                finally 
                {
			if (oos != null) 
                        {
				try 
                                {
					oos.close();
				} 
                                catch (IOException e) 
                                {
                                    /* Silent */
				}
			}
		}
	}
        
    @Override
    public void cadastra(Requisicao r) throws IOException, CadastroRequisicaoExistenteException 
    {
        if (r != null) 
        {
            if (this.existe(r.getID())) 
            {
                throw new CadastroRequisicaoExistenteException(r.toString());
            } 
            else 
            {
                this.requisicao[proxima] = r;
                this.proxima = this.proxima + 1;
            }
        }
        if (this.proxima == this.requisicao.length) 
        {

            this.duplicaArrayCliente();
        }
        salvarArquivo();

    }

    
    public Requisicao procurar(int id)	throws ProcuraRequisicaoInexistenteException 
    {

        int i = this.procurarIndice(id);
        Requisicao resultado = null;
        if (i != this.proxima) 
        {
            resultado = this.requisicao[i];
        } 
        else 
        {
            throw new ProcuraRequisicaoInexistenteException();
        }
        
        return resultado;

    }

    public boolean existe(int id) 
    {

		boolean existe = false;
		int indice = this.procurarIndice(id);
		if (indice != proxima) 
                {

			existe = true;

		}

		return existe;
	}
    public void remover(int id) throws IOException, ProcuraRequisicaoInexistenteException 
    {

		int i = this.procurarIndice(id);
		if (i != this.proxima) 
                {
			this.requisicao[i] = this.requisicao[this.proxima - 1];
			this.requisicao[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}
                else 
                    throw new ProcuraRequisicaoInexistenteException(); 
		
		salvarArquivo();

	}

    private int procurarIndice(int id)
    {

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) 
                {
			if (id == (this.requisicao[i].getID())) 
                        {

				achou = true;

			} 
                        else 
                        {

				i = i + 1;
			}

		}
	
		return i;
	}
    
    private void duplicaArrayCliente() 
    {

		if (this.requisicao != null && this.requisicao.length > 0) 
                {
			Requisicao[] arrayDuplicado = new Requisicao[this.requisicao.length * 2];
                        System.arraycopy(this.requisicao, 0, arrayDuplicado, 0, this.requisicao.length);

			this.requisicao = arrayDuplicado;
		}
	}
    
    public void exibeListaReq() throws IOException 
    {
            
            for (int aux = 0;aux < requisicao.length;aux++ ) 
            {
                if(requisicao[aux]!= null)
                {
                    System.out.println(requisicao[aux].toString());
                    System.out.println("");
                }
            }
    }
    
    public void exibeReq(int id) throws IOException , ProcuraRequisicaoInexistenteException
    {
            int indice = this.procurarIndice(id);
            if (indice != proxima)
            {
                System.out.println(requisicao[indice].toString());
                System.out.println("");
            }
            
    }
    
    public void atualizar(int id, int status) throws IOException, ProcuraRequisicaoInexistenteException
    {
        if(status >= 0 && status <= 3)
        {
            int indice = this.procurarIndice(id);
            if (indice != proxima)
            {
                requisicao[indice].setStatus(status);
            }
        }
    }
    
}