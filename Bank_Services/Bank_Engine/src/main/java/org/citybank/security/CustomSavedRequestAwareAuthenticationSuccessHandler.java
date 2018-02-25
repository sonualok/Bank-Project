//package org.citybank.security;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//import org.springframework.util.StringUtils;
//
//public class CustomSavedRequestAwareAuthenticationSuccessHandler 
//                                       extends SimpleUrlAuthenticationSuccessHandler{
//	
//	 private RequestCache requestCache = new HttpSessionRequestCache();
//	    
//	 @Override
//	 public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//	         Authentication authentication) throws IOException, ServletException {
//	      final SavedRequest savedRequest = requestCache.getRequest(request, response);
//	      
//	      if (savedRequest == null) {
//	          clearAuthenticationAttributes(request);
//	          return;
//	      }
//	      final String targetUrlParameter = getTargetUrlParameter();
//	      if (isAlwaysUseDefaultTargetUrl()
//	              || (targetUrlParameter != null && StringUtils.hasText(request
//	                      .getParameter(targetUrlParameter)))) {
//	          requestCache.removeRequest(request, response);
//	          clearAuthenticationAttributes(request);
//	          return;
//	      }
//	  
//	      clearAuthenticationAttributes(request);
//	  }
//	  
//	  public void setRequestCache(final RequestCache requestCache) {
//	      this.requestCache = requestCache;
//	  }
//}
