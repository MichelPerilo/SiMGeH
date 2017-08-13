/**
 * simgeh RepositorioAnimalArraylist
 * @author Bartô Alheiros
 */
package br.simgeh.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import br.simgeh.model.Animal;

public class RepositorioAnimalArrayList implements IRepositorioAnimal {

	private List<Animal> listaAnimal = null;
	private static RepositorioAnimalArrayList instance;

	private RepositorioAnimalArrayList() {
		this.listaAnimal = new ArrayList(); 
	}

	public static RepositorioAnimalArrayList getInstance() {
		if(instance == null) {
			instance = lerDoArquivo();
		}

		return instance;
	}

	private static RepositorioAnimalArrayList lerDoArquivo() {
		RepositorioAnimalArrayList instanciaLocal = null;

		File in = new File("ARQUIVOS\\CADASTRO DE ANIMAL\\animal.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioAnimalArrayList) o;
		} catch (Exception e) {
			instanciaLocal = new RepositorioAnimalArrayList();
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
	
	public void salvarArquivo() {
		if (instance == null) {
			return;
		}
		File out = new File("ARQUIVOS\\CADASTRO DE ANIMAL\\animal.bin");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try { oos.close(); } catch (IOException e) {/*Silent*/}
			}
		}
	}
	
	public boolean existe(Animal a) {
		for(Animal a1: getInstance().listaAnimal) {
			if(a1.equals(a)) {
				return true;
			}
		}

		return false;
	}
	
	@Override
	public boolean cadastrar(Animal a) {
		List<Animal> listaAnimal = getInstance().listaAnimal;
		
		if(!listaAnimal.contains(a)) {
			getInstance().listaAnimal.add(a);
			this.salvarArquivo();
			return true;
		}

		return false;

	}

	@Override
	public void atualizar(Animal a) {
		// TODO Auto-generated method stub

	}

	@Override
	public Animal buscaPorID(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Animal buscarPorCPFTutor(String CPF) {
		Animal a = null;

		for(Animal anim: getInstance().listaAnimal) {
			if(anim.getTutor().getCpf().equals(CPF)) {
				a = anim;
				break;
			}
		}

		return a;
	}

	@Override
	public void remover(String ID) {
		// TODO Auto-generated method stub

	}

}
