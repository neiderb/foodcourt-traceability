package com.foodcourt.traceability.domain.model.auth;

import com.foodcourt.traceability.domain.model.auth.enums.UserRole;

public record UserClaims(
	Long id,
	String email,
	UserRole role,
	Long idRestaurant
) {}
