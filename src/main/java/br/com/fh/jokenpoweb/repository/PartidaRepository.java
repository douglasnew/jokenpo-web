package br.com.fh.jokenpoweb.repository;

import br.com.fh.jokenpoweb.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
