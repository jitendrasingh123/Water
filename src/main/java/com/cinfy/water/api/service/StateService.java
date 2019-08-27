package com.cinfy.water.api.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cinfy.water.model.State;
import com.cinfy.water.model.common.StatePayload;
import com.cinfy.water.model.mapper.StateMapper;
import com.cinfy.water.model.repositories.MStateRepository;
import com.cinfy.water.model.response.ErrorMessage;
import com.cinfy.water.model.response.GenericResponse;
import com.cinfy.water.utils.Messages;


@Service
public class StateService {

	public static final Logger logger = LoggerFactory.getLogger(StateService.class);

	private static final int ERROR_CODE_CLASS = 1600;

	@Autowired
	private MStateRepository mStateRepository;

	@Transactional
	public GenericResponse findById(Integer id) {
		GenericResponse response = new GenericResponse();
		response.setStatus(0);
		try {

			State state = this.mStateRepository.getById(id);
			
			if (state != null) {

				StatePayload statePayload = StateMapper.INSTANCE.stateEntityToStatePayload(state);
				
				response.setData(statePayload);
				response.setStatus(1);
			}
		} catch (Exception ex) {
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(
					new ErrorMessage(ERROR_CODE_CLASS, "Project Resource not found for the id", ex.getMessage()));
		}
		return response;
	}

//	public GenericResponse getMaterialPlanningList() {
//		logger.info(" Requested Material Planning List..");
//		GenericResponse response = new GenericResponse();
//		response.setStatus(1);
//
//		try {
//			List<MaterialPlanning> materialPlanningList = null;
//
//			materialPlanningList = this.materialPlanningRepository.findAll();
//
//			if (materialPlanningList.size() > 0) {
//				response.setData(materialPlanningList);
//			} else {
//				response.setStatus(0);
//				response.setError(
//						new ErrorMessage(ERROR_CODE_CLASS, "No data found for this category:" + materialPlanningList));
//
//			}
//		} catch (Exception ex) {
//			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
//			response.setStatus(0);
//			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
//		}
//		return response;
//
//	}

	@Transactional
	public GenericResponse saveOrUpdate(StatePayload statePayload) {

		logger.info("Material Planning save/update by ID: [{}] ", statePayload.getId());

		GenericResponse response = new GenericResponse();
		response.setStatus(1);

		try {

			State state = StateMapper.INSTANCE.statePayloadToStateEntity(statePayload);

			
			if(state != null) {
				this.mStateRepository.save(state);
			}

			// TODO:Response construction of Material Planning Payload after save
			statePayload = StateMapper.INSTANCE.stateEntityToStatePayload(state);
			response.setData(statePayload);

		} catch (Exception ex) {
			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
			response.setStatus(0);
			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
		}
		return response;

	}

//	public GenericResponse getMaterialPlanningList(Map<String, Object> params) {
//		// TODO Need to implement Pagination
//		logger.info("Getting the list of details ....Material Planning Services");
//		List<MaterialPlanningPayload> result = null;
//		GenericResponse response = new GenericResponse();
//		response.setStatus(1);
//		try {
//			Integer empId = 0;
//			Integer projectId = 0;
//			Integer companyId = 0;
//
//			empId = params.get("empId") != null ? Integer.parseInt(params.get("empId").toString()) : 0;
//			projectId = params.get("projectId") != null ? Integer.parseInt(params.get("projectId").toString()) : 0;
//			companyId = params.get("companyId") != null ? Integer.parseInt(params.get("companyId").toString()) : 0;
//
//			Date fromDateUtil = null;
//			Date toDateUtil = null;
//			String from = params.get("fromDate") != null ? params.get("fromDate").toString().trim() : "";
//			if (!StringUtils.isEmpty(from)) {
//				fromDateUtil = CommonUtils.convertDateString(from, "yyyy-MM-dd");
//				String to = params.get("toDate") != null ? params.get("toDate").toString().trim() : "";
//				if (!StringUtils.isEmpty(to)) {
//					toDateUtil = CommonUtils.convertDateString(to, "yyyy-MM-dd");
//				}
//
//			}
//			// String phone = params.get("")
//
//			// Response convert to customers into List
//			List<MaterialPlanning> materialPlanningList = null;
//			if (empId != null && empId != 0) {
//				materialPlanningList = this.materialPlanningRepository.findByEmpIdIdAndCompanyId(empId, companyId);
//			} else if (projectId != null && projectId != 0) {
//				materialPlanningList = this.materialPlanningRepository.findByProjectIdIdAndCompanyId(projectId,
//						companyId);
//			} else if (toDateUtil != null && fromDateUtil != null) {
//				materialPlanningList = this.materialPlanningRepository.findByCreatedDate(toDateUtil, fromDateUtil,
//						companyId);
//
//			} else {
//				materialPlanningList = this.materialPlanningRepository.findALL();
//			}
//
//			if (materialPlanningList != null && !materialPlanningList.isEmpty()) {
//				result = new ArrayList<>();
//				for (MaterialPlanning materialPlanning : materialPlanningList) {
//
//					MaterialPlanningPayload materialPlanningPayload = MaterialPlanningMapper.INSTANCE
//							.materialPlanningEntityToMaterialPlanningPayload(materialPlanning);
//
//					result.add(materialPlanningPayload);
//				}
//			}
//			response.setData(result);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
//			response.setStatus(0);
//			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
//		}
//		return response;
//	}
//	
//	@Transactional
//	public GenericResponse updateDelete(MaterialPlanningDeleteRequest materialPlanningDeleteRequest) {
//		logger.info("Material Planning delete by ID: [{}]", materialPlanningDeleteRequest.getId());
//		GenericResponse response = new GenericResponse();
//		response.setStatus(1);
//		try {
//			List<Integer> ids = materialPlanningDeleteRequest.getId().stream().map(Integer::valueOf)
//					.collect(Collectors.toList());
//			this.materialPlanningRepository.updateDeleted(ids);
//			// this.cu.updateItemsDeleteFlag(ids);
//		} catch (Exception ex) {
//			logger.error(ERROR_CODE_CLASS + "-Exception occurred due to the:" + ex.fillInStackTrace());
//			response.setStatus(0);
//			response.setError(new ErrorMessage(ERROR_CODE_CLASS, Messages.get("sales.save.update"), ex.getMessage()));
//		}
//		return response;
//
//	}

}
