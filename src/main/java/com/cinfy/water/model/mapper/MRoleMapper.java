package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.MRole;
import com.cinfy.water.model.common.MRolePayload;

@Mapper
public interface MRoleMapper {	
		
		MRoleMapper INSTANCE = Mappers.getMapper(MRoleMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		MRole mRolePayloadToMRoleEntity(MRolePayload mRolePayload);
		
		@InheritInverseConfiguration(name="mRolePayloadToMRoleEntity")
		MRolePayload mRoleEntityToMRolePayload(MRole mRole);

}
