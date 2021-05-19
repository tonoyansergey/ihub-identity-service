package com.company.ihub.ibruma.entity;

import com.company.ihub.base.entity.BaseEntity;
import com.company.ihub.ibruma.entity.property.LegalEntity;
import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ibruma")
@EqualsAndHashCode(callSuper = true)
public class IbrumaEntity extends BaseEntity {

    @Embedded
    private LegalEntity legalEntity;

    private String apiKey;

}
