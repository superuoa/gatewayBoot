package com.yit.gateway.controller;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yit.gateway.util.EnvUtil;

@RestController
public class GatewayController {

	
	// inject it,
	@Autowired
	private EnvUtil envUtil;
	
	@RequestMapping("/")
    public Object restTest() throws UnknownHostException {

		Map<String, Object> map = new HashMap<>();
	    map.put("port", envUtil.getPort());
	    map.put("host", envUtil.getHostname());
	    return map;
    }
	
}
