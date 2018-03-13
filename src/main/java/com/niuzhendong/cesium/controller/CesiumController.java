package com.niuzhendong.cesium.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niuzhendong.cesium.service.ICesiumService;


@Controller  
@RequestMapping("/cesium")
public class CesiumController {
	@Resource
	private ICesiumService cesiumService;
	
	@RequestMapping("/login")  
    public ModelAndView toIndex(HttpServletRequest request,ModelAndView model){  
		Map<String,String> param = new HashMap<String,String>();
		param.put("username", request.getParameter("username"));
		param.put("password", request.getParameter("password"));
		try{
			List<Map<String, String>> user = this.cesiumService.getUser(param);
	        if(param.get("password").equals(user.get(0).get("password"))){
	        	model = new ModelAndView("./index");
	        	request.getSession().setAttribute("user", user.get(0).get("username"));
	        	request.getSession().setAttribute("pasd", user.get(0).get("password"));
	        }else{
	        	model = new ModelAndView("./login/login");
	        }
	        return model;  
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("./login/login");
		}
    }
}
