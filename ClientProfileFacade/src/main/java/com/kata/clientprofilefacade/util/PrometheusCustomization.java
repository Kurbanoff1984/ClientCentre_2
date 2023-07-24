package com.kata.clientprofilefacade.util;

import com.kata.clientprofilefacade.exception.MetricsProcessingException;
import com.kata.clientprofilefacade.service.IPRangeService;
import eu.bitwalker.useragentutils.UserAgent;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Configuration class for Prometheus
 */
@Component
@AllArgsConstructor
@Slf4j
public class PrometheusCustomization {

    private final MeterRegistry meterRegistry;
    private final IPRangeService ipRangeService;

    /**
     * A method that adds a metric to Prometheus
     * @param request
     * @param name - graphic title in Prometheus
     */
    public void add(HttpServletRequest request, String name) {

        try {
            String userAgentString = request.getHeader("User-Agent");
            UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
            String deviceType = userAgent.getOperatingSystem().getDeviceType().getName();
            String browserName = userAgent.getBrowser().getName();
            String ip = request.getRemoteAddr();
            Optional<String> cityOptional = ipRangeService.findCityByIpAddress(ip);
            log.info(cityOptional.orElse("unknown"));
            if (userAgentString.startsWith("Postman")) {
                meterRegistry.counter(name + " Postman",
                                "ipAddress", ip,
                                "API platform", userAgentString,
                                "City", cityOptional.orElse("unknown"))
                                .increment();
            } else {
                meterRegistry.counter(name + " Browser",
                                "ipAddress", ip,
                                "deviceType", deviceType,
                                "browserName", browserName,
                                "City", cityOptional.orElse("unknown"))
                                .increment();
            }
        } catch (RuntimeException e) {
            throw new MetricsProcessingException("Failed to add metrics: " + e.getMessage());
        }
    }
}
