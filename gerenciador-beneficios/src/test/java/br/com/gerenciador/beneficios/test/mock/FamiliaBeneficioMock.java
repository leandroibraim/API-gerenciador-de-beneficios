package br.com.gerenciador.beneficios.test.mock;

import java.util.ArrayList;
import java.util.List;

import br.com.digix.gerenciador.dto.FamiliaBeneficioDto;
import br.com.digix.gerenciador.model.DependenteBeneficioModelo;

public class FamiliaBeneficioMock {
	public static FamiliaBeneficioMock mockFamiliaBeneficiario() {
		return FamiliaBeneficioDto.builder().nome("Fulado").pontos(5).rendaFamiliarTotal(899).id(1L).dependentes(mockDependente()).build();
	}
	private static List<DependenteBeneficioModelo> mockDependente() {
		List<DependenteBeneficioModelo> dependenteModels = new ArrayList<>();
		DependenteBeneficioModelo dependente1 = DependenteBeneficioModelo.builder().id(1L).idade(5).nome("Fulaninho Juninho").build();
		DependenteBeneficioModelo dependente2 = DependenteBeneficioModelo.builder().id(2L).idade(19).nome("Fulaninha Julinha").build();
		dependenteModels.add(dependente1);
		dependenteModels.add(dependente2);
		return dependenteModels;
	}
}
