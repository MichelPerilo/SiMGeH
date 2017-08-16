package br.simgeh.data;

import java.io.IOException;

import br.simgeh.control.ControladorAnimal_A;

public class Teste {

	public static void main(String[] args) {
		try {
			ControladorAnimal_A controlAnimal_A = new ControladorAnimal_A();
			controlAnimal_A.imprimiAnimal();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
