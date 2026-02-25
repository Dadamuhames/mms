package com.uzum.mms.entity;

import com.uzum.mms.constant.enums.Status;
import com.uzum.mms.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
@Entity(name = "terminal_entity")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TerminalEntity extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchant_id", nullable = false)
    MerchantEntity merchant;

    String webhookUrl;

    Status terminalStatus;
}
