package br.com.digix.gerenciador.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.digix.gerenciador.dto.DependenteBeneficioDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DependenteBeneficioModelo {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Integer idade;
	private Date dataDeNascimento;

	public DependenteBeneficioModelo(DependenteBeneficioDto dependente) {
		nome = dependente.getNome();
		idade = dependente.getIdade();
	}
}
