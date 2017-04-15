package com.vnsoft.server.tags.yui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

import com.vnsoft.server.tags.yui.YUIJavaScript.TYPE;

public class TableTag extends YUICustomTag {
	private static final String CHECKBOX_COLUMN_NAME = "checkboxColumnName";
	private static final String NEW_LINE = "\n";
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030534879341277525L;
	private String columns;// column1[type]:label,column2:label,...
	private String sortableColumns;// column1,column2,...
	private String returnValueOfColumns;//column1,column2,..
	private String containerId;// divId
	private String callBackMethod;
	private String callBackButtonId;
	private String queryJsonDataUrl;
	private String sortByColumns;
	private boolean tableWithCheckBox = false;
	@Override
	public int doEndTag() throws JspException {
		Map<String,String> cols = new HashMap<String, String>();
		for(String col : columns.split(",")){
			String[] tmp = col.split(":");
			if(tmp.length != 2)
				throw new JspException("Colums must have format filename:lable for ex: name:Name");
			cols.put(tmp[0], tmp[1]);
		}
		print(getYUIDataTableJSTemplate(getQueryJsonDataUrl(),cols, containerId));
		return EVAL_PAGE;
	}

	public String getYUIDataTableJSTemplate(String queryJsonDataUrl, Map<String,String> columns, String divContainserID){
		StringBuilder resultFields = new StringBuilder();
		for(String col : columns.keySet()){
			if(col.indexOf("[") > 0 && col.indexOf("]") > 0){
				resultFields.append("        \""+col.substring(0,col.indexOf("["))+"\",").append(NEW_LINE);
			}else{
				resultFields.append("        \""+col+"\",").append(NEW_LINE);
			}
		}
		String jsTemplate = YUIJavaScript.getJavaScriptPattern(TYPE.TABLE);
		jsTemplate = jsTemplate.replace("{url}", queryJsonDataUrl);
		jsTemplate = jsTemplate.replace("{resultFields}", resultFields.toString().substring(0, resultFields.toString().length()-2));
		Map<String, String> data = buildColumns();
		jsTemplate = jsTemplate.replace("{columns}", data.get("columns"));
		jsTemplate = jsTemplate.replace("{sortable}", buildSortableColumns(sortableColumns));
		jsTemplate = jsTemplate.replace("{sortBy}", getSortBy(getSortByColumns()));
		jsTemplate = jsTemplate.replace("{recordType}", getDataTableColumnsName(this.columns));
		jsTemplate = jsTemplate.replace("{div_id}", getContainerId());
		jsTemplate = jsTemplate.replace("{callback}", getCallBackMethod());
		jsTemplate = jsTemplate.replace("{callbackBtnId}", getCallBackButtonId());
		if(data.get(CHECKBOX_COLUMN_NAME)!=null)
			jsTemplate = jsTemplate.replace("{checkbox-column}", data.get(CHECKBOX_COLUMN_NAME));
		else
			jsTemplate = jsTemplate.replace("{checkbox-column}", "nocheckbox");
//		System.out.println(jsTemplate.toString());
		return jsTemplate.toString();
	}
	private Map<String, String> buildColumns() {
		Map<String, String> data = new HashMap<>();
		String[] columns = this.columns.split(",");
		StringBuilder result = new StringBuilder();
		for(String column: columns){
			String[] columnLabelPair = column.split(":");
			if(columnLabelPair[0].indexOf("[") > 0 && columnLabelPair[0].indexOf("]") > 0){
				String type = columnLabelPair[0].substring(columnLabelPair[0].indexOf("[")+1, columnLabelPair[0].indexOf("]"));
				if("checkbox".equals(type)){
					result.append("{key:").append("'"+columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("["))+"'");
					result.append(",formatter:checkBox").append(NEWLINE);
					result.append(",label:").append("'"+columnLabelPair[1]+"<input id=\"id-all\" type=\"checkbox\" class=\"protocol-"+columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("["))+"-all\" title=\"Toggle ALL records\"/>'").append(",allowHTML: true").append("},").append(NEWLINE);
					//FIXME: Now we support only one checkbox in the table.
					data.put(CHECKBOX_COLUMN_NAME, columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("[")));
				}else if("image".equals(type)){
					result.append("		{key:").append("'"+columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("["))+"'");
					result.append(", formatter:").append("image").append(NEWLINE);
					result.append(", label:").append("'"+columnLabelPair[1]+"'").append(", allowHTML: true },").append(NEWLINE);
				}else{
					result.append("		{key:").append("'"+columnLabelPair[0]+"'");
					result.append(",label:").append("'"+columnLabelPair[1]+"'").append("},").append(NEWLINE);
				}
			}else{
				result.append("		{key:").append("'"+columnLabelPair[0]+"'")
					  .append(",label:").append("'"+columnLabelPair[1]+"'},").append(NEWLINE);
			}
		}
		data.put("columns", result.toString().substring(0,result.toString().length()-2));
		return data;
	}

	private String buildSortableColumns(String columns) {
		StringBuilder tmp = new StringBuilder();
		String[] cols = columns.split(",");
		int count = 0;
		for(String col : cols){
			count ++;
			if(col.indexOf("[")>0 && col.indexOf("]") > 0)
				col = col.substring(0,col.indexOf("["));
			
			if(count < cols.length){
				tmp.append("'"+col+"',");
			}else{
				tmp.append("'"+col+"'");
			}
		}
		return tmp.toString();
	}

	private String getSortBy(String columns) {
		return buildSortableColumns(columns);
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

	@Override
	protected void print(String content) {
		super.print(content);
	}

	public String getReturnValueOfColumns() {
		return returnValueOfColumns;
	}

	public void setReturnValueOfColumns(String returnValueOfColumns) {
		this.returnValueOfColumns = returnValueOfColumns;
	}

	public String getCallBackMethod() {
		return callBackMethod;
	}

	public void setCallBackMethod(String callBackMethod) {
		this.callBackMethod = callBackMethod;
	}

	public String getCallBackButtonId() {
		return callBackButtonId;
	}

	public void setCallBackButtonId(String callBackButtonId) {
		this.callBackButtonId = callBackButtonId;
	}

	public String getSortableColumns() {
		return sortableColumns;
	}

	public void setSortableColumns(String sortableColumns) {
		this.sortableColumns = sortableColumns;
	}

	public String getQueryJsonDataUrl() {
		return queryJsonDataUrl;
	}

	public void setQueryJsonDataUrl(String queryJsonDataUrl) {
		this.queryJsonDataUrl = queryJsonDataUrl;
	}

	public String getSortByColumns() {
		return sortByColumns;
	}

	public void setSortByColumns(String sortByColumns) {
		this.sortByColumns = sortByColumns;
	}

	public boolean isTableWithCheckBox() {
		return tableWithCheckBox;
	}

	public void setTableWithCheckBox(boolean tableWithCheckBox) {
		this.tableWithCheckBox = tableWithCheckBox;
	}
	public static void main(String[] args) {
		String columns = "ismain[checkbox]:asdsd";
		String[] columns2 = columns.split(",");
		StringBuilder result = new StringBuilder();
		for(String column: columns2){
			String[] columnLabelPair = column.split(":");
			if(columnLabelPair[0].indexOf("[") > 0 && columnLabelPair[0].indexOf("]") > 0){
				System.out.println("ga");
				String type = columnLabelPair[0].substring(columnLabelPair[0].indexOf("[")+1, columnLabelPair[0].indexOf("]"));
				System.out.println(type);
				if("checkbox".equals(type)){
					result.append("	 {key:").append("'"+columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("["))+"'");
					result.append(", formatter:checkBox,").append("'<input type=\"checkbox\" name=\"item\" value=\"{value}\">',").append(NEWLINE);
					result.append(", allowHTML:  true,").append(NEWLINE);
				}else if("image".equals(type)){
					result.append("		{key:").append("'"+columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("["))+"'");
					result.append(", formatter:").append("'<img src=\"{value}\">',").append(NEWLINE);
				}else{
					result.append("		{key:").append("'"+columnLabelPair[0]+"'");
				}
				result.append(", label:").append("'"+columnLabelPair[1]+"'},").append(NEWLINE);
			}else{
				result.append("		{key:").append("'"+columnLabelPair[0]+"'")
					  .append(", label:").append("'"+columnLabelPair[1]+"'},").append(NEWLINE);
			}
			
		}
		System.out.println(result.toString());
	}
}
