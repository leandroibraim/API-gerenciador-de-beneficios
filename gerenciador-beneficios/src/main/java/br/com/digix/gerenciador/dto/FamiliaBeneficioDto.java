package br.com.digix.gerenciador.dto;

import java.util.List;

public class FamiliaBeneficioDto {
	private Integer id;
	private String nome;
	private Integer pontos;
	private Integer rendaFamilia;
	private List<DependenteBeneficioDto> dependentes;

	public FamiliaBeneficioDto() { }

	public FamiliaBeneficioDto(Integer id, String nome, Integer pontos, Integer rendaFamilia, List<DependenteBeneficioDto> dependentes) {
		this.id = id;
		this.nome = nome;
		this.pontos = pontos;
		this.rendaFamilia = rendaFamilia;
		this.dependentes = dependentes;
	}

	public static class FamiliaBeneficioBiulder {
		private Integer id;
		private String nome;
		private Integer pontos;
		private Integer rendaFamilia;
		private List<DependenteBeneficioDto> dependentes;

		public FamiliaBeneficioBiulder nome(String nome) {
			this.nome = nome;
			return this;
		}

		public FamiliaBeneficioBiulder pontos(Integer pontos) {
			this.pontos = pontos;
			return this;
		}

		public FamiliaBeneficioBiulder rendaFamilia(Integer rendaFamilia) {
			this.rendaFamilia = rendaFamilia;
			return this;
		}

		public FamiliaBeneficioBiulder dependentes(List<DependenteBeneficioDto> dependentes) {
			this.dependentes = dependentes;
			return this;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public Integer getPontos() {
			return pontos;
		}

		public void setPontos(Integer pontos) {
			this.pontos = pontos;
		}

		public Integer getRendaFamilia() {
			return rendaFamilia;
		}

		public void setRendaFamilia(Integer rendaFamilia) {
			this.rendaFamilia = rendaFamilia;
		}

		public List<DependenteBeneficioDto> getDependentes() {
			return dependentes;
		}

		public void setDependentes(List<DependenteBeneficioDto> dependentes) {
			this.dependentes = dependentes;
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getRendaFamilia() {
		return rendaFamilia;
	}

	public void setRendaFamilia(Integer rendaFamilia) {
		this.rendaFamilia = rendaFamilia;
	}

	public List<DependenteBeneficioDto> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<DependenteBeneficioDto> dependentes) {
		this.dependentes = dependentes;
	}

}
