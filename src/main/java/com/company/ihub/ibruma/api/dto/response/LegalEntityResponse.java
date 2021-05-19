package com.company.ihub.ibruma.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LegalEntityResponse {

    private String jurisdictionCode;

    private String searchTerm;

    private String network;

    private List<String> fillings;

    private List<String> events;

    private List<String> statements;
}
