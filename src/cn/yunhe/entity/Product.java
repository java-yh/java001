/**
 * 
 */
package cn.yunhe.entity;

/**
 * @迪丽惹bug
 *
 * 2019年9月25日下午5:29:03
 */
public class Product {

	private int proid;
	private String proname;
	private String proprice;
	private String proaddress;
	private String proimage;
	public Product() {}
	/**
	 * @param proid
	 * @param proname
	 * @param proprice
	 * @param proaddress
	 * @param proimage
	 */
	public Product(int proid, String proname, String proprice, String proaddress, String proimage) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.proprice = proprice;
		this.proaddress = proaddress;
		this.proimage = proimage;
	}
	/**
	 * @return the proid
	 */
	public int getProid() {
		return proid;
	}
	/**
	 * @param proid the proid to set
	 */
	public void setProid(int proid) {
		this.proid = proid;
	}
	/**
	 * @return the proname
	 */
	public String getProname() {
		return proname;
	}
	/**
	 * @param proname the proname to set
	 */
	public void setProname(String proname) {
		this.proname = proname;
	}
	/**
	 * @return the proprice
	 */
	public String getProprice() {
		return proprice;
	}
	/**
	 * @param proprice the proprice to set
	 */
	public void setProprice(String proprice) {
		this.proprice = proprice;
	}
	/**
	 * @return the proaddress
	 */
	public String getProaddress() {
		return proaddress;
	}
	/**
	 * @param proaddress the proaddress to set
	 */
	public void setProaddress(String proaddress) {
		this.proaddress = proaddress;
	}
	/**
	 * @return the proimage
	 */
	public String getProimage() {
		return proimage;
	}
	/**
	 * @param proimage the proimage to set
	 */
	public void setProimage(String proimage) {
		this.proimage = proimage;
	}
	@Override
	public String toString() {
		return "Product [proid=" + proid + ", proname=" + proname + ", proprice=" + proprice + ", proaddress="
				+ proaddress + ", proimage=" + proimage + "]";
	}
	
}
