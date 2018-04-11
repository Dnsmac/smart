 var testEditor;
    $(function () {
        testEditor = editormd("test-editormd", {
            width: "95%",
            height: 640,
            syncScrolling: "single",
            path: "/static/editor/lib/",
            imageUpload: true,
            imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL: "/file",
        });
    });
    var tale = new $.tale();

    function saveHtml() {
    	var title = $("input[name=title]").val();
    	var url = $("input[name=url]").val();
    	var content = $("#text").text();
    	var cid = $("#cid").text();
    	var seriesId = $("#seriesId").val();
    	var projectId = $("#projectId").val();
    	 if (title == '') {
    	        tale.alertWarn('请输入文章标题');
    	        return;
    	    }
    	 if (url == '') {
    	        tale.alertWarn('请输入接口url');
    	        return;
    	    }
   	    if (content == '') {
   	        tale.alertWarn('请输入文章内容');
   	        return;
   	    }
        var jsons = {
                "content": content,
                "seriesId": seriesId,
                "cid": cid,
                "url": url,
                "title": title
            }
               console.log(jsons);
        $.ajax({
            url: "/Editor/save",
            type: "post",
            async: true,
            data : JSON.stringify(jsons),
    		contentType : "application/json",
            dataType: "json",
            success: function (data) {
            	backHtml();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus); // paser error;
            }
        });
    }
    
    function backHtml(){
    	var projectId = $("#projectIdType").val();
    	window.location.href = "/admin/view/"+projectId;
    }
    
    function openModalCategory(){
    	$('#modalCategory').modal();
    }		
    
    function saveCategoryType(){
    	var name = $("#categoryName").val();
    	
    	if (name == '') {
            tale.alertWarn('请输入名称');
            return;
        }
    	 $.ajax({
             url: "/save/CategoryType",
             type: "post",
             async: true,
             data : "name="+name,
             dataType: "json",
             success: function (data) {
            	 window.location.reload();
             }
         });
    }
    