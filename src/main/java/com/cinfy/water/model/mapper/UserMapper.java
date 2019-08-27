package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.User;
import com.cinfy.water.model.common.UserPayload;


@Mapper(uses = {MCircleMapper.class, StateMapper.class, MZoneMapper.class, MDesignationMapper.class, 
		MDivisionMapper.class, MUserLevelMapper.class, MRoleMapper.class, SystemsAdminTypeMapper.class})
public interface UserMapper {	
		
		UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")
					
		})
		
		User userPayloadToUserEntity(UserPayload userPayload);
		
		@InheritInverseConfiguration(name="userPayloadToUserEntity")
		UserPayload userEntityToUserPayload(User user);

}
