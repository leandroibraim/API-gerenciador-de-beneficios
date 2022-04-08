package br.com.digix.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digix.gerenciador.dto.FamiliaBeneficioDto;
import br.com.digix.gerenciador.model.FamiliaBeneficioModelo;
import br.com.digix.gerenciador.service.FamiliaBeneficioService;

@RestController
@RequestMapping("familias")
public class GerenciadorFamiliaController {
	@Autowired
	private FamiliaBeneficioService familiaBeneficioService;

	@GetMapping(value = "/sortByPontos")
	public ResponseEntity<List<FamiliaBeneficioModelo>> buscaFamiliaMelhorPontuada() {
		List<FamiliaBeneficioModelo> listBeneficiario = familiaBeneficioService.buscaTodasFamiliasContempladas();
		if (listBeneficiario.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(listBeneficiario);
	}
	
    @PostMapping()
    public ResponseEntity<?> addBeneficiario(@RequestBody FamiliaBeneficioDto familia){
        try {
        	familiaBeneficioService.obtemFamiliaContemplada(familia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Lista das familias beneficiadas gerada com sucesso!");
    }
	
    /* End-Points pronto abaixo, use conforme Necessidade. *
	@PostMapping
	public void incluiFamilia(@RequestBody FamiliaBeneficioModelo familia) {
		familiaBeneficioRepositorio.save(familia);
	}	
	@GetMapping(value = "/sortByPontos")
	public ResponseEntity<List<FamiliaBeneficioModelo>> buscaMelhorPontuacao() {
		List<FamiliaBeneficioModelo> result = familiaBeneficioRepositorio.findByOrderByPontos();
		return ResponseEntity.ok(result);
	}
	@GetMapping("/{numeroGeristro}")
	public Optional<FamiliaBeneficioModelo> buscaPorNumeroDeGeristro(@PathVariable Long numeroGeristro) {
		return familiaBeneficioRepositorio.findById(numeroGeristro);
	}
	@PutMapping
	public void atualizarFamilia(@RequestBody FamiliaBeneficioModelo atualizaFamilia) {
		familiaBeneficioRepositorio.save(atualizaFamilia);
	}
	@DeleteMapping("/{numeroGeristro}")
	public void deletarFamilia(@PathVariable Long numeroGeristro) {
		familiaBeneficioRepositorio.deleteById(numeroGeristro);
	} 
	*/
}
