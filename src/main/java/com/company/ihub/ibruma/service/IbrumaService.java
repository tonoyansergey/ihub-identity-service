package com.company.ihub.ibruma.service;

import com.company.ihub.ibruma.api.dto.response.IbrumaResponse;

import java.util.List;

public interface IbrumaService {

    List<IbrumaResponse> searchLegalEntity(String searchTerm, String jurisdictionCode);

    IbrumaResponse searchLegalEntity(String apiKey, String jurisdictionCode, String leExternalId);

    IbrumaResponse getFullLegalEntity(String jurisdictionCode, String leExternalId);

    List<String> getFullLegalEntityFilings(String jurisdictionCode, String leExternalId);

    String getFullLegalEntityNetwork(String jurisdictionCode, String leExternalId);

    List<String> getFullLegalEntityStatements(String jurisdictionCode, String leExternalId);

    List<String> getLegalEntityMonitor(String jurisdictionCode, String leExternalId);
}
