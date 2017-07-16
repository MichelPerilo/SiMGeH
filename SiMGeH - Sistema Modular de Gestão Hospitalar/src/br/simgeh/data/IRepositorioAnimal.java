/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.simgeh.data;

import br.simgeh.model.Animal;
import java.util.List;

/**
 *
 * @author Bartô
 */
public interface IRepositorioAnimal {
    public boolean cadastrarAnimal(Animal animal);
    
    public void buscarMedico(int crmv, int MATRICULA, String CPF);
    
   /**
    *
    * @param animal: recebe uma instância de cadastro de animal atualizada(com os novos dados)
    */ 
    public boolean atualizarCDAnimal(Animal animal);
    
    public boolean removerCDAnimal(Animal animal);
    
    public List<Animal> listarAnimal();
}
