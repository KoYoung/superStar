package com.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.entity.Dept;
import com.entity.Emp;
import com.service.EmpService;

@Controller
@RequestMapping("/Emp")
public class EmpConntroller {
	@Autowired
	private EmpService es;
	@RequestMapping("/findEmp")
	private void findDept(HttpServletResponse resp){
		System.out.println("-----------------------------------");
		List<Emp> DeptList = es.findEmp();
		String listJSON = JSON.toJSONString(DeptList);
		try {
			resp.getWriter().write(listJSON);
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private int addEmp(){
		return 0;
	}
	private int modify(){
		return 0;
		
	}
}