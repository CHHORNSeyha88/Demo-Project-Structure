package com.spring.demo_project.entity;

import java.time.Instant;
import java.util.List;

/**
 * Projection for {@link UserEntity}
 */
public interface UserEntityInfo {
    Long getId();

    Instant getCreatedDate();

    Instant getModifiedDate();

    String getName();

    String getUsername();

    String getEmail();

    String getBio();

    String getAvatar();

    String getAddress();

    String getPhone();

    RoleEntityInfo getRole();

    /**
     * Projection for {@link RoleEntity}
     */
    interface RoleEntityInfo {
        Long getId();

        String getName();

        List<PermissionEntityInfo> getPermissions();

        /**
         * Projection for {@link PermissionEntity}
         */
        interface PermissionEntityInfo {
            Long getId();

            String getName();

            String getModule();
        }
    }
}