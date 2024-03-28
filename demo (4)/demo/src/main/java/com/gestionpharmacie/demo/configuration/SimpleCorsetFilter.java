package com.gestionpharmacie.demo.configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
//st utilisée pour spécifier l'ordre dans lequel
// les beans gérés par Spring doivent être initialisés ou invoqués.
//highest_precedence:
//ne constante prédéfinie dans l'interface Ordered de Spring qui indique
// la priorité la plus élevée.
@Order(Ordered.HIGHEST_PRECEDENCE)

public class SimpleCorsetFilter implements Filter  {
    @Override
    // le but de gérer les en-têtes CORS (Cross-Origin Resource Sharing).
    // CORS est une politique de sécurité implémentée par les navigateurs web qui contrôle l'accès
    // aux ressources d'une page web depuis un autre domaine.
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain Chain) throws IOException, ServletException {
        HttpServletResponse response =(HttpServletResponse) res;
        HttpServletRequest request =(HttpServletRequest) req;
        Map<String,String> map= new HashMap<>();
        String originHeader= request.getHeader("origin");
        response.setHeader("Access-Control-Allow-Origin",originHeader);
        response.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","*");
        //la méthode de la requête est OPTIONS, cela signifie que le navigateur
        //envoie une pré-vérification pour vérifier les autorisations CORS.
        //En répondant avec un statut 200 (SC_OK), le serveur indique au navigateur
        // que la demande OPTIONS est autorisée pour cette ressource.
        if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            Chain.doFilter(req,res);
        }
    }
    @Override
    public  void init(FilterConfig filterConfig){

    }

}
