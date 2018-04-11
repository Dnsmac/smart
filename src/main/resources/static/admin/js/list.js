 var tale = new $.tale();
function openModal(){
	var projectId = $("#projectId").val();
	if (projectId == '') {
		tale.alertWarn('请在设置项添加具体模块!!!!');
		return;
	}
	$('#modal').modal();
}		

function hrefWindow(id){
	 window.location.href = "/Editor/view/update/"+id;
}

function saveSeriesType(){
	var name = $("#seriesName").val();
	
	if (name == '') {
        tale.alertWarn('请输入名称');
        return;
    }
	
	 $.ajax({
         url: "/save/series",
         type: "post",
         async: true,
         data : "name="+name,
         dataType: "json",
         success: function (data) {
        	 window.location.reload();
         }
     });
}


function addEdit(seriesId,projectId){
	window.location.href="/Editor/view/"+seriesId+"/"+projectId
}
