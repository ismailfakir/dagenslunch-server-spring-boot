package net.cloudcentrik.dagenslunch.exception;

/**
 * Created by DAM on 3/9/17.
 */

import lombok.Getter;
import lombok.Setter;


public class ResourceNotFoundException extends RuntimeException {


    private Long resourceId;

    public ResourceNotFoundException(Long resourceId, String resourceName) {
        super(resourceName+ " with id "+resourceId+" not found");
        this.resourceId = resourceId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}