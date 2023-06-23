package com.yedam.common;

public class PageDTO {
//전체글 수를 기준으로 페이지계산하는클래스
	
	private int startPage, endPage ;//ex) 3페이지면 1p  10p 라고 구현목적 
	private boolean prev ,next;
	
	private int total;
	private int curPage;
	
	public PageDTO(int curPage, int total) {
		this.curPage = curPage;
		this.total = total;
		this.endPage = (int)Math.ceil((double)curPage/10)*10;
		this.startPage = this.endPage-9;
		
		int realEnd = (int)(Math.ceil((double)total/10));
		
		if(realEnd <this.endPage){
			this.endPage = realEnd;
		}
		
		this.prev= this.startPage >1;
		this.next = this.endPage<realEnd;
	}

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", curPage=" + curPage + "]";
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}


	
}
