package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MZoneType;
import com.cinfy.water.model.common.MZoneTypePayload;

@Mapper
public interface MZoneTypeMapper {	
		
		MZoneTypeMapper INSTANCE = Mappers.getMapper(MZoneTypeMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MZoneType mZoneTypePayloadToMZoneTypeEntity(MZoneTypePayload mZoneTypePayload);
		
		@InheritInverseConfiguration(name="mZoneTypePayloadToMZoneTypeEntity")
		MZoneTypePayload mZoneTypeEntityToMZoneTypePayload(MZoneType mZoneType);

}
