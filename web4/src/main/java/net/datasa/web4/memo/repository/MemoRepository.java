package net.datasa.web4.memo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.datasa.web4.memo.entity.MemoEntity;

@Repository
public interface MemoRepository extends JpaRepository<MemoEntity, Integer>{

}
