package com.drive.modules.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drive.modules.auth.model.Token;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
   
    @Query(value = """
            select t from Token t inner join User u\s
            on t.dtUser.id = u.id\s
            where u.id = :id and (t.isExpired = false or t.isRevoked = false)\s
            """)
    List<Token> findAllValidTokenByUser(@Param("id") Integer id);

    Optional<Token> findByToken(String token);
}