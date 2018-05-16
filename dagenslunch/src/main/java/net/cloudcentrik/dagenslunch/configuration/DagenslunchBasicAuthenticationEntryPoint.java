package net.cloudcentrik.dagenslunch.configuration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.api.scripting.JSObject;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class DagenslunchBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();

        writer.println("Dagenslunch server response: HTTP Status 401 - " + authEx.getMessage());
        //writer.print(getBadrRequestResponse());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("dagenslunch");
        super.afterPropertiesSet();
    }

    @GetMapping
    public HashMap<String, Object> getBadrRequestResponse() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("server", "dagesnlunch");
        map.put("http_response_code", 401);
        map.put("response","Bad credentials");
        return map;
    }

}
