<script type="text/javascript">
YUI().use("datatable", "datasource-get", "datasource-jsonschema", "datatable-datasource", function (Y) {
	 var url = "{url}&";
	 var dataSource = new Y.DataSource.Get({ source: url }); 
	 dataSource.plug(Y.Plugin.DataSourceJSONSchema, {
	   schema: {
	    resultListLocator: "results",
	    resultFields: [
	        {resultFields}
	    ]
	   }
	 });
	 function checkBox(o){
		 if(o.value == true){
			 return "checked";
		 }else{
			 return " ";
		 }
	 }
	 var table = new Y.DataTable({
	   columns: [
	       {columns}
	    ],
	    scrollable: 'y',
	    sortable  : [{sortable}],
	    sortBy    : {sortBy},
	    recordType: [{recordType}]
	 });
	 
	table.plug(Y.Plugin.DataTableDataSource, { datasource: dataSource });
	table.render("#{div_id}");
	table.datasource.load({});
});
</script>