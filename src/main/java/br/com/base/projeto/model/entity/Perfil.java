package br.com.base.projeto.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Entity
@Table(name = "PERFIL")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public @Data class Perfil {
	
	@Id
    @SequenceGenerator(name="PK_PERFIL", sequenceName="SQ_PERFIL", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="PK_PERFIL")
    @Column(name = "ID", updatable = false)
	private Long id;
	
	@NotNull
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Singular("permissao")
	private List<Permissao> permissoes;

}
