package com.cognizant.onlinefooddeliverysystem.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class ExtractIpFromRequest {
    /**
     * Extracts the client IP address from the request, considering proxy headers.
     * @param request The HttpServletRequest object.
     * @return The client IP address string, or null if unable to determine.
     */
    public String extractIpFromRequest(HttpServletRequest request) {
        String clientIp = request.getHeader("X-Forwarded-For");

        if (clientIp == null || clientIp.isEmpty() || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.isEmpty() || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (clientIp == null || clientIp.isEmpty() || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (clientIp == null || clientIp.isEmpty() || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (clientIp == null || clientIp.isEmpty() || "unknown".equalsIgnoreCase(clientIp)) {
            clientIp = request.getRemoteAddr(); // Fallback to direct connection IP
        }

        // Handle comma-separated IPs in X-Forwarded-For (take the first one)
        if (clientIp != null && clientIp.contains(",")) {
            clientIp = clientIp.split(",")[0].trim();
        }

        // Handle potential IPv6 loopback format "[0:0:0:0:0:0:0:1]" -> "0:0:0:0:0:0:0:1"
        if (clientIp != null && clientIp.equals("[0:0:0:0:0:0:0:1]")) {
            clientIp = "0:0:0:0:0:0:0:1";
        }

        return clientIp;
    }
}
