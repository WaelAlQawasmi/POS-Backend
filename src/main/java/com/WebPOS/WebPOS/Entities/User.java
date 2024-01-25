package com.WebPOS.WebPOS.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(	name = "users",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = "email")
    })
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String password;


}
