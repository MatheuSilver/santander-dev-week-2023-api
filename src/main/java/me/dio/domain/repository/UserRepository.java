package me.dio.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import me.dio.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String number);

    boolean existsByCardNumber(String number);

    @Query("SELECT u FROM User u " +
           "WHERE (:name IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
           "AND (:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%')))")
    Page<User> findByNameAndEmail(@Param("name") String name,
                                  @Param("email") String email,
                                  Pageable pageable);
}
