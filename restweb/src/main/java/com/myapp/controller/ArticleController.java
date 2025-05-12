package com.myapp.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.Article;

@Controller
public class ArticleController {
	private Logger logger;
	public ArticleController() {
		this.logger = Logger.getLogger(this.getClass());
	}

	
	@PostMapping(path = "/articleService", consumes = "application/json", produces = "application/json")
	public @ResponseBody Article postArticleService (@RequestHeader HttpHeaders httpHeaders, 
			@RequestBody Article art) {
		logger.info(httpHeaders.get("person"));
		logger.info(httpHeaders.getContentType());
		logger.info(httpHeaders.getAcceptLanguage());
		logger.info(httpHeaders.getContentLength());
		logger.info(httpHeaders.getConnection());
		logger.info(art);
		return art;
	}
}
