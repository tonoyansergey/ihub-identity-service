package com.company.ihub.ibruma.entity.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntity {

    private String jurisdictionCode;

    private String searchTerm;

    private String network;

    @ElementCollection
    private List<String> fillings;

    @ElementCollection
    private List<String> events;

    @ElementCollection
    private List<String> statements;
}
