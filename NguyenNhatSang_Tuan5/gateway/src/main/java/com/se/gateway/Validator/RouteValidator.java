package com.se.gateway.Validator;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class RouteValidator {
	
    public static final List<String> endpointsNoAuth = List.of(
            "/auth/register",
            "/auth/login"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> endpointsNoAuth
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}