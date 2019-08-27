package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.State;
import com.cinfy.water.model.common.StatePayload;

@Mapper
public interface StateMapper {	
		
		StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		State statePayloadToStateEntity(StatePayload statePayload);
		
		@InheritInverseConfiguration(name="statePayloadToStateEntity")
		StatePayload stateEntityToStatePayload(State state);

}
