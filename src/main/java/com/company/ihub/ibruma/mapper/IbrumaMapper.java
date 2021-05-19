package com.company.ihub.ibruma.mapper;

import com.company.ihub.ibruma.api.dto.response.IbrumaResponse;
import com.company.ihub.ibruma.entity.IbrumaEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IbrumaMapper {

    private final ModelMapper mapper;

    public IbrumaResponse toIbrumaResponse( IbrumaEntity ibrumaEntity) {
        return mapper.map(ibrumaEntity, new TypeToken<IbrumaResponse>() {}.getType());
    }

    public List<IbrumaResponse> toIbrumaResponseList(List<IbrumaEntity> ibrumaEntities) {
        return mapper.map(ibrumaEntities, new TypeToken<List<IbrumaResponse>>() {}.getType());
    }
}
