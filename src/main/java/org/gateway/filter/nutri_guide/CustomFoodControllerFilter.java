package org.gateway.filter.nutri_guide;

import java.util.List;
import org.commons.feature.nutri_guide.paths.CustomFoodControllerPaths;
import org.commons.feature.shared.dto.EndpointPermission;
import org.commons.feature.shared.enums.HttpMethod;
import org.commons.feature.shared.enums.UserAccess;
import org.gateway.filter.MainFilter;
import org.springframework.stereotype.Component;

@Component
public class CustomFoodControllerFilter extends MainFilter {

  @Override
  protected List<EndpointPermission> getPermissions() {
    return List.of(
        new EndpointPermission(CustomFoodControllerPaths.GET_ALL, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(CustomFoodControllerPaths.GET_BY_ID, UserAccess.AUTH,
            HttpMethod.GET),
        new EndpointPermission(CustomFoodControllerPaths.CREATE, UserAccess.AUTH, HttpMethod.POST),
        new EndpointPermission(CustomFoodControllerPaths.UPDATE, UserAccess.AUTH, HttpMethod.PUT),
        new EndpointPermission(CustomFoodControllerPaths.DELETE, UserAccess.AUTH, HttpMethod.DELETE)
    );
  }

  @Override
  protected String getBasePath() {
    return CustomFoodControllerPaths.BASE;
  }
}