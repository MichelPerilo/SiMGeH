
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
    
    private Calendar calendar;
    private SimpleDateFormat formatter;
    private Date minhaDataEncapsulada;
    private String dataFormatada;

    public Produto(String nome, String tipo, String descricao) {
        setNome(nome);
        setTipo(tipo);
        setDescricao(descricao);
        this.calendar = Calendar.getInstance();
	this.formatter = new SimpleDateFormat("dd/MMM/YYYY    HH: mm: ss");
	this.minhaDataEncapsulada = calendar.getTime();
	this.dataFormatada = formatter.format(minhaDataEncapsulada);

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
    
    public String getDataFormatada() {
		return dataFormatada;
	}
    
    
     @Override
	public String toString() {
		return "\n\n" + dataFormatada  +"\nNOME: " + nome + " Tipo: " + tipo + "\nDescrição: " + descricao;
	}
}
