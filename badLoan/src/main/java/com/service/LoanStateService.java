package com.service;

import java.util.List;
import java.util.Map;

public interface LoanStateService {
	List<Map<String, String>> findLoanState();
}