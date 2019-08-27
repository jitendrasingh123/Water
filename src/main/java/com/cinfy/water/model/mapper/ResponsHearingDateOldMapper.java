package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.ResponsHearingDateOld;
import com.cinfy.water.model.common.ResponsHearingDateOldPayload;

@Mapper
public interface ResponsHearingDateOldMapper {	
		
		ResponsHearingDateOldMapper INSTANCE = Mappers.getMapper(ResponsHearingDateOldMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		ResponsHearingDateOld responsHearingDateOldPayloadToResponsHearingDateOldEntity(ResponsHearingDateOldPayload responsHearingDateOldPayload);
		
		@InheritInverseConfiguration(name="responsHearingDateOldPayloadToResponsHearingDateOldEntity")
		ResponsHearingDateOldPayload responsHearingDateOldEntityToResponsHearingDateOldPayload(ResponsHearingDateOld responsHearingDateOld);

}
