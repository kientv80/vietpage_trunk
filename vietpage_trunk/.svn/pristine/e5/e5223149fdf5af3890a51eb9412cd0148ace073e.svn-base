function asynReloadDropdownList(uri,targetDropdownListId){
		YUI().use("node", "io", "dump", "json-parse", function (Y) {
		    // Define a function to handle the response data.
		    function complete(id, o, args) {
		        var id = id; // Transaction ID.
		        parsedResponse = Y.JSON.parse(o.responseText);
//		        alert(parsedResponse);
		        var location = document.getElementById(targetDropdownListId);
		        clearDropdownList(location);
		        
		        for(var i =0; i < parsedResponse.length ; ++i){
		        	var option=document.createElement("option");
		        	option.text = parsedResponse[i].value;
		        	option.value = parsedResponse[i].key;
		        	location.add(option, null);
		        }
		    };
		    Y.on('io:complete', complete, Y, []);
		    var request = Y.io(uri);
		});
		
	}
function asynReloadDropdownList2(uri,formId,targetDropdownListId){
	YUI().use("node", "io", "dump", "json-parse", function (Y) {
	    // Define a function to handle the response data.
	    function complete(id, o, args) {
	        var id = id; // Transaction ID.
	        parsedResponse = Y.JSON.parse(o.responseText);
	        var form = document.getElementById(formId);
	        var location = form.elements.namedItem(targetDropdownListId);
	        clearDropdownList(location);
	        for(var i =0; i < parsedResponse.length ; ++i){
	        	var option=document.createElement("option");
	        	option.text = parsedResponse[i].value;
	        	option.value = parsedResponse[i].key;
	        	location.add(option, null);
	        }
	    };
	    Y.on('io:complete', complete, Y, []);
	    var request = Y.io(uri);
	});
	
}
function ajaxCall(uri,callback){
	YUI().use("node", "io", "dump", "json-parse", function (Y) {
	    // Define a function to handle the response data.
	    function complete(id, o, args) {
	        var id = id; // Transaction ID.
	        parsedResponse = Y.JSON.parse(o.responseText);
	        alert(parsedResponse);
	        if(callback != null && callback!=undefined && callback!=""){
	        	
	        }
	       
	    };
	    Y.on('io:complete', complete, Y, []);
	    var request = Y.io(uri);
	});
	
}

function clearDropdownList(targetDropdownListId){
//	 var location = document.getElementById(targetDropdownListId);
     var count = targetDropdownListId.options.length;
     while(targetDropdownListId.options.length > 0){
    	 targetDropdownListId.remove(0);
     }
     
}

function ajaxRequest(uri,callback){
	YUI().use("node", "io", "dump", "json-parse", function (Y) {
	    // Define a function to handle the response data.
	    function complete(id, o, args) {
	        var id = id; // Transaction ID.
	        if(callback != null && callback!=undefined && callback!=""){
		        parsedResponse = Y.JSON.parse(o.responseText);
		        window[callback].apply(this,[parsedResponse]);
	        }
	    };
	    Y.on('io:complete', complete, Y, []);
	    var request = Y.io(uri);
	});
}
function showDialog1(message){
	
}
function showDialog(message,icon,callBack){
	YUI().use("panel", function (Y) {  // loading escape only for security on this page
	    var dialog = new Y.Panel({
	        /* classnames and images provided in the CSS are:
	        .icon-bubble
	        .icon-error
	        .icon-info
	        .icon-question
	        .icon-warn
	        .icon-success
	        .icon-none
	     */
	        contentBox : Y.Node.create('<div id="dialog" />'),
	        bodyContent: '<div class="message '+icon+'">'+message+'</div>',
	        width      : 410,
	        zIndex     : 10,
	        centered   : true,
	        modal      : false, // modal behavior
	        render     : '.example',
	        visible    : false, // make visible explicitly with .show()
	        buttons    : {
	            footer: [
	                {
	                    name  : 'cancel',
	                    label : 'Cancel',
	                    action: 'onCancel'
	                },

	                {
	                    name     : 'proceed',
	                    label    : 'OK',
	                    action   : 'onOK'
	                }
	            ]
	        }
	    });

	    dialog.onCancel = function (e) {
	        e.preventDefault();
	        this.hide();
	        // the callback is not executed, and is
	        // callback reference removed, so it won't persist
	        this.callback = false;
	    }
	    dialog.callback=callBack;
	    dialog.onOK = function (e) {
	        e.preventDefault();
	        this.hide();
	        // code that executes the user confirmed action goes here
	        if(this.callback){
	           this.callback();
	        }
	        // callback reference removed, so it won't persist
	        this.callback = false;
	    }
	    dialog.show();
	});
}

function isNumber(number){
	var RE = /^-{0,1}\d*\.{0,1}\d+$/;
    return (RE.test(number));
}






