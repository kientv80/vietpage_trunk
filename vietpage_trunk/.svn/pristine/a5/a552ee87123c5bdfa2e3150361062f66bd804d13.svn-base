package com.vnsoft.server.tags.yui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.jsp.JspException;

public class ChartTag extends YUICustomTag{
	private static final long serialVersionUID = 4747933709824560583L;
	private String title;
	private String xTitle;
	private String yTitle;
	private String chartType;//line,stepLine,spline,area,splineArea,bar,pie,doughnut,bubble,scatter,stackedColumn,stackedColumn100,stackedArea,stackedArea100,stackedBar,stackedBar100
	private List<ChartData> chartData = new ArrayList<>();
	private String containerId;
	private String valueFormatString;
	SimpleDateFormat yyymmdd = new SimpleDateFormat("yyyy,MM,dd");
	@Override
	public int doEndTag() throws JspException {
		try {
			print(getLinechartJs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
	private String getLinechartJs(){
		if(chartData == null || chartData.size() == 0)
			return"No Data";
		boolean isDate = false;
		if(chartData != null && chartData.size() > 0){
			if (chartData.get(0).getX() instanceof Date) {
				isDate = true;
			}
		}
		StringBuilder js = new StringBuilder();
		js.append("<script type=\"text/javascript\">\n")
		.append("  window.onload = function () {\n")
		.append("    var chart = new CanvasJS.Chart(\""+containerId+"\",\n")
		.append("    {\n")
		.append("      title:{\n")
		.append("      text: \""+getTitle()+"\"\n")
		.append("      },\n");
		if(xTitle != null){
			js.append("      axisX: {\n")
			.append("        title:\""+xTitle+"\"");
			/*if(isDate && valueFormatString!=null){
				js.append(",\n");
				js.append("        valueFormatString:\"MMM\"");
			}*/
			js.append("      },\n");
		}
		if(yTitle != null){
			js.append("      axisY: {\n")
			.append("        title:\""+yTitle+"\"")
			.append("      },\n");
		}
		js.append("      data: [\n")
		.append("      {\n")
		.append("        type: \""+getChartType()+"\",\n")
		.append("        dataPoints: \n")
		.append("        ["+buildJSONData()+"] \n")
		.append("       }\n")
		.append("       ]\n")
		.append("     });\n")
		.append("     chart.render();\n")
		.append("   }\n")
		.append("   </script>\n");
		return js.toString();
	}
	
	private String buildJSONData() {
		StringBuilder data = new StringBuilder();
		
		boolean isDate = false;
		if(chartData != null && chartData.size() > 0){
			if (chartData.get(0).getX() instanceof Date) {
				isDate = true;
			}
		}else{
			System.out.println("no data");
			return data.toString();
		}
		int i = 0;
		if(isDate){
			for(ChartData d : chartData){
				if(i<chartData.size()-1)
					data.append("{x: new Date("+yyymmdd.format(d.getX())+"), y: "+d.getY()+"},\n");
				else
					data.append("{x: new Date("+yyymmdd.format(d.getX())+"), y: "+d.getY()+"}\n");
				i++;
			}
		}else{
			for(ChartData d : chartData){
				if(i<chartData.size()-1)
					data.append("{x: "+d.getX()+", y:"+d.getY()+"},\n");
				else
					data.append("{x: "+d.getX()+", y:"+d.getY()+"}\n");
				i++;
			}
		}

		return data.toString();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChartType() {
		return chartType;
	}
	public void setChartType(String chartType) {
		this.chartType = chartType;
	}
	public List<ChartData> getChartData() {
		return chartData;
	}
	public void setChartData(List<ChartData> chartData) {
		this.chartData = chartData;
	}
	public String getContainerId() {
		return containerId;
	}
	public void setContainerId(String containerId) {
		this.containerId = containerId;
	}
	public String getxTitle() {
		return xTitle;
	}
	public void setxTitle(String xTitle) {
		this.xTitle = xTitle;
	}
	public String getyTitle() {
		return yTitle;
	}
	public void setyTitle(String yTitle) {
		this.yTitle = yTitle;
	}
	public String getValueFormatString() {
		return valueFormatString;
	}
	public void setValueFormatString(String valueFormatString) {
		this.valueFormatString = valueFormatString;
	}
	
}
