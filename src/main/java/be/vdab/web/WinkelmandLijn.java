package be.vdab.web;

public interface WinkelmandLijn {
	void setProductId(long id);
	void setAantal(int aantal);
	long getProductId();
	int getAantal();
}
