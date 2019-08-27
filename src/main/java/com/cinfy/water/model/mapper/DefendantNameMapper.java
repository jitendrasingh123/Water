package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.DefendantName;
import com.cinfy.water.model.common.DefendantNamePayload;

@Mapper(uses= {UserMapper.class})
public interface DefendantNameMapper {	
		
		DefendantNameMapper INSTANCE = Mappers.getMapper(DefendantNameMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		DefendantName defendantNamePayloadToDefendantNameEntity(DefendantNamePayload defendantNamePayload);
		
		@InheritInverseConfiguration(name="defendantNamePayloadToDefendantNameEntity")
		DefendantNamePayload defendantNameEntityToDefendantNamePayload(DefendantName defendantName);

}
