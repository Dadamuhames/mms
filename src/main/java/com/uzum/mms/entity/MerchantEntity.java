package com.uzum.mms.entity;

import com.uzum.mms.constant.enums.Status;
import com.uzum.mms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity(name = "merchant_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@SuperBuilder

public class MerchantEntity extends BaseEntity {
    @Column(unique = true,nullable = false)
    String companyName;

    @Column(nullable = false,unique = true)
    String inn;

    @Column(unique = true,nullable = false)
    String login;

    @Column(nullable = false)
    String password;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    Status merchantStatus;

    @Column(nullable = false)
    UUID firstAccountId;

    @Column(nullable = false)
    UUID secondAccountId;

}
