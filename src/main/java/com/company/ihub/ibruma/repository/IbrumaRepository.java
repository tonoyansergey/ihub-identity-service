package com.company.ihub.ibruma.repository;

import com.company.ihub.ibruma.entity.IbrumaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IbrumaRepository extends JpaRepository<IbrumaEntity, Long> {

    Optional<List<IbrumaEntity>> getAllByLegalEntity_SearchTermAndLegalEntity_JurisdictionCode(final String searchTerm, final String jurisdictionCode);

    Optional<IbrumaEntity> getByIdAndApiKeyAndLegalEntity_JurisdictionCode(final Long leExternalId, final String apiKey, final String jurisdictionCode);

    Optional<IbrumaEntity> getByIdAndLegalEntity_JurisdictionCode(final Long leExternalId, final String jurisdictionCode);
}
