package br.com.digix.gerenciador.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.digix.gerenciador.dto.DependenteBeneficioDto;
import br.com.digix.gerenciador.dto.FamiliaBeneficioDto;
import br.com.digix.gerenciador.dto.FamiliaBeneficioDto.FamiliaBeneficioBiulder;
import br.com.digix.gerenciador.model.DependenteBeneficioModelo;
import br.com.digix.gerenciador.model.FamiliaBeneficioModelo;
import br.com.digix.gerenciador.repository.FamiliaBeneficioRepository;
import br.com.digix.gerenciador.utils.MensagensUtil;
import br.com.digix.gerenciador.utils.PontuacaoUtil;
import br.com.digix.gerenciador.utils.RendasUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamiliaBeneficioService {
	@Autowired
	private FamiliaBeneficioRepository familiaBeneficioRepository;
	
    public List<FamiliaBeneficioModelo> buscaTodasFamiliasContempladas() {
    	List<FamiliaBeneficioModelo> listaFamiliaContemplada =  familiaBeneficioRepository.findAll(Sort.by(Sort.Direction.DESC, "pontos"));
    	return listaFamiliaContemplada.stream().filter((FamiliaBeneficioModelo familia) -> familia.getPontos() != 0).collect(Collectors.toList());
   }

    public void obtemFamiliaContemplada(FamiliaBeneficioDto familia) {
    	FamiliaBeneficioBiulder familiaContemplada = new FamiliaBeneficioDto.FamiliaBeneficioBiulder()
    		.nome(familia.getNome())
    		.pontos(familia.getPontos())
    		.rendaFamilia(familia.getRendaFamilia())
    		.dependentes(listaDependenteOrdenado(familia.getDependentes()))
    		.pontos(obtemFamiliaContempladaPorPontuacaoGeral(familiaContemplada))
    		.build();
    	familiaBeneficioRepository.save(familiaContemplada);
    }
    
    private Integer obtemFamiliaContempladaPorPontuacaoGeral(FamiliaBeneficioDto beneficiario) {
		int pontuacao = 0;
		if (beneficiario.getRendaFamilia() <= RendasUtil.RENDA_FAMILIAR_CINCO_PONTOS) {
			pontuacao += PontuacaoUtil.CINCO_PONTOS;
		}
		if (beneficiario.getRendaFamilia() > RendasUtil.RENDA_FAMILIAR_CINCO_PONTOS
				&& beneficiario.getRendaFamilia() <= RendasUtil.RENDA_FAMILIAR_TRES_PONTOS) {
			pontuacao += PontuacaoUtil.TRES_PONTOS;
		}
		pontuacao += obtempontuacaoPorDependentes(beneficiario.getDependentes());

		return pontuacao;
	}

	private int obtempontuacaoPorDependentes(List<DependenteBeneficioDto> dependentes){
    	List<DependenteBeneficioDto> listDependentes = dependentes.stream()
    			.filter((DependenteBeneficioDto dependente) -> dependente.getIdade() <= MensagensUtil.MAIOR_IDADE)
    			.collect(Collectors.toList());
        if(listDependentes.size() >= PontuacaoUtil.TRES_PONTOS){
            return PontuacaoUtil.TRES_PONTOS;
        }
        if(listDependentes.size() > PontuacaoUtil.ZERO_PONTOS){
            return PontuacaoUtil.DOIS_PONTOS;
        }
        return PontuacaoUtil.ZERO_PONTOS;
    }
	private List<DependenteBeneficioModelo> listaDependenteOrdenado(List<DependenteBeneficioDto> dependentes){
		return dependentes.stream().map(DependenteBeneficioModelo::new).collect(Collectors.toList()); //Lista dependentes ordenado
	}
}