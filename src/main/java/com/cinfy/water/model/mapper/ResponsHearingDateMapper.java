package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.ResponsHearingDate;
import com.cinfy.water.model.common.ResponsHearingDatePayload;

@Mapper
public interface ResponsHearingDateMapper {	
		
		ResponsHearingDateMapper INSTANCE = Mappers.getMapper(ResponsHearingDateMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		ResponsHearingDate responsHearingDatePayloadToResponsHearingDateEntity(ResponsHearingDatePayload responsHearingDatePayload);
		
		@InheritInverseConfiguration(name="responsHearingDatePayloadToResponsHearingDateEntity")
		ResponsHearingDatePayload responsHearingDateEntityToResponsHearingDatePayload(ResponsHearingDate responsHearingDate);

}
