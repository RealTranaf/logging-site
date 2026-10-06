package com.vtc.logging.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken>{

    private static final String CLIENT_ID = "logging-be";

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {

        Map<String, Object> realmAccess = jwt.getClaim("realm_access"); // realm roles

        List<String> roles = List.of();

        if (realmAccess != null) {
            Object rolesObject = realmAccess.get("roles");

            if (rolesObject instanceof Collection<?> collection) {
                roles = collection.stream()
                        .map(Object::toString)
                        .toList();
            }
        }

//        Map<String, Object> resourceAccess = jwt.getClaim("resource_access"); // client roles
//

//        if (resourceAccess != null) {
//            Object clientObject = resourceAccess.get(CLIENT_ID);
//            if (clientObject instanceof Map<?, ?> client) {
//
//                Object rolesObject = client.get("roles");
//                if (rolesObject instanceof Collection<?> collection) {
//                    roles = collection.stream()
//                            .map(Object::toString)
//                            .toList();
//                }
//            }
//        }

        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(toList());

        return new JwtAuthenticationToken(jwt, authorities, jwt.getClaimAsString("preferred_username"));
    }
}
