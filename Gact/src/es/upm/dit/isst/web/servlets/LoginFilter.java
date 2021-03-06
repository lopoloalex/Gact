package es.upm.dit.isst.web.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import es.upm.dit.isst.web.dao.model.*;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config)
        throws ServletException {
    	System.out.println("Filtrado de peticiones iniciado");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        String requestPath = request.getRequestURI();
        
        String[] validNonAuthenticationUrls = { "FormLogin.jsp", "CrearProfesor.jsp",".css", ".js",".jpg",".png","Servlet" };
        
        if(session == null || (session.getAttribute("profesor") == null && session.getAttribute("adminLogged") == null)) {
        	boolean access = false;
        	for(String validUrl : validNonAuthenticationUrls) {
                if (requestPath.endsWith(validUrl)) {
                	chain.doFilter(req, res);
                	access = true;
                }
            }
        	
        	if(!access) {
        		response.sendRedirect(request.getContextPath() + "/FormLogin.jsp");
        	}
        	
        } else	{
        	
            if (hasAccess(session, requestPath)) {
            	chain.doFilter(req, res); // Usuario logeado, continua la petición
            } else {
            	response.sendRedirect(request.getHeader("referer")); // Página sin autenticacion
            }
        }
    }

    @Override
    public void destroy() {
        // Clean files
    }
    
    private boolean hasAccess(HttpSession session, String url) {
    	
    	String[] AdminPages = { };
    	String[] ResponsablePages = { };
    	String[] CoordinadorPages = { };
    	String[] validNonAuthenticationUrls = { "FormLogin.jsp", "CrearProfesor.jsp",".css", ".js",".jpg",".png","Servlet" };
        
        // Si no está logeado, no tiene acceso a nada
        if(session == null || (session.getAttribute("profesor") == null && session.getAttribute("adminLogged") == null)) {
        	System.out.println("Null");
        	return false;
        } else {
        	// El usuario está logeado
        	
        	// Si es root, se permite acceso a todas las páginas
            if(session.getAttribute("adminLogged") != null && (boolean)(session.getAttribute("adminLogged")) == true) {
            	return true;
            // Si es Responsable del departamento
            } else if(session.getAttribute("profesor") != null && session.getAttribute("isResponsable") != null && (boolean)(session.getAttribute("isResponsable")) == true) {
            	for(String validUrl : ResponsablePages) {
                    if (url.endsWith(validUrl)) {
                        return true;
                    }
                }
            	for(String validUrl : AdminPages) {
                    if (url.endsWith(validUrl)) {
                        return false;
                    }
                }
            	return true;
            // Si es Coordinador de alguna asignatura
            } else if(session.getAttribute("profesor") != null && session.getAttribute("isCoordinador") != null  && (boolean)(session.getAttribute("isCoordinador")) == true) {
            	for(String validUrl : CoordinadorPages) {
                    if (url.endsWith(validUrl)) {
                        return true;
                    }
                }
            	for(String validUrl : ResponsablePages) {
                    if (url.endsWith(validUrl)) {
                    	return false;
                    }
                }
            	for(String validUrl : AdminPages) {
                    if (url.endsWith(validUrl)) {
                        return false;
                    }
                }
            	return true;
            // Si es Profesor solamente
            } else {
            	for(String validUrl : CoordinadorPages) {
                    if (url.endsWith(validUrl)) {
                    	return false;
                    }
                }
            	for(String validUrl : ResponsablePages) {
                    if (url.endsWith(validUrl)) {
                    	return false;
                    }
                }
            	for(String validUrl : AdminPages) {
                    if (url.endsWith(validUrl)) {
                        return false;
                    }
                }
            	return true;
            }
        }
    }
}