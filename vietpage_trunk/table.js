<script type="text/javascript">
YUI().use("datatable", "datasource-get", "datasource-jsonschema", "datatable-datasource", function (Y) {
	 var url = "{url}";
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
			 return '<input type="checkbox" name="item" checked>';
		 }else{
			 return '<input type="checkbox" name="item">';
		 }
	 }
	 function image(o){
		return "<div style=\"width:300px;height:200px;overflow:hidden;\"><img src='"+o.value+"' max-width='100%'></div>";
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
	 
	table.plug(Y.Plugin.DataTableDataSource, { 
		datasource: dataSource ,
		initialRequest: "action=getItems&"
	});
	table.render("#{div_id}");
	table.detach('*:change');
	
    // Check all
    table.delegate('click', function (e) {
        this.get('contentBox').all('input[name]').set('checked', e.currentTarget.get('checked'));
     // undefined to trigger the emptyCellValue
 	   var checked = e.target.get('checked') || undefined;
 	   // Set the selected attribute in all records in the ModelList silently
 	   // to avoid each update triggering a table update
 	   this.data.invoke('set', '{checkbox-column}', checked, { silent: true });
 	   // Update the table now that all records have been updated
 	   // this.syncUI();
    }, '#id-all', table);
    
    //Single check
    table.delegate('click', function (e) {
        Y.one('#id-all').set('checked', false);
        var checked = e.target.get('checked') || undefined;
		this.getRecord(e.target).set('{checkbox-column}', checked);
    }, '.yui3-datatable-data input', table);
	
    dataSource.after("response", function() {
        table.render("#{div_id}")}
    );
	function process() {
	    var ml  = table.data,
	        msg = '',
	        template = 'id:{id};';
	    ml.each(function (item, i) {
	        var data = item.getAttrs(['{checkbox-column}','id']);
	        if (data.{checkbox-column}==true) {
	            data.index = i;
	            msg += Y.Lang.sub(template, data);
	        }
	    });
	 	{callback}(msg);
	}
	function refresh(){
		var newurl = callBackRefresh();
		table.datasource.load({request:newurl});
//		table.syncUI();
	}
	Y.one("#{callbackBtnId}").on("click", process);
	Y.one("#selectedMenuId").on("change", refresh);
	table.datasource.load({});
});
</script>