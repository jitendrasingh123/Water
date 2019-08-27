package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.CaseAttachment;
import com.cinfy.water.model.common.CaseAttachmentPayload;

@Mapper
public interface CaseAttachmentMapper {	
		
		CaseAttachmentMapper INSTANCE = Mappers.getMapper(CaseAttachmentMapper.class);
		
		@Mappings({			
			@Mapping(source = "id", target = "id")			
		})
		
		CaseAttachment caseAttachmentPayloadToCaseAttachmentEntity(CaseAttachmentPayload caseAttachmentPayload);
		
		@InheritInverseConfiguration(name="caseAttachmentPayloadToCaseAttachmentEntity")
		CaseAttachmentPayload caseAttachmentEntityToCaseAttachmentPayload(CaseAttachment caseAttachment);

}
