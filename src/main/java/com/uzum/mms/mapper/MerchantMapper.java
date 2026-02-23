package com.uzum.mms.mapper;

import com.uzum.mms.dto.request.MerchantRequest;
import com.uzum.mms.dto.request.UpdateMerchantRequest;
import com.uzum.mms.dto.response.MerchantResponse;
import com.uzum.mms.entity.MerchantEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MerchantMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "merchantStatus",constant = "ACTIVE")
    MerchantEntity toEntity(MerchantRequest merchantRequest);

    MerchantResponse toResponse(MerchantEntity merchant);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMerchantFromDto(UpdateMerchantRequest dto, @MappingTarget MerchantEntity entity);
}
