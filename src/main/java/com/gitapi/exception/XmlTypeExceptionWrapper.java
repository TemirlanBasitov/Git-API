package com.gitapi.exception;

import com.fasterxml.jackson.databind.JsonMappingException;

public class XmlTypeExceptionWrapper extends RuntimeException{
    public XmlTypeExceptionWrapper(String  cause) {
        super(cause);
    }
}
