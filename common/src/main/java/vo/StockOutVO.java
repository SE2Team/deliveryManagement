package vo;

import util.ListType;
import util.TransportType;

/**
 * Created by Administrator on 2015/10/26 0026.
 */
public class StockOutVO extends ListVO {
	private static final long serialVersionUID = 1L;// 序列化编号
	/**
	 * 快递编号、出库日期、目的地、装运形式（火车、飞机、汽车）、中转单编号
	 */
	private String deliveryNum;
	private String outDate;
	private String end;
	private TransportType transportType;
	private String transferNum;


	public StockOutVO(String deliveryNum, String outDate, String end,
					  TransportType transportType, String transferNum, boolean isCheck) {
		super(isCheck);
		this.deliveryNum = deliveryNum;
		this.outDate = outDate;
		this.end = end;
		this.transportType = transportType;
		this.transferNum = transferNum;
		setType(ListType.STOCKOUT);
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public String getDeliveryNum() {
		return deliveryNum;
	}

	public void setOutdate(String outDate) {
		this.outDate = outDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getEnd() {
		return end;
	}

	public void setLoadingWay(TransportType transportType) {
		this.transportType = transportType;
	}

	public TransportType getLoadingWay() {
		return transportType;
	}

	public void setTransferNum(String transferNum) {
		this.transferNum = transferNum;
	}

	public String getTransferNum() {
		return transferNum;
	}

	public TransportType getTransportType() {
		return transportType;
	}
}
