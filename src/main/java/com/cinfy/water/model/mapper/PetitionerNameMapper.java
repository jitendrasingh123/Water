package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.PetitionerName;
import com.cinfy.water.model.common.PetitionerNamePayload;

@Mapper
public interface PetitionerNameMapper {	
		
		PetitionerNameMapper INSTANCE = Mappers.getMapper(PetitionerNameMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		PetitionerName petitionerNamePayloadToPetitionerNameEntity(PetitionerNamePayload petitionerNamePayload);
		
		@InheritInverseConfiguration(name="petitionerNamePayloadToPetitionerNameEntity")
		PetitionerNamePayload petitionerNameEntityToPetitionerNamePayload(PetitionerName petitionerName);

}
