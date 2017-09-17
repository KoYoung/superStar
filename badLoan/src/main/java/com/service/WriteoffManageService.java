package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.entity.Repaymentinfo;
import com.entity.WriteoffManage;

public interface WriteoffManageService {
	/**
	 * 查询所有申请核销的贷款信息
	 * 
	 * @author Administrator
	 *
	 */
	List<WriteoffManage> findWriteoffManage();

	/**
	 * 根据贷款编号查询这笔贷款的所有回收记录
	 */
	List<Repaymentinfo> findReayment(String loaninfoId);

	/**
	 * 添加核销信息
	 */
	int addWriteoffManage(WriteoffManage write);

	/**
	 * 添加核销信息
	 */
	int addWriteoffManage(WriteoffManage write, HttpSession session);

	/**
	 * 根据贷款编号和贷款人姓名进行模糊查询
	 */
	List<WriteoffManage> findWriteM(String loaninfoId);
	/**
	 * 根据员工名称查询员工编号
	 */
	// List<Employee> findEmpId(String empName);
}