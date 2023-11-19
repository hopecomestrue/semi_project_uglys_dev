package com.veg.ojy.cart.dto;

public class CartAction {
	// 컨트롤러에서 비지니스 로직 처리하고 뷰 페이지로 넘길 때 필요한 정보를 저장하는 곳
	private String path;
	private boolean redirect;
	
	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public boolean isRedirect() {
		return redirect;
	}


	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}


	public CartAction(String path, boolean redirect) {
		super();
		this.path = path;
		this.redirect = redirect;
	}
	
	
	
}
