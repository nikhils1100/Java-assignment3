package com.example.multiTenant;

public class TenantResolvingException extends Exception {
    public TenantResolvingException(Throwable throwable, String message) {
        super(message, throwable);
    }
}
