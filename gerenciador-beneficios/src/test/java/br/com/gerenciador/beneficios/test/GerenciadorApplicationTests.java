package br.com.gerenciador.beneficios.test;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.gerenciador.beneficios.test.service.FamiliaBeneficiadaServiceTest;

@SpringBootTest
@RunWith(Suite.class)
@Suite.SuiteClasses({ FamiliaBeneficiadaServiceTest.class })
class GerenciadorApplicationTests {
	@Test
	void contextLoads() {
	}

}
