package com.im.stockapp.actions;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.im.stockapp.models.Item;
import com.im.stockapp.utils.DB;
import com.opensymphony.xwork2.ActionSupport;


public class ItemAction extends ActionSupport{
	private Item item;
	private List<Item> itemList;
	
	public String execute() {
		itemList = (List<Item>)DB.list("Item");
		return SUCCESS;
	}
	
	public String add() {
		
		DB.save(item);
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
		    String filePath = servletContext.getRealPath("/uploads/");
		    File fileToCreate = new File(filePath, item.getPhotoFileName());
		    FileUtils.copyFile(item.getPhoto(), fileToCreate);
			
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}
		
		
		
		itemList =(List<Item>)DB.list("Item");
		return SUCCESS;
	}
	
	
	public String delete() {
		DB.delete(item);
		itemList =(List<Item>)DB.list("Item");
		return SUCCESS;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	
	
	
	

}
