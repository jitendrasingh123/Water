package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MCircle;
import com.cinfy.water.model.common.MCirclePayload;

@Mapper(uses = {MCircleTypeMapper.class, StateMapper.class, MZoneMapper.class})
public interface MCircleMapper {	
		
		MCircleMapper INSTANCE = Mappers.getMapper(MCircleMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MCircle mCirclePayloadToMCircleEntity(MCirclePayload mCirclePayload);
		
		@InheritInverseConfiguration(name="mCirclePayloadToMCircleEntity")
		MCirclePayload mCircleEntityToMCirclePayload(MCircle mCircle);

}
