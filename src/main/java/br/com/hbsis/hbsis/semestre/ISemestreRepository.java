package br.com.hbsis.hbsis.semestre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ISemestreRepository extends JpaRepository<Semestre, Long> {

//    @Query(value = "SELECT TOP 1 * FROM semestre WHERE termino_vendas >= :dataInicial AND id_fornecedor = :fornecedor", nativeQuery = true)
//    long existDateinOpen(
//            @Param("dataInicial") Date dataInicial,
//            @Param("fornecedor") Long fornecedor
//    );
}
