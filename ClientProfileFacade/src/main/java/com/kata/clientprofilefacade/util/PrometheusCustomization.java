package com.kata.clientprofilefacade.util;

import com.kata.clientprofilefacade.exception.MetricsProcessingException;
import eu.bitwalker.useragentutils.UserAgent;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PrometheusCustomization {

    private final MeterRegistry meterRegistry;

    public void add(HttpServletRequest request, String name) {

        try {
            String userAgentString = request.getHeader("User-Agent");
            UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
            String deviceType = userAgent.getOperatingSystem().getDeviceType().getName();
            String browserName = userAgent.getBrowser().getName();
            String ip = request.getRemoteAddr();

            if (userAgentString.startsWith("Postman")) {
                meterRegistry.counter(name + " Postman",
                                "ipAddress", ip,
                                "API platform", userAgentString)
                        .increment();
            } else {
                meterRegistry.counter(name + " Browser",
                                "ipAddress", ip,
                                "deviceType", deviceType,
                                "browserName", browserName)
                        .increment();
            }
        } catch (RuntimeException e) {
            throw new MetricsProcessingException("Failed to add metrics: " + e.getMessage());
        }

    }
}
