package com.zhoukewei.nlp.service;

import java.util.List;

import com.zhoukewei.nlp.eneity.Case;

public interface SerchService {
	public List<Case> getSearchResult(String keyWord);
}
