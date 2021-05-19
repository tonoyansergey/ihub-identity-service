package com.company.ihub.ibruma.service.impl;

import com.company.ihub.ibruma.api.dto.response.IbrumaResponse;
import com.company.ihub.ibruma.mapper.IbrumaMapper;
import com.company.ihub.ibruma.repository.IbrumaRepository;
import com.company.ihub.ibruma.service.IbrumaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IbrumaServiceImpl implements IbrumaService {

    private final IbrumaRepository ibrumaRepository;
    private final IbrumaMapper ibrumaMapper;

    @Override
    public List<IbrumaResponse> searchLegalEntity(String searchTerm, String jurisdictionCode) {
        return ibrumaRepository.
                getAllByLegalEntity_SearchTermAndLegalEntity_JurisdictionCode(searchTerm, jurisdictionCode).
                    map(ibrumaMapper::toIbrumaResponseList).
                        orElse(null);
    }

    @Override
    public IbrumaResponse searchLegalEntity(String apiKey, String jurisdictionCode, String leExternalId) {
        return ibrumaRepository.
                getByIdAndApiKeyAndLegalEntity_JurisdictionCode(Long.parseLong(leExternalId), apiKey, jurisdictionCode).
                    map(ibrumaMapper::toIbrumaResponse).
                        orElse(null);
    }

    @Override
    public IbrumaResponse getFullLegalEntity(String jurisdictionCode, String leExternalId) {
        return ibrumaRepository.
                getByIdAndLegalEntity_JurisdictionCode(Long.parseLong(leExternalId), jurisdictionCode).
                    map(ibrumaMapper::toIbrumaResponse).
                        orElse(null);
    }

    @Override
    public List<String> getFullLegalEntityFilings(String jurisdictionCode, String leExternalId) {
        return ibrumaRepository.
                getByIdAndLegalEntity_JurisdictionCode(Long.parseLong(leExternalId), jurisdictionCode).
                    map(o -> o.getLegalEntity().getFillings()).
                        orElse(null);
    }

    @Override
    public String getFullLegalEntityNetwork(String jurisdictionCode, String leExternalId) {
        return ibrumaRepository.
                getByIdAndLegalEntity_JurisdictionCode(Long.parseLong(leExternalId), jurisdictionCode).
                    map(o -> o.getLegalEntity().getNetwork()).
                        orElse(null);
    }

    @Override
    public List<String> getFullLegalEntityStatements(String jurisdictionCode, String leExternalId) {
        return ibrumaRepository.
                getByIdAndLegalEntity_JurisdictionCode(Long.parseLong(leExternalId), jurisdictionCode).
                    map(o -> o.getLegalEntity().getStatements()).
                        orElse(null);
    }

    @Override
    public List<String> getLegalEntityMonitor(String jurisdictionCode, String leExternalId) {
        return ibrumaRepository.
                getByIdAndLegalEntity_JurisdictionCode(Long.parseLong(leExternalId), jurisdictionCode).
                    map(o -> o.getLegalEntity().getEvents()).
                        orElse(null);
    }
}
