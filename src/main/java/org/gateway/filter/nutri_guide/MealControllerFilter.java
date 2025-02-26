package org.gateway.filter.nutri_guide;

import java.util.List;
import org.commons.feature.nutri_guide.paths.MealControllerPaths;
import org.commons.feature.shared.dto.EndpointPermission;
import org.commons.feature.shared.enums.HttpMethod;
import org.commons.feature.shared.enums.UserAccess;
import org.gateway.filter.MainFilter;
import org.springframework.stereotype.Component;

@Component
public class MealControllerFilter extends MainFilter {

  @Override
  protected List<EndpointPermission> getPermissions() {
    return List.of(
        new EndpointPermission(MealControllerPaths.GET_ALL, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(MealControllerPaths.GET_BY_ID, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(MealControllerPaths.CREATE, UserAccess.AUTH, HttpMethod.POST),
        new EndpointPermission(MealControllerPaths.UPDATE, UserAccess.AUTH, HttpMethod.PATCH),
        new EndpointPermission(MealControllerPaths.DELETE, UserAccess.AUTH, HttpMethod.DELETE)
    );
  }

  @Override
  protected String getBasePath() {
    return MealControllerPaths.BASE;
  }
}