package com.cinfy.water.model.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.cinfy.water.model.CaseRegistration;
import com.cinfy.water.model.common.CaseRegistrationPayload;

@Mapper(uses = { MCourtNameMapper.class, MCaseTypeMapper.class, MZoneMapper.class,
		MCircleMapper.class, MDivisionMapper.class, UserMapper.class, ResponsHearingDateMapper.class,
		CaseAttachmentMapper.class, PetitionerNameMapper.class, DefendantNameMapper.class })
public interface CaseRegistrationMapper {

	CaseRegistrationMapper INSTANCE = Mappers.getMapper(CaseRegistrationMapper.class);

	@Mappings({ @Mapping(source = "id", target = "id") })

	CaseRegistration caseRegistrationPayloadToCaseRegistrationEntity(CaseRegistrationPayload caseRegistrationPayload);

	@InheritInverseConfiguration(name = "caseRegistrationPayloadToCaseRegistrationEntity")
	CaseRegistrationPayload caseRegistrationEntityToCaseRegistrationPayload(CaseRegistration caseRegistration);

}
 