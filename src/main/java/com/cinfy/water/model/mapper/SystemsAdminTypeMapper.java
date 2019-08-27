package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.SystemsAdminType;
import com.cinfy.water.model.common.SystemsAdminTypePayload;

@Mapper
public interface SystemsAdminTypeMapper {	
		
		SystemsAdminTypeMapper INSTANCE = Mappers.getMapper(SystemsAdminTypeMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		SystemsAdminType systemsAdminTypePayloadToSystemsAdminTypeEntity(SystemsAdminTypePayload systemsAdminTypePayload);
		
		@InheritInverseConfiguration(name="systemsAdminTypePayloadToSystemsAdminTypeEntity")
		SystemsAdminTypePayload systemsAdminTypeEntityToSystemsAdminTypePayload(SystemsAdminType systemsAdminType);

}
