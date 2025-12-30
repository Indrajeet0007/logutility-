package com.EXTRAJEET.enums;

import java.util.Set;

public enum Team {
ROLE_CERT(Set.of(Permission.CREATE)),
ROLE_QA(Set.of(Permission.CREATE)),
ROLE_CCT(Set.of(Permission.CREATE)),
ROLE_ECST(Set.of(Permission.CREATE)),
ROLE_STPL(Set.of(Permission.CREATE)),
ROLE_L1(Set.of(Permission.CREATE)),
ROLE_L2(Set.of(Permission.CREATE)),
ROLE_L3(Set.of(Permission.CREATE)),
ROLE_ADMIN(Set.of(Permission.CREATE,Permission.DELETE));

	private final Set <Permission> permissions;
Team(Set<Permission> permissions) {
	// TODO Auto-generated constructor stub
	this.permissions=permissions;
}
public Set<Permission> getPermissions() {
	return permissions;
}


}
