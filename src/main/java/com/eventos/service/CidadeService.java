package com.eventos.service;

import com.eventos.dtos.CidadeDTO;
import com.eventos.dtos.UsuarioDTO;
import com.eventos.models.Cidade;
import com.eventos.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public CidadeDTO salvarCidade(CidadeDTO cidadeDTO){
        Cidade cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return converterCidadeParaCidadeDTO(cidade);

    }

    public CidadeDTO converterCidadeParaCidadeDTO(Cidade cidade) {
        CidadeDTO cidadeDTO = new CidadeDTO();
        cidadeDTO.setId(cidade.getId());
        cidadeDTO.setNome(cidade.getNome());
        cidadeDTO.setEstado(cidade.getEstado());
        return cidadeDTO;
    }

    public Cidade converterCidadeDTOParaCidade(CidadeDTO cidadeDTO) {
        Cidade cidade = new Cidade(
                cidadeDTO.getId(),
                cidadeDTO.getNome(),
                cidadeDTO.getEstado());
        return cidade;
    }

    public Cidade buscarCidadePorId(Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cidade não encontrado"));
    }
    public CidadeDTO atualizarCidade(CidadeDTO cidadeDTO) {
            if (isNull(cidadeDTO.getId())) {
                throw new IllegalArgumentException("campo Id não informado");
            }
        Cidade cidade = cidadeRepository.findById(cidadeDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Cidade não encontrado"));

        cidade = converterCidadeDTOParaCidade(cidadeDTO);
        cidade = cidadeRepository.save(cidade);

        return converterCidadeParaCidadeDTO(cidade);
    }
    public void deletarCidade(Long id) {
        cidadeRepository.deleteById(id);
    }

    public CidadeDTO buscarCidadePorNome(String nome) {
        return converterCidadeParaCidadeDTO(cidadeRepository.findByNome(nome)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cidade não encontrado")));
    }
    }

