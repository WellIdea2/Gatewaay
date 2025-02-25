package org.gateway.filter.record;

import java.util.List;
import org.commons.feature.record.paths.RecordControllerPaths;
import org.commons.feature.shared.dto.EndpointPermission;
import org.commons.feature.shared.enums.HttpMethod;
import org.commons.feature.shared.enums.UserAccess;
import org.gateway.filter.MainFilter;
import org.springframework.stereotype.Component;

@Component
public class RecordControllerFilter extends MainFilter {

  @Override
  protected List<EndpointPermission> getPermissions() {
    return List.of(
        new EndpointPermission(RecordControllerPaths.GET_ALL, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(RecordControllerPaths.GET_BY_ID, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(RecordControllerPaths.CREATE, UserAccess.AUTH, HttpMethod.POST),
        new EndpointPermission(RecordControllerPaths.UPDATE, UserAccess.AUTH, HttpMethod.PATCH),
        new EndpointPermission(RecordControllerPaths.DELETE, UserAccess.AUTH, HttpMethod.DELETE)
    );
  }

  @Override
  protected String getBasePath() {
    return RecordControllerPaths.BASE;
  }
}