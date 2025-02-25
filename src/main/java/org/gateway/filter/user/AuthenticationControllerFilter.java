package org.gateway.filter.user;

import java.util.List;
import org.commons.feature.shared.dto.EndpointPermission;
import org.commons.feature.shared.enums.HttpMethod;
import org.commons.feature.shared.enums.UserAccess;
import org.commons.feature.user.paths.AuthenticationControllerPaths;
import org.gateway.filter.MainFilter;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationControllerFilter extends MainFilter {

  @Override
  protected List<EndpointPermission> getPermissions() {
    return List.of(
        new EndpointPermission(AuthenticationControllerPaths.LOGIN, UserAccess.NO_AUTH,
            HttpMethod.POST)
    );
  }

  @Override
  protected String getBasePath() {
    return AuthenticationControllerPaths.BASE;
  }
}