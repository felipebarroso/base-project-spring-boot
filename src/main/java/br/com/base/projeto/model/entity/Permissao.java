package br.com.base.projeto.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PERMISSAO")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public @Data class Permissao implements GrantedAuthority {
	
	private static final long serialVersionUID = -9167787021028145504L;

	@Id
    @SequenceGenerator(name="PK_PERMISSAO", sequenceName="SQ_PERMISSAO", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="PK_PERMISSAO")
    @Column(name = "ID", updatable = false)
	private Long id;
	
	@NotNull
	@Column(name = "NOME", nullable = false)
	private String nome;

	@Override
	public String getAuthority() {
		return this.nome;
	}
	
}
