package com.sppot.sid.security;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccess implements AuthenticationSuccessHandler{
	private RedirectStrategy strategy=new DefaultRedirectStrategy();

	@Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication)
            throws IOException, ServletException {
        Collection<GrantedAuthority> authorities= (Collection<GrantedAuthority>) authentication.getAuthorities();

        authorities.forEach(grantedAuthority ->{
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_MEMBRE":
                    try {
                        strategy.sendRedirect(httpServletRequest, httpServletResponse, "/");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "ROLE_LOCATAIRE":
                    try {
                        strategy.sendRedirect(httpServletRequest, httpServletResponse, "locataire");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "ROLE_ADMIN":
                    try {
                        strategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case "ROLE_RESAGENCE":
                    try {
                        strategy.sendRedirect(httpServletRequest, httpServletResponse, "/respAgence");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    throw new IllegalStateException();
            }
            HttpSession session = httpServletRequest.getSession();
            session.setMaxInactiveInterval(10*60);
        });
    }


}
