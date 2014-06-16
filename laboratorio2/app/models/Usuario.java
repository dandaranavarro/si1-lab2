package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;



@Entity (name = "Usuario")
public class Usuario {
	
		// Gerador de Sequencia para o Id
		@Id
		@GeneratedValue(strategy = GenerationType.TABLE)
		private Long id;

		// Nome do usuario
		@Column
		private String nome;
		
		// Relação Um para Muitos
		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable
		private List<Meta> metas;

		// Construtor Vazio para o Hibernate criar os objetos
		public Usuario() {
			this.metas = new ArrayList<Meta>();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public List<Meta> getMetas() {
			return metas;
		}

		public void setMetas(List<Meta> metas) {
			this.metas = metas;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}

		

	
		
}
