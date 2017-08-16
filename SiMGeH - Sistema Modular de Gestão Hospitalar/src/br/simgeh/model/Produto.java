
package br.simgeh.model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;


/**
 *
 * @author Raylison
 */


public class Produto implements Serializable{
    
    
    
    private String nome;
    private String tipo;
    private String descricao;
    private int id;
    private int qtd;
    private Calendar calendar;
    private SimpleDateFormat formatter;
    private Date minhaDataEncapsulada;
    private String dataFormatada;

    public Produto(String nome, String tipo, String descricao,int id,int qtd) {
        setNome(nome);
        setTipo(tipo);
        setDescricao(descricao);
        setId(id);
        setQtd(qtd);
        this.calendar = Calendar.getInstance();
	this.formatter = new SimpleDateFormat("dd/MMM/YYYY    HH: mm: ss");
	this.minhaDataEncapsulada = calendar.getTime();
	this.dataFormatada = formatter.format(minhaDataEncapsulada);

    }

    
    public void debitarQTD(){
        --qtd;
    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public int getId() {
        return id;
    }

    public int getQtd() {
        return qtd;
    }
    
    public String getDataFormatada() {
		return dataFormatada;
	}

    private void setNome(String nome) {
        if(nome != null && nome.length() > 0){
        this.nome = nome;
        }
    }

    private void setTipo(String tipo) {
        if(tipo != null && tipo.length() > 0){
        this.tipo = tipo;
        }
    }

    private void setDescricao(String descricao) {
        if(descricao != null && descricao.length() > 0){
        this.descricao = descricao;
        }
    }
    
     private void setId(int id) {
        this.id = id;
    }

    private void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    
    
    
     @Override
	public String toString() {
		return "\n\n" + dataFormatada  + "         ID"+ id + "            QTD: " + qtd 
                        + "\nNOME: " + nome + " Tipo: " + tipo + "\nDescrição: " + descricao;
	}
}
