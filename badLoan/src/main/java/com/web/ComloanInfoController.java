package com.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.entity.Borgua;
import com.entity.ComloanInfo;
import com.entity.CustomerGoods;
import com.entity.Guarantor;
import com.entity.LoanManageRecord;
import com.entity.Loanmanage;
import com.entity.Pledge;
import com.service.ComloanInfoService;
import com.util.FileUpload;
import com.util.Paging;
import com.util.PagingResult;
import com.util.UrlUtil;

@Controller
@RequestMapping("/ComloanInfo")
public class ComloanInfoController {
	@Autowired
	private ComloanInfoService comloanInfoService;

	/**
	 * 添加企业贷款信息
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/addComloanInfo")
	@ResponseBody
	public String addComloanInfo(@RequestParam("borPhoto") MultipartFile[] borPhotos, HttpServletRequest request,
			ComloanInfo comloanInfo, Pledge pledge, CustomerGoods customerGoods, Guarantor guarantor, Borgua borgua,
			LoanManageRecord lmr, Loanmanage lonm) throws IOException {
		List files = FileUpload.uploadFile1(borPhotos, request);
		System.out.println("-----------------------");
		String phonePath = "";
		for (int i = 0; i < files.size(); i++) {

			phonePath = phonePath + files.get(i).toString() + ",";
			// 保存文件
		}
		pledge.setPledgePhoto(phonePath);
		System.out.println("zhaopi=a==n=====" + pledge.getPledgePhoto());
		int flag = comloanInfoService.addComloanInfo(comloanInfo, pledge, customerGoods, guarantor, borgua, lmr, lonm);
		if (flag > 0) {
			return "add Success";
		} else {
			return "add error";
		}

	}

	/**
	 * 查询企业贷款信息
	 */
	@RequestMapping("/findComloanInfo")
	@ResponseBody
	public PagingResult<ComloanInfo> findComloanInfo(Integer page, Integer rows) {
		List<ComloanInfo> comList = comloanInfoService.findComloanInfo();
		Paging<ComloanInfo> paging = new Paging<ComloanInfo>();
		List<ComloanInfo> list = paging.paging(comList, rows, page);
		PagingResult<ComloanInfo> pr = new PagingResult<ComloanInfo>();
		pr.setRows(list);
		pr.setTotal(comList.size());
		return pr;
	}

	/**
	 * 合同编号唯一性验证
	 */
	@RequestMapping("/findContractIdCom")
	@ResponseBody
	public boolean findContractIdCom(String contractId) {
		System.out.println("comList--" + contractId);
		List<ComloanInfo> comList = comloanInfoService.findContractIdCom(contractId);
		System.out.println("*******comList.size()********" + comList.size());
		if (comList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	@RequestMapping("/findComLoan")
	@ResponseBody
	public PagingResult<Map<String, String>> findComLoan(@RequestBody String data, @RequestParam Integer page,
			Integer rows) {
		data = UrlUtil.getURLDecoderString(data);
		System.out.println(data);
		// 将获取到的表单序列化数据拼装成JSON字符串，并转为MAP
		data = "{" + data.replace("&", "\",").replace("=", ":\"") + "\"}";
		System.out.println(data);
		Map<String, String> datamap = JSON.parseObject(data, Map.class);
		System.out.println(datamap);
		List<Map<String, String>> findBorSearch = comloanInfoService.findComLoan(datamap);

		Paging<Map<String, String>> pagingMap = new Paging<Map<String, String>>();
		List<Map<String, String>> list1 = pagingMap.paging(findBorSearch, rows, page);
		PagingResult<Map<String, String>> pResult = new PagingResult<Map<String, String>>();
		pResult.setTotal(findBorSearch.size());
		pResult.setRows(list1);
		System.out.println(pResult);
		System.out.println(findBorSearch);
		return pResult;
	}

	@RequestMapping("/modifyComState")
	@ResponseBody
	public String modifyComState(@RequestBody String data) {
		Map<String, String> datamap = JSON.parseObject(data, Map.class);
		comloanInfoService.modifyComState(datamap);
		return "success";
	}
}
