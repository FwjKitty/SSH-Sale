package com.hand.action;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.URLEncoder;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.hand.model.CustomersInfo;
import com.hand.model.PriceList;
import com.hand.model.PriceListConfig;
import com.hand.service.PriceListService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

@Controller
public class PriceListAction extends ActionSupport {

	@Resource
	private PriceListService priceListService;
	private int pageSize = 10;
	private int pageNow;
	private int count;
	private CustomersInfo customersInfo;
	private PriceList priceList;
	private List<PriceList> priceLists;
	private File priceListFile;
	private String priceListFileFileName;
	private String priceListFileContentType;
	List<String> displayNames;
	List<String> priceListCols;
	List<Integer> priceListIds;
	
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
				jsonObject.addProperty("priceListId", priceList.get(i).getPrice_list_id());
				jsonObject.addProperty("hyItem", priceList.get(i).getHy_item());
				jsonObject.addProperty("effectiveDateFrom", priceList.get(i).getEffective_date_from().toString());
				jsonObject.addProperty("effectiveDateTo", priceList.get(i).getEffective_date_to().toString());
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
    		  &&(priceList.getHy_item() == null || priceList.getHy_item().trim().equals(""))){
    	  addFieldError("msg","请输入查询内容");
      	}
	}
	
	public void getCustomerCode(){
		try {
			JsonObject jsonObject = null;
			JsonArray jsonArray = new JsonArray();
			List<CustomersInfo> customerCodes = priceListService.getCustomerCodes();
			for(CustomersInfo customersInfo : customerCodes){
				jsonObject = new JsonObject();
				jsonObject.addProperty("customerId", customersInfo.getCustomerId().toString());
				jsonObject.addProperty("customerCode", customersInfo.getCustomerCode());
				jsonArray.add(jsonObject);
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
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
	
	public void update(){
		int result = priceListService.updateList(priceLists);
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			String msg = "";
			if(result == 1){
				msg = "保存成功！";
			}else{
				msg = "保存数据失败，请重新操作！";
			}
			response.getWriter().write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void save(){
		try{
			int result = priceListService.saveList(priceLists);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			JsonObject jsonObject = new JsonObject();
			if(result == 1){
				jsonObject.addProperty("msg", "保存成功！");
			}else{
				jsonObject.addProperty("msg", "保存数据失败，请重新添加！");
			}
			jsonObject.addProperty("number", String.valueOf(priceLists.size()));
			response.getWriter().write(jsonObject.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void importPriceListShow(){
		List<PriceListConfig> priceListConfigs = priceListService.getHeader(customersInfo);
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("customersInfo.customerId", priceListConfigs.get(0).getCustomersInfo().getCustomerId());
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
		String destPath = ServletActionContext.getServletContext().getRealPath("/")+"upload/";
		System.out.println(destPath);
		try {
			//需要解析的Excel文件
			File destFile = new File(destPath,priceListFileFileName);
			FileUtils.copyFile(priceListFile, destFile);
			System.out.println(destFile.getAbsolutePath());
			//创建Excel，读取文件内容
			HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(destFile));
			//读取默认第一个工作表sheet
			HSSFSheet sheet = workbook.getSheetAt(0);
			//获取sheet中最后一行行号
			int lastRowNum = sheet.getLastRowNum();
			
			JsonArray jsonArray = new JsonArray();
			JsonObject jsonObject = null;
			
			for(int i=1; i<lastRowNum; i++){
				jsonObject = new JsonObject();
				HSSFRow row = sheet.getRow(i);
				int lastCellNum = row.getLastCellNum();
				for(int j=0; j<lastCellNum; j++){
					HSSFCell cell = row.getCell(j);
					String value = getValue(cell);
					jsonObject.addProperty("column"+(j+1), value);
				}
				jsonArray.add(jsonObject);
			}
			workbook.close();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportPriceList(){
		try {
			//创建Excel工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			//创建一个工作表sheet
			XSSFSheet sheet = workbook.createSheet();
			//创建第一行【表头】
			Row headRow = sheet.createRow(0);
			Cell cell = null;
			//插入第一行数据【表头】
			for(int i=0; i<displayNames.size(); i++){
				cell = headRow.createCell(i);
				cell.setCellValue(displayNames.get(i));
			}
			//追加数据
			List<Object[]> list = priceListService.getExportPriceList(priceListCols.get(0), priceListIds);
			String cellValue = null;
			
			for(int i=1; i<=priceListIds.size(); i++){
				Row nextRow = sheet.createRow(i);
				Object[] obj = list.get(i-1);
				for(int j=0; j<displayNames.size(); j++){
					cell = nextRow.createCell(j);
					if(j == 0){
						cell.setCellValue(i);
					}else{
						cell.setCellValue(obj[j-1].toString());
					}
				}
			}
			
			//创建一个文件并response
			String temPath = "E:\\template\\";
			File file = new File(temPath+"temFile.xlsx");
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
			workbook.close();
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/x-download;charset=UTF-8");
		    response.setHeader("Content-Disposition","attachment;filename=\"" + URLEncoder.encode("价格表.xlsx", "UTF-8") + "\"");
		    response.setContentLength(Integer.valueOf(((Long)file.length()).toString()));
			//输入流 读取目标文件
			FileInputStream fis=new FileInputStream(file);
			int len=-1;
			byte[] data=new byte[1024];
			ByteArrayOutputStream bos=new ByteArrayOutputStream(1024);
			//文件读到最末尾 返回-1
			while((len=fis.read(data))!=-1){
				//将服务器中的数据 转换成二进制数组 放入内存中
				bos.write(data,0,len);
			}
			//将服务器上的文件转换成二进制数组
			OutputStream out = new BufferedOutputStream(response.getOutputStream());
			//从服务器拿到数据向客户端写入
			out.write(bos.toByteArray());
			//清空内存文件
			out.flush();
			//关闭输出流、输入流
			out.close();
			fis.close();
		} catch (Exception e) {
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
	public List<PriceList> getPriceLists() {
		return priceLists;
	}
	public void setPriceLists(List<PriceList> priceLists) {
		this.priceLists = priceLists;
	}
	public List<String> getDisplayNames() {
		return displayNames;
	}
	public void setDisplayNames(List<String> displayNames) {
		this.displayNames = displayNames;
	}
	public List<String> getPriceListCols() {
		return priceListCols;
	}
	public void setPriceListCols(List<String> priceListCols) {
		this.priceListCols = priceListCols;
	}
	public List<Integer> getPriceListIds() {
		return priceListIds;
	}
	public void setPriceListIds(List<Integer> priceListIds) {
		this.priceListIds = priceListIds;
	}
}