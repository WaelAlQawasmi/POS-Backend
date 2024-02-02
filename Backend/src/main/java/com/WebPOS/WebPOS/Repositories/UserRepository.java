package com.WebPOS.WebPOS.Repositories;

import com.WebPOS.WebPOS.DTO.userDTO;
import com.WebPOS.WebPOS.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Query("SELECT new com.WebPOS.WebPOS.DTO.userDTO(u.id , u.email ,u.name ) FROM User u WHERE u.email = :email")
    Optional<userDTO> findNameAndIdByEmail(@Param("email") String email);


}
