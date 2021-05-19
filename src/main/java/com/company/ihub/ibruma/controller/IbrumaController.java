package com.company.ihub.ibruma.controller;

import com.company.ihub.base.messages.ResponseMessageConstant;
import com.company.ihub.base.response.BaseResponse;
import com.company.ihub.ibruma.api.IbrumaAPI;
import com.company.ihub.ibruma.api.dto.response.IbrumaResponse;
import com.company.ihub.ibruma.service.IbrumaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IbrumaController implements IbrumaAPI {

    private final IbrumaService ibrumaService;

    @Override
    public ResponseEntity<BaseResponse<List<IbrumaResponse>>> searchLegalEntity(String searchTerm, String jurisdictionCode) {
        List<IbrumaResponse> response = ibrumaService.searchLegalEntity(searchTerm, jurisdictionCode);
        Boolean success = response != null && !response.isEmpty();
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<List<IbrumaResponse>> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<IbrumaResponse>> searchLegalEntity(String apiKey, String jurisdictionCode, String leExternalId) {
        IbrumaResponse response = ibrumaService.searchLegalEntity(apiKey, jurisdictionCode, leExternalId);
        Boolean success = response != null;
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<IbrumaResponse> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<IbrumaResponse>> getFullLegalEntity(String jurisdictionCode, String leExternalId) {
        IbrumaResponse response = ibrumaService.getFullLegalEntity(jurisdictionCode, leExternalId);
        Boolean success = response != null;
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<IbrumaResponse> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<List<String>>> getFullLegalEntityFilings(String jurisdictionCode, String leExternalId) {
        List<String> response = ibrumaService.getFullLegalEntityFilings(jurisdictionCode, leExternalId);
        Boolean success = response != null && !response.isEmpty();
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<List<String>> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<String>> getFullLegalEntityNetwork(String jurisdictionCode, String leExternalId) {
        String response = ibrumaService.getFullLegalEntityNetwork(jurisdictionCode, leExternalId);
        Boolean success = response != null && !response.isEmpty();
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<String> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<List<String>>> getFullLegalEntityStatements(String jurisdictionCode, String leExternalId) {
        List<String> response = ibrumaService.getFullLegalEntityStatements(jurisdictionCode, leExternalId);
        Boolean success = response != null && !response.isEmpty();
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<List<String>> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse<List<String>>> getLegalEntityMonitor(String jurisdictionCode, String leExternalId) {
        List<String> response = ibrumaService.getLegalEntityMonitor(jurisdictionCode, leExternalId);
        Boolean success = response != null && !response.isEmpty();
        String message = success ? ResponseMessageConstant.GET : ResponseMessageConstant.ERROR;
        BaseResponse<List<String>> baseResponse = new BaseResponse<>(success, message, response);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
