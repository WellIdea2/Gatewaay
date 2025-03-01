package com.floxie.gateway.filter.nutri_guide;

import java.util.List;
import org.commons.feature.nutri_guide.paths.NutritionixApiControllerPaths;
import org.commons.feature.shared.dto.EndpointPermission;
import org.commons.feature.shared.enums.HttpMethod;
import org.commons.feature.shared.enums.UserAccess;
import com.floxie.gateway.filter.MainFilter;
import org.springframework.stereotype.Component;

@Component
public class NutritionixApiControllerFilter extends MainFilter {

  @Override
  protected List<EndpointPermission> getPermissions() {
    return List.of(
        new EndpointPermission(NutritionixApiControllerPaths.GET_COMMON_FOOD, UserAccess.NO_AUTH,
            HttpMethod.GET),
        new EndpointPermission(NutritionixApiControllerPaths.GET_BRANDED_FOOD, UserAccess.NO_AUTH,
            HttpMethod.GET),
        new EndpointPermission(NutritionixApiControllerPaths.GET_FOODS_BY_NAME, UserAccess.NO_AUTH,
            HttpMethod.GET)
    );
  }

  @Override
  protected String getBasePath() {
    return NutritionixApiControllerPaths.BASE;
  }
}