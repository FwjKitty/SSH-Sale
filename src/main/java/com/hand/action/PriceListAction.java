package com.hand.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hand.model.CustomersInfo;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;
import com.hand.service.PriceListService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class PriceListAction extends ActionSupport {

	@Resource
	private PriceListService priceListService;
	private int pageSize = 10;
	private int pageNow;
	private int count;
	private CustomersInfo customersInfo;
	private PriceList priceList;
	private File priceListFile;
	private String priceListFileFileName;
	private String priceListFileContentType;
	
	public String show(){
		//List<PriceList> priceList = priceListService.getPriceListByPage(pageSize,1);
		//ServletActionContext.getRequest().setAttribute("priceListConfigs", priceList);
		this.setCount(priceListService.getCount());
		this.setPageNow(1);
		return "success";
	}
	public void getPageResult(){
		List<PriceList> priceList = priceListService.getPriceListByPage(pageSize,pageNow);
		JsonArray jsonArray = new JsonArray();
		JsonObject jsonObject = null;
		try {
			for (int i = 0; i < priceList.size(); i++) {
				jsonObject = new JsonObject();
//				jsonObject.addProperty("number", i+1);
				jsonObject.addProperty("priceListId", priceList.get(i).getPriceListId());
				jsonObject.addProperty("hyItem", priceList.get(i).getHyItem());
				jsonObject.addProperty("effectiveDateFrom", priceList.get(i).getEffectiveDateFrom().toString());
				jsonObject.addProperty("effectiveDateTo", priceList.get(i).getEffectiveDateTo().toString());
				jsonArray.add(jsonObject);
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			this.setCount(priceListService.getCount());
			this.setPageNow(pageNow);
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void search(){
		JsonArray priceLists = priceListService.searchPriceList(customersInfo,priceList);
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(priceLists.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void validateSearch() {
		if ((customersInfo.getCustomerCode() == null || customersInfo.getCustomerCode().trim().equals(""))
    		  &&(customersInfo.getType() == null || customersInfo.getType().trim().equals(""))
    		  &&(priceList.getHyItem() == null || priceList.getHyItem().trim().equals(""))){
    	  addFieldError("msg","请输入查询内容");
      	}
	}
	
	public void getCustomerCode(){
		JsonObject jsonObject = null;
		JsonArray jsonArray = new JsonArray();
		List<CustomersInfo> customerCodes = priceListService.getCustomerCodes();
		for(CustomersInfo customersInfo : customerCodes){
			jsonObject = new JsonObject();
			jsonObject.addProperty("customerId", customersInfo.getCustomerId().toString());
			jsonObject.addProperty("customerCode", customersInfo.getCustomerCode());
			jsonArray.add(jsonObject);
		}
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getPriceListHeader(){
		List<PriceListConfig> priceListConfigs = priceListService.getHeader(customersInfo.getCustomerId());
		JsonObject jsonObject = new JsonObject();
		for(int i=0; i<priceListConfigs.size(); i++){
			jsonObject.addProperty(priceListConfigs.get(i).getPriceListCol(),priceListConfigs.get(i).getDisplayName());
		}
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void importPriceListShow(){
		List<PriceListConfig> priceListConfigs = priceListService.getHeader(customersInfo);
		JsonObject jsonObject = new JsonObject();
		for(int i=0; i<priceListConfigs.size(); i++){
			jsonObject.addProperty(priceListConfigs.get(i).getPriceListCol(),priceListConfigs.get(i).getDisplayName());
		}
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void importPriceList(){
		String destPath = ServletActionContext.getServletContext().getRealPath("/")+"/upload/";
		System.out.println(destPath);
		File destFile = new File(destPath,priceListFileFileName);
		try {
			FileUtils.copyFile(priceListFile, destFile);
			System.out.println("destFile path:"+destFile.getAbsolutePath());
			System.out.println("priceListFile path:"+priceListFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//需要解析的Excel文件
		File file = new File("poi_test.xls");
		try {
			//创建Excel，读取文件内容
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));
			//读取默认第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			for(int i=0; i<lastRowNum; i++){
				HSSFRow row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				for(int j=0; j<lastCellNum; j++){
					HSSFCell cell = row.getCell(j);
					String value = cell.getStringCellValue();
					System.out.print(value+"\t");
				}
				System.out.println();
			}
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String getValue(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(cell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(cell.getStringCellValue());
        }
    }
	
	public List<String> getPriceListColumn() {
		List<String> priceListColumn = new ArrayList<String>();
		priceListColumn.add("hy_item");
		priceListColumn.add("effective_date_from");
		priceListColumn.add("effective_date_to");
		for(int i=1; i<31; i++){
			priceListColumn.add("user_def"+i);
		}
		return priceListColumn;
	}
	
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public CustomersInfo getCustomersInfo() {
		return customersInfo;
	}
	public void setCustomersInfo(CustomersInfo customersInfo) {
		this.customersInfo = customersInfo;
	}
	public PriceList getPriceList() {
		return priceList;
	}
	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}
	public File getPriceListFile() {
		return priceListFile;
	}
	public void setPriceListFile(File priceListFile) {
		this.priceListFile = priceListFile;
	}
	public String getPriceListFileFileName() {
		return priceListFileFileName;
	}
	public void setPriceListFileFileName(String priceListFileFileName) {
		this.priceListFileFileName = priceListFileFileName;
	}
	public String getPriceListFileContentType() {
		return priceListFileContentType;
	}
	public void setPriceListFileContentType(String priceListFileContentType) {
		this.priceListFileContentType = priceListFileContentType;
	}
}