package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MZone;
import com.cinfy.water.model.common.MZonePayload;

@Mapper(uses = {StateMapper.class, MZoneTypeMapper.class})
public interface MZoneMapper {	
		
		MZoneMapper INSTANCE = Mappers.getMapper(MZoneMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MZone mZonePayloadToMZoneEntity(MZonePayload mZonePayload);
		
		@InheritInverseConfiguration(name="mZonePayloadToMZoneEntity")
		MZonePayload mZoneEntityToMZonePayload(MZone mZone);

}
