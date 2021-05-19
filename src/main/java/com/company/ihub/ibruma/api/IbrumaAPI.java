package com.company.ihub.ibruma.api;

import com.company.ihub.base.response.BaseResponse;
import com.company.ihub.ibruma.api.dto.response.IbrumaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/companies")
public interface IbrumaAPI {

    @GetMapping("/search")
    ResponseEntity<BaseResponse<List<IbrumaResponse>>> searchLegalEntity(
            @RequestParam(name = "searchterm") final String searchTerm,
            @RequestParam(name = "jurisdiction_code", required = false) final String jurisdictionCode);

    @GetMapping("/{jurisdiction_code}/{le_externalid}/event")
    ResponseEntity<BaseResponse<IbrumaResponse>> searchLegalEntity(
            @RequestParam(name = "apikey") final String apiKey,
            @PathVariable(name = "jurisdiction_code", required = false) final String jurisdictionCode,
            @PathVariable(name = "le_externalid") final String leExternalId);

    @GetMapping("/{jurisdiction_code}/{le_externalid}")
    ResponseEntity<BaseResponse<IbrumaResponse>> getFullLegalEntity(
            @PathVariable(name = "jurisdiction_code") final String jurisdictionCode,
            @PathVariable(name = "le_externalid") final String leExternalId);

    @GetMapping("/{jurisdiction_code}/{le_externalid}/filings")
    ResponseEntity<BaseResponse<List<String>>> getFullLegalEntityFilings(
            @PathVariable(name = "jurisdiction_code") final String jurisdictionCode,
            @PathVariable(name = "le_externalid") final String leExternalId);

    @GetMapping("/{jurisdiction_code}/{le_externalid}/network")
    ResponseEntity<BaseResponse<String>> getFullLegalEntityNetwork(
            @PathVariable(name = "jurisdiction_code") final String jurisdictionCode,
            @PathVariable(name = "le_externalid") final String leExternalId);

    @GetMapping("/{jurisdiction_code}/{le_externalid}/statements")
    ResponseEntity<BaseResponse<List<String>>> getFullLegalEntityStatements(
            @PathVariable(name = "jurisdiction_code") final String jurisdictionCode,
            @PathVariable(name = "le_externalid") final String leExternalId);

    @GetMapping("/{jurisdiction_code}/{le_externalid}/events")
    ResponseEntity<BaseResponse<List<String>>> getLegalEntityMonitor(
            @PathVariable(name = "jurisdiction_code") final String jurisdictionCode,
            @PathVariable(name = "le_externalid") final String leExternalId);
}
