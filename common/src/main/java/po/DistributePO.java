package po;

import util.ListState;
import util.ListType;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/25 0025.
 */
public class DistributePO extends ListPO implements Serializable {
	private static final long serialVersionUID = 1L;//序列化编号
	
	//到达日期、托运订单条形码号、派送员
	private String arriveDate;
	private String orderNum;
	private String distributeHuman;
	
	/**
	 * 
	 * @param arriveDate
	 * @param orderNum
	 * @param distributeHuman
	 */
	public DistributePO(String arriveDate, String orderNum, String distributeHuman, ListState isCheck) {
		super(isCheck);
		this.arriveDate = arriveDate;
		this.orderNum = orderNum;
		this.distributeHuman = distributeHuman;
		setType(ListType.DISTRIBUTEINFO);
	}

	/**
	 * 到达日期
	 * @param arriveDate
	 */
	public void setArriveDate(String arriveDate){
		this.arriveDate=arriveDate;
	}
	
	/**
	 * 
	 * @return 到达日期
	 */
	public String getArriveDate(){
		return arriveDate;
	}
	
	/**
	 * 托运订单条形码号
	 * @param orderNum
	 */
	public void setOrderNum( String orderNum){
		this.orderNum=orderNum;
	}
	
	/**
	 * 
	 * @return 托运订单条形码号
	 */
	public String getOrderNum(){
		return orderNum;
	}
	
	/**
	 * 派送员
	 * @param distributeHuman
	 */
	public void setDistributeHuman(String distributeHuman){
		this.distributeHuman=distributeHuman;
	}
	
	/**
	 * 派送员
	 * @return
	 */
	public String getDistributeHuman(){
		return distributeHuman;
	}


}
