package org.gateway.filter.nutri_guide;

import java.util.List;
import org.commons.feature.nutri_guide.paths.MealFoodControllerPaths;
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
        new EndpointPermission(MealFoodControllerPaths.GET_ALL, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(MealFoodControllerPaths.GET_BY_ID, UserAccess.AUTH, HttpMethod.GET),
        new EndpointPermission(MealFoodControllerPaths.CREATE, UserAccess.AUTH, HttpMethod.POST),
        new EndpointPermission(MealFoodControllerPaths.UPDATE, UserAccess.AUTH, HttpMethod.PUT),
        new EndpointPermission(MealFoodControllerPaths.DELETE, UserAccess.AUTH, HttpMethod.DELETE)
    );
  }

  @Override
  protected String getBasePath() {
    return MealFoodControllerPaths.BASE;
  }
}