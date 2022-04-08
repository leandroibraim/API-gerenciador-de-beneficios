package br.com.gerenciador.beneficios.test.service;

import br.com.digix.gerenciador.dto.DependenteBeneficioDto;
import br.com.digix.gerenciador.dto.FamiliaBeneficioDto;
import br.com.digix.gerenciador.model.DependenteBeneficioModelo;
import br.com.digix.gerenciador.utils.MensagensUtil;
import br.com.digix.gerenciador.utils.PontuacaoUtil;
import br.com.gerenciador.beneficios.test.mock.FamiliaBeneficioMock;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FamiliaBeneficiadaServiceTest {

	FamiliaBeneficioDto familia = FamiliaBeneficioMock.mockFamiliaBeneficiario();

	@Test
	void pontuaDependendeSeForMenorDeIdade() {
		DependenteBeneficioDto dependenteModel = familia.getDependentes().get(0);
		assertTrue(dependenteModel.getIdade() <= MensagensUtil.MAIOR_IDADE);
	}

	@Test
	void naoPontuaCasoDependendeForMaiorDeIdade() {
		DependenteBeneficioDto dependenteModel = familia.getDependentes().get(1);
		assertFalse(dependenteModel.getIdade() <= MensagensUtil.MAIOR_IDADE);
	}
	
	@Test
	void verificaSeTemDependente() {
		assertTrue(familia.getDependentes().size() > 0);
	}

	@Test
	void podeReceberBeneficio() {
		assertTrue(familia.getPontos() > 0);
	}

	@Test
	void ganhaGanhaCincoPontos() {
		assertTrue(familia.getRendaFamilia() <= PontuacaoUtil.CINCO_PONTOS);
	}

	@Test
	void ganhaTresPontos() {
		assertFalse(familia.getRendaFamilia() > PontuacaoUtil.CINCO_PONTOS
				&& familia.getRendaFamilia() <= PontuacaoUtil.TRES_PONTOS);
	}

}
