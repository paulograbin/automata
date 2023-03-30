package com.paulograbin.cloudportal;

import com.paulograbin.ccv2api.model.CreateDeploymentRequestDTO;
import com.paulograbin.ccv2api.model.CreateDeploymentResponseDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailDTO;
import com.paulograbin.ccv2api.model.DeploymentDetailsDTO;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class DeploymentService
{

	private final Logger LOG = LoggerFactory.getLogger(DeploymentService.class);

	@Resource
	CloudPortalAPI cloudPortalAPI;

	public void makeDeployment(String buildCode)
	{
		CreateDeploymentRequestDTO request = new CreateDeploymentRequestDTO();
		request.setBuildCode(buildCode);
		request.setStrategy(CreateDeploymentRequestDTO.StrategyEnum.RECREATE);
		request.setDatabaseUpdateMode(CreateDeploymentRequestDTO.DatabaseUpdateModeEnum.NONE);
		request.setEnvironmentCode("d1");

		CreateDeploymentResponseDTO deployments = cloudPortalAPI.sendPostRequest("deployments", request, CreateDeploymentResponseDTO.class);

		LOG.info("Deployment created: ");
		LOG.info(" Code: {}", deployments.getCode());
	}

	public DeploymentDetailsDTO fetchDeployments()
	{
		{
			LOG.info("Fetching all recent builds...");

			DeploymentDetailsDTO buildDetailsDTO = cloudPortalAPI.sendRequest("deployments", DeploymentDetailsDTO.class);

			for (DeploymentDetailDTO buildDetailDTO : buildDetailsDTO.getValue())
			{
				LOG.info(" ****************** ");
				LOG.info("Deployment details: ");
				LOG.info(" Code {}", buildDetailDTO.getCode());
				LOG.info(" Code {}", buildDetailDTO.getEnvironmentCode());
				LOG.info(" Status {}", buildDetailDTO.getStatus());
				LOG.info(" Created by {}", buildDetailDTO.getCreatedBy());
			}

			return buildDetailsDTO;
		}
	}
}
