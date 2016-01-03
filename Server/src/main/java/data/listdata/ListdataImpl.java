package data.listdata;

import data.Common.Common;
import dataservice.listdataservice.ListDataService;
import po.*;
import util.DeliveryType;
import util.ListState;
import util.TransportType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by MYK on 2015/11/23 0023.
 */
public class ListdataImpl extends UnicastRemoteObject implements ListDataService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ListdataImpl() throws RemoteException {
		super();
	}

	public Boolean save(OrderPO orderPO) throws RemoteException {
		Common common = new Common("order");
		String order = this.POToString(orderPO);
		ArrayList<String> list = common.readData();
		String[] str = order.split(";");
		boolean isEqual = true;
		for (int j = 0; j < list.size(); j++) {
			String[] strings = list.get(j).split(";");
			for (int i = 0; i < strings.length - 1; i++) {
				if (str[i] != strings[i]) {
					isEqual = false;
				}
			}
			if (isEqual) {
				list.remove(j);
				break;
			}

		}
		list.add(order);
		common.clearData("order");
		common.writeData(list);
		return true;
	}

	public Boolean save(AddresseeInformationPO addresseeInformationPO) throws RemoteException {
		Common common = new Common("addresseeInformation");
		common.writeDataAdd(this.POToString(addresseeInformationPO));
		return true;
	}

	public Boolean save(LoadingPO loadingPO) throws RemoteException {
		Common common = new Common("loading");
		common.writeDataAdd(this.POToString(loadingPO));
		return true;
	}

	public Boolean save(ReceivePO receivePO) throws RemoteException {
		Common common = new Common("receive");
		common.writeDataAdd(this.POToString(receivePO));
		return true;
	}

	public Boolean save(DistributePO distributePO) throws RemoteException {

		Common common = new Common("distribute");
		common.writeDataAdd(this.POToString(distributePO));
		return true;
	}

	public Boolean save(ReceiptPO receiptPO) throws RemoteException {

		Common common = new Common("receipt");
		common.writeDataAdd(this.POToString(receiptPO));
		return true;
	}

	public Boolean save(TransferPO transferPO) throws RemoteException {
		Common common = new Common("transfer");
		common.writeDataAdd(this.POToString(transferPO));
		return true;
	}

	public Boolean save(TransferReceivePO transferReceivePO) throws RemoteException {
		Common common = new Common("transferReceive");
		common.writeDataAdd(this.POToString(transferReceivePO));
		return true;
	}

	public Boolean save(StockOutPO stockOutPO) throws RemoteException {
		Common common = new Common("stockOut");
		common.writeDataAdd(this.POToString(stockOutPO));
		return true;
	}

	public Boolean save(StockInPO stockInPO) throws RemoteException {
		Common common = new Common("stockIn");
		common.writeDataAdd(this.POToString(stockInPO));
		return true;
	}

	public Boolean save(PaymentPO paymentPO) throws RemoteException {
		Common common = new Common("payment");
		common.writeDataAdd(this.POToString(paymentPO));
		return true;
	}

	public Boolean save(GatheringPO gatheringPO) throws RemoteException {
		Common common = new Common("gathering");
		common.writeDataAdd(this.POToString(gatheringPO));
		return true;
	}

	// public Boolean saveAsList(ListPO listPo) throws RemoteException {
	// Common common = new Common("list");
	// String str = "";
	// switch (listPo.getType()) {
	// case LOADINGINFO:
	// str = POToString((LoadingPO) listPo);
	// break;
	// case ADDRESSEEINFOMATION:
	// str = POToString((AddresseeInformationPO) listPo);
	// break;
	// case DISTRIBUTEINFO:
	// str = POToString((DistributePO) listPo);
	// break;
	// case GATHERING:
	// str = POToString((GatheringPO) listPo);
	// break;
	// case ORDER:
	// str = POToString((OrderPO) listPo);
	// break;
	// case PAYMENT:
	// str = POToString((PaymentPO) listPo);
	// break;
	// case RECEIPT:
	// str = POToString((ReceiptPO) listPo);
	// break;
	// case RECEIVEINFO:
	// str = POToString((ReceivePO) listPo);
	// break;
	// case STOCKIN:
	// str = POToString((StockInPO) listPo);
	// break;
	// case STOCKOUT:
	// str = POToString((StockOutPO) listPo);
	// break;
	// case TRANSARRIVE:
	// str = POToString((TransferReceivePO) listPo);
	// break;
	// case TRANSINFO:
	// str = POToString((TransferPO) listPo);
	// break;
	// default:
	// return false;
	// }
	// common.writeDataAdd(str);
	// return true;
	// }

	@Override
	public boolean saveAsList(ReceivePO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(LoadingPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(AddresseeInformationPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(DistributePO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(GatheringPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(OrderPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(PaymentPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(ReceiptPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(StockInPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(StockOutPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(TransferReceivePO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	@Override
	public boolean saveAsList(TransferPO po) throws RemoteException {
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		common.writeDataAdd(str);
		return true;
	}

	public ArrayList<ListPO> checkList() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("list");
		ArrayList<String> list = common.readData();
		ArrayList<ListPO> list2 = new ArrayList<ListPO>();
		ListPO listPO = null;
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.UNCHECK;
			if (str[1].equals("PASSED")) {
				isCheck = ListState.PASSED;
			} else if (str[1].equals("REJECTED")) {
				isCheck = ListState.REJECTED;
			}
			switch (str[0]) {
				case "LOADINGINFO":
					listPO = new LoadingPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11],
							isCheck);
					break;
				case "ADDRESSEEINFOMATION":
					listPO = new AddresseeInformationPO(str[2], str[3], str[4], isCheck);
					break;
				case "DISTRIBUTEINFO":
					listPO = new DistributePO(str[2], str[3], str[4], isCheck);
					break;
				case "GATHERING":
					listPO = new GatheringPO(str[2], str[3], str[4], str[5], str[6], isCheck);
					break;
				case "ORDER":
					DeliveryType deliveryType = DeliveryType.ECONOMIC;
					if (str[16].equals("FAST")) {
						deliveryType = DeliveryType.FAST;
					} else if (str[16].equals("STANDARD")) {
						deliveryType = DeliveryType.STANDARD;
					}
					listPO = new OrderPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11],
							str[12], str[13], str[14], str[15], deliveryType, str[17], str[18], str[19], str[20], str[21],
							str[22], isCheck);
					break;
				case "PAYMENT":
					listPO = new PaymentPO(str[2], str[3], str[4], str[5], str[6], str[7], isCheck);
					break;
				case "RECEIPT":
					ArrayList<String> list3 = new ArrayList<String>();
					for (int j = 5; j < str.length; j++) {
						list3.add(str[j]);
					}

					listPO = new ReceiptPO(str[2], str[3], str[4], list3, isCheck);
					break;
				case "RECEIVEINFO":
					listPO = new ReceivePO(str[2], str[3], str[4], str[5], isCheck);
					break;
				case "STOCKIN":
					listPO = new StockInPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], isCheck);
					break;
				case "STOCKOUT":
					TransportType transportType = TransportType.AIRPLANE;
					if (str[5].equals("CAR")) {
						transportType = TransportType.CAR;
					} else if (str[5].equals("TRAIN")) {
						transportType = transportType.TRAIN;
					}
					listPO = new StockOutPO(str[2], str[3], str[4], transportType, str[6], isCheck);
					break;
				case "TRANSARRIVE":
					listPO = new TransferReceivePO(str[2], str[3], str[4], str[5], str[6], isCheck);
					break;
				case "TRANSINFO":
					listPO = new TransferPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10],
							str[10], str[11], isCheck);
					break;
				case "RECEIVE":
					listPO = new ReceivePO(str[0], str[1], str[2], str[3], isCheck);
					break;
				default:
					return null;
			}// close the switch

			list2.add(listPO);
		}

		return list2;
	}

	@Override
	public ArrayList<AddresseeInformationPO> checkAddresseeInfo() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("addresseeInformation");
		ArrayList<String> list = common.readData();
		ArrayList<AddresseeInformationPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new AddresseeInformationPO(str[2], str[3], str[4], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<DistributePO> checkDistribute() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("distribute");
		ArrayList<String> list = common.readData();
		ArrayList<DistributePO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new DistributePO(str[2], str[3], str[4], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<GatheringPO> checkGathering() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("gathering");
		ArrayList<String> list = common.readData();
		ArrayList<GatheringPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new GatheringPO(str[2], str[3], str[4], str[5], str[6], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<OrderPO> checkOrder() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("order");
		ArrayList<String> list = common.readData();
		ArrayList<OrderPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			DeliveryType deliveryType = DeliveryType.ECONOMIC;
			if (str[16].equals("FAST")) {
				deliveryType = DeliveryType.FAST;
			} else if (str[16].equals("STANDARD")) {
				deliveryType = DeliveryType.STANDARD;
			}

			list1.add(new OrderPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11],
					str[12], str[13], str[14], str[15], deliveryType, str[17], str[18], str[19], str[20], str[21],
					str[22], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<PaymentPO> checkPayment() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("payment");
		ArrayList<String> list = common.readData();
		ArrayList<PaymentPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new PaymentPO(str[2], str[3], str[4], str[5], str[6], str[7], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<ReceiptPO> checkReceipt() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("receipt");
		ArrayList<String> list = common.readData();
		ArrayList<ReceiptPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			ArrayList<String> list3 = new ArrayList<String>();
			for (int j = 5; j < str.length; j++) {
				list3.add(str[j]);
			}

			list1.add(new ReceiptPO(str[2], str[3], str[4], list3, isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<StockInPO> checkStockIn() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("stockIn");
		ArrayList<String> list = common.readData();
		ArrayList<StockInPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new StockInPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<StockOutPO> checkStockOut() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("stockOut");
		ArrayList<String> list = common.readData();
		ArrayList<StockOutPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			TransportType transportType = TransportType.AIRPLANE;
			if (str[5].equals("CAR")) {
				transportType = TransportType.CAR;
			} else if (str[5].equals("TRAIN")) {
				transportType = transportType.TRAIN;
			}
			list1.add(new StockOutPO(str[2], str[3], str[4], transportType, str[6], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<TransferPO> checkTransfer() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("transfer");
		ArrayList<String> list = common.readData();
		ArrayList<TransferPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new TransferPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[10],
					str[11], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<TransferReceivePO> checkTransferReceive() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("transferReceive");
		ArrayList<String> list = common.readData();
		ArrayList<TransferReceivePO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new TransferReceivePO(str[2], str[3], str[4], str[5], str[6], isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<LoadingPO> checkLoading() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("loading");
		ArrayList<String> list = common.readData();
		ArrayList<LoadingPO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new LoadingPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11],
					isCheck));
		}
		return list1;
	}

	@Override
	public ArrayList<ReceivePO> checkReceive() throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("receive");
		ArrayList<String> list = common.readData();
		ArrayList<ReceivePO> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			ListState isCheck = ListState.PASSED;
			list1.add(new ReceivePO(str[0], str[1], str[2], str[3], isCheck));
		}
		return list1;
	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(OrderPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getSenderName() + ";" + po.getSenderAddress() + ";"
				+ po.getSenderWorkplace() + ";" + po.getSenderTelephone() + ";" + po.getSenderPhone() + ";"
				+ po.getReceiverName() + ";" + po.getReceiverAddress() + ";" + po.getReceiverWorkplace() + ";"
				+ po.getReceiverTelephone() + ";" + po.getReceiverPhone() + ";" + po.getOriginalNum() + ";"
				+ po.getWeight() + ";" + po.getVolume() + ";" + po.getGoods_Name() + ";" + po.getDeliveryType() + ";"
				+ po.getWrapper() + ";" + po.getExpenseOfTransport() + ";" + po.getExpenseOfWrapper() + ";"
				+ po.getExpense() + ";" + po.getDate() + ";" + po.getDeliveryNum() + ";" + po.getLogistics();
	}

	private String POToString(AddresseeInformationPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getAddresseeNum() + ";" + po.getAddresseeName() + ";"
				+ po.getAddresseeDate() + ";";

	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(LoadingPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getLoadingDate() + ";" + po.getHallNum() + ";"
				+ po.getTransportNum() + ";" + po.getStart() + ";" + po.getEnd() + ";" + po.getMonitor() + ";"
				+ po.getSupercargo() + ";" + po.getVehicleNum() + ";" + po.getConsignList() + ";"
				+ po.getTransportMoney() + ";";

	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(ReceivePO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getArriveDate() + ";" + po.getTransferNum() + ";"
				+ po.getStart() + ";" + po.getArriveDate() + ";";
	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(DistributePO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getArriveDate() + ";" + po.getOrderNum() + ";"
				+ po.getDistributeHuman() + ";";
	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(TransferPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getLoadingWay() + ";" + po.getLoadingDate() + ";"
				+ po.getTransportNum() + ";" + po.getVehicleNum() + ";" + po.getVehicleNum() + ";" + po.getStart() + ";"
				+ po.getEnd() + ";" + po.getContainerNum() + ";" + po.getMonitor() + ";" + po.getSupercargo() + ";"
				+ po.getOrderNum() + ";" + po.getMoney() + ";";
	}

	/**
	 * todo 写了两遍getArriveDate?
	 *
	 * @param po
	 * @return
	 */
	private String POToString(TransferReceivePO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getArriveDate() + ";" + po.getArriveDate() + ";"
				+ po.getStart() + ";" + po.getCargoState() + ";" + po.getTransferCenterNum() + ";"
				+ po.getTransferNum();
	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(StockOutPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getDeliveryNum() + ";" + po.getOutDate() + ";"
				+ po.getEnd() + ";" + po.getLoadingWay() + ";" + po.getTransferNum();
	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(StockInPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getDeliveryNum() + ";" + po.getInDate() + ";"
				+ po.getEnd() + ";" + po.getZoneNum() + ";" + po.getRowNum() + ";" + po.getShelfNum() + ";"
				+ po.getPositionNum();
	}

	/**
	 * @param po
	 * @return
	 */

	private String POToString(ReceiptPO po) {
		String s = po.getType() + ";" + po.getIsCheck() + ";" + po.getReceiptDate() + ";" + po.getReceiptMoney() + ";"
				+ po.getReceiptCourier() + ";";
		for (String s1 : po.getOrderNum()) {
			s = s + ";" + s1;
		}
		return s;
	}

	private String POToString(PaymentPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getPayDate() + ";" + po.getPayMoney() + ";"
				+ po.getPayHuman() + ";" + po.getPayAccount() + ";" + po.getPayReason() + ";" + po.getPayComment();
	}

	private int DateToInt(String date) {
		String[] str = date.split("-");
		for (int i = 1; i < str.length; i++) {
			str[0] = str[0] + str[i];
		}
		return Integer.parseInt(str[0]);
	}

	/**
	 * @param po
	 * @return
	 */
	private String POToString(GatheringPO po) {
		return po.getType() + ";" + po.getIsCheck() + ";" + po.getDate() + ";" + po.getWorkplace() + ";" + po.getMan()
				+ ";" + po.getMoney() + ";" + po.getPlace();
	}

	/**
	 * a
	 */
	public ExpenseAndDatePO getExpenseOfTransport(ExpenseAndDatePO expenseAndDate)
			throws RemoteException {
		double transport = 0;
		double wrapper = 0;

		// 计算运费和时间
		Common common = new Common("constant");
		ArrayList<String> list = common.readData();
		for (int i = 0; i < list.size(); i++) {
			String[] str = list.get(i).split(";");
			// System.out.println(expenseAndDate.getCity1());
			if (str[0].equals(expenseAndDate.getCity1()) && str[1].equals(expenseAndDate.getCity2())) {
				transport = Double.parseDouble(str[2]) * Double.parseDouble(str[3]) / 1000.0;
				Double days = Double.parseDouble(str[2]);
				expenseAndDate.setDays(days.intValue() / 300 + "");
				if (expenseAndDate.getDeliveryType() == DeliveryType.FAST) {
					transport = transport * 2;
				} else if (expenseAndDate.getDeliveryType() == DeliveryType.ECONOMIC) {
					transport = transport / 2;
				}
				expenseAndDate.setExpenseOfTransport(transport + "");
			}
		}

		// 计算包装费
		Common common2 = new Common("wrapper");
		ArrayList<String> list2 = common2.readData();
		for (int i = 0; i < list2.size(); i++) {
			String[] str2 = list2.get(i).split(";");
			// System.out.println(str2[0]);
			if (str2[0].equals(expenseAndDate.getWrapper())) {
				wrapper = Double.parseDouble(str2[1]) * Double.parseDouble(expenseAndDate.getVolume()) / 2.0;
				expenseAndDate.setExpenseOfWrap(wrapper + "");
				break;

			}
		}
		expenseAndDate.setExpense((wrapper + transport) + "");
		return expenseAndDate;
	}

	@Override
	public ArrayList<ListPO> getRecent(String start, String end) throws RemoteException {
		// TODO Auto-generated method stub
		int startDate = this.DateToInt(start);
		int endDate1 = this.DateToInt(end);
		Iterator<ListPO> list = this.checkList().iterator();
		ArrayList<ListPO> list2 = new ArrayList<>();
		while (list.hasNext()) {
			int date = 0;
			ListPO listPO = list.next();
			switch (listPO.getType()) {
				case LOADINGINFO:
					date = this.DateToInt(((LoadingPO) listPO).getLoadingDate());

					break;
				case ADDRESSEEINFOMATION:
					date = this.DateToInt(((AddresseeInformationPO) listPO).getAddresseeDate());
					break;
				case DISTRIBUTEINFO:
					date = this.DateToInt(((DistributePO) listPO).getArriveDate());
					break;
				case GATHERING:
					date = this.DateToInt(((GatheringPO) listPO).getDate());
					break;
				case ORDER:
					date = this.DateToInt(((OrderPO) listPO).getDate());
					break;
				case PAYMENT:
					date = this.DateToInt(((PaymentPO) listPO).getPayDate());
					break;
				case RECEIPT:
					date = this.DateToInt(((ReceiptPO) listPO).getReceiptDate());
					break;
				case RECEIVEINFO:
					date = this.DateToInt(((ReceivePO) listPO).getArriveDate());
					break;
				case STOCKIN:
					date = this.DateToInt(((StockInPO) listPO).getInDate());
					break;
				case STOCKOUT:
					date = this.DateToInt(((StockOutPO) listPO).getOutDate());
					break;
				case TRANSARRIVE:
					date = this.DateToInt(((TransferReceivePO) listPO).getArriveDate());
					break;
				case TRANSINFO:
					date = this.DateToInt(((TransferPO) listPO).getLoadingDate());
					break;
				default:
					return null;
			}
			if (date >= startDate && date <= endDate1) {
				list2.add(listPO);
			}
		}
		return list2;
	}

	@Override
	public boolean deleteList(AddresseeInformationPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(DistributePO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		// System.out.println("numdm");
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			// System.out.println("del");
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(GatheringPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(OrderPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		System.out.println(list.get(0));
		System.out.println(str);
		System.out.println(list.get(0) == str);
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			System.out.println("indata");

			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(PaymentPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(ReceiptPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(StockInPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(StockOutPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(TransferReceivePO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(ReceivePO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);

		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(LoadingPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteList(TransferPO po) throws RemoteException {
		po.setIsCheck(ListState.UNCHECK);
		Common common = new Common("list");
		String str = "";
		str = POToString(po);
		ArrayList<String> list = common.readData();
		if (list.contains(str)) {
			list.remove(str);
			common.clearData("list");
			common.writeData(list);
			return true;
		}
		return false;
	}

	@Override
	public OrderPO getOrder(String num) throws RemoteException {
		// TODO Auto-generated method stub
		Common common = new Common("order");
		ArrayList<String> list = common.readData();

		for (int j = 0; j < list.size(); j++) {
			String[] str = list.get(j).split(";");
			ListState isCheck = ListState.UNCHECK;
			DeliveryType deliveryType = DeliveryType.ECONOMIC;
			if (str[1].equals("PASSED")) {
				isCheck = ListState.PASSED;
			} else if (str[1].equals("REJECTED")) {
				isCheck = ListState.REJECTED;
			}

			if (str[16].equals("FAST")) {
				deliveryType = DeliveryType.FAST;
			} else if (str[16].equals("STANDARD")) {
				deliveryType = DeliveryType.STANDARD;
			}

			if (str[22].equals(num)) {
				return new OrderPO(str[2], str[3], str[4], str[5], str[6], str[7], str[8], str[9], str[10], str[11],
						str[12], str[13], str[14], str[15], deliveryType, str[17], str[18], str[19], str[20], str[21],
						str[22], isCheck, str[24]);
			}
		}
		return null;
	}

}
