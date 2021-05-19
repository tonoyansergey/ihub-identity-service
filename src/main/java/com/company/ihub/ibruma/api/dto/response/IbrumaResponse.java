package com.company.ihub.ibruma.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IbrumaResponse {

    private Long id;

    private LegalEntityResponse legalEntity;

}
