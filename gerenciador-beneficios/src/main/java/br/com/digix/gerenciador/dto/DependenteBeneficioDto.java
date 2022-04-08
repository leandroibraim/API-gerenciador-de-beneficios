package br.com.digix.gerenciador.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DependenteBeneficioDto {

	private Integer id;
	private Integer idade;
	private String nome;

}
