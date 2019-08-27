package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MDivision;
import com.cinfy.water.model.common.MDivisionPayload;

@Mapper(uses = {MCircleMapper.class, MDivisionTypeMapper.class, StateMapper.class})
public interface MDivisionMapper {	
		
		MDivisionMapper INSTANCE = Mappers.getMapper(MDivisionMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MDivision mDivisionPayloadToMDivisionEntity(MDivisionPayload mDivisionPayload);
		
		@InheritInverseConfiguration(name="mDivisionPayloadToMDivisionEntity")
		MDivisionPayload mDivisionEntityToMDivisionPayload(MDivision mDivision);

}
