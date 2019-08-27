package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MCircleType;
import com.cinfy.water.model.common.MCircleTypePayload;

@Mapper
public interface MCircleTypeMapper {	
		
		MCircleTypeMapper INSTANCE = Mappers.getMapper(MCircleTypeMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MCircleType mCircleTypePayloadToMCircleTypeEntity(MCircleTypePayload mCircleTypePayload);
		
		@InheritInverseConfiguration(name="mCircleTypePayloadToMCircleTypeEntity")
		MCircleTypePayload mCircleTypeEntityToMCircleTypePayload(MCircleType mCircleType);

}
