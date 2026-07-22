package com.jplatform_studiodomino.shared.repository;

import com.jplatform_studiodomino.shared.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    List<Account> findAllByOrderByDescrizioneAsc();

    List<Account> findByTipoAccountOrderByDescrizioneAsc(String tipoAccount);

    Account findFirstByTipoAccountOrderByIdAsc(String tipoAccount);
}