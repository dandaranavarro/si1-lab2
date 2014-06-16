package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity (name = "Meta")
public class Meta {
	
	String descricao;
	int semana;
	int prioridade;
	
	//construtor default para o hibernate
	public Meta(){}
	
	public Meta(String descricao, int semana, int prioridade){
		this.descricao = descricao;
		this.semana = semana;
		this.prioridade = prioridade;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

}
