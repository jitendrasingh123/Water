package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MDivisionType;
import com.cinfy.water.model.common.MDivisionTypePayload;

@Mapper
public interface MDivisionTypeMapper {	
		
		MDivisionTypeMapper INSTANCE = Mappers.getMapper(MDivisionTypeMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MDivisionType mDivisionTypePayloadToMDivisionTypeEntity(MDivisionTypePayload mDivisionTypePayload);
		
		@InheritInverseConfiguration(name="mDivisionTypePayloadToMDivisionTypeEntity")
		MDivisionTypePayload mDivisionTypeEntityToMDivisionTypePayload(MDivisionType mDivisionType);

}
