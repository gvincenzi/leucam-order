package org.leucam.order.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "leucam_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(nullable = false)
    private String mail;
    @Column
    private Integer telegramUserId;
    @Column
    private Boolean active = Boolean.TRUE;
    @Column
    private Boolean administrator = Boolean.FALSE;
}
