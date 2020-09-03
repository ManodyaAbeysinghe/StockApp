package com.im.stockapp.actions;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.im.stockapp.models.Item;
import com.im.stockapp.models.Supplier;
import com.im.stockapp.utils.DB;
import com.opensymphony.xwork2.ActionSupport;

public class SupplierAction extends ActionSupport{
	
	private Supplier supplier;
	private List<Supplier> itemList;
	
	
	public String execute() {
		itemList = (List<Supplier>)DB.list("Supplier");
		return SUCCESS;
	}

	
	public String add() {
		
		DB.save(supplier);
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
		    String filePath = servletContext.getRealPath("/uploads/");
		    File fileToCreate = new File(filePath, supplier.getPhotoFileName());
		    FileUtils.copyFile(supplier.getPhoto(), fileToCreate);
			
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}
		
		
		
		itemList =(List<Supplier>)DB.list("Supplier");
		return SUCCESS;
	}
	
	
	public String delete() {
		DB.delete(supplier);
		itemList =(List<Supplier>)DB.list("Supplier");
		return SUCCESS;
	}


	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}


	public List<Supplier> getItemList() {
		return itemList;
	}


	public void setItemList(List<Supplier> itemList) {
		this.itemList = itemList;
	}
	
	
	
	
	
}
