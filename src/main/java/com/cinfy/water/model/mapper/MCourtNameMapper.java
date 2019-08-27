package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MCourtName;
import com.cinfy.water.model.common.MCourtNamePayload;

@Mapper
public interface MCourtNameMapper {	
		
		MCourtNameMapper INSTANCE = Mappers.getMapper(MCourtNameMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MCourtName mCourtNamePayloadToMCourtNameEntity(MCourtNamePayload mCourtNamePayload);
		
		@InheritInverseConfiguration(name="mCourtNamePayloadToMCourtNameEntity")
		MCourtNamePayload mCourtNameEntityToMCourtNamePayload(MCourtName mCourtName);

}
