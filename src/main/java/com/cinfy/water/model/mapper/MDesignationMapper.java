package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MDesignation;
import com.cinfy.water.model.common.MDesignationPayload;

@Mapper
public interface MDesignationMapper {	
		
		MDesignationMapper INSTANCE = Mappers.getMapper(MDesignationMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MDesignation mDesignationPayloadToMDesignationEntity(MDesignationPayload mDesignationPayload);
		
		@InheritInverseConfiguration(name="mDesignationPayloadToMDesignationEntity")
		MDesignationPayload mDesignationEntityToMDesignationPayload(MDesignation mDesignation);

}
