package com.vnsoft.server.tags.yui;

import java.util.Arrays;
import java.util.List;

import javax.servlet.jsp.JspException;

import com.vnsoft.server.util.ObjectUtil;

public class DataTableTag extends YUICustomTag{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030534879341277525L;
	private List<Object> data;
	private String displayedColumnsAndLabels;//columns:labels;column2:label2
	private String columnsFormat;//column:checked;column:date[format];column:input;column:list
	private String columns;//column1,column2,...
	private String returnValueOfColumns;//column1,column2,...
	private String containerId;//divId
	private String sortableColumns;//'column1','column2'
	private String sortBy;//column
	private String callBackButton;
	private String callBack;
	
	public List<Object> getData() {
		return data;
	}
	public void setData(List<Object> data) {
		this.data = data;
	}
	public String getDisplayedColumnsAndLabels() {
		return displayedColumnsAndLabels;
	}
	public void setDisplayedColumnsAndLabels(String displayedColumnsAndLabels) {
		this.displayedColumnsAndLabels = displayedColumnsAndLabels;
	}
	public String getColumnsFormat() {
		return columnsFormat;
	}
	public void setColumnsFormat(String columnsFormat) {
		this.columnsFormat = columnsFormat;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			if(data == null || data.isEmpty())
				return EVAL_PAGE;
			
			String tableName = "table";
			String dataTableVar = "dataTable";
			String dataTable = ObjectUtil.objectToJSONDataTable(data,Arrays.asList(columns.split(",")),dataTableVar);
			if(returnValueOfColumns == null || returnValueOfColumns.isEmpty())
				returnValueOfColumns = columns;
			String dataTableYUI = getYUIDataTable(getContainerId(),tableName,dataTableVar,displayedColumnsAndLabels,returnValueOfColumns, getSortableColumns(),getSortBy(),callBackButton,callBack);
			StringBuilder yuiJs = new StringBuilder();
			yuiJs.append("<div id=\""+containerId+"\"></div>\n");
			yuiJs.append("<script type=\"text/javascript\">").append(NEWLINE)
			.append("YUI({ filter: 'raw' }).use(\"selector-css3\", \"datatable-sort\", \"datatable-scroll\", \"cssbutton\", function (Y) {").append(NEWLINE);
			yuiJs.append(dataTable).append(NEWLINE)
			.append(dataTableYUI).append(NEWLINE);
			yuiJs.append("});").append(NEWLINE);
			yuiJs.append("</script>").append(NEWLINE);
//			System.out.println(yuiJs.toString());
			print(yuiJs.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	
	
	
	
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}
	public String getContainerId() {
		return containerId;
	}
	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}
	public String getSortableColumns() {
		return sortableColumns;
	}
	public void setSortableColumns(String sortableColumns) {
		this.sortableColumns = sortableColumns;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getCallBack() {
		return callBack;
	}
	public void setCallBack(String callBack) {
		this.callBack = callBack;
	}
	public String getCallBackButton() {
		return callBackButton;
	}
	public void setCallBackButton(String callBackButton) {
		this.callBackButton = callBackButton;
	}
	public String getReturnValueOfColumns() {
		return returnValueOfColumns;
	}
	public void setReturnValueOfColumns(String returnValueOfColumns) {
		this.returnValueOfColumns = returnValueOfColumns;
	}
}
