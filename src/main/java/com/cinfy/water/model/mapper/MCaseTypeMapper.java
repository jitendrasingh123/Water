package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MCaseType;
import com.cinfy.water.model.common.MCaseTypePayload;

@Mapper
public interface MCaseTypeMapper {	
		
		MCaseTypeMapper INSTANCE = Mappers.getMapper(MCaseTypeMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MCaseType mCaseTypePayloadToMCaseTypeEntity(MCaseTypePayload mCaseTypePayload);
		
		@InheritInverseConfiguration(name="mCaseTypePayloadToMCaseTypeEntity")
		MCaseTypePayload mCaseTypeEntityToMCaseTypePayload(MCaseType mCaseType);

}
