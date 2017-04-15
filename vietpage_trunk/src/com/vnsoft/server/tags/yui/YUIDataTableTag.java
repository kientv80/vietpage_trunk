package com.vnsoft.server.tags.yui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;

public class YUIDataTableTag extends YUICustomTag {
	private static final String NEW_LINE = "\n";
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030534879341277525L;
	private String columns;// column1:label,column2:label,...
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
		StringBuilder js = new StringBuilder();
		js.append("<script type=\"text/javascript\">").append(NEW_LINE)
		.append("YUI().use(\"datatable\", \"datasource-get\", \"datasource-jsonschema\", \"datatable-datasource\", function (Y) {").append(NEW_LINE)
		.append(" var url = \""+queryJsonDataUrl+"\";").append(NEW_LINE)
		.append(" var dataSource = new Y.DataSource.Get({ source: url }); ").append(NEW_LINE)
		.append(" dataSource.plug(Y.Plugin.DataSourceJSONSchema, {").append(NEW_LINE)
		.append("   schema: {").append(NEW_LINE)
		.append("    resultListLocator: \"results\",").append(NEW_LINE)
		.append("    resultFields: [").append(NEW_LINE);
		for(String col : columns.keySet()){
			js.append("        \""+col+"\",").append(NEW_LINE);
		}
		js.append("    ]").append(NEW_LINE)
		.append("   }").append(NEW_LINE)
		.append(" });").append(NEW_LINE)
		.append(" var table = new Y.DataTable({").append(NEW_LINE)
		.append("   columns: [").append(NEW_LINE);
	    
	    if(tableWithCheckBox){
	    js.append("      {   key: 'select',").append(NEWLINE)
	    .append("            formatter:      '<input type=\"checkbox\" checked/>',").append(NEWLINE)
	    .append("            emptyCellValue: '<input type=\"checkbox\"/>',").append(NEWLINE)
	    .append("             allowHTML:  true, // to avoid HTML escaping").append(NEWLINE)
	    .append("            label:      '<input type=\"checkbox\" class=\"protocol-select-all\" title=\"Toggle ALL records\"/>'").append(NEWLINE)
	    .append("        },").append(NEWLINE);
	    }

		js.append(toJSONDataTableColumns(this.columns)).append(NEWLINE)
		.append("    ],").append(NEW_LINE)
		.append("    scrollable: 'y',").append(NEWLINE)
		.append("    sortable  : ["+buildSortableColumns(sortableColumns)+"],").append(NEWLINE)
	    .append("    sortBy    : "+getSortBy(getSortByColumns())+",").append(NEWLINE)
	    .append("    recordType: ['select', "+getDataTableColumnsName(this.columns)+"]").append(NEWLINE)
		.append(" });").append(NEW_LINE)
		.append("table.plug(Y.Plugin.DataTableDataSource, { datasource: dataSource });").append(NEW_LINE)
		.append("table.render(\"#"+divContainserID+"\");").append(NEW_LINE)
		.append("table.detach('*:change');").append(NEWLINE);
		if(tableWithCheckBox)
		js.append(addCheckEvent("table", getCallBackButtonId(),getCallBackMethod(),this.returnValueOfColumns,this.columns)).append(NEWLINE);
		
		js.append("table.datasource.load({});").append(NEW_LINE)
		.append("});").append(NEW_LINE)
		.append("</script>").append(NEW_LINE);
		return js.toString();
	}

	private String buildSortableColumns(String columns) {
		StringBuilder tmp = new StringBuilder();
		String[] cols = columns.split(",");
		int count = 0;
		for(String col : cols){
			count ++;
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
}
