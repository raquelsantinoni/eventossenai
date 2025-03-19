package com.eventos.service;

import com.eventos.dtos.CidadeDTO;
import com.eventos.dtos.ProdutoraDTO;
import com.eventos.models.Cidade;
import com.eventos.models.Produtora;
import com.eventos.repositories.ProdutoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service

public class ProdutoraService {

    @Autowired
    private ProdutoraRepository produtoraRepository;

    public ProdutoraDTO salvarProdutora(ProdutoraDTO produtoraDTO){
        Produtora produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);
        return converterProdutoraParaProdutoraDTO(produtora);
    }

    private Produtora converterProdutoraDTOParaProdutora(ProdutoraDTO produtoraDTO) {
        Produtora produtora = new Produtora();
        produtora.setId(produtoraDTO.getId());
        produtora.setNome(produtoraDTO.getNome());
        produtora.setCpfCnpj(produtoraDTO.getCpfCnpj());
        return produtora;
    }

    private ProdutoraDTO converterProdutoraParaProdutoraDTO(Produtora produtora){
        ProdutoraDTO produtoraDTO = new ProdutoraDTO();
        produtoraDTO.setId(produtora.getId());
        produtoraDTO.setNome(produtora.getNome());
        produtoraDTO.setCpfCnpj(produtora.getCpfCnpj());
        return produtoraDTO;
    }

    public ProdutoraDTO buscarProdutoraPorId(Long id) {
        Produtora produtora = produtoraRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produtora não encontrado"));
        return converterProdutoraParaProdutoraDTO(produtora);

    }

    public ProdutoraDTO atualizarProdutora(ProdutoraDTO produtoraDTO) {
        if (isNull(produtoraDTO.getId())) {
            throw new IllegalArgumentException("campo Id não informado");
        }
        Produtora produtora = produtoraRepository.findById(produtoraDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Produtora não encontrado"));

        produtora = converterProdutoraDTOParaProdutora(produtoraDTO);
        produtora = produtoraRepository.save(produtora);

        return converterProdutoraParaProdutoraDTO(produtora);
    }

    public void deletarProdutora(Long id) {
        produtoraRepository.deleteById(id);
    }

    public ProdutoraDTO buscarProdutoraPorNome(String nome){
        return converterProdutoraParaProdutoraDTO(produtoraRepository.findByNome(nome)
                .orElseThrow(() ->
                        new IllegalArgumentException("produtora não encontrado")));
    }
}








