package com.eventos.repositories;

import com.eventos.models.Produtora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoraRepository  extends JpaRepository<Produtora, Long> {

    Optional<Produtora> findByNome(String nome);
    Optional<Produtora> findByCpfCnpj(String cpfCnpj);
}
