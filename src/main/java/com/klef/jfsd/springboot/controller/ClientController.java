package com.klef.jfsd.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("SpringMVC")
public class ClientController {
	
	@GetMapping("/greet")
	@ResponseBody
	public String greet(@RequestParam("username") String uname)
	{
		return "Hii..Welcome "+uname;
	}

	@GetMapping("/about")
	public ModelAndView about()
	{
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("about");
		return mv;
	}
	
	@GetMapping("/demo1")
	public ModelAndView demo1(@RequestParam("age") int a,@RequestParam("country") String c)
	{
		String msg1= Integer.toString(a);
		String msg2=c;
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("message1", msg1);
		mv.addObject("message2", msg2);
		mv.setViewName("demo1");
		return mv;
	}
	@GetMapping("/demo2/{a}/{b}")
	public String demo2(@PathVariable("a") int x,@PathVariable("b") int y)
	{
		int sub = x-y;
		int div=x/y;
		String str1 = Integer.toString(sub);
		String str2 = Integer.toString(div);
		return "Sub value="+str1+"Div value="+str2;
	}
	@GetMapping("productform")
	public ModelAndView product()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("productform");
		return mv;
	}
	
	@GetMapping("/multiplyNumbers")
	public ModelAndView multiplyNumbers(@RequestParam("num1") int a,@RequestParam("num2") int b)
	{
		int result=a*b;
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("output", result);
		mv.setViewName("multiplyNumbers");
		return mv;
	}
	
	@GetMapping("/reverse")
	public ModelAndView reverse(@RequestParam("str1") String a,@RequestParam("str2") String b)
	{
		String str= a;
		a=b;
		b=str;
		String msg1=a;
		String msg2=b;
		ModelAndView mv= new ModelAndView();
		mv.addObject("output1", msg1);
		mv.addObject("output2", msg2);
		mv.setViewName("reverse");
		return mv;
	}
	
	
	
	@GetMapping("/calculate")
	public ModelAndView calculate(@RequestParam("num1") int a,@RequestParam("num2") int b)
	{
		int result1=a+b;
		int result2=a-b;
		ModelAndView mv= new ModelAndView();
		mv.addObject("output1", result1);
		mv.addObject("output2", result2);
		mv.setViewName("calculate");
		return mv;
	}
	
	
	
}
