   <link href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css" rel="stylesheet">
  <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script> 

     

         
<script type="text/javascript">
	$(document).ready(function() {
		 var selected = [];
		 
		$("#example").dataTable({
			
			        "processing": true,
			        "serverSide": true,
			        "scrollY": "400px",
			        "ajax": {
			            "url": "./lead_api",
			            "type": "POST"			            
			        },
			        "fnCreatedRow": function( nRow, aData, iDataIndex ) {			        				        	
			            $(nRow).attr('id', aData['id']);
			           	$(nRow).find('a[name=detail]').attr("href", "./_editLead?ids="+aData['id']);	
			           	$(nRow).find('a[name=detail1]').attr("href", "./userdetail?user_id="+aData['id']);	
			           	$(nRow).find('a[name=detail2]').attr("href", "./userdetail?user_id="+aData['id']);				           			           	
						if(aData['username'] !== ""){			        		
							$(nRow).find('a[name=detail3]').attr("href", "./userdetail3?user_id="+aData['id']);							
			        	}else{
			        		$(nRow).find('a[name=detail3]').remove();
			        	}
			           	
			        },
			        "rowCallback": function( row, data ) {			        				      			        	
			            if ( $.inArray(parseInt(data['id']), selected) != -1 ) {
			            	$(row).find("input[type=checkbox]").prop( "checked", true );
			                $(row).addClass('selected');
			            }
			        },
			        "fnFormatNumber": function ( iIn ) {			        	
			            if ( iIn < 1000 ) {
			              return iIn;
			            } else {
			              var
			                s=(iIn+""),
			                a=s.split(""), out="",
			                iLen=s.length;
			               
			              for ( var i=0 ; i<iLen ; i++ ) {
			                if ( i%3 === 0 && i !== 0 ) {
			                  out = "'"+out;
			                }
			                out = a[iLen-i-1]+out;
			              }
			            }
			            return out;
			         },
			        "columns": [
			            { "data": "leadOwner" },
			            { "data": "firstName" },
			            { "data": "lastName" },
			            {			          
			            	"class":          "cek",
			                "orderable":      false,
			                "data":           null,
			                "defaultContent": 
			                	'<input type="checkbox" name="aCheckBox" class="dt_checked"/>'+
			            		'&nbsp; <a name="detail"> EDIT </a>'+
			            		'&nbsp; <a name="detail1"> VIEW </a>'
			            		
			            },
			        ]

		});

		
	    $('#example tbody').on('click', 'tr', function () {
	        var id = this.id;
	        var index = $.inArray(parseInt(id), selected);
	 
	        if ( index === -1 ) {
	            selected.push( parseInt(id) );	  
	            $(this).find("input[type=checkbox]").prop( "checked", true );
	            $('#select').val(selected);	
	        } else {
	            selected.splice( index, 1 );
	            $(this).find("input[type=checkbox]").prop( "checked", false );
	            $('#select').val(selected);	
	        }	  
	        	        
	        $(this).toggleClass('selected');
	    } );
	    
	    $("#btnSubmit").click(function() {
			console.log("Masuk");
			if(typeof selected[0] !== 'undefined' && selected[0] !== null){
				document.getElementById("form").action = "./detail"; 
				document.getElementById("form").submit();
			}else{
				alert("Pilih dulu");
				return false;
			}
			
		});
		
	    
	});
		
	
</script>

</head>
<body>
	<div class="row">
		<br />
	
		  <div class="col-md-12 col-sm-12 col-xs-12" >
             
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
<form method="POST" id="form" name="form">
	<input type="hidden" id="select" name="select" value="" />
	
	   <div class="table-responsive">
    
				<table id="example" class="table table-striped  table-condensed table-hover" cellspacing="0" width="100%">
					<thead>					
						<tr>
							<th>Name</th>
							<th>Password</th>
							<th>Email</th>
							<th>Action</th>							
						</tr>
					</thead>
				
				</table>	
	</div>
	<button type="submit" id="btnSubmit" >CHOOSE </button>
	
</form>
<button id="example"></button>
</div></div>

            
            <div class="col-md-12 col-sm-12 col-xs-12" style="height:200px;" >
            
            
            </div>