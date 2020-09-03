package com.im.stockapp.actions;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.im.stockapp.models.Customer;
import com.im.stockapp.utils.DB;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport{

	private Customer customer;
	private List<Customer> customerList;
	
	
	public String execute() {
		customerList = (List<Customer>)DB.list("Customer");
		return SUCCESS;
	}
	
	
	
	public String add() {
		
		DB.save(customer);
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
		    String filePath = servletContext.getRealPath("/uploads/");
		    File fileToCreate = new File(filePath, customer.getPhotoFileName());
		    FileUtils.copyFile(customer.getPhoto(), fileToCreate);
			
		}catch(Exception e) {
			e.printStackTrace();
			addActionError(e.getMessage());
			return INPUT;
		}
		
		
		
		customerList =(List<Customer>)DB.list("Customer");
		return SUCCESS;
	}
	
	public String delete() {
		DB.delete(customer);
		customerList =(List<Customer>)DB.list("Customer");
		return SUCCESS;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public List<Customer> getCustomerList() {
		return customerList;
	}



	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	
	
	
	

	
	
	
	
	
	
	
}
