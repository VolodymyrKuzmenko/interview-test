package com.roketbnk.test.apigateway.configuration;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
    //    @Bean
    //    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //        //@formatter:off
//		return builder.routes()
//				.build();
//		//@formatter:on
    //    }

    @Bean
    public DiscoveryClientRouteDefinitionLocator discoveryClientRouteLocator(DiscoveryClient discoveryClient,
                                                                             DiscoveryLocatorProperties locatorProperties) {

        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, locatorProperties);
    }
}
