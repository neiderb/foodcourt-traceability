package com.foodcourt.traceability.domain.gateways;

import com.foodcourt.traceability.domain.model.auth.UserClaims;

public interface TokenServiceGateway {
	
	UserClaims parseToken(String token);
	
}
