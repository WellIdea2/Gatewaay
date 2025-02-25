package org.gateway.filter.record;

import java.util.List;
import org.commons.feature.record.paths.FoodControllerPaths;
import org.commons.feature.shared.dto.EndpointPermission;
import org.commons.feature.shared.enums.HttpMethod;
import org.commons.feature.shared.enums.UserAccess;
import org.gateway.filter.MainFilter;
import org.springframework.stereotype.Component;

@Component
public class FoodControllerFilter extends MainFilter {

  @Override
  protected List<EndpointPermission> getPermissions() {
    return List.of(
        new EndpointPermission(FoodControllerPaths.GET_ALL, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(FoodControllerPaths.GET_BY_ID, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(FoodControllerPaths.CREATE, UserAccess.AUTH, HttpMethod.POST),
        new EndpointPermission(FoodControllerPaths.UPDATE, UserAccess.AUTH, HttpMethod.PUT),
        new EndpointPermission(FoodControllerPaths.DELETE, UserAccess.AUTH, HttpMethod.DELETE)
    );
  }

  @Override
  protected String getBasePath() {
    return FoodControllerPaths.BASE;
  }
}