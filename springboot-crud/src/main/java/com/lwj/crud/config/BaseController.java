package com.lwj.crud.config;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice(basePackages = "com.lwj.crud")
public class BaseController {
    protected final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

}
