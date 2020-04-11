package br.com.base.projeto.model.entity;

import java.util.ArrayList;
import java.util.Collection;
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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Entity
@Table(name = "USUARIO")
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public @Data class Usuario implements UserDetails {

	private static final long serialVersionUID = -1468345392830435984L;

	@Id
    @SequenceGenerator(name="PK_USUARIO", sequenceName="SQ_USUARIO", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="PK_USUARIO")
    @Column(name = "ID", updatable = false)
	private Long id;
	
	@NotNull
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@NotNull
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@NotNull
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Singular("perfil")
	private List<Perfil> perfis;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Permissao> permissoes = new ArrayList<>();
		this.perfis.forEach(perfil -> permissoes.addAll(perfil.getPermissoes()));
		return permissoes;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
