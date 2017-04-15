package com.vnsoft.server.tags.yui;

import java.io.IOException;

import javax.servlet.jsp.tagext.TagSupport;

public class YUICustomTag extends TagSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4036703224326937745L;
	protected static final String NEWLINE = "\n";
	protected String getScrollJs(int height, String containerId){
		
		StringBuilder js = new StringBuilder();
		js.append("YUI().use(\"scrollview-base\", function(Y) {").append(NEWLINE)
			.append("var scrollview = new Y.ScrollView({").append(NEWLINE)
			.append("id: \"scrollview\",").append(NEWLINE)
    		.append("srcNode:\"#"+containerId+"\",").append(NEWLINE)
    		.append("height:"+height+",").append(NEWLINE)
    		.append("flick: {").append(NEWLINE)
    		.append("minDistance:10,").append(NEWLINE)
    		.append("minVelocity:0.3,").append(NEWLINE)
    		.append("axis:\"y\"").append(NEWLINE)
    		.append("}").append(NEWLINE)
    		.append("});").append(NEWLINE)
    		.append("scrollview.render();").append(NEWLINE)
    		.append("});").append(NEWLINE);
		return js.toString();
	}
	protected String getYUIDataTable(String containerId, String tableName,String dataTableVar, String displayedColums,String columns, String sortable, String sortBy, String callButton, String callBack) {
		StringBuilder js = new StringBuilder();
		js.append("var " + tableName + " = new Y.DataTable({").append(NEWLINE)
	    .append("columns : [").append("\n").append(NEWLINE)
	    .append("        {   key:        'select',").append(NEWLINE)
	    .append("            allowHTML:  true, // to avoid HTML escaping").append(NEWLINE)
	    .append("            label:      '<input type=\"checkbox\" class=\"protocol-select-all\" title=\"Toggle ALL records\"/>',").append(NEWLINE)
	    .append("            formatter:      '<input type=\"checkbox\" checked/>',").append(NEWLINE)
	    .append("            emptyCellValue: '<input type=\"checkbox\"/>'").append(NEWLINE)
	    .append("        },").append(NEWLINE)	
	    .append(toJSONDataTableColumns(displayedColums)).append(NEWLINE)
	    .append("    ],").append(NEWLINE)
	    .append("    data      : "+dataTableVar+",").append(NEWLINE)
	    .append("    scrollable: 'y',").append(NEWLINE)
//	    .append("    height    : '250px',").append(NEWLINE)
	    .append("    sortable  : ["+getDataTableColumnsName(displayedColums)+"],").append(NEWLINE)
	    .append("    sortBy    : '"+sortBy+"',").append(NEWLINE)
	    .append("    recordType: ['select', "+getDataTableColumnsName(displayedColums)+"]").append(NEWLINE)
	    .append("}).render(\"#"+containerId+"\");").append(NEWLINE)
		.append(tableName+".detach('*:change');").append(NEWLINE)
		.append(addCheckEvent(tableName, callButton,callBack,columns,displayedColums)).append(NEWLINE);
		
		return js.toString();
	}
	protected String addCheckEvent(String tableVar, String callButton, String callBack,String returnedValudOfColumns,String displayedColums){
		StringBuilder js = new StringBuilder();
		js.append("// Define a listener on the DT first column for each record's \"checkbox\",").append(NEWLINE);
		js.append("//   to set the value of 'select' to the checkbox setting").append(NEWLINE);
		js.append(tableVar+".delegate(\"click\", function(e){").append(NEWLINE);
        js.append("// undefined to trigger the emptyCellValue").append(NEWLINE);
		js.append("var checked = e.target.get('checked') || undefined;").append(NEWLINE);
//		js.append("alert(e.target);").append(NEWLINE);
		js.append("this.getRecord(e.target).set('select', checked);").append(NEWLINE);
		js.append("// Uncheck the header checkbox").append(NEWLINE);
		js.append("this.get('contentBox')").append(NEWLINE);
		js.append("    .one('.protocol-select-all').set('checked', false);").append(NEWLINE);
		js.append("}, \".yui3-datatable-data .yui3-datatable-col-select input\", "+tableVar+");").append(NEWLINE);
		
		
		js.append("// Also define a listener on the single TH \"checkbox\" to").append(NEWLINE);
		js.append("//   toggle all of the checkboxes").append(NEWLINE);
		js.append(tableVar+".delegate('click', function (e) {").append(NEWLINE);
		js.append("    // undefined to trigger the emptyCellValue").append(NEWLINE);
		js.append("    var checked = e.target.get('checked') || undefined;").append(NEWLINE);
		js.append("    // Set the selected attribute in all records in the ModelList silently").append(NEWLINE);
		js.append("    // to avoid each update triggering a table update").append(NEWLINE);
		js.append("    this.data.invoke('set', 'select', checked, { silent: true });").append(NEWLINE);
		js.append("    // Update the table now that all records have been updated").append(NEWLINE);
		js.append("    this.syncUI();").append(NEWLINE);
		js.append("},'.protocol-select-all', "+tableVar+");").append(NEWLINE);
		
		js.append("//----------------").append(NEWLINE);
		js.append("//  CSS-Button click handlers ....").append(NEWLINE);
		js.append("//----------------").append(NEWLINE);
		js.append("function process() {").append(NEWLINE);
		js.append("    var ml  = "+tableVar+".data,").append(NEWLINE);
		js.append("        msg = '',").append(NEWLINE);
		//js.append("        template = '<li>Record index = {index} Data = {port} : {pname}</li>';");
		js.append("        template = '"+buildTemplate(returnedValudOfColumns)+";';").append(NEWLINE);
		js.append("    ml.each(function (item, i) {").append(NEWLINE);
		js.append("        var data = item.getAttrs(['select',"+getAttrsColumns(returnedValudOfColumns)+"]);").append(NEWLINE);

		js.append("        if (data.select) {").append(NEWLINE);
		js.append("            data.index = i;").append(NEWLINE);
		js.append("            msg += Y.Lang.sub(template, data);").append(NEWLINE);
		js.append("        }").append(NEWLINE);
		js.append("    });").append(NEWLINE);
		if(callBack!=null && callButton !=null){
			js.append(" 	"+callBack+"(msg);").append(NEWLINE);
			js.append("}").append(NEWLINE);
	
			js.append("Y.one(\"#"+callButton+"\").on(\"click\", process);").append(NEWLINE);
		}else{
			js.append("}").append(NEWLINE);
		}
		return js.toString();
	    
	    
	}
	private String buildTemplate(String colums){
		StringBuilder tmp = new StringBuilder();
		for(String colmn : colums.split(",")){
			tmp.append(colmn + ":"+"{"+colmn+"},");
		}
		return tmp.substring(0,tmp.length()-1);
	}
	protected String toJSONDataTableColumns(String displayedColums){
		String[] columns = displayedColums.split(",");
		StringBuilder result = new StringBuilder();
		for(String column: columns){
			String[] columnLabelPair = column.split(":");
			if(columnLabelPair[0]!="checked")
			result.append("		{key:").append("'"+columnLabelPair[0]+"'").append(", label:").append("'"+columnLabelPair[1]+"'},").append(NEWLINE);
		}
		return result.toString().substring(0,result.toString().length()-2);
	}
	protected String getDataTableColumnsName(String displayedColums){
		String[] columns = displayedColums.split(",");
		StringBuilder result = new StringBuilder();
		for(String column: columns){
			String[] columnLabelPair = column.split(":");
			if(columnLabelPair[0].indexOf("[")>0 && columnLabelPair[0].indexOf("]")>0)
				result.append("'"+columnLabelPair[0].substring(0,columnLabelPair[0].indexOf("["))).append("',");
			else
				result.append("'").append(columnLabelPair[0]).append("',");
		}
		return result.toString().substring(0,result.toString().length()-1);
	}
	private String getAttrsColumns(String columns){
		String[] column = columns.split(",");
		StringBuilder result = new StringBuilder();
		for(String col: column){
			result.append("'").append(col).append("',");
		}
		return result.toString().substring(0,result.toString().length()-1);
	}
	protected void print(String content){
		try {
//			pageContext.getResponse().setContentType("text/javascript");
			pageContext.getOut().print(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
