package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MUserLavel;
import com.cinfy.water.model.common.MUserLevelPayload;

@Mapper
public interface MUserLevelMapper {	
		
		MUserLevelMapper INSTANCE = Mappers.getMapper(MUserLevelMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MUserLavel mUserLevelPayloadToMUserLevelEntity(MUserLevelPayload mUserLevelPayload);
		
		@InheritInverseConfiguration(name="mUserLevelPayloadToMUserLevelEntity")
		MUserLevelPayload mUserLevelEntityToMUserLevelPayload(MUserLavel mUserLavel);

}
