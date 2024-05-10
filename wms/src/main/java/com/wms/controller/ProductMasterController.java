package com.wms.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wms/product/api/")

@CrossOrigin(originPatterns="*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.PUT,RequestMethod.PATCH,RequestMethod.DELETE},allowedHeaders = {"Content-type"})

public class ProductMasterController {

}
